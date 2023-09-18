package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import bo.uagrm.m4.model.Formato;

public class Main {
    public static void main(String[] args) {
        CarritoVentaManager carrito = new CarritoVentaManager();
        carrito.imprimir();
        carrito.setFechaVentaString("2000-02-07");
        System.out.println(">> 1000, 2019, TAPA_DURA" );
        var resp = carrito.calcularDecuento("1000", 2019, Formato.TAPA_DURA);
        resp.imprimir();
    }
    
}
