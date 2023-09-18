package bo.uagrm.m4.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {

    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean areEquals(Object a, Object b) {
        return a != null && a.equals(b);
    }

    public static String formatDate(Date fecha) {
        return formatter.format(fecha);
    }

    public static Date parseDate(String fecha) {
        try {
            return formatter.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public static String formatNumber(Number numero) {
        return formatNumber(numero, 2);
    }

    public static String formatNumber(Number numero, int decimales) {
        return String.format("%." + decimales + "f", numero);
    }
    
    public static Double roundToTwoDecimals(double number){
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
