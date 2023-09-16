package bo.uagrm.m4.manager;

import bo.uagrm.m4.exception.NotFounException;
import bo.uagrm.m4.model.Descuento;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import bo.uagrm.m4.util.Loader;
import java.util.Date;
import java.util.List;

public class CarritoVentaManager {

    private List<Libro> libros = Loader.libros();
    private List<PrecioLibro> precios = Loader.precios();

    public Double calcularDecuento(String isbn, Integer edicion, Formato formato) {
        for (PrecioLibro it : precios) {
            if (it.getIsbn() == isbn
                    && it.getEdicion() == edicion
                    && it.getFormato() == formato) {  
                
                Date now = new Date();
                
                if(edicion == now.getYear()){
                    return Descuento.DESC_01.cacularDescuento(it.getPrecioVenta());
                }
                return it.getDescuento().cacularDescuento(it.getPrecioVenta());
            }
        }
        throw new NotFounException("Libro no encontrado");
    }
    
    public void imprimir(){
        for (Libro libro : libros) {
            System.out.println(libro.getNombre());
        }
    }
    
}
