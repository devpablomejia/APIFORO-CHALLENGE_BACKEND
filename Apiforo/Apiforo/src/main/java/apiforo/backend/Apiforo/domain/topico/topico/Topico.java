package apiforo.backend.Apiforo.domain.topico.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active;
    private String autor;
    private String titulo;
    private String mensaje;
    private String curso;

    public Topico(DataTopico dataTopico) {
        this.id = null;
        this.active = true;
        this.autor = dataTopico.autor();
        this.titulo = dataTopico.titulo();
        this.mensaje = dataTopico.mensaje();
        this.curso = dataTopico.curso();
    }

    public void updateTopico(@Valid DataUpdateTopico dataTopico) {
        if(dataTopico.titulo() != null){
            this.titulo = dataTopico.titulo();
        }
        if(dataTopico.mensaje() != null){
            this.mensaje = dataTopico.mensaje();
        }
        if(dataTopico.curso() != null){
            this.curso = dataTopico.curso();
        }
    }

    public void deleteTopico() {
        this.active = false;
    }
}
