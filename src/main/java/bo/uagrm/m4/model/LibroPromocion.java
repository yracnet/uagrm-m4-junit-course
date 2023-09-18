package bo.uagrm.m4.model;

import bo.uagrm.m4.util.Tool;
import java.util.Date;
import lombok.Data;

@Data
public class LibroPromocion {

    private Long id;
    private TipoPromocion tipo;
    private String isbn;
    private Integer edicion;
    private Formato formato;
    private Date fechaDesde;
    private Date fechaHasta;
    private Float descuento;

    public String getFechaDesdeString() {
        return Tool.formatDate(fechaDesde);
    }

    public String getFechaHastaString() {
        return Tool.formatDate(fechaHasta);
    }

    public boolean isFechaValida(Date fecha) {
        var esMayor = fechaDesde.getTime() < fecha.getTime();
        var esMenor = fechaHasta == null || fecha.getTime() < fechaHasta.getTime();
        return esMayor && esMenor;
    }

    public boolean existeLibroPromo(String isbn, Integer edicion, Formato formato, TipoPromocion tipo) {
        return Tool.areEquals(this.isbn, isbn)
                && Tool.areEquals(this.edicion, edicion)
                && Tool.areEquals(this.formato, formato)
                && Tool.areEquals(this.tipo, tipo);
    }
}
