package com.app.config;

import java.util.ArrayList;

/**
 * esta Clase se usa para grabar temporalmente valores en variables
 *
 * @author Diego
 */
public class Configuracion {

    private static String USU_CODIGO = "1";
    private static String USU_NOMBRE = "Usuario de Prueba";
    private static String PERF_CODIGO = "1";
    private static String PERF_NOMBRE = "Perfil de Prueba";
    private static String EMP_CODIGO = "1";
    private static String EMP_NOMBRE = "Empresa de Prueba";
    private static String SUC_CODIGO = "1";
    private static String SUC_NOMBRE = "CENTRAL";
    private static String PFISC_CODIGO = "1";
    private static String PFISC_DESCRIP = "2016";
    private static String TITULO_MENSAJE = "..:: Mensaje del Sistema ::..";
    private static String TITULO_VENTANA = "SysTema";
    private static final String Logo = "/com/app/iconos/icon.png";
    //private static final Icon Icono = new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/com/app/iconos/icon.png")));
    private static int CantidadMaxVAbierta = 6;
    private static int CantidadVentanaAbierta = 1;
    private static int Contador = 0;
    private static String CODIGO_BUSCAR = "";
    private static String IMPRESORA;
    private static String DIRECTORIO_DEFECTO = "";

    public static String getUSU_CODIGO() {
        return Configuracion.USU_CODIGO;
    }

    public static void setUSU_CODIGO(String USU_CODIGO) {
        Configuracion.USU_CODIGO = USU_CODIGO;
    }

    public static String getUSU_NOMBRE() {
        return Configuracion.USU_NOMBRE.trim();
    }

    public static void setUSU_NOMBRE(String USU_NOMBRE) {
        Configuracion.USU_NOMBRE = USU_NOMBRE;
    }

    public static String getPERF_CODIGO() {
        return Configuracion.PERF_CODIGO;
    }

    public static void setPERF_CODIGO(String PERF_CODIGO) {
        Configuracion.PERF_CODIGO = PERF_CODIGO;
    }

    public static String getPERF_NOMBRE() {
        return Configuracion.PERF_NOMBRE.trim();
    }

    public static void setPERF_NOMBRE(String PERF_NOMBRE) {
        Configuracion.PERF_NOMBRE = PERF_NOMBRE;
    }

    public static String getEMP_CODIGO() {
        return Configuracion.EMP_CODIGO;
    }

    public static void setEMP_CODIGO(String EMP_CODIGO) {
        Configuracion.EMP_CODIGO = EMP_CODIGO;
    }

    public static String getEMP_NOMBRE() {
        return Configuracion.EMP_NOMBRE.trim();
    }

    public static void setEMP_NOMBRE(String EMP_NOMBRE) {
        Configuracion.EMP_NOMBRE = EMP_NOMBRE;
    }

    public static String getSUC_CODIGO() {
        return Configuracion.SUC_CODIGO;
    }

    public static void setSUC_CODIGO(String SUC_CODIGO) {
        Configuracion.SUC_CODIGO = SUC_CODIGO;
    }

    public static String getSUC_NOMBRE() {
        return Configuracion.SUC_NOMBRE.trim();
    }

    public static void setSUC_NOMBRE(String SUC_NOMBRE) {
        Configuracion.SUC_NOMBRE = SUC_NOMBRE;
    }

    public static String getPFISC_CODIGO() {
        return Configuracion.PFISC_CODIGO.trim();
    }

    public static void setPFISC_CODIGO(String PFISC_CODIGO) {
        Configuracion.PFISC_CODIGO = PFISC_CODIGO;
    }

    public static String getPFISC_DESCRIP() {
        return Configuracion.PFISC_DESCRIP.trim();
    }

    public static void setPFISC_DESCRIP(String PFISC_DESCRIP) {
        Configuracion.PFISC_DESCRIP = PFISC_DESCRIP;
    }

    public static String getTITULO_MENSAJE() {
        return Configuracion.TITULO_MENSAJE;
    }

    public static void setTITULO_MENSAJE(String TITULO_MENSAJE) {
        Configuracion.TITULO_MENSAJE = TITULO_MENSAJE;
    }

    public static String getTITULO_VENTANA() {
        return Configuracion.TITULO_VENTANA;
    }

    public static void setTITULO_VENTANA(String TITULO_VENTANA) {
        Configuracion.TITULO_VENTANA = TITULO_VENTANA;
    }

    public static String getLogo() {
        return Configuracion.Logo;
    }

    public static int getCantidadMaxVAbierta() {
        return Configuracion.CantidadMaxVAbierta;
    }

    public static void setCantidadMaxVAbierta(int CantidadMaxVAbierta) {
        Configuracion.CantidadMaxVAbierta = CantidadMaxVAbierta;
    }

    public static int getCantidadVentanaAbierta() {
        return Configuracion.CantidadVentanaAbierta;
    }

    public static void setCantidadVentanaAbierta(int CantidadVentanaAbierta) {
        Configuracion.CantidadVentanaAbierta = CantidadVentanaAbierta;
    }

    public static int getContador() {
        return Configuracion.Contador;
    }

    public static void SetContador(int cantidad) {
        Configuracion.Contador = cantidad;
    }

    public static void restaContador() {
        if (Configuracion.Contador > 0) {
            Configuracion.Contador = getContador() - 1;
        }
    }

    public static void sumaContador() {
        Configuracion.Contador = getContador() + 1;
    }

    public static String getCODIGO_BUSCAR() {
        return Configuracion.CODIGO_BUSCAR;
    }

    public static void setCODIGO_BUSCAR(String codigo_buscar) {
        Configuracion.CODIGO_BUSCAR = codigo_buscar;
    }

    public static String getIMPRESORA() {
        return Configuracion.IMPRESORA.trim();
    }

    public static void setIMPRESORA(String IMPRESORA) {
        Configuracion.IMPRESORA = IMPRESORA;
    }

    public static String getDIRECTORIO_DEFECTO() {
        return DIRECTORIO_DEFECTO;
    }

    public static void setDIRECTORIO_DEFECTO(String DIRECTORIO_DEFECTO) {
        Configuracion.DIRECTORIO_DEFECTO = DIRECTORIO_DEFECTO;
    }

    private static ArrayList Permisos = new ArrayList();

    public static void cargarPermisos(ConexionBD conexion) {
        ArrayList resu = conexion.consultar("Acc_Principal", "Men_Codigo",
                new String[]{"Emp_Codigo", "Suc_Codigo", "Perf_Codigo"},
                new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), Configuracion.getPERF_CODIGO()});
        Permisos.clear();
        Permisos = resu;
    }

    public static boolean BuscarMenu(int codigo) {
        for (Object Permiso : Permisos) {
            if (Permiso.toString().equals(codigo + "")) {
                return true;
            }
        }
        return false;
    }
}
