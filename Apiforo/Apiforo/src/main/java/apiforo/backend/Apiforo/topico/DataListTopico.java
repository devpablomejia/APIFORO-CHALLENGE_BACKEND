package apiforo.backend.Apiforo.topico;

public record DataListTopico(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        String curso
) {
    public DataListTopico(Topico topico){
        this(
                topico.getId(),
                topico.getAutor(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso()
        );
    }
}
