package bo.uagrm.m4.manager;

import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.TipoPromocion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarritoVentaManager {
    
    public TestCarritoVentaManager() {
    }
    
    @Test
    public void testCalcularDescuentoLibroNuevo(){
        System.out.println("testCalcularDescuentoLibroNuevo");
        CarritoVentaManager instance = new CarritoVentaManager();
        instance.setFechaVentaString("2023-02-07");
        
        String isbn = "1000";
        Integer edicion = 2019;
        Formato formato =  Formato.TAPA_DURA;
        TipoPromocion tipo =  TipoPromocion.NUEVO;
        
        Double expResult = 346.50;
        
        ValorDescuento respValorDescuento = instance.calcularDescuento(isbn, edicion, formato, tipo);
        
        Double result = respValorDescuento.getTotal();
        
        assertEquals(expResult,result);
        
        System.out.println("Valor esperado = " + expResult);
        System.out.println("Valor obtenido = " + result);
        
    }
    
    
    
}
