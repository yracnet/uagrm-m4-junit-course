package bo.uagrm.m4.util;

import bo.uagrm.m4.access.LibroDAL;
import bo.uagrm.m4.access.LibroPromocionDAL;
import bo.uagrm.m4.access.LibroPrecioDAL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class Loader {

    private static Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public static <T> T parseFile(URL url, Class<T> type, T defaultData)  {
        try {
            FileReader reader = new FileReader(url.getFile(), Charset.forName("utf-8"));
            T data = gson.fromJson(reader, type);
            return data;
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
        return defaultData;
    }


    public static LibroDAL libroDAL() {
        var input = Loader.class.getResource("/database/libro-store.json");
        return parseFile(input,LibroDAL.class, new LibroDAL());
    }

    public static LibroPrecioDAL libroPrecioDAL() {
        var input = Loader.class.getResource("/database/libro-precio-store.json");
        return parseFile(input,LibroPrecioDAL.class, new LibroPrecioDAL());
    }

    public static LibroPromocionDAL libroPromocionDAL() {
        var input = Loader.class.getResource("/database/libro-promocion-store.json");
        return parseFile(input,LibroPromocionDAL.class, new LibroPromocionDAL());
    }
}
