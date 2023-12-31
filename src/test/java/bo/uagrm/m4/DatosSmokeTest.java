package bo.uagrm.m4;

import bo.uagrm.m4.manager.CarritoVentaManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void testInicial() {
        var carrito = new CarritoVentaManager();

        var libroCount = carrito.getLibroDAL().count();
        var precioCount = carrito.getPrecioDAL().count();
        var promocionCount = carrito.getPromocionDAL().count();
        var fechaVenta = carrito.getFechaVenta();

        assertNotEquals(libroCount, 0);
        assertNotEquals(libroCount, 0);
        assertNotEquals(precioCount, 0);
        assertNotEquals(promocionCount, 0);
    }
}
