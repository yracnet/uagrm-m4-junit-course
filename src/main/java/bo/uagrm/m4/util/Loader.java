package bo.uagrm.m4.util;

import bo.uagrm.m4.model.Libro;
import bo.uagrm.m4.model.PrecioLibro;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static List<Libro> libros(){
        var lista = new ArrayList<Libro>();
        return lista;
    }
    public static List<PrecioLibro> precios(){
        var lista = new ArrayList<PrecioLibro>();
        return lista;
    }
}
