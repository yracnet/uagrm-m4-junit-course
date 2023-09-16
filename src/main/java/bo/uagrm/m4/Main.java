package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.LibroPrecio;

public class Main {
    public static void main(String[] args) {
        CarritoVentaManager carrito = new CarritoVentaManager();
        carrito.imprimir();
        
        var resp = carrito.calcularDecuento("1000", 2019, Formato.TAPA_DURA);
        resp.imprimir();
    }
    
}
