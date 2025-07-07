package apiforo.backend.Apiforo.controller;

import apiforo.backend.Apiforo.topico.DataTopico;
import apiforo.backend.Apiforo.topico.Topico;
import apiforo.backend.Apiforo.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Transactional
    @PostMapping
    public void newTopico(@RequestBody @Valid DataTopico dataTopico){
        topicoRepository.save(new Topico(dataTopico));
    }
}
