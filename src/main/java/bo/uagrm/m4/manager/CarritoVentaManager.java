package bo.uagrm.m4.manager;

import bo.uagrm.m4.access.LibroDAL;
import bo.uagrm.m4.access.LibroPrecioDAL;
import bo.uagrm.m4.access.LibroPromocionDAL;
import bo.uagrm.m4.exception.NotFounException;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.LibroPrecio;
import bo.uagrm.m4.model.LibroPromocion;
import bo.uagrm.m4.model.TipoPromocion;
import bo.uagrm.m4.util.Loader;
import bo.uagrm.m4.util.Tool;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CarritoVentaManager {

    @Setter
    private Date fechaVenta = new Date();
    private final LibroDAL libroDAL = Loader.libroDAL();
    private final LibroPrecioDAL precioDAL = Loader.libroPrecioDAL();
    private final LibroPromocionDAL promocionDAL = Loader.libroPromocionDAL();

    public void setFechaVentaString(String fecha) {
        fechaVenta = Tool.parseDate(fecha);
    }

    public String getFechaVentaString() {
        return Tool.formatDate(fechaVenta);
    }

    public ValorDescuento calcularDescuento(String isbn, Integer edicion, Formato formato, TipoPromocion tipo) {
        Libro libro = libroDAL.buscarLibro(isbn);
        if (libro == null) {
            throw new NotFounException("Libro no encontrado");
        }
        LibroPrecio precio = precioDAL.buscarPrecio(isbn, edicion, formato);
        if (precio == null) {
            throw new NotFounException("Precio Libro no encontrado");
        }
        System.out.println("fechaVenta = " + fechaVenta);
        LibroPromocion promocion = promocionDAL.buscarPromocion(fechaVenta, isbn, edicion, formato, tipo);

        var resp = new ValorDescuento();
        resp.setIsbn(libro.getIsbn());
        resp.setTitulo(libro.getTitulo());
        resp.setAutor(libro.getAutor());
        resp.setMoneda(precio.getMoneda());

        if (promocion == null) {
            resp.initPorcentaDecuento(precio.getPrecioUnitario(), 0F);
            resp.setTipo(null);
            resp.setGlosa("Sin descuento");
        } else {
            resp.initPorcentaDecuento(precio.getPrecioUnitario(), promocion.getDescuento());
            resp.setTipo(promocion.getTipo());
            resp.setGlosa("Descuento por Libro " + promocion.getTipo());
        }

        return resp;
    }

    public void imprimir() {
        libroDAL.imprimir();
        precioDAL.imprimir();
        promocionDAL.imprimir();
    }
}
