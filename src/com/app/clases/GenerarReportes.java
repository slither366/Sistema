package com.app.clases;

import com.app.config.ConexionBD;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Principal;
import com.app.form.Especiales.frm_reporte;
import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Diego
 */
public class GenerarReportes {

    /**
     * Variable que indica la ubicacion del reporte
     */
    public static String ubicacionReport = "/com/app/reportes/";

    /**
     *
     * @param rs
     * @param tituloVentanaActual
     * @param desde
     * @param hasta
     * @param tipo
     */
    public void listadoDosCampos(ResultSet rs, String tituloVentanaActual,
            String desde, String hasta, char tipo) {
        String reporte = "listadosDosCampos";
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        HashMap parameters = getParametros(
                new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario"},
                new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                    Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE()});
        this.MostrarReporte(parameters, jrRS, reporte, tipo, tituloVentanaActual);
    }

    /**
     *
     * @param rs
     * @param tituloVentanaActual
     * @param desde
     * @param hasta
     * @param tipo
     * @param tituloForaneo
     */
    public void listadoTresCampos(ResultSet rs, String tituloVentanaActual,
            String desde, String hasta, char tipo, String tituloForaneo) {
        String reporte = "listadosTresCampos";
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        HashMap parameters = getParametros(
                new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario", "tituloForaneo"},
                new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                    Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE(), tituloForaneo});
        this.MostrarReporte(parameters, jrRS, reporte, tipo, tituloVentanaActual);
    }

    public JasperPrint getReporte(TableModel resu, String reporte, String tituloVentanaActual, String desde, String hasta) {
        HashMap parameters = getParametros(
                new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario"},
                new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                    Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE()});
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(reporte));
            JRTableModelDataSource jrRS = new JRTableModelDataSource(resu);
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, jrRS);
            return masterPrint;
        } catch (JRException ex) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", ex);
        }
        return null;
    }

    public JasperPrint getReporte(ResultSet rs, String reporte, String tituloVentanaActual, String desde, String hasta) {
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        HashMap parameters = getParametros(
                new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario"},
                new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                    Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE()});
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(reporte));
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, jrRS);
            return masterPrint;
        } catch (JRException ex) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", ex);
        }
        return null;
    }

    public void MostrarReporte(HashMap parameters, JRResultSetDataSource jrRS,
            String reporte, char tipo, String tituloVentanaActual) {
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(reporte));
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, jrRS);
            Reporte(masterPrint, tipo, tituloVentanaActual);
        } catch (JRException e) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", e);
        }
    }

    public void MostrarReporte(HashMap parameters, ConexionBD con, String reporte, char tipo, String tituloVentanaActual) {
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(reporte));
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, con.getConexion());
            Reporte(masterPrint, tipo, tituloVentanaActual);
        } catch (JRException e) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", e);
        }
    }

    public void MostrarReporte(ResultSet resu, String reporte, String desde, String hasta,
            char tipo, String tituloVentanaActual) {
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            HashMap parameters = getParametros(
                    new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario"},
                    new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                        Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE()});
            JRResultSetDataSource jrRS = new JRResultSetDataSource(resu);
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(reporte));
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, jrRS);
            Reporte(masterPrint, tipo, tituloVentanaActual);
        } catch (JRException ex) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", ex);
        }
    }

    public void MostrarReporte(TableModel resu, String reporte, String desde, String hasta,
            char tipo, String tituloVentanaActual) {
        reporte = ubicacionReport + reporte + ".jasper";
        try {
            HashMap parameters = getParametros(
                    new String[]{"titulo", "desde", "hasta", "empresa", "sucursal", "usuario"},
                    new String[]{tituloVentanaActual, desde, hasta, Configuracion.getEMP_NOMBRE(),
                        Configuracion.getSUC_NOMBRE(), Configuracion.getUSU_NOMBRE()});
            JRTableModelDataSource jrRS = new JRTableModelDataSource(resu);
            URL in = this.getClass().getResource(reporte);
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(in);
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, jrRS);
            Reporte(masterPrint, tipo, tituloVentanaActual);
        } catch (JRException ex) {
            MensajeSistema.setException("Se produjo un Error inesperado al crear el listado...", ex);
        }
    }

    private void Reporte(JasperPrint masterPrint, char tipo, String tituloVentanaActual) {
        if (!masterPrint.getPages().isEmpty()) {
            try {
                if (tipo == 'I') {//cuando es imprimir                    
                    JasperPrintManager.printReport(masterPrint, true);
                } else if (tipo == 'P') { //cuando es pantalla   
                    JRViewer viewer = new JRViewer(masterPrint);
                    viewer.setOpaque(true);
                    viewer.setVisible(true);
                    viewer.setAutoscrolls(true);

                    final frm_reporte ventana = new frm_reporte();
                    ventana.setTitle(tituloVentanaActual + "_rep");
                    ventana.jPanel1.removeAll();
                    ventana.jPanel1.setLayout(new java.awt.BorderLayout());
                    ventana.jPanel1.add(viewer, BorderLayout.CENTER);
                    ventana.setLocation((frm_Principal.escritorio.getSize().width - ventana.getSize().width) / 2,
                            (frm_Principal.escritorio.getSize().height - ventana.getSize().height) / 2);
                    frm_Principal.escritorio.add(ventana);
                    ventana.toFront();
                    try {
                        ventana.setSelected(true);
                    } catch (PropertyVetoException e) {
                    }
                }
            } catch (JRException ex) {
                MensajeSistema.setException(ex);
            }
        } else {
            MensajeSistema.MensajeVarios("El Reporte no tiene Páginas", MensajeSistema.ERROR_MESSAGE());
        }
    }

    /**
     * Metodo que retorna los parametros que se puede agregar a un reporte
     *
     * @param titulos
     * @param valores
     * @return
     */
    public HashMap getParametros(String[] titulos, String[] valores) {
        HashMap parameters = new HashMap();
        for (int i = 0; i < titulos.length; i++) {
            parameters.put(titulos[i], valores[i]);
        }
        return parameters;
    }
}
