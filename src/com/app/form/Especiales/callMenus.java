package com.app.form.Especiales;

import com.app.form.Productos;
import com.app.form.Productos_Farm;
import com.app.form.Productos_Farm_Lst;
import com.app.form.Productos_lst;

/**
 *
 * @author Diego
 */
public class callMenus {

    static UbicarVentana menu = new UbicarVentana();

    public static void Marcas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Marcas", cod_ventana, true, false,
                "Mar_Codigo", "Mar_Descrip", "Marcas"), frm_Principal.escritorio);
    }

    public static void Marcas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_marcas", cod_ventana, true, false,
                "Mar_Codigo", "Mar_Descrip", "Marcas"), frm_Principal.escritorio);
    }

    public static void Lineas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Lineas", cod_ventana, true, false,
                "Lin_Codigo", "Lin_Descrip", "Lineas"), frm_Principal.escritorio);
    }

    public static void Lineas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Lineas", cod_ventana, true, false,
                "Lin_Codigo", "Lin_Descrip", "Lineas"), frm_Principal.escritorio);
    }

    public static void Envaces(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("Ref_Envaces", cod_ventana, true, false,
                "Env_Codigo", "Env_Descrip", "Envaces"), frm_Principal.escritorio);
    }

    public static void Envaces_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Envaces", cod_ventana, true, false,
                "Env_Codigo", "Env_Descrip", "Envaces"), frm_Principal.escritorio);
    }

    public static void Productos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos(cod_ventana), frm_Principal.escritorio);
    }

    public static void Productos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_lst(cod_ventana), frm_Principal.escritorio);
    }

    public static void Drogas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMDosCampos("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas"), frm_Principal.escritorio);
    }

    public static void Drogas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas"), frm_Principal.escritorio);
    }

    public static void Sintomas(int cod_ventana) {
        menu.llamarInternalFrame(new ABMTresCampos("Ref_Sintomas", cod_ventana, true, false,
                "Sint_Codigo", "Sint_Descrip", "observacion", "Sintomas"), frm_Principal.escritorio);
    }

    public static void Sintomas_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("ref_drogas", cod_ventana, true, false,
                "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion", "Observación"), frm_Principal.escritorio);
    }

    public static void Enfermedades(int cod_ventana) {
        menu.llamarInternalFrame(new ABMTresCampos("Ref_Enfermedades", cod_ventana, true, false,
                "Enf_Codigo", "Enf_Descrip", "observacion", "Enfermedades"), frm_Principal.escritorio);
    }

    public static void Enfermedades_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Listar("Ref_Enfermedades", cod_ventana, true, false,
                "Enf_Codigo", "Enf_Descrip", "Enfermedades", "observacion", "Observación"), frm_Principal.escritorio);
    }

    public static void Tratamientos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Tratamientos", cod_ventana, true, false, "Trat_Codigo",
                "Ref_Enfermedades", "Enf_Codigo", "Enf_Descrip", "Enfermedades",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), frm_Principal.escritorio);
    }

    public static void Tratamientos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Tratamientos", cod_ventana, true, false,
                "Trat_Codigo",
                "Enf_Descrip", "Enfermedades", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), frm_Principal.escritorio);
    }

    public static void Diagnosticos(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Diagnosticos", cod_ventana, true, false, "Diag_Codigo",
                "ref_enfermedades", "cod_enfermedad", "nom_enfermedad", "Enfermedades",
                "ref_sintomas", "cod_sintoma", "nom_sintoma", "Sintomas",
                "observacion", "Diagnosticos"), frm_Principal.escritorio);
    }

    public static void Diagnosticos_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Diagnosticos", cod_ventana, true, false,
                "Diag_Codigo",
                "ref_sintomas", "Sintomas", "nom_sintoma", "Sintomas",
                "observacion", "Diagnosticos"), frm_Principal.escritorio);
    }

    public static void Componentes(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("Farm_Componentes", cod_ventana, true, false, "Comp_Codigo",
                "Mant_Productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion",
                "Componentes"), frm_Principal.escritorio);
    }

    public static void Componentes_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_Farm_Componentes", cod_ventana, true, false,
                "Comp_Codigo",
                "Prod_Descrip", "Productos", "Dro_Descrip", "Drogas",
                "observacion", "Componentes"), frm_Principal.escritorio);
    }

    public static void Contraindicaciones(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm("farm_contraindicaciones", cod_ventana, true, false, "Cont_Codigo",
                "mant_productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "ref_enfermedades", "Enf_Codigo", "Enf_Desrip", "Enfermedades",
                "observacion", "Contraindicaciones"), frm_Principal.escritorio);
    }

    public static void Contraindicaciones_Lst(int cod_ventana) {
        menu.llamarInternalFrame(new Productos_Farm_Lst("vst_farm_contraindicaciones", cod_ventana, true, false,
                "Cont_Codigo",
                "Prod_Descrip", "Productos", "Enf_Desrip", "Enfermedades",
                "observacion", "Contraindicaciones"), frm_Principal.escritorio);
    }
}