package bo.uagrm.m4.access;

import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.LibroPrecio;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class LibroPrecioDAL {

    @Setter
    @Getter
    private List<LibroPrecio> precios;

    public void imprimir() {
        System.out.println("PRECIOS");
        System.out.println("-------------------------------------");
        System.out.println("ISBN | EDICION | FORMATO    | PRECIO ");
        for (LibroPrecio precio : precios) {
            System.out.println(precio.getIsbn() + " | " + precio.getEdicion() + "    | " + precio.getFormato() + "  | " + precio.getPrecioUnitario());
        }
    }

    public LibroPrecio buscarPrecio(String isbn, Integer edicion, Formato formato) {
        for (var it : precios) {
            var sw = it.isLibroIgual(isbn, edicion, formato);
            if (sw) {
                return it;
            }
        }
        return null;
    }

}
