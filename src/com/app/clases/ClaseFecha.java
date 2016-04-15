package com.app.clases;

import com.app.config.MensajeSistema;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego
 */
public class ClaseFecha {

    public static Date getFecha() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Metodo que retorna la fecha actual del sistema en formato dd/MM/yyyy
     *
     * @return
     */
    public static String getFechaActual() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(getFecha());
    }

    /**
     * Metodo que retorna el nombre del mes que se recibe como parametro
     *
     * @param mes
     * @return
     */
    public static String getNombreMes(int mes) {
        String result;
        switch (mes) {
            case 1: {
                result = "Enero";
                break;
            }
            case 2: {
                result = "Febrero";
                break;
            }
            case 3: {
                result = "Marzo";
                break;
            }
            case 4: {
                result = "Abril";
                break;
            }
            case 5: {
                result = "Mayo";
                break;
            }
            case 6: {
                result = "Junio";
                break;
            }
            case 7: {
                result = "Julio";
                break;
            }
            case 8: {
                result = "Agosto";
                break;
            }
            case 9: {
                result = "Septiembre";
                break;
            }
            case 10: {
                result = "Octubre";
                break;
            }
            case 11: {
                result = "Noviembre";
                break;
            }
            case 12: {
                result = "Diciembre";
                break;
            }
            default: {
                result = "";
                break;
            }
        }
        return result;
    }

    public static String getNombreMes(Date fecha) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        return getNombreMes(cal.get(Calendar.MONTH) + 1);
    }

    public static String getNombreMes() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(getFecha());
        return getNombreMes(cal.get(Calendar.MONTH) + 1);
    }

    /**
     * Metodo que retorna el nombre del dia que se recibe como parametro
     *
     * @param dia
     * @return
     */
    public static String getNombreDia(int dia) {
        String vNombre;
        switch (dia) {
            case 1:
                vNombre = "Domingo";
                break;
            case 2:
                vNombre = "Lunes";
                break;
            case 3:
                vNombre = "Martes";
                break;
            case 4:
                vNombre = "Miercoles";
                break;
            case 5:
                vNombre = "Jueves";
                break;
            case 6:
                vNombre = "Viernes";
                break;
            case 7:
                vNombre = "Sabado";
                break;
            default:
                vNombre = "";
                break;
        }
        return vNombre;
    }

    /**
     * Metodo que retorna el nombre el Dia que recibe como parametro
     *
     * @param fecha
     * @return
     */
    public static String getNombreDia(Date fecha) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        return getNombreDia(cal.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * Metodo que retorna el nombre del Dia actual
     *
     * @return
     */
    public static String getNombreDia() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(getFecha());
        return getNombreDia(cal.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * Metodo que valida la Fecha tipo String recibida como parametro si es
     * valida, retorna true o false dependiendo si es valido o no la fecha
     * recibida, la fecha tiene que estar en formato DD/MM/YYYY
     *
     * @param fecha
     * @return
     */
    public static boolean esFechaValida(String fecha) {
        SimpleDateFormat formatoFecha;
        if (fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        } else {
            formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            MensajeSistema.setParseException("Hubo un error al convertir la Fecha\nLa Fecha ingresada no es Válida", e);
            return false;
        }
    }

    /**
     * Medodo que suma la cantidad de Dias a una Fecha que recibe como parametro
     *
     * @param fecha
     * @param dias
     * @return
     */
    public static String setFechaAddDias(String fecha, int dias) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.DAY_OF_MONTH, dias);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Metodo que suma la cantidad de Meses a una fecha que recibe como
     * parametro
     *
     * @param fecha
     * @param mes
     * @return
     */
    public static String setFechaAddMes(String fecha, int mes) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.MONTH, mes);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Metodo que suma la cantidad de Años a una fecha que recibe como parametro
     *
     * @param fecha
     * @param anho
     * @return
     */
    public static String setFechaAddAnho(String fecha, int anho) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.YEAR, anho);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Medodo que resta la cantidad de Dias a una Fecha que recibe como
     * parametro
     *
     * @param fecha
     * @param dias
     * @return
     */
    public static String setFechaSubDias(String fecha, int dias) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.DAY_OF_MONTH, dias * -1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Metodo que resta la cantidad de Meses a una fecha que recibe como
     * parametro
     *
     * @param fecha
     * @param mes
     * @return
     */
    public static String setFechaSubMes(String fecha, int mes) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.MONTH, mes * -1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Metodo que resta la cantidad de Años a una fecha que recibe como
     * parametro
     *
     * @param fecha
     * @param anho
     * @return
     */
    public static String setFechaSubAnho(String fecha, int anho) {
        if (esFechaValida(fecha)) {
            Calendar c1 = GregorianCalendar.getInstance();
            c1.setTime(deStringToDate(fecha));
            c1.add(Calendar.YEAR, anho * -1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(c1.getTime());
        }
        return null;
    }

    /**
     * Metodo que retona la fecha actual del sistema en formato 01 de Enero de
     * 2014
     *
     * @return
     */
    public static String getFechaActualLarga() {
        String mes = getNombreMes(getFecha());
        return getDay() + " de " + mes + " de " + getYear();
    }

    /**
     * Metodo que retona la fecha actual del sistema en formato Miercoles, 01 de
     * Enero de 2014
     *
     * @return
     */
    public static String getFechaActualLargaCompleta() {
        String dia = getNombreDia(getFecha());
        String mes = getNombreMes(getFecha());
        return dia + ", " + getDay() + " de " + mes + " de " + getYear();
    }

    /**
     * Metodo que retorna la fecha actual del sistema en formato dd-MM-yyyy
     *
     * @return
     */
    public static String getFechaActualDMA() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna la fecha actual del sistema en formato yyyy-mm-dd
     *
     * @return
     */
    public static String getFechaActualAMD() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(new Date());
    }

    /**
     * Metodo que retorna el dia actual del sistema
     *
     * @return
     */
    public static String getDay() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd");
        return formateador.format(getFecha());
    }

    /**
     * Metodo que retorna el mes actual del sistema
     *
     * @return
     */
    public static String getMonth() {
        SimpleDateFormat formateador = new SimpleDateFormat("MM");
        return formateador.format(getFecha());
    }

    /**
     * Metodo que retorna el año actual del sistema
     *
     * @return
     */
    public static String getYear() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
        return formateador.format(getFecha());
    }

    /**
     * Metodo para saber si el año actual del sistema es bisiesto.
     *
     * @return
     */
    public static boolean esBisiesto() {
        Calendar date = Calendar.getInstance();
        date.setTime(getFecha());
        return esBisiesto(date.getWeekYear());
    }

    /**
     * Metodo para saber si el año enviado como parametro es bisiesto.
     *
     * @param anho
     * @return
     */
    public static boolean esBisiesto(int anho) {
        if (anho > 0 || anho < 10000) {
            GregorianCalendar calendar = new GregorianCalendar();
            return calendar.isLeapYear(anho);
        } else {
            return false;
        }
    }

    /**
     * Metodo para saber si un año es bisiesto.
     *
     * @param fecha
     * @return
     */
    public static boolean esBisiesto(Date fecha) {
        Calendar date = Calendar.getInstance();
        date.setTime(fecha);
        return esBisiesto(date.getWeekYear());
    }

    /**
     * Metodo que resta una fecha de otra fecha, recibe dos parametros fecha
     * tipo Date, retorna la cantidad de dias que lleva la fecha inicial de la
     * fecha final
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     */
    public static long getDiferenciasDeFechas(Date fechaInicial, Date fechaFinal) {
        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        System.out.println(fechaInicialMs);
        System.out.println(fechaFinalMs);
        long miliseg = (1000 * 60 * 60 * 24);
        return (fechaFinalMs - fechaInicialMs) / miliseg;
    }

    /**
     * Metodo que convierte un valor String a Date en formato dd/MM/yyyy
     *
     * @param fecha
     * @return
     */
    public static Date deStringToDate(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(fecha);
        } catch (ParseException ex) {
            MensajeSistema.setParseException("Hubo un error al convertir la Fecha\nLa Fecha ingresada no es Válida", ex);
        }
        return null;
    }

    /**
     * Metodo que convierte un valor Date a String en formato dd/MM/yyyy
     *
     * @param fecha
     * @return
     */
    public static String deDateToString(Date fecha) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    /**
     * Metodo que permite formatear la fecha a AAAA-MM-DD
     *
     * @param fecha
     * @return
     */
    public static String getFechaAAAAMMDD(String fecha) {
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(3, 5);
        String anho = fecha.substring(6, 10);
        String x = dia + "/" + mes + "/" + anho;
        if (esFechaValida(x)) {
            return anho + "-" + mes + "-" + dia;
        }
        return null;
    }

    /**
     * Metodo que permite formatear la fecha a DD/MM/AAAA
     *
     * @param fecha
     * @return
     */
    public static String getFechaDDMMAAAA(String fecha) {
        String dia = fecha.substring(8, 10);
        String mes = fecha.substring(5, 7);
        String anho = fecha.substring(0, 4);
        String x = dia + "/" + mes + "/" + anho;
        if (esFechaValida(x)) {
            return dia + "/" + mes + "/" + anho;
        }
        return null;
    }

    /**
     * Calcula la diferencia entre dos fechas. Devuelve el resultado en días,
     * meses o años según sea el valor del parámetro 'tipo'
     *
     * @param fechaInicio Fecha inicial
     * @param fechaFin Fecha final
     * @param tipo 0=TotalAños; 1=TotalMeses; 2=TotalDías; 3=MesesDelAnio;
     * 4=DiasDelMes
     * @return numero de días, meses o años de diferencia
     */
    public static long getDiffDates(Date fechaInicio, Date fechaFin, int tipo) {
        // Fecha inicio
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(fechaInicio);
        int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
        int mesInicio = calendarInicio.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
        int anioInicio = calendarInicio.get(Calendar.YEAR);

        // Fecha fin
        Calendar calendarFin = Calendar.getInstance();
        calendarFin.setTime(fechaFin);
        int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
        int mesFin = calendarFin.get(Calendar.MONTH) + 1; // 0 Enero, 11 Diciembre
        int anioFin = calendarFin.get(Calendar.YEAR);

        int anios = 0;
        int mesesPorAnio = 0;
        int diasPorMes = 0;
        int diasTipoMes = 0;

	//
        // Calculo de días del mes
        //
        if (mesInicio == 2) {
            // Febrero
            if ((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))) {
                // Bisiesto
                diasTipoMes = 29;
            } else {
                // No bisiesto
                diasTipoMes = 28;
            }
        } else if (mesInicio <= 7) {
            // De Enero a Julio los meses pares tienen 30 y los impares 31
            if (mesInicio % 2 == 0) {
                diasTipoMes = 30;
            } else {
                diasTipoMes = 31;
            }
        } else if (mesInicio > 7) {
            // De Julio a Diciembre los meses pares tienen 31 y los impares 30
            if (mesInicio % 2 == 0) {
                diasTipoMes = 31;
            } else {
                diasTipoMes = 30;
            }
        }

	//
        // Calculo de diferencia de año, mes y dia
        //
        if ((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin)
                || (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)) {
		// La fecha de inicio es posterior a la fecha fin
            // System.out.println("La fecha de inicio ha de ser anterior a la fecha fin");
            return -1;
        } else {
            if (mesInicio <= mesFin) {
                anios = anioFin - anioInicio;
                if (diaInicio <= diaFin) {
                    mesesPorAnio = mesFin - mesInicio;
                    diasPorMes = diaFin - diaInicio;
                } else {
                    if (mesFin == mesInicio) {
                        anios = anios - 1;
                    }
                    mesesPorAnio = (mesFin - mesInicio - 1 + 12) % 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                }
            } else {
                anios = anioFin - anioInicio - 1;
                System.out.println(anios);
                if (diaInicio > diaFin) {
                    mesesPorAnio = mesFin - mesInicio - 1 + 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                } else {
                    mesesPorAnio = mesFin - mesInicio + 12;
                    diasPorMes = diaFin - diaInicio;
                }
            }
        }
	//System.out.println("Han transcurrido " + anios + " Años, " + mesesPorAnio + " Meses y " + diasPorMes + " Días.");		

	//
        // Totales
        //
        long returnValue = -1;

        switch (tipo) {
            case 0:
                // Total Años
                returnValue = anios;
                // System.out.println("Total años: " + returnValue + " Años.");
                break;

            case 1:
                // Total Meses
                returnValue = anios * 12 + mesesPorAnio;
                // System.out.println("Total meses: " + returnValue + " Meses.");
                break;

            case 2:
                // Total Dias (se calcula a partir de los milisegundos por día)
                long millsecsPerDay = 86400000; // Milisegundos al día
                returnValue = (fechaFin.getTime() - fechaInicio.getTime()) / millsecsPerDay;
                // System.out.println("Total días: " + returnValue + " Días.");
                break;

            case 3:
                // Meses del año
                returnValue = mesesPorAnio;
                // System.out.println("Meses del año: " + returnValue);
                break;

            case 4:
                // Dias del mes
                returnValue = diasPorMes;
                // System.out.println("Dias del mes: " + returnValue);
                break;

            default:
                break;
        }

        return returnValue;
    }
}
