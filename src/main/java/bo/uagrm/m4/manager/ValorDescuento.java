
package bo.uagrm.m4.manager;

import lombok.Data;

@Data
public class ValorDescuento {
    private String isbn;
    private String titulo;
    private String autor;
    private Double precio;
    private Double descuento;
    private Double total;
    private String glosa;
    
    public void initPorcentaDecuento(Double precio, Float porcentaje){
            this.precio = precio;
            this.descuento = precio * porcentaje;
            this.total = precio - this.descuento;
    }

    public void imprimir() {
        System.out.println("VALOR DESCUENTO");
        System.out.println("-------------------------------------");
        System.out.println("ISBN      : " + isbn);
        System.out.println("TITULO    : " + titulo);
        System.out.println("AUTOR     : " + autor);
        System.out.println("PRECIO    : " + precio);
        System.out.println("DESCUENTO : " + descuento);
        System.out.println("TOTAL     : " + total);
        System.out.println("GLOSA     : " + glosa);
    }
}
