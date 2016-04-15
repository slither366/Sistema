package com.app.clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Diego
 */
public class StringED {

    //algoritmos
    private static final String MD2 = "MD2";
    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA-1";
    private static final String SHA256 = "SHA-256";
    private static final String SHA384 = "SHA-384";
    private static final String SHA512 = "SHA-512";
    
    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 32 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarMD2(String text) {
        return getStringMessageDigest(text, MD2);
    }

    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 32 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarMD5(String text) {
        return getStringMessageDigest(text, MD5);
    }

    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 40 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarSHA1(String text) {
        return getStringMessageDigest(text, SHA1);
    }

    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 64 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarSHA256(String text) {
        return getStringMessageDigest(text, SHA256);
    }

    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 96 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarSHA384(String text) {
        return getStringMessageDigest(text, SHA384);
    }

    /**
     * Metodo que encripta la cadena de texto que recibe como parametro. retorna
     * un String de 128 caracteres
     *
     * @param text texto a encriptar
     * @return texto encriptado
     */
    public static String EncriptarSHA512(String text) {
        return getStringMessageDigest(text, SHA512);
    }

    /**
     * *
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     *
     * @param digest arreglo de bytes a convertir
     * @return String creado a partir de <code>digest</code>
     */
    private static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    /**
     * *
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     *
     * @param message texto a encriptar
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1,
     * SHA-256, SHA-384, SHA-512
     * @return mensaje encriptado
     */
    private static String getStringMessageDigest(String message, String algorithm) {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }
}
