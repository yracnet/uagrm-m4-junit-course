package bo.uagrm.m4.model;

import lombok.Data;

@Data
public class PrecioLibro {

    private Long id;
    private String isbn;
    private String edicion;
    private Formato formato;
    private double precioVenta;
    private Descuento descuento;

    public static enum Formato {
        TAPA_DURA,
        TAPA_BLANDA
    }

    public static enum Descuento {
        DESC_01(0.01),
        DESC_05(0.05),
        DESC_10(0.1),
        DESC_25(0.25);

        private double valor;

        Descuento(double valor) {
            this.valor = valor;
        }
        
        public Double cacularDescuento(Double monto){
            return monto * (1 - valor);
        }

    }
}
