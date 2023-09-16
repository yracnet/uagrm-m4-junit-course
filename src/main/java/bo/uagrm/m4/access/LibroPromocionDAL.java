package bo.uagrm.m4.access;

import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.LibroPromocion;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class LibroPromocionDAL {

    @Setter
    @Getter
    private List<LibroPromocion> promociones;

    public void imprimir() {
        System.out.println("PROMOCIONES");
        System.out.println("-------------------------------------");
        String template = "%-6s | %-10s | %-15s | %-10s | %-10s | %-10s | %-30s";
        System.out.println(String.format(template, new Object[]{"ISBN", "EDICION", "FORMATO", "DESDE", "HASTA", "DESCUENTO", "GLOSA"}));
        for (LibroPromocion it : promociones) {
            System.out.println(String.format(template, new Object[]{it.getIsbn(), it.getEdicion(), it.getFormato(), it.getFechaDesdeString(), it.getFechaHastaString(), it.getDescuento(), it.getDescripcion()}));
        }
    }

    public LibroPromocion buscarPromocion(Date fecha, String isbn, Integer edicion, Formato formato) {
        for (var it : promociones) {
            var sw = it.isFechaValida(fecha)
                    && it.isLibroIgual(isbn, edicion, formato);
            if (sw) {
                return it;
            }
        }
        return null;
    }

    public int count() {
        return promociones.size();
    }

}
