package bo.uagrm.m4.model;

public class Libro {
    private Long id;
    private String isbn;
    private String autor;
    private String nombre;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
