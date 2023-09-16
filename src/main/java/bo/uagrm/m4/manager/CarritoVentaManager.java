package bo.uagrm.m4.manager;

import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import bo.uagrm.m4.util.Loader;
import java.util.List;

public class CarritoVentaManager {
    
    private List<Libro> libros = Loader.libros();
    private List<PrecioLibro> precios = Loader.precios();
    
}
