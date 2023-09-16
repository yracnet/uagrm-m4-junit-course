package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatosSmokeTest {
    
    public DatosSmokeTest() {
    }

    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
     @Test
     public void simple() {
         var carrito = new CarritoVentaManager ();
         
         var libroCount = carrito.getLibroDAL().count();
         var precioCount = carrito.getPrecioDAL().count();
         var promocionCount = carrito.getPromocionDAL().count();
         var fechaCompra = carrito.getFechaCompra();
         
         assertEquals(libroCount,2);
         assertEquals(libroCount,2);
         assertEquals(precioCount,6);
         assertEquals(promocionCount,6);
     }
}
