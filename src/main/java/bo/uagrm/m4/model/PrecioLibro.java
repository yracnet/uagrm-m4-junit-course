package bo.uagrm.m4.model;

import lombok.Data;

@Data
public class PrecioLibro {
    private Long id;
    private String isbn;
    private String edicion;
    private String formato;
    private double precioVenta;
    private double descuento;
}
