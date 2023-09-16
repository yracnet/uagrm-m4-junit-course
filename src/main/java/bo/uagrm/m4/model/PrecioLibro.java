package bo.uagrm.m4.model;

public class PrecioLibro {

    private int id;
    private String isbn;
    private String edicion;
    private Formato formato;
    private double precioVenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
    private Descuento descuento;

    public static enum Formato {
        TAPA_DURA,
        TAPA_BLANDA
    }

    public static enum Descuento {
        DESC_00(0),
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
