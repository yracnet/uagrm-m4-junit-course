package bo.uagrm.m4.manager;

import bo.uagrm.m4.exception.NotFounException;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import bo.uagrm.m4.util.Loader;
import java.util.List;

public class CarritoVentaManager {

    private List<Libro> libros = Loader.libros();
    private List<PrecioLibro> precios = Loader.precios();

    public Double calcularDecuento(String isbn, String edicion, PrecioLibro.Formato formato) {
        for (PrecioLibro it : precios) {
            if (it.getIsbn() == isbn
                    && it.getEdicion() == edicion
                    && it.getFormato() == formato) {                
                return it.getDescuento().cacularDescuento(it.getPrecioVenta());
            }
        }
        throw new NotFounException("Libro no encontrado");
    }
}
