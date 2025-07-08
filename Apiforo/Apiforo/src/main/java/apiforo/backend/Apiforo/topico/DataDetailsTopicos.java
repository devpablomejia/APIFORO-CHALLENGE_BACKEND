package apiforo.backend.Apiforo.topico;

public record DataDetailsTopicos(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        String curso
) {
    public DataDetailsTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getAutor(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso()
        );
    }
}
