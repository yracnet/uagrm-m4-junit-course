package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.TipoPromocion;

public class Main {
    public static void main(String[] args) {
       
        
        CarritoVentaManager carrito = new CarritoVentaManager();
        carrito.imprimir();
        carrito.setFechaCompraString("2023-02-07");
        System.out.println(">> 1000, 2010, TAPA_DURA, NUEVO" );
        var resp = carrito.calcularDescuento("1000", 2010, Formato.TAPA_DURA, TipoPromocion.NUEVO);
        resp.imprimir();
    }
    
}
