package com.app.clases;

import com.app.config.MensajeSistema;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author Diego
 */
public class ClaseUtilidades {

    /**
     * metodo para convertir temperaturas de Centigrados a Farenheit
     *
     * @param Tem
     * @return
     */
    public static double centigradosToFarenheit(double Tem) {
        double result = Tem;
        result = result * 2 - result / 5;
        result = result + 32;
        return result;
    }

    /**
     * metodo para convertir temperaturas de Farenheit a Centigrados
     *
     * @param Tem
     * @return
     */
    public static double farenheitToCentigrados(double Tem) {
        double result;
        result = Tem - 32;
        result *= 5;
        result /= 9;
        return result;
    }

    /**
     * metodo que comprueba si existe conexion a internet, recibiendo como
     * parametros la URL de la pagina web, sino usa una URL Predeterminada
     *
     * @param dirWeb
     * @return
     */
    public static boolean ConeccionInternet(String dirWeb) {
        if (!dirWeb.trim().isEmpty()) {
            int puerto = 80;
            try {
                Socket s = new Socket(dirWeb, puerto);
                return s.isConnected();
            } catch (IOException e) {
            }
        }
        return false;
    }

    /**
     * metodo para saber el directorio de Trabajo desde donde corre el sistema
     *
     * @return
     */
    public static String getDirectorioTrabajo() {
        return System.getProperty("user.dir");
    }

    /**
     * metodo para saber que separador usa el sistema operativo donde corre el
     * sistema
     *
     * @return
     */
    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * metodo para saber el Sistema Operativo donde corre el sistema
     *
     * @return
     */
    public static String getSistemaOperativo() {
        return System.getProperty("os.name");

    }

    /**
     * metodo para saber la version del sistema operativo
     *
     * @return
     */
    public static String getSistemaOperativoVersion() {
        return System.getProperty("os.version");
    }

    /**
     * metodo para saber el nombre de usuario de la pc
     *
     * @return
     */
    public static String getNombreUsuario() {
        return System.getProperty("user.name");
    }

    /**
     * metodo para saber la resolucion de la pantalla donde corre el sistema
     *
     * @return
     */
    public static Dimension getPantallaTamaño() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return pantalla;
    }

    public static int getPantallaTamoñoHorizontal() {
        return getPantallaTamaño().width;
    }

    public static int getPantallaTamoñoVertical() {
        return getPantallaTamaño().height;
    }

    /**
     * para saber si una ruta es un directorio del sistema
     *
     * @param ruta
     * @return
     */
    public static boolean esDirectorio(String ruta) {
        return new File(ruta).isDirectory();
    }

    /**
     * metodo para saber si existe el archivo especificado en un directorio
     *
     * @param file
     * @return
     */
    public static boolean esArchivo(String file) {
        return new File(file).isFile();
    }

    /**
     *
     * @param file
     * @return
     */
    public static boolean existe(String file) {
        return new File(file).exists();
    }

    /**
     * metodo para crear un directorio con el nombre y direccion especificado
     *
     * @param Ruta
     * @return
     */
    public static boolean setCrearDirectorio(String Ruta) {
        return new File(Ruta).mkdir();
    }

    /**
     * metodo para crear un archivo con el nombre y direccion especificado
     *
     * @param ruta
     * @param archivo
     * @return
     */
    public static boolean setCrearArchivo(String ruta, String archivo) {
        try {
            new FileWriter(ruta + getSeparator() + archivo);
            return esArchivo(ruta + getSeparator() + archivo);
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * metodo que hace una captura de pantalla y guarda un archivo.jpg en la
     * carpeta errores con el nombre de la fechahoraminutosegundo actual del
     * sistema
     *
     * @return
     */
    public static boolean capturarPantalla() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
        String nombreArchivo = formateador.format(new Date());
        String direccion = getDirectorioTrabajo() + getSeparator() + "errores" + getSeparator();
        if (!esDirectorio(direccion)) {
            setCrearDirectorio(direccion);
        }
        direccion = direccion + "error" + nombreArchivo + ".jpg";
        try {
            Robot r = new Robot();
            Rectangle captureSize = new Rectangle(getPantallaTamaño());
            BufferedImage bufImg = r.createScreenCapture(captureSize);
            return ImageIO.write(bufImg, "jpg", new File(direccion));
        } catch (AWTException | IOException ex) {
        }
        return false;
    }

    /**
     * Metodo que retorna la direccion IP de la maquina local
     *
     * @return
     */
    public static String getDireccionIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
        }
        return null;
    }

    /**
     * Metodo que retorna el nombre del equipo local
     *
     * @return
     */
    public static String getNombreEquipo() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
        }
        return null;
    }

    /**
     * Metodo que verifica el si esta bien el correo electronico
     *
     * @param email
     * @return
     */
    public static boolean verificarMail(String email) {
        return email.matches("[-\\w\\.]+@\\w+\\.\\w+");
    }

    public static void abrirEnlace(String url) {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            MensajeSistema.setException("Se produjo un error al intentar abrir el Enlace...", ex);
        }
    }
}
