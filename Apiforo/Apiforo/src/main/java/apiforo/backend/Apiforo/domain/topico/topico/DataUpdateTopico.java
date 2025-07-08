package apiforo.backend.Apiforo.domain.topico.topico;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopico(
        @NotNull long id,
        String titulo,
        String mensaje,
        String curso
) {

}
