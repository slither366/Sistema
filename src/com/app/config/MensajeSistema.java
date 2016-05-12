package com.app.config;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Esta clase es donde estan los metodos con los distintos mensajes que puede
 * mostrar el sistema
 *
 * @author Diego
 */
public class MensajeSistema {

    /**
     * Mensaje que se muestra cuando un campo de texto se deja vacio
     *
     * @return
     */
    public static boolean CampoVacio() {
        int msn = MensajeOpciones("Este campo no se puede dejar Vacio\nDesea Cancelar esta operación",
                new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    /**
     * Mensaje que se muestra cuando un campo de texto se deja vacio
     *
     * @param ventana
     * @return
     */
    public static boolean CampoVacio(JFrame ventana) {
        int msn = MensajeOpciones("Este campo no se puede dejar Vacio\nDesea Cancelar esta operación",
                new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    /**
     * Mensaje que se muestra cuando un campo de texto se deja vacio
     *
     * @param ventana
     * @return
     */
    public static boolean CampoVacio(JInternalFrame ventana) {
        int msn = MensajeOpciones("Este campo no se puede dejar Vacio\nDesea Cancelar esta operación",
                new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    /**
     * Metodo que muestra un mensaje cuando alguna consulta en la Base de Datos
     * retorna un error, recibe como parametro el codigo del error devuelve la
     * Base de Datos
     *
     * @param error
     */
    public static void setSQLException(SQLException error) {
        int codigo = error.getErrorCode();
        switch (codigo) {
            case 1012: {
                JOptionPane.showMessageDialog(null, "No se puede leer el registro en la tabla del especificada...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1045: {
                JOptionPane.showMessageDialog(null, "Acceso denegado para este usuario...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1049: {
                JOptionPane.showMessageDialog(null, "Base de Datos Desconocida...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1054: {
                JOptionPane.showMessageDialog(null, " La columna seleccionada no existe en la Tabla especificada...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1062: {
                JOptionPane.showMessageDialog(null, "Este registro ya existe en la Base de Datos\n"
                        + "Verifique e intente nuevamente...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1064: {
                JOptionPane.showMessageDialog(null, "La sintaxis SQL ingresada no es valida...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1074: {
                JOptionPane.showMessageDialog(null, "Longitud de columna demasiado grande...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1088: {
                JOptionPane.showMessageDialog(null, "Registros Duplicados...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1114: {
                JOptionPane.showMessageDialog(null, "La tabla esta llena...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1141: {
                JOptionPane.showMessageDialog(null, "No existe permiso definido para el usuario...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1142: {
                JOptionPane.showMessageDialog(null, "No posee permisos para realizar esta operación...\n"
                        + "Comuniquese con el Administrador del Sistema...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1146: {
                JOptionPane.showMessageDialog(null, "La Tabla especificada no existe en la Base de Datos...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1265: {
                JOptionPane.showMessageDialog(null, "Uno de los campos no puede ser nulo...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1318: {
                JOptionPane.showMessageDialog(null, "Sintaxis SQL incorrecta...\nNumero de argumentros incorrecto...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1364: {
                JOptionPane.showMessageDialog(null, "Uno de los campos no tiene valor por defecto...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), WARNING_MESSAGE());
                break;
            }
            case 1406: {
                JOptionPane.showMessageDialog(null, "Uno de los registros ya sobrepasa la capacidad "
                        + "del campo en la Base de Datos\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            case 1451: {
                JOptionPane.showMessageDialog(null, "No se puede Borrar ni Modificar este registro\n"
                        + "porque existen movimientos que dependen de ella...\n"
                        + "Código del error: " + codigo, Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                break;
            }
            default: {
                switch (error.getSQLState()) {
                    case "S1002":
                        JOptionPane.showMessageDialog(null, "Numero de Columna invalido...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    case "S1004":
                        JOptionPane.showMessageDialog(null, "El tipo de Datos es invalido...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    case "S1009":
                        JOptionPane.showMessageDialog(null, "Es incorecto, es menor al que tiene que ser...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    case "07009":
                        JOptionPane.showMessageDialog(null, "Nombre de indice no encontrado...\n"
                                + "\nCódigo del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    case "42S12":
                        JOptionPane.showMessageDialog(null, "Indice no encontrado...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    case "42S22":
                        JOptionPane.showMessageDialog(null, "La columna no Existe...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Se produjo un error inesperado al Consultar en la Base de Datos\n"
                                + "Comuniquese con el Proveedor del Sistema...\n"
                                + "Código del error: " + error.getSQLState() + "\n"
                                + error.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
                        break;
                }
            }
        }
    }

    public static void setException(Exception ex) {
        JOptionPane.showMessageDialog(null, "Hubo un error en el Sistema...\nComuniquese con el Administrador de Sistema..."
                + "\n" + ex.getMessage(), Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setException(String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(null, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setException(JFrame ventana, String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setException(JInternalFrame ventana, String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setIOException(String mensaje, IOException ex) {
        JOptionPane.showMessageDialog(null, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setIOException(JFrame ventana, String mensaje, IOException ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setIOException(JInternalFrame ventana, String mensaje, IOException ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setParseException(String mensaje, ParseException ex) {
        JOptionPane.showMessageDialog(null, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setParseException(JFrame ventana, String mensaje, ParseException ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void setParseException(JInternalFrame ventana, String mensaje, ParseException ex) {
        JOptionPane.showMessageDialog(ventana, mensaje + "\n" + ex.getMessage(),
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void MensajeVarios(String mensaje, int TipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(), TipoMensaje);
    }

    public static void MensajeVarios(JFrame ventana, String mensaje, int TipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), TipoMensaje);
    }

    public static void MensajeVarios(JInternalFrame ventana, String mensaje, int TipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), TipoMensaje);
    }

    public static int Pregunta_YES_NO(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION());
    }

    public static int Pregunta_YES_NO(JFrame ventana, String mensaje) {
        return JOptionPane.showConfirmDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), QUESTION_MESSAGE());
    }

    public static int Pregunta_YES_NO(JInternalFrame ventana, String mensaje) {
        return JOptionPane.showConfirmDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), QUESTION_MESSAGE());
    }        

    public static int Pregunta_YES_NO_CANCEL(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_CANCEL_OPTION(), QUESTION_MESSAGE());
    }

    public static int Pregunta_YES_NO_CANCEL(JFrame ventana, String mensaje) {
        return JOptionPane.showConfirmDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_CANCEL_OPTION(), QUESTION_MESSAGE());
    }

    public static int Pregunta_YES_NO_CANCEL(JInternalFrame ventana, String mensaje) {
        return JOptionPane.showConfirmDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), YES_NO_CANCEL_OPTION(), QUESTION_MESSAGE());
    }

    public static boolean ConsultaSQLVacio() {
        int msn = MensajeOpciones("No existen Registros referentes al Parametro ingresado\n"
                + "Desea Cancelar esta operación?..", new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    public static boolean ConsultaSQLVacio(JFrame ventana) {
        int msn = MensajeOpciones(ventana, "No existen Registros referentes al Parametro ingresado\n"
                + "Desea Cancelar esta operación?..", new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    public static boolean ConsultaSQLVacio(JInternalFrame ventana) {
//        JOptionPane.showMessageDialog(ventana, "No existen Registros referentes al Parametro ingresado\n"
//                + "Verifique y vuelva a intentar...", Configuracion.getTITULO_MENSAJE(), WARNING_MESSAGE());
        int msn = MensajeOpciones(ventana, "No existen Registros referentes al Parametro ingresado\n"
                + "Desea Cancelar esta operación?..", new Object[]{"Reintentar", "Cancelar"}, 0);
        return msn == 0;
    }

    public static void validarVacio() {
        JOptionPane.showMessageDialog(null, "Hay campos importantes que estan vacios...",
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void validarVacio(JFrame ventana) {
        JOptionPane.showMessageDialog(ventana, "Hay campos importantes que estan vacios...",
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static void validarVacio(JInternalFrame ventana) {
        JOptionPane.showMessageDialog(ventana, "Hay campos importantes que estan vacios...",
                Configuracion.getTITULO_MENSAJE(), ERROR_MESSAGE());
    }

    public static String MensajeImput(String mensaje) {
        String respuesta = JOptionPane.showInputDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE());
        return respuesta == null ? "" : respuesta;
    }

    public static String MensajeImput(JFrame ventana, String mensaje) {
        String respuesta = JOptionPane.showInputDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE());
        return respuesta == null ? "" : respuesta;
    }

    public static String MensajeImput(JInternalFrame ventana, String mensaje) {
        String respuesta = JOptionPane.showInputDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE());
        return respuesta == null ? "" : respuesta;
    }

    public static String MensajeImput(String mensaje, Object[] opciones) {
        Object respuesta = JOptionPane.showInputDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE(), null, opciones, opciones[0]);
        return respuesta == null ? "" : respuesta.toString();
    }

    public static String MensajeImput(JFrame ventana, String mensaje, Object[] opciones) {
        Object respuesta = JOptionPane.showInputDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE(), null, opciones, opciones[0]);
        return respuesta == null ? "" : respuesta.toString();
    }

    public static String MensajeImput(JInternalFrame ventana, String mensaje, Object[] opciones) {
        Object respuesta = JOptionPane.showInputDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(), INFORMATION_MESSAGE(), null, opciones, opciones[0]);
        return respuesta == null ? "" : respuesta.toString();
    }

    public static int MensajeOpciones(String mensaje, Object[] opciones, int primeraOpcion) {
        return JOptionPane.showOptionDialog(null, mensaje, Configuracion.getTITULO_MENSAJE(),
                OK_OPTION(), INFORMATION_MESSAGE(), null, opciones, opciones[primeraOpcion]);
    }

    public static int MensajeOpciones(JFrame ventana, String mensaje, Object[] opciones, int primeraOpcion) {
        return JOptionPane.showOptionDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(),
                OK_OPTION(), INFORMATION_MESSAGE(), null, opciones, opciones[primeraOpcion]);
    }

    public static int MensajeOpciones(JInternalFrame ventana, String mensaje, Object[] opciones, int primeraOpcion) {
        return JOptionPane.showOptionDialog(ventana, mensaje, Configuracion.getTITULO_MENSAJE(),
                OK_OPTION(), INFORMATION_MESSAGE(), null, opciones, opciones[primeraOpcion]);
    }

    public static boolean Guardar() {
        int preg = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere Grabar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Guardar(JFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Grabar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Guardar(JInternalFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Grabar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Modificar() {
        int preg = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere Grabar la Modificación de este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Modificar(JFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Grabar la Modificación de este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Modificar(JInternalFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Grabar la Modificación de este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Eliminar() {
        int preg = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere Eliminar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), WARNING_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Eliminar(JFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Eliminar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), WARNING_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Eliminar(JInternalFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Eliminar este Registro?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), WARNING_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Cancelar() {
        int preg = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere Cancelar el proceso Actual?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Cancelar(JFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Cancelar el proceso Actual?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Cancelar(JInternalFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere Cancelar el proceso Actual?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Salir() {
        int preg = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere salir?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Salir(JFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere salir?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static boolean Salir(JInternalFrame ventana) {
        int preg = JOptionPane.showConfirmDialog(ventana, "Esta seguro que quiere salir?...",
                Configuracion.getTITULO_MENSAJE(), YES_NO_OPTION(), INFORMATION_MESSAGE());
        return preg == YES_OPTION();
    }

    public static int ERROR_MESSAGE() {
        return JOptionPane.ERROR_MESSAGE;
    }

    public static int INFORMATION_MESSAGE() {
        return JOptionPane.INFORMATION_MESSAGE;
    }

    public static int WARNING_MESSAGE() {
        return JOptionPane.WARNING_MESSAGE;
    }

    public static int QUESTION_MESSAGE() {
        return JOptionPane.QUESTION_MESSAGE;
    }

    public static int CANCEL_OPTION() {
        return JOptionPane.CANCEL_OPTION;
    }

    public static int NO_OPTION() {
        return JOptionPane.NO_OPTION;
    }

    public static int YES_OPTION() {
        return JOptionPane.YES_OPTION;
    }

    public static int YES_NO_OPTION() {
        return JOptionPane.YES_NO_OPTION;
    }

    public static int OK_CANCEL_OPTION() {
        return JOptionPane.OK_CANCEL_OPTION;
    }

    public static int OK_OPTION() {
        return JOptionPane.OK_OPTION;
    }

    public static int YES_NO_CANCEL_OPTION() {
        return JOptionPane.YES_NO_CANCEL_OPTION;
    }
}
