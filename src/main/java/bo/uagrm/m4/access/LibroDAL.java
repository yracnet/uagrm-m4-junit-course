package bo.uagrm.m4.access;

import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class LibroDAL {

    @Setter
    @Getter
    private List<Libro> libros;

    public void imprimir() {
        System.out.println("LIBROS");
        System.out.println("-------------------------------------");
        String template = "%-6s | %-30s | %-30s";
        System.out.println(String.format(template, new Object[]{"ISBN", "TITULO", "AUTOR"}));
        for (Libro libro : libros) {
            System.out.println(String.format(template, new Object[]{libro.getIsbn(), libro.getTitulo(), libro.getAutor()}));
        }
        System.out.println("-------------------------------------");
    }

    public Libro buscarLibro(String isbn) {
        for (var it : libros) {
            var sw = it.isLibroIgual(isbn);
            if (sw) {
                return it;
            }
        }
        return null;
    }

}
