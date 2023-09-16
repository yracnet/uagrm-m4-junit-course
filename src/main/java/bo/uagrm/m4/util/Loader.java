package bo.uagrm.m4.util;

import bo.uagrm.m4.model.Descuento;
import bo.uagrm.m4.model.Formato;
import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static List<Libro> libros(){
        var lista = new ArrayList<Libro>();
        
        Libro a = new Libro();
        a.setId(1L);
        a.setIsbn("1000");
        a.setNombre("El principito");
        a.setDescripcion("Libro1");
        a.setAutor("Antoine de Saint-Exupéry");
       
        Libro b = new Libro();
        b.setId(2L);
        b.setIsbn("1001");
        b.setNombre("Habitos Atomicos");
        b.setDescripcion("Libro2");
        b.setAutor("Antoine de Saint-Exupéry");
                
        return lista;
    }
    public static List<PrecioLibro> precios(){
        var lista = new ArrayList<PrecioLibro>();
        
         PrecioLibro ap = new PrecioLibro();
        ap.setId(1L);
        ap.setIsbn("1000");
        ap.setEdicion(2019);
        ap.setFormato(Formato.TAPA_DURA);
        ap.setDescuento(Descuento.DESC_01);
        ap.setPrecioVenta(350D);
        
        PrecioLibro ap2 = new PrecioLibro();
        ap2.setId(2L);
        ap2.setIsbn("1000");
        ap2.setEdicion(2005);
        ap2.setFormato(Formato.TAPA_DURA);
        ap2.setDescuento(Descuento.DESC_05);
        ap2.setPrecioVenta(330D);
        
        PrecioLibro ap3 = new PrecioLibro();
        ap3.setId(3L);
        ap3.setIsbn("1000");
        ap3.setEdicion(2010);
        ap3.setFormato(Formato.TAPA_BLANDA);
        ap3.setDescuento(Descuento.DESC_10);
        ap3.setPrecioVenta(200D);
        
        //-------------------------------------------------
        
        PrecioLibro bp = new PrecioLibro();
        bp.setId(4L);
        bp.setIsbn("1001");
        bp.setEdicion(2023);
        bp.setFormato(Formato.TAPA_DURA);
        bp.setDescuento(Descuento.DESC_01);
        bp.setPrecioVenta(550D);
        
        PrecioLibro bp2 = new PrecioLibro();
        bp2.setId(5L);
        bp2.setIsbn("1001");
        bp2.setEdicion(2005);
        bp2.setFormato(Formato.TAPA_BLANDA);
        bp2.setDescuento(Descuento.DESC_10);
        bp2.setPrecioVenta(330D);
        
        PrecioLibro bp3 = new PrecioLibro();
        bp3.setId(6L);
        bp3.setIsbn("1001");
        bp3.setEdicion(1989);
        bp3.setFormato(Formato.TAPA_BLANDA);
        bp3.setDescuento(Descuento.DESC_25);
        bp3.setPrecioVenta(300D);
        
        return lista;
    }
}
