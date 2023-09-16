package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import bo.uagrm.m4.model.PrecioLibro;

public class Main {
    public static void main(String[] args) {
        CarritoVentaManager cart = new CarritoVentaManager();
        cart.imprimir();
    }
    
}
