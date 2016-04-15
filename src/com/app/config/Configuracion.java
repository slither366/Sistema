package com.app.config;

import java.util.ArrayList;

/**
 * esta Clase se usa para grabar temporalmente valores en variables
 *
 * @author Diego
 */
public class Configuracion {

    private static String COD_USUARIO = "1";
    private static String NOM_USUARIO = "Usuario de Prueba";
    private static String COD_PERFIL = "1";
    private static String NOM_PERFIL = "Perfil de Prueba";
    private static String COD_EMPRESA = "1";
    private static String NOM_EMPRESA = "Empresa de Prueba";
    private static String COD_SUCURSAL = "1";
    private static String NOM_SUCURSAL = "CENTRAL";
    private static String TITULO_MENSAJE = "..:: Mensaje del Sistema ::..";
    private static String TITULO_VENTANA = "SysTema";
    private static int COD_PERIODO;
    private static final String Logo = "/com/app/iconos/icon.png";
    //private static final Icon Icono = new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/com/app/iconos/icon.png")));
    private static int CantidadMaxVAbierta = 6;
    private static int CantidadVentanaAbierta = 1;
    private static int Contador = 0;
    private static String CODIGO_BUSCAR = "";
    private static String IMPRESORA;
    private static String DIRECTORIO_DEFECTO = "";

    public static String getCOD_USUARIO() {
        return Configuracion.COD_USUARIO;
    }

    public static void setCOD_USUARIO(String COD_USUARIO) {
        Configuracion.COD_USUARIO = COD_USUARIO;
    }

    public static String getNOM_USUARIO() {
        return Configuracion.NOM_USUARIO.trim();
    }

    public static void setNOM_USUARIO(String NOM_USUARIO) {
        Configuracion.NOM_USUARIO = NOM_USUARIO;
    }

    public static String getCOD_PERFIL() {
        return Configuracion.COD_PERFIL;
    }

    public static void setCOD_PERFIL(String COD_PERFIL) {
        Configuracion.COD_PERFIL = COD_PERFIL;
    }

    public static String getNOM_PERFIL() {
        return Configuracion.NOM_PERFIL.trim();
    }

    public static void setNOM_PERFIL(String NOM_PERFIL) {
        Configuracion.NOM_PERFIL = NOM_PERFIL;
    }

    public static String getCOD_EMPRESA() {
        return Configuracion.COD_EMPRESA;
    }

    public static void setCOD_EMPRESA(String COD_EMPRESA) {
        Configuracion.COD_EMPRESA = COD_EMPRESA;
    }

    public static String getNOM_EMPRESA() {
        return Configuracion.NOM_EMPRESA.trim();
    }

    public static void setNOM_EMPRESA(String NOM_EMPRESA) {
        Configuracion.NOM_EMPRESA = NOM_EMPRESA;
    }

    public static String getCOD_SUCURSAL() {
        return Configuracion.COD_SUCURSAL;
    }

    public static void setCOD_SUCURSAL(String COD_SUCURSAL) {
        Configuracion.COD_SUCURSAL = COD_SUCURSAL;
    }

    public static String getNOM_SUCURSAL() {
        return Configuracion.NOM_SUCURSAL.trim();
    }

    public static void setNOM_SUCURSAL(String NOM_SUCURSAL) {
        Configuracion.NOM_SUCURSAL = NOM_SUCURSAL;
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

    public static int getCOD_PERIODO() {
        return COD_PERIODO;
    }

    public static void setCOD_PERIODO(int COD_PERIODO) {
        Configuracion.COD_PERIODO = COD_PERIODO;
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
                new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), Configuracion.getCOD_PERFIL()});
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
