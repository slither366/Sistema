package com.app.clases.utilidades;

/**
 *
 * @author Diego
 */
public class NumeroEnLetra {

    private static final String[] _grupos = {"", "millon", "billon", "trillon"};
    private static final String[] _unidades = {"", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    private static final String[] _decena1 = {"", "once", "doce", "trece", "catorce", "quince",
        "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
    private static final String[] _decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta",
        "sesenta", "setenta", "ochenta", "noventa"};
    private static final String[] _centenas = {"", "cien", "doscientos", "trescientos", "cuatrocientos",
        "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

    /**
     * Metodo para convertir un valor numerico a letras, recibe como parametro
     * el numero tipo long y retorna en letras el Numero recibido
     *
     * @param numero
     * @return
     */
    public static String numeroEnLetra(long numero) {
        String resultado = "";
        int grupo = 0;
        while (numero != 0 && grupo < _grupos.length) {
            long fragmento = numero % 1000000;
            int millarAlto = (int) (fragmento / 1000);
            int millarBajo = (int) (fragmento % 1000);
            numero = numero / 1000000;

            String nombreGrupo = _grupos[grupo];
            if (fragmento > 1 && grupo > 0) {
                nombreGrupo += "es";
            }
            if ((millarAlto != 0) || (millarBajo != 0)) {
                if (millarAlto > 1) {
                    resultado = millarATexto(millarAlto) + " mil "
                            + millarATexto(millarBajo) + " "
                            + nombreGrupo + " "
                            + resultado;
                }
                if (millarAlto == 0) {
                    resultado = millarATexto(millarBajo) + " "
                            + nombreGrupo + " "
                            + resultado;
                }
                if (millarAlto == 1) {
                    resultado = "mil " + millarATexto(millarBajo) + " "
                            + nombreGrupo + " "
                            + resultado;
                }
            }
            grupo++;
        }
        return resultado.trim();
    }

    private static String millarATexto(int n) {
        if (n == 0) {
            return "";
        }
        int centenas = n / 100;
        n = n % 100;
        int decenas = n / 10;
        int unidades = n % 10;
        String sufijo = "";
        if (decenas == 0 && unidades != 0) {
            sufijo = _unidades[unidades];
        }
        if (decenas == 1 && unidades != 0) {
            sufijo = _decena1[unidades];
        }
        if (decenas == 2 && unidades != 0) {
            sufijo = "veinti" + _unidades[unidades];
        }
        if (unidades == 0) {
            sufijo = _decenas[decenas];
        }
        if (decenas > 2 && unidades != 0) {
            sufijo = _decenas[decenas] + " y " + _unidades[unidades];
        }
        if (centenas != 1) {
            return _centenas[centenas] + " " + sufijo;
        }
        if (unidades == 0 && decenas == 0) {
            return "cien";
        }
        return "ciento " + sufijo;
    }
}
