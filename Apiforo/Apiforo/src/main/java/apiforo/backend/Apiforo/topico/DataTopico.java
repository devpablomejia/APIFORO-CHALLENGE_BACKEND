package apiforo.backend.Apiforo.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopico(
        @NotBlank String autor,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso) {
}
