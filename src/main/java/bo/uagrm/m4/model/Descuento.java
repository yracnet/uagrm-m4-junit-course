package bo.uagrm.m4.model;

public enum Descuento {
    DESC_00(0),
    DESC_01(0.01),
    DESC_05(0.05),
    DESC_10(0.1),
    DESC_25(0.25);

    private double valor;

    Descuento(double valor) {
        this.valor = valor;
    }

    public Double cacularDescuento(Double monto) {
        return monto * (1 - valor);
    }

}
