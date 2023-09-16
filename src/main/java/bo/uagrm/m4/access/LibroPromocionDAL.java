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
        System.out.println("ISBN | EDICION | FORMATO       | DESDE    | HASTA    | DESCUENTO ");
        for (LibroPromocion descuento : promociones) {
            // System.out.println(descuento);
            System.out.println(descuento.getIsbn() + " | " + descuento.getEdicion() + "    | " + descuento.getFormato() + "    | " + descuento.getFechaDesdeString() + "  | " + descuento.getFechaHastaString() + "  | " + descuento.getDescuento());
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

}
