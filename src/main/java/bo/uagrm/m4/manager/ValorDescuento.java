
package bo.uagrm.m4.manager;

import bo.uagrm.m4.util.Tool;
import lombok.Data;

@Data
public class ValorDescuento {
    private String isbn;
    private String titulo;
    private String autor;
    private String moneda;
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
        System.out.println("MONEDA    : " + moneda);
        System.out.println("PRECIO    : " + Tool.formatNumber(precio));
        System.out.println("DESCUENTO : " + Tool.formatNumber(descuento));
        System.out.println("TOTAL     : " + Tool.formatNumber(total) );
        System.out.println("GLOSA     : " + glosa);
    }
}
