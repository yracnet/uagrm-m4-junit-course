package bo.uagrm.m4.model;

import lombok.Data;

@Data
public class PrecioLibro {
    private Long id;
    private String isbn;
    private String edicion;
    private Formato formato;
    private double precioVenta;
    private double descuento;
    
    
    public static enum Formato{
        TAPA_DURA,
        TAPA_BLANDA
    }
}
