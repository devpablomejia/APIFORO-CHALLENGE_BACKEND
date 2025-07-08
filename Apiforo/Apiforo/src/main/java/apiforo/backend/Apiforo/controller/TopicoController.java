package apiforo.backend.Apiforo.controller;

import apiforo.backend.Apiforo.domain.topico.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Transactional
    @PostMapping
    public ResponseEntity newTopico(@RequestBody @Valid DataTopico dataTopico, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(dataTopico);
        topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailsTopicos(topico));
    }

    @GetMapping()
    public ResponseEntity<Page<DataListTopico>> listTopicos(Pageable pageable){
        var page = topicoRepository.findAllByActiveTrue(pageable).map(DataListTopico::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity updateTopico(@RequestBody @Valid DataUpdateTopico dataTopico){
            var topico = topicoRepository.getReferenceById(dataTopico.id());
            topico.updateTopico(dataTopico);
            return ResponseEntity.ok(new DataDetailsTopicos(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        topico.deleteTopico();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity showTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailsTopicos(topico));
    }

}
