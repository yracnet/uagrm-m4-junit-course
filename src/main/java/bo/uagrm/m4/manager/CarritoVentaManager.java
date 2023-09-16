package bo.uagrm.m4.manager;

import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import bo.uagrm.m4.util.Loader;
import java.util.List;

public class CarritoVentaManager {

    private List<Libro> libros = Loader.libros();
    private List<PrecioLibro> precios = Loader.precios();

    public Double calcularDecuento(String isbn, String edicion, PrecioLibro.Formato formato) {
        
//        var libro = libros.stream().filter(it -> {
//            return it.getIsbn() == isbn;
//        }).findFirst().get();
//        var precioLibro = precios.stream().filter(it -> {
//            return it.getIsbn() == isbn
//                    && it.getEdicion() == edicion
//                    && it.getFormato() == formato;
//        }).findFirst().get();
        //precioLibro
        //return precioLibro.getPrecioVenta() - precioLibro.getDescuento();
        return 0.0;
    }
}
