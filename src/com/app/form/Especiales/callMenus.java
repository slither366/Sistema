package com.app.form.Especiales;

import com.app.form.adm.Menus;
import com.app.form.adm.Usuarios;
import com.app.form.adm.Permisos;
import com.app.form.adm.Empresas;
import com.app.form.Contactos;
import com.app.form.Productos;
import com.app.form.Productos_Farm;
import com.app.form.Productos_Farm_Lst;
import com.app.form.Productos_lst;
import com.app.form.Stock_Ajuste;
import com.app.form.adm.Perfiles;
import com.app.form.cont.CotizacionSet;
import com.app.form.cont.CotizacionSet_Lst;
import com.app.form.herramientas.frm_Password;
import javax.swing.JDesktopPane;

/**
 *
 * @author dramosort
 */
public class callMenus {

    static UbicarVentana menu = new UbicarVentana();
    static JDesktopPane escritorio = frm_Principal.escritorio;

    /*                        Referenciales                                */
    public static void Marcas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Marcas", cod_ventana, true, false,
                "Mar_Codigo", "Mar_Descrip", "Marcas"), escritorio);
    }

    public static void Marcas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_marcas", cod_ventana, true, false,
                "Mar_Codigo", "Mar_Descrip", "Marcas"), escritorio);
    }

    public static void Lineas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Lineas", cod_ventana, true, false,
                "Lin_Codigo", "Lin_Descrip", "Lineas"), escritorio);
    }

    public static void Lineas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Lineas", cod_ventana, true, false,
                "Lin_Codigo", "Lin_Descrip", "Lineas"), escritorio);
    }

    public static void Envaces(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Envaces", cod_ventana, true, false,
                "Env_Codigo", "Env_Descrip", "Envaces"), escritorio);
    }

    public static void Envaces_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Envaces", cod_ventana, true, false,
                "Env_Codigo", "Env_Descrip", "Envaces"), escritorio);
    }

    public static void Bancos(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("ref_bancos", cod_ventana, true, false,
                "Ban_Codigo", "Ban_Descrip", "Bancos"), escritorio);
    }

    public static void Bancos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_ciudades", cod_ventana, true, false,
                "Ciu_Codigo", "Ciu_Descrip", "Ciudades"), escritorio);
    }

    public static void Ciudades(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("ref_bancos", cod_ventana, true, false,
                "Ban_Codigo", "Ban_Descrip", "Bancos"), escritorio);
    }

    public static void Ciudades_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_ciudades", cod_ventana, true, false,
                "Ciu_Codigo", "Ciu_Descrip", "Ciudades"), escritorio);
    }

    public static void Nacionalidades(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("ref_nacionalidades", cod_ventana, true, false,
                "Nac_Codigo", "Nac_Descrip", "Nacionalidad"), escritorio);
    }

    public static void Nacionalidades_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_nacionalidad", cod_ventana, true, false,
                "Nac_Codigo", "Nac_Descrip", "Nacionalidad"), escritorio);
    }

    /*                        Farmacia                                */
    public static void Drogas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }

    public static void Drogas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }

    public static void Sintomas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMTresCampos("Ref_Sintomas", cod_ventana, true, false,
                "Sint_Codigo", "Sint_Descrip", "observacion", "Sintomas"), escritorio);
    }

    public static void Sintomas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion", "Observación"), escritorio);
    }

    public static void Enfermedades(int cod_ventana) {
        menu.llamarInternalFrame(new ABMTresCampos("Ref_Enfermedades", cod_ventana, true, false,
                "Enf_Codigo", "Enf_Descrip", "observacion", "Enfermedades"), escritorio);
    }

    public static void Enfermedades_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Enfermedades", cod_ventana, true, false,
                "Enf_Codigo", "Enf_Descrip", "Enfermedades", "observacion", "Observación"), escritorio);
    }

    public static void Tratamientos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Tratamientos", cod_ventana, true, false, "Trat_Codigo",
                "Ref_Enfermedades", "Enf_Codigo", "Enf_Descrip", "Enfermedades",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), escritorio);
    }

    public static void Tratamientos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Tratamientos", cod_ventana, true, false,
                "Trat_Codigo",
                "Enf_Descrip", "Enfermedades", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), escritorio);
    }

    public static void Diagnosticos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Diagnosticos", cod_ventana, true, false, "Diag_Codigo",
                "ref_enfermedades", "Enf_Codigo", "Enf_Descrip", "Enfermedades",
                "ref_sintomas", "Sint_Codigo", "Sint_Descrip", "Sintomas",
                "observacion", "Diagnosticos"), escritorio);
    }

    public static void Diagnosticos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Diagnosticos", cod_ventana, true, false,
                "Diag_Codigo",
                "Enf_Descrip", "Enfermedades", "Sint_Descrip", "Sintomas",
                "observacion", "Diagnosticos"), escritorio);
    }

    public static void Componentes(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Componentes", cod_ventana, true, false, "Comp_Codigo",
                "Mant_Productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion",
                "Componentes"), escritorio);
    }

    public static void Componentes_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Componentes", cod_ventana, true, false,
                "Comp_Codigo",
                "Prod_Descrip", "Productos", "Dro_Descrip", "Drogas",
                "observacion", "Componentes"), escritorio);
    }

    public static void Contraindicaciones(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("farm_contraindicaciones", cod_ventana, true, false, "Cont_Codigo",
                "mant_productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "ref_enfermedades", "Enf_Codigo", "Enf_Desrip", "Enfermedades",
                "observacion", "Contraindicaciones"), escritorio);
    }

    public static void Contraindicaciones_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_farm_contraindicaciones", cod_ventana, true, false,
                "Cont_Codigo",
                "Prod_Descrip", "Productos", "Enf_Desrip", "Enfermedades",
                "observacion", "Contraindicaciones"), escritorio);
    }

    /*                        Mantenimientos                                */
    public static void Productos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos(cod_ventana), escritorio);
    }

    public static void Productos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_lst(cod_ventana), escritorio);
    }

    public static void Contactos(int cod_ventana) {
        menu.llamarInternalFrame(new Contactos(cod_ventana), escritorio);
    }

    public static void Contactos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Contactos(cod_ventana), escritorio);
    }
    /*                        Contabilidad                                  */

    public static void CotizacionSet(int cod_ventana) {
        menu.llamarInternalFrame(new CotizacionSet(cod_ventana), escritorio);
    }

    public static void CotizacionSet_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new CotizacionSet_Lst(cod_ventana), escritorio);
    }

    /*                        Movimiento Stock                                */
    public static void Stock_Ajuste(int cod_ventana) {
        menu.llamarInternalFrame(new Stock_Ajuste(cod_ventana), escritorio);
    }

    /*                        Administrativo                                  */
    public static void Empresas(int cod_ventana) {
        menu.llamarInternalFrame(new Empresas(cod_ventana), escritorio);
    }

    public static void Empresas_Lst(int cod_ventana) {
        System.out.println("en construccion");
    }

    public static void Sucursales(int cod_ventana) {
        System.out.println("en construccion");
    }

    public static void Sucursales_Lst(int cod_ventana) {
        System.out.println("en construccion");
    }

    public static void Menus(int cod_ventana) {
        menu.llamarInternalFrame(new Menus(), escritorio);
    }

    public static void Menus_Lst(int cod_ventana) {
        System.out.println("en construccion");
    }

    public static void Permisos() {
        menu.llamarInternalFrame(new Permisos(), escritorio);
    }

    public static void Permisos_Lst() {
        System.out.println("en construccion");
    }

    public static void Usuarios(int cod_ventana) {
        menu.llamarInternalFrame(new Usuarios(cod_ventana), escritorio);
    }

    public static void Usuarios_Lst(int cod_ventana) {
        System.out.println("en construccion");
    }

    public static void Usuarios_ActUser() {
        menu.llamarInternalFrame(new frm_Password(), escritorio);
    }

    public static void Usuarios_ActPass() {
        menu.llamarInternalFrame(new frm_Password(), escritorio);
    }

    public static void Perfiles(int cod_ventana) {
        menu.llamarInternalFrame(new Perfiles(cod_ventana), escritorio);
    }

    public static void Perfiles_Lst(int cod_ventana) {

    }
}
