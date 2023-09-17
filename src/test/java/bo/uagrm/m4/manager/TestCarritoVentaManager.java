package bo.uagrm.m4.manager;
import bo.uagrm.m4.exception.NotFoundException;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.TipoPromocion;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class TestCarritoVentaManager {
    
    public TestCarritoVentaManager() {
    }

    //Libro Nuevo
    @Test
    public void testCalcularDescuentoLibroNuevo() {
        System.out.println("calcularDecuentoLibroNuevo");
        String isbn = "1000";
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        Double expResult = 346.50;
        ValorDescuento respValorDescuento = instance.calcularDescuento(isbn, edicion, formato, tipo);
        Double result = respValorDescuento.getTotal();
        assertEquals(expResult, result);
        System.out.println("Valor esperado = " + expResult);
        System.out.println("valor obtenido = " + result + "\n");
    } 
    
    @Test
    public void testCalcularDescuentoLibroNuevoExceptionISBN() {
        System.out.println("testCalcularDescuentoLibroNuevoExceptionISBN");
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(null, edicion, formato, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage() + "\n");
    }
    
    @Test
    public void testCalcularDescuentoLibroNuevoExceptionEdicion() {
        System.out.println("testCalcularDescuentoLibroNuevoExceptionEdicion");
        String isbn = "1000";
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(isbn, null, formato, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage()+ "\n");
    } 
    
    @Test
    public void testCalcularDescuentoLibroNuevoExceptionFormato() {
        System.out.println("testCalcularDescuentoLibroNuevoExceptionFormato");
        String isbn = "1000";
        Integer edicion = 2019;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(isbn, edicion, null, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage() + "\n");
    } 
    
    @Test
    public void testCalcularDescuentoLibroNuevoSinDescuento() {
        System.out.println("testCalcularDescuentoLibroNuevoSinDescuento");
        String isbn = "1000";
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-06-27";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        Double expResult = 350.0;
        ValorDescuento respValorDescuento = instance.calcularDescuento(isbn, edicion, formato, tipo);
        Double result = respValorDescuento.getTotal();
        assertEquals(expResult, result);
        System.out.println("Valor esperado = " + expResult);
        System.out.println("valor obtenido = " + result + "\n");
    } 
    
    //Libro Antiguo
    @Test
    public void testCalcularDescuentoLibroAntiguo() {
        System.out.println("testCalcularDescuentoLibroAntiguo");
        String isbn = "1000";
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        String fechaCompra = "2023-06-27";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        Double expResult = 315.0;
        ValorDescuento respValorDescuento = instance.calcularDescuento(isbn, edicion, formato, tipo);
        Double result = respValorDescuento.getTotal();
        assertEquals(expResult, result);
        System.out.println("Valor esperado = " + expResult);
        System.out.println("valor obtenido = " + result + "\n");
    } 
    
    @Test
    public void testCalcularDescuentoLibroAntiguoSinDescuento() {
        System.out.println("testCalcularDescuentoLibroAntiguoSinDescuento");
        String isbn = "1000";
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        String fechaCompra = "2023-06-05";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        Double expResult = 350.0;
        ValorDescuento respValorDescuento = instance.calcularDescuento(isbn, edicion, formato, tipo);
        Double result = respValorDescuento.getTotal();
        assertEquals(expResult, result);
        System.out.println("Valor esperado = " + expResult);
        System.out.println("valor obtenido = " + result + "\n");
    }
    
    @Test
    public void testCalcularDescuentoLibroAntiguoExceptionISBN() {
        System.out.println("testCalcularDescuentoLibroAntiguoExceptionISBN");
        Integer edicion = 2019;
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(null, edicion, formato, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage() + "\n");
    }
    
    @Test
    public void testCalcularDescuentoLibroAntiguoExceptionEdicion() {
        System.out.println("testCalcularDescuentoLibroAntiguoExceptionEdicion");
        String isbn = "1000";
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(isbn, null, formato, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage()+ "\n");
    } 
    
    @Test
    public void testCalcularDescuentoLibroAntiguoExceptionFormato() {
        System.out.println("testCalcularDescuentoLibroAntiguoExceptionFormato");
        String isbn = "1000";
        Integer edicion = 2019;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        String fechaCompra = "2023-02-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        NotFoundException assertThrows = assertThrows(NotFoundException.class, () -> {
            instance.calcularDescuento(isbn, edicion, null, tipo);
        });
        System.out.println("Exception: " + assertThrows.getMessage() + "\n");
    }
    
    //Calcular precios distintos de libros

    // Por tipo de promocion: nuevo o antiguo
    @Test
    public void testCalcularDescuentoValorDistintoPorTipoPromo() {
        System.out.println("testCalcularDescuentoValorDistintoPorTipoPromo");
        String isbn = "1001";
        Integer edicion = 1989;
        Formato formato = Formato.TAPA_BLANDA;
        TipoPromocion tipo1 = TipoPromocion.NUEVO;
        TipoPromocion tipo2 = TipoPromocion.ANTIGUO;
        
        String fechaCompra = "2023-07-07";
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        ValorDescuento respValorDescuento1 = instance.calcularDescuento(isbn, edicion, formato, tipo1);
        ValorDescuento respValorDescuento2 = instance.calcularDescuento(isbn, edicion, formato, tipo2);
        respValorDescuento1.imprimir();
        respValorDescuento2.imprimir();
        System.out.println();
        System.out.println("Valor Total TipoPromo Opcion 1 = " + respValorDescuento1.getTotal());
        System.out.println("Valor Total TipoPromo Opcion 2 = " + respValorDescuento2.getTotal());
        
        assertFalse(respValorDescuento1.equals(respValorDescuento2));
    }
    
    //Con diferente Edicion - Obs
    @Test
    public void testCalcularDescuentoValorDistintoPorEdicion() {
        System.out.println("testCalcularDescuentoValorDistintoPorEdicion");
        String isbn = "1000";
        Formato formato = Formato.TAPA_DURA;
        TipoPromocion tipo = TipoPromocion.NUEVO;
        String fechaCompra = "2023-02-07";
        Integer edicion1 = 2010;
        Integer edicion2 = 2019;
        
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        ValorDescuento respValorDescuento1 = instance.calcularDescuento(isbn, edicion1, formato, tipo);
        ValorDescuento respValorDescuento2 = instance.calcularDescuento(isbn, edicion2, formato, tipo);
        respValorDescuento1.imprimir();
        respValorDescuento2.imprimir();
        System.out.println("Valor Total Edicion Opcion 1 = " + respValorDescuento1.getTotal());
        System.out.println("Valor Total Edicion Opcion 2 = " + respValorDescuento2.getTotal());
        
        assertFalse(respValorDescuento1.equals(respValorDescuento2));
    }
    
    //Con diferente Formato - Obs
    @Test
    public void testCalcularDescuentoValorDistintoPorFormato() {
        System.out.println("testCalcularDescuentoValorDistintoPorFormato");
        String isbn = "1001";
        Integer edicion = 2001;
        TipoPromocion tipo = TipoPromocion.ANTIGUO;
        Formato formato1 = Formato.TAPA_DURA;
        Formato formato2 = Formato.TAPA_BLANDA;
        String fechaCompra = "2023-07-07";
        
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaCompraString(fechaCompra);
        
        ValorDescuento respValorDescuento1 = instance.calcularDescuento(isbn, edicion, formato1, tipo);
        ValorDescuento respValorDescuento2 = instance.calcularDescuento(isbn, edicion, formato2, tipo);
        respValorDescuento1.imprimir();
        respValorDescuento2.imprimir();
        System.out.println("Valor Total Formato Opcion 1 = " + respValorDescuento1.getTotal());
        System.out.println("Valor Total Formato Opcion 2 = " + respValorDescuento2.getTotal());
        
        assertFalse(respValorDescuento1.equals(respValorDescuento2));
    }
}
