package bo.uagrm.m4.model;

import bo.uagrm.m4.util.Tool;
import lombok.Data;

@Data
public class LibroPrecio {

    private String isbn;
    private Integer edicion;
    private Formato formato;
    private Double precioUnitario;
    private String moneda;

    public boolean isLibroIgual(String isbn, Integer edicion, Formato formato) {
        return Tool.areEquals(this.isbn, isbn)
                && Tool.areEquals(this.edicion, edicion)
                && Tool.areEquals(this.formato, formato);
    }
}
