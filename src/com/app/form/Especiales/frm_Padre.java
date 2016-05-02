package com.app.form.Especiales;

import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.config.ConexionBD;
import com.app.config.Propiedades;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JInternalFrame;

/**
 *
 * @author
 */
public class frm_Padre extends JInternalFrame implements ActionListener {

    public String tablaConsutada, idConsultada, descripcionConsultada, tituloVentanaActual, codigoFormulario;
    public static String cod_empresa = "Emp_Codigo";
    public static String cod_sucursal = "Suc_Codigo";
    public boolean UsarEmpresa = false;
    public boolean UsarSucursal = false;
    public int Cod_Ventana;
    public boolean Autorizado_ok = false, Agrega_OK = false, Modifica_OK = false, Borra_OK = false, Listar_OK = false;
    public char operacion;
    public static ConexionBD getConexion;
    public static Propiedades getPropiedades;
    public Image getIcono;
    public static String ubicacionReport = "/com/app/Reportes/";

    public frm_Padre() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        Icon Icono = new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Configuracion.getLogo())));
        this.setFrameIcon(Icono);
        this.setTitle("..:: " + Configuracion.getTITULO_VENTANA() + " ::..");
    }

    public boolean Borrar(JInternalFrame ventana, String tabla, boolean Empresa,
            boolean Sucursal, String codigo, String codigoID) {
        if (MensajeSistema.Eliminar(ventana)) {
            if (Empresa && Sucursal) {
                return getConexion.eliminar(tabla,
                        new String[]{cod_empresa, cod_sucursal, codigo},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), codigoID});
            } else if (Empresa) {
                return getConexion.eliminar(tabla,
                        new String[]{cod_empresa, codigo},
                        new String[]{Configuracion.getCOD_EMPRESA(), codigoID});
            } else {
                return getConexion.eliminar(tabla, codigo, codigoID);
            }
        }
        return false;
    }

    public boolean Borrar(JInternalFrame ventana, String tabla, String[] campoCondicion, String[] valores) {
        if (MensajeSistema.Eliminar(ventana)) {
            return getConexion.eliminar(tabla, campoCondicion, valores);
        }
        return false;
    }

    public void Salir(JInternalFrame ventana) {
        if (MensajeSistema.Salir(ventana)) {
            frm_Principal.llamarFormulario.CloseFrame(ventana);
        }
    }

    public void Buscar(String tabla, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo) {
        Buscar buscar = new Buscar(null, true, tabla, Empresa, Sucursal, codigo, descripcion, titulo, getConexion);
        buscar.setVisible(true);
    }

    public void Buscar(String consulta, String titulo) {
        Buscar buscar = new Buscar(null, true, consulta, titulo, getConexion);
        buscar.setVisible(true);
    }

    public void Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion, String titulo) {
        Listar listar = new Listar(tabla, cod_ventana, Empresa, Sucursal, codigo, descripcion, titulo);
        frm_Principal.llamarFormulario.llamarInternalFrame(listar, frm_Principal.escritorio);
    }

    public void Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion, String titulo,
            String descripcion2, String tituloDescri2) {
        Listar listar = new Listar(tabla, cod_ventana, Empresa, Sucursal, codigo, descripcion, titulo, descripcion2, tituloDescri2);
        frm_Principal.llamarFormulario.llamarInternalFrame(listar, frm_Principal.escritorio);
    }

    public void Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion, String titulo,
            String idForaneo, String descripcionForaneo, String tituloForaneo) {
        Listar listar = new Listar(tabla, cod_ventana, Empresa, Sucursal, codigo, descripcion, titulo, idForaneo, descripcionForaneo, tituloForaneo);
        frm_Principal.llamarFormulario.llamarInternalFrame(listar, frm_Principal.escritorio);
    }

    public void Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion, String titulo,
            String reporte, String[] campos, String[] nombres) {
        Listar listar = new Listar(tabla, cod_ventana, Empresa, Sucursal, codigo, descripcion,
                titulo, reporte, campos, nombres);
        frm_Principal.llamarFormulario.llamarInternalFrame(listar, frm_Principal.escritorio);
    }

    /**
     * Metodo que verifica los permisos de un formulario en la Base de Datos
     *
     * @param cod_ventana
     */
    public void getPermisos(int cod_ventana) {
        String[] resu = getConexion.getDescripciones("acc_principal",
                new String[]{"autorizado_ok", "agrega_ok", "borra_ok", "modifica_ok"},
                new String[]{cod_empresa, cod_sucursal, "Perf_Codigo", "Men_Codigo"},
                new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(),
                    Configuracion.getCOD_PERFIL(), String.valueOf(cod_ventana)});
        if (resu[0] != null) {
            this.Autorizado_ok = "1".equals(resu[0]);
            this.Agrega_OK = "1".equals(resu[1]);
            this.Borra_OK = "1".equals(resu[2]);
            this.Modifica_OK = "1".equals(resu[3]);
        }
    }

    /**
     * Metodo que verifica los permisos de un formulario de listado en la Base
     * de Datos
     *
     * @param cod_ventana
     */
    public void getPermisosListar(int cod_ventana) {
        String[] resu = getConexion.getDescripciones("acc_principal",
                new String[]{"autorizado_ok", "listar_ok"},
                new String[]{cod_empresa, cod_sucursal, "Perf_Codigo", "Men_Codigo"},
                new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(),
                    Configuracion.getCOD_PERFIL(), String.valueOf(cod_ventana)});
        if (resu[0] != null) {
            this.Autorizado_ok = "1".equals(resu[0]);
            this.Listar_OK = "1".equals(resu[1]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setVisible(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public interface Metodos {

        public abstract void Inicializar();

        public abstract void Grabar();

        public abstract void Agregar();

        public abstract void Editar(char c);

        public abstract void RecuperarDatos(String codigo);
    }
}
