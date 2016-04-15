package com.app.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author diego
 */
public final class Propiedades {

    private final Properties propiedades;
    private InputStream entrada = null;
    private OutputStream salida = null;
    String vDir;
//    String SO = System.getProperty("os.name");
    private static String decoracion;

    public Propiedades() throws FileNotFoundException, IOException {
        this.propiedades = new Properties();
//        switch (SO.toUpperCase().substring(0, 3)) {
//            case "WIN": {
//                vDir = "C:\\Librerias_java\\configuracion.properties";
//                break;
//            }
//            case "LIN": {
//                vDir = "/home/diego/config/configuracion.properties";
//                break;
//            }
//            case "IOS": {
//                vDir = "/home/diego/config/configuracion.properties";
//                break;
//            }
//            default: {
//                vDir = "configuracion.properties";
//            }
//        }    

        vDir = "configuracion.properties";
        this.entrada = new FileInputStream(vDir);
        // cargamos el archivo de Propiedades
        propiedades.load(entrada);
        decoracion = getDecoracion();

    }

    /**
     * Metodo que retorna la direccion del servidor en donde esta la Base de
     * Datos
     *
     * @return
     */
    public String getHost() {
        return propiedades.getProperty("host");
    }

    /**
     * Metodo que Guarda el Port del Servidor
     *
     * @param host
     */
    public void setHost(String host) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("host", host);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    /**
     * Metodo que retorna la direccion del servidor en donde esta la Base de
     * Datos
     *
     * @return
     */
    public String getPort() {
        return propiedades.getProperty("port");
    }

    /**
     * Metodo que Guarda el Port del Servidor
     *
     * @param port
     */
    public void setPort(String port) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("port", port);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    /**
     * Metodo que retorna el Nombre de la Base de Datos a que se va a conectar
     * el Sistema
     *
     * @return
     */
    public String getBD() {
        return propiedades.getProperty("bd");
    }

    /**
     * Metodo que guarda el nombre de la Base de Datos donde se va a conectar el
     * Sistema
     *
     * @param bd
     */
    public void setBD(String bd) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("bd", bd);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    /**
     * Metodo que retorna el Nombre de Usuario que se va a utilizar para
     * conectar el Sistema con la Base de Datos
     *
     * @return
     */
    public String getUser() {
        return propiedades.getProperty("user");
    }

    /**
     * Metodo que Guarda el Nombre de Usuario que se va a utilizar para conectar
     * el Sistema a la Base de Datos
     *
     * @param user
     */
    public void setUser(String user) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("user", user);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    /**
     * Metodo que retorna el Password del Usuario que se va a utilizar para
     * conectar el Sistema con la Base de Datos
     *
     * @return
     */
    public String getPass() {
        return propiedades.getProperty("pass");
    }

    /**
     * Metodo que Guarda el Password del Usuario que se va a utilizar para
     * conectar el Sistema con la Base de Datos
     *
     * @param pass
     */
    public void setPass(String pass) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("pass", pass);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    /**
     * Metodo que retorna la decoracion del Sistemas
     *
     * @return
     */
    public String getDecoracion() {
        return propiedades.getProperty("decoracion");
    }

    public static String getDecoracion2() {
        return decoracion;
    }

    /**
     * Metodo que guarda la configución de la decoración del Sistema
     *
     * @param decoracion
     */
    public void setDecoracion(String decoracion) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("decoracion", decoracion);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }

    public String getImpresora() {
        return propiedades.getProperty("impresora");
    }

    public void setImpresora(String impresora) {
        try {
            this.salida = new FileOutputStream(vDir);
            propiedades.setProperty("impresora", impresora);
            propiedades.store(salida, null);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error!!!", ex);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    MensajeSistema.setIOException("Se produjo un error!!!", ex);
                }
            }
        }
    }
}
