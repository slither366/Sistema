package com.app.clases;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Diego
 */
public class ClaseNumeros {

    /**
     * Metodo para redondear valores con decimales, recibe dos parametros, uno
     * tipo DOUBLE y otro tipo INT, el parametro REDONDEO de tipo Int es la
     * cantidad de digitos a redondear despues de la coma o la parte decimal del
     * parametro VALOR tipo Double que se recibe
     *
     * @param numero
     * @param decimales
     * @return
     */
    public static double redondearNumero(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }

    /**
     * Metodo para formatear el parametro Valor tipo double que recibe en
     * formato de miles con Decimales
     *
     * @param numero
     * @param decimal
     * @return
     */
    public static String formatoMiles(long numero, int decimal) {
        if (numero == 0) {
            return "";
        }
        return formatoMiles(String.valueOf(numero), decimal);
    }

    /**
     * Metodo para formatear el parametro Valor tipo double que recibe en
     * formato de miles con Decimales
     *
     * @param numero
     * @param decimal
     * @return
     */
    public static String formatoMiles(String numero, int decimal) {
        if (numero.trim().isEmpty()) {
            return "";
        }
        try {
            String vNumero = numero.replaceAll(",", "");
            String Decimal = "";
            int punto = vNumero.indexOf(".");
            if (punto > 0) {
                if (decimal > 0) {
                    Decimal = vNumero.substring(punto);
                    Decimal = Decimal.substring(0, (Decimal.length() > decimal) ? decimal + 1 : Decimal.length());
                    vNumero = vNumero.substring(0, punto);
                } else {
                    vNumero = vNumero.substring(0, punto);
                }
            } else {
                Decimal = decimal == 0 ? "" : ".0";
            }
            return formatoMiles(Long.parseLong(vNumero)) + Decimal;
        } catch (NumberFormatException ex) {            
            return "0";
        }
    }
        
    public static String formatoMiles(long numero) {
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.ENGLISH);
        return nf.format(getNumerosSinDecimal(numero));
    }

    public static String formatoMiles(String numero) {
        try {
            return formatoMiles(Long.parseLong(numero.replaceAll(",", "")));
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public static long getNumerosSinDecimal(String numero) {
        numero = numero.replaceAll(",", "");
        int punto = numero.indexOf(".");
        numero = numero.substring(0, punto < 0 ? numero.length() : punto);
        return Long.parseLong(numero);
    }

    public static long getNumerosSinDecimal(long numero) {
        return getNumerosSinDecimal(String.valueOf(numero));
    }
}
