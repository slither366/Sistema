package com.app.clases;

import com.app.config.MensajeSistema;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ClaseEncriptacion {

    private final static String letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789_-";
    private final static String[] caracteres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
        "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "_", "-"};
    private final static String[] cifrado = {"P", "Q", "2", "3", "T", "U", "V", "Z",
        "1", "5", "9", "0", "%", "N", "$", "K", "L", "4", "R", "S", "O", "W", "X", "Y",
        "A", "6", "7", "D", "E", "8", "B", "C", "F", "G", "?", "I", "-", "_"};

    /**
     * Metodo para encriptar un String que recibe como parametro
     *
     * @param text
     * @return
     */
    public static String cifrarTexto(String text) {
        String textoCifrado = "";
        if (isTextoPermitido(text)) {
            text = text.toUpperCase();
            String t1;
            int posicion = text.length();
            if (text.length() <= 40) {
                for (int i = 1; i <= text.length(); i++) {
                    t1 = text.substring(i - 1, i);
                    for (int x = 0; x <= caracteres.length; x++) {
                        if (t1.equals(caracteres[x])) {
                            textoCifrado += cifrado[x];
                            break;
                        }
                    }
                }
                if (textoCifrado.length() < 40) {
                    textoCifrado = textoCifrado + "|";
                    while (textoCifrado.length() <= 40) {
                        posicion = posicion + 2;
                        if (posicion >= cifrado.length - 1) {
                            posicion = 3;
                        }
                        if (textoCifrado.length() == 40) {
                            break;
                        } else {
                            textoCifrado = textoCifrado + cifrado[posicion];
                        }
                    }
                }
                textoCifrado = "*" + textoCifrado;
            } else {
                JOptionPane.showMessageDialog(null, "La longitud del texto no es el permitido\nEl máximo permitido son 40 caracteres...",
                        "Error de Cifrado!!!", JOptionPane.ERROR_MESSAGE);
                textoCifrado = "";
            }
        }
        return textoCifrado;
    }

    /**
     * Metodo para desencriptar un string que recibe como parametros
     * <>Este metodo solo funciona para textos que hayan sido encriptados por el
     * metodo "cifrarTexto"
     *
     * @param text
     * @return
     */
    public static String descifrarTexto(String text) {
        String textoDescifrado = "", t1;
        int posicion;
        if ("*".equals(text.substring(0, 1))) {
            posicion = text.indexOf("|");
            if (posicion < 0) {
                posicion = text.length();
            }
            text = text.substring(1, posicion);
            for (int i = 1; i <= text.length(); i++) {
                t1 = text.substring(i - 1, i);
                for (int x = 0; x <= cifrado.length; x++) {
                    if (t1.equals(cifrado[x])) {
                        textoDescifrado += caracteres[x];
                        break;
                    }
                }
            }
            textoDescifrado = textoDescifrado.toLowerCase();
        } else {
            JOptionPane.showMessageDialog(null, "El texto no es un texto Cifrado...",
                    "Error al Descrifrar!!!", JOptionPane.ERROR_MESSAGE);
        }

        return textoDescifrado;
    }

    /**
     * Mentodo para saber que caracteres estan permitidos para la contraseña, Se
     * envia como parametro el texto completo que se quiera validar.
     *
     * @param text
     * @return
     */
    public static boolean isTextoPermitido(String text) {
        boolean resultado = false;
        String letra = "";
        int longitud = text.length();
        if (longitud != 0) {
            for (int i = 0; i < longitud; i++) {
                letra = text.substring(i, i + 1);
                resultado = ClaseEncriptacion.letras.contains(letra);
                if (resultado == false) {
                    break;
                }
            }
            if (resultado == false) {
                MensajeSistema.MensajeVarios("El caracter \"" + letra + "\" no esta permitida... \n"
                        + "Solo esta permitido letras desde la \"a\" hasta la \"z\" \n"
                        + "y números desde el \"0\" hasta el \"9\"...",
                        MensajeSistema.ERROR_MESSAGE());
            }
        } else {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Mentodo para validar letra a letra cuando se escribe si es valida o no
     * <>Se usa en el KeyTiped del Campo<>
     *
     * @param evt
     * @return
     */
    public static boolean isCaracterPermitido(KeyEvent evt) {
        return (ClaseEncriptacion.letras.contains(evt.getKeyChar() + "")) || (evt.getKeyChar() + "".trim().length() == 8);
    }

    public static String getLetras() {
        return letras;
    }
}
