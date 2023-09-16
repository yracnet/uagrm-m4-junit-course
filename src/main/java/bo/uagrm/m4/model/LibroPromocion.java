package bo.uagrm.m4.model;

import bo.uagrm.m4.util.Tool;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

@Data
public class LibroPromocion {

    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private Long id;
    private String isbn;
    private Integer edicion;
    private Formato formato;
    private Date fechaDesde;
    private Date fechaHasta;
    private Float descuento;
    private String descripcion;

    public String getFechaDesdeString() {
        return formatter.format(fechaDesde);
    }

    public String getFechaHastaString() {
        return formatter.format(fechaHasta);
    }

    public boolean isFechaValida(Date fecha) {
        var esMayor = fechaDesde.getTime() < fecha.getTime();
        var esMenor = fechaHasta == null || fecha.getTime() <= fechaHasta.getTime();
        return esMayor && esMenor;
    }

    public boolean isLibroIgual(String isbn, Integer edicion, Formato formato) {
        return Tool.areEquals(this.isbn, isbn)
                && Tool.areEquals(this.edicion, edicion)
                && Tool.areEquals(this.formato, formato);
    }
}
