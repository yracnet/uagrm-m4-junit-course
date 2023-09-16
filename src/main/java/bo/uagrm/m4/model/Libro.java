package bo.uagrm.m4.model;

import bo.uagrm.m4.util.Tool;
import lombok.Data;

@Data
public class Libro {
    private String isbn;
    private String autor;
    private String titulo;
    private String descripcion;

    public boolean isLibroIgual(String isbn) {
        return Tool.areEquals(this.isbn, isbn);
    }
}
