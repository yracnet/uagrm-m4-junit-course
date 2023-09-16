package bo.uagrm.m4.manager;

import bo.uagrm.m4.access.LibroDAL;
import bo.uagrm.m4.access.LibroPrecioDAL;
import bo.uagrm.m4.access.LibroPromocionDAL;
import bo.uagrm.m4.exception.NotFounException;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.LibroPrecio;
import bo.uagrm.m4.model.LibroPromocion;
import bo.uagrm.m4.util.Loader;
import bo.uagrm.m4.util.Tool;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class CarritoVentaManager {

    @Setter
    @Getter
    private Date fechaCompra = new Date();
    private final LibroDAL libroDAL = Loader.libroDAL();
    private final LibroPrecioDAL precioDAL = Loader.libroPrecioDAL();
    private final LibroPromocionDAL promocionDAL = Loader.libroPromocionDAL();

    public void setFechaCompraString(String fecha) {
        fechaCompra = Tool.parseDate(fecha);
    }

    public ValorDescuento calcularDecuento(String isbn, Integer edicion, Formato formato) {
        Libro libro = libroDAL.buscarLibro(isbn);
        if (libro == null) {
            throw new NotFounException("Libro no encontrado");
        }
        LibroPrecio precio = precioDAL.buscarPrecio(isbn, edicion, formato);
        if (precio == null) {
            throw new NotFounException("Precio Libro no encontrado");
        }
        LibroPromocion promocion = promocionDAL.buscarPromocion(fechaCompra, isbn, edicion, formato);

        var resp = new ValorDescuento();
        resp.setIsbn(libro.getIsbn());
        resp.setTitulo(libro.getTitulo());
        resp.setAutor(libro.getAutor());
        resp.setMoneda(precio.getMoneda());

        if (promocion == null) {
            resp.initPorcentaDecuento(precio.getPrecioUnitario(), 0F);
            resp.setGlosa("Sin descuento");
        } else {
            resp.initPorcentaDecuento(precio.getPrecioUnitario(), promocion.getDescuento());
            resp.setGlosa(promocion.getDescripcion());
        }

        return resp;
    }

    public void imprimir() {
        libroDAL.imprimir();
        precioDAL.imprimir();
        promocionDAL.imprimir();
    }


}
