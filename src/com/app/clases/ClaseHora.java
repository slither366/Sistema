package com.app.clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.app.config.MensajeSistema;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ClaseHora {

    /**
     * Metodo para validar si la Hora tipo String recibida como parametros es
     * una hora valida, retorna true o false si la Hora es o no valida, funciona
     * con una hora en formato HH:MM:SS
     *
     * <> Cuando la hora esta en formato 12 horas, la hora tiene que ser Mayor o
     * igual a "1" y Menor o igual a "11"
     * <> Cuando la hora esta en formato 24 horas, la hora tiene que ser Mayor o
     * igual a "0" y Menor o igual a "24"
     *
     * @param hora
     * @return
     */
    public static boolean esHoraValida(String hora) {
        try {
            boolean h12;
            int HORA = Integer.parseInt(hora.substring(0, 2));
            int MINUTO = Integer.parseInt(hora.substring(3, 5));
            int SEGUNDO;
            try {
                String valor = hora.substring(6, 8).toUpperCase();
                if ("AM".equals(valor) || "PM".equals(valor)) {
                    SEGUNDO = 1;
                    h12 = true;
                } else {
                    try {
                        SEGUNDO = Integer.parseInt(valor);
                        h12 = false;
                    } catch (Exception e) {
                        SEGUNDO = 1;
                        h12 = true;
                    }
                }
            } catch (Exception ex) {
                SEGUNDO = 0;
                h12 = false;
            }
            boolean x1 = HORA >= (h12 ? 1 : 0) && HORA < (h12 ? 12 : 24);
            boolean x2 = MINUTO >= (h12 ? 1 : 0) && MINUTO <= (h12 ? 60 : 59);
            boolean x3 = SEGUNDO >= (h12 ? 1 : 0) && SEGUNDO <= (h12 ? 60 : 59);
            return x1 && x2 && x3;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que retorna la Hora actual del sistema en formato hh:mm
     *
     * @return
     */
    public static String getHoraActualHM() {
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna la Hora actual del sistema en formato hh:mm:ss
     *
     * @return
     */
    public static String getHoraActualHMS() {
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna la Hora actual del sistema en formato hh:mm:ss:SSS
     *
     * @return
     */
    public static String getHoraActualHMSM() {
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss:SSS");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna la Hora actual del sistema en formato 12 horas AM-PM
     *
     * @return
     */
    public static String getHoraActualAMPM() {
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm aa");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna la hora actual del sistema
     *
     * @return
     */
    public static String getHora() {
        SimpleDateFormat formateador = new SimpleDateFormat("HH");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna el minuto actual del sistema
     *
     * @return
     */
    public static String getMinuto() {
        SimpleDateFormat formateador = new SimpleDateFormat("mm");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna cuantos Minutos ya paso en el dia
     *
     * @return
     */
    public static long getMinutosDia() {
        return getHoraToMinuto(getHoraActualHMS());
    }

    /**
     * Metodo que retorna el segundo actual del sistema
     *
     * @return
     */
    public static String getSegundo() {
        SimpleDateFormat formateador = new SimpleDateFormat("ss");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna cuantos segundos ya paso en el dia
     *
     * @return
     */
    public static long getSegundoDia() {
        return getHoraToSegundo(getHoraActualHMS());
    }

    /**
     * Metodo que retorna el equivalente de una hora recibida como parametro en
     * segundos
     *
     * @param tiempo
     * @return
     */
    public static long getHoraToSegundo(String tiempo) {
        if (esHoraValida(tiempo)) {
            int HORA = Integer.parseInt(tiempo.substring(0, 2));
            int MINUTO = Integer.parseInt(tiempo.substring(3, 5));
            int SEGUNDO;
            try {
                String valor = tiempo.substring(6, 8).toUpperCase();
                if ("AM".equals(valor) || "PM".equals(valor)) {
                    SEGUNDO = 0;
                } else {
                    try {
                        SEGUNDO = Integer.parseInt(valor);
                    } catch (Exception e) {
                        SEGUNDO = 0;
                    }
                }
            } catch (Exception ex) {
                SEGUNDO = 0;
            }
            return (HORA * 3600) + (MINUTO * 60) + SEGUNDO;
        }
        return -1;
    }

    /**
     * Metodo que retorna el equivalente de una hora recibida como parametros en
     * minutos, dedondeando los segundos si alcanzan 30 segundos.
     *
     * @param tiempo
     * @return
     */
    public static long getHoraToMinuto(String tiempo) {
        if (esHoraValida(tiempo)) {
            int HORA = Integer.parseInt(tiempo.substring(0, 2));
            int MINUTO = Integer.parseInt(tiempo.substring(3, 5));
            int SEGUNDO;
            try {
                String valor = tiempo.substring(6, 8).toUpperCase();
                if ("AM".equals(valor) || "PM".equals(valor)) {
                    SEGUNDO = 0;
                } else {
                    try {
                        SEGUNDO = Integer.parseInt(valor);
                    } catch (Exception e) {
                        SEGUNDO = 0;
                    }
                }
            } catch (Exception ex) {
                SEGUNDO = 0;
            }
            return (HORA * 60) + MINUTO + (SEGUNDO >= 30 ? 1 : 0);
        }
        return -1;
    }

    /**
     * Metodo que retorna el equivalente en hora de los segundos que recibe como
     * parametro
     *
     * @param tiempo
     * @return
     */
    public static String getSegundoToHoraHMS(long tiempo) {
        int vHora = 0, vMinuto = 0, vSegundo = 0;
        if (tiempo >= 0) {
            for (int i = 0; i < tiempo; i++) {
                vSegundo++;
                if (vSegundo == 60) {
                    vSegundo = 0;
                    vMinuto++;
                    if (vMinuto == 60) {
                        vMinuto = 0;
                        vHora++;
                    }
                }
            }
            String x1 = String.valueOf(vHora);
            String x2 = String.valueOf(vMinuto);
            String x3 = String.valueOf(vSegundo);
            String hora = (x1.length() == 1 ? "0" + x1 : x1) + ":";
            hora = hora + (x2.length() == 1 ? "0" + x2 : x2) + ":";
            hora = hora + (x3.length() == 1 ? "0" + x3 : x3);
            return hora;
        } else {
            MensajeSistema.MensajeVarios("Tiene que ser igual o mayor a CERO segundos para poder convertir a hora.", MensajeSistema.ERROR_MESSAGE());
        }
        return null;
    }

    /**
     * Metodo que retorna el equivalente en hora de los segundos que recibe como
     * parametro
     *
     * @param tiempo
     * @return
     */
    public static String getSegundoToHoraHM(long tiempo) {
        int vHora = 0, vMinuto = 0, vSegundo = 0;
        if (tiempo >= 0) {
            for (int i = 0; i < tiempo; i++) {
                vSegundo++;
                if (vSegundo == 60) {
                    vSegundo = 0;
                    vMinuto++;
                    if (vMinuto == 60) {
                        vMinuto = 0;
                        vHora++;
                    }
                }
            }
            if (vSegundo >= 30) {
                vMinuto++;
                if (vMinuto == 60) {
                    vHora++;
                }
            }
            String x1 = String.valueOf(vHora);
            String x2 = String.valueOf(vMinuto);
            String hora = (x1.length() == 1 ? "0" + x1 : x1) + ":" + (x2.length() == 1 ? "0" + x2 : x2);
            return hora;
        } else {
            MensajeSistema.MensajeVarios("Tiene que ser igual o mayor a CERO segundos para poder convertir a hora.", MensajeSistema.ERROR_MESSAGE());
        }
        return null;
    }

    /**
     * Metodo que retorna la diferencia de hora entre la hora1 y la hora2 que
     * recibe como parametro
     *
     * @param hora1
     * @param hora2
     * @return
     */
    public static String diferenciaHora(String hora1, String hora2) {
        long vSeg1 = getHoraToSegundo(hora1);
        long vSeg2 = getHoraToSegundo(hora2);
        if (vSeg1 <= vSeg2) {
            return getSegundoToHoraHMS(vSeg2 - vSeg1);
        } else {
            MensajeSistema.MensajeVarios("La Hora1 no puede ser mayor a la Hora2.\n"
                    + "Verifique y vuelva a intentar!", MensajeSistema.INFORMATION_MESSAGE());
        }
        return null;
    }

    /**
     * Metodo que retorna la diferencia de hora entre la hora1 y la hora2 que
     * recibe como parametro, retorna la diferencia en segundos, retorna -1 si
     * ocurre algun error
     *
     * @param hora1
     * @param hora2
     * @return
     */
    public static long diferenciaHoraLong(String hora1, String hora2) {
        long vSeg1 = getHoraToSegundo(hora1);
        long vSeg2 = getHoraToSegundo(hora2);
        if (vSeg1 <= vSeg2) {
            return vSeg2 - vSeg1;
        } else {
            MensajeSistema.MensajeVarios("La Hora1 no puede ser mayor a la Hora2.\n"
                    + "Verifique y vuelva a intentar!", MensajeSistema.INFORMATION_MESSAGE());
        }
        return -1;
    }

    /**
     * Metodo que suma una hora a otra hora que se envia como paramentros,
     * retorna la cantidad de hora
     *
     * @param hora1
     * @param hora2
     * @return
     */
    public static String SumarHoraString(String hora1, String hora2) {
        long segundos1 = getHoraToSegundo(hora1);
        long segundos2 = getHoraToSegundo(hora2);
        if (segundos1 < 0 || segundos2 < 0) {
            return null;
        }
        return getSegundoToHoraHMS(Long.parseLong((segundos2 + segundos1) + ""));
    }

    /**
     * Metodo que suma una hora a otra hora que se envia como paramentros,
     * retorna la cantidad de hora pero en segundos
     *
     * @param hora1
     * @param hora2
     * @return
     */
    public static long SumarHoraLong(String hora1, String hora2) {
        long segundos1 = getHoraToSegundo(hora1);
        long segundos2 = getHoraToSegundo(hora2);
        if (segundos1 < 0 || segundos2 < 0) {
            return -1;
        }
        return segundos2 + segundos1;
    }   
}
