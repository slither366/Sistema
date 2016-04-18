package com.app.form;

import com.app.clases.utilidades.Excel;
import com.app.clases.ClaseBotones;
import com.app.clases.ClaseTeclas;
import com.app.clases.GenerarReportes;
import com.app.config.Configuracion;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRResultSetDataSource;

/**
 *
 * @author Diego
 */
public class Productos_Farm_Lst extends frm_Padre {

    private String desde, hasta;
    private final GenerarReportes reportes = new GenerarReportes();
    private final String NomDesc1, NomDesc2, Titulo1, Titulo2;
    private final String reporte = frm_Padre.ubicacionReport + "Productos_Esp_Lst.jasper";

    /**
     * Listar para dos campos
     *
     * @param tablaPrin
     * @param cod_ventana
     * @param empresa
     * @param sucursal
     * @param codigo
     * @param nomDesc1
     * @param titulo1
     * @param nomDesc2
     * @param tituloPrincipal
     * @param Observacion
     * @param titulo2
     */
    public Productos_Farm_Lst(String tablaPrin, int cod_ventana, boolean empresa, boolean sucursal,
            String codigo, String nomDesc1, String titulo1, String nomDesc2, String titulo2,
            String Observacion, String tituloPrincipal) {
        initComponents();
        this.setName("listar" + tablaPrin);
        this.tablaConsutada = tablaPrin;
        this.UsarEmpresa = empresa;
        this.UsarSucursal = sucursal;
        this.idConsultada = codigo;
        this.NomDesc1 = nomDesc1;
        this.NomDesc2 = nomDesc2;
        this.Titulo1 = titulo1;
        this.Titulo2 = titulo2;
        this.descripcionConsultada = Observacion;
        this.tituloVentanaActual = tituloPrincipal;
        this.textTitulo.setText("Listado de " + tituloVentanaActual + "...");
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textDesde = new javax.swing.JLabel();
        textHasta = new javax.swing.JLabel();
        txtCod_Desde = new com.app.paleta.txtCodigo();
        txtCod_Hasta = new com.app.paleta.txtCodigo();
        jPanelBotones = new javax.swing.JPanel();
        btnReporNuevo = new com.app.botones.btnNuevo();
        btnReporPantalla = new com.app.botones.btnPantalla();
        btnReporImpresora = new com.app.botones.btnImpresora();
        btnReporCancelar = new com.app.botones.btnCancelar();
        btnReporSalir = new com.app.botones.btnSalir();
        btnReporExportar = new com.app.botones.btnExportar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setMaximumSize(new java.awt.Dimension(552, 60));
        jPanelTitulo.setMinimumSize(new java.awt.Dimension(552, 60));
        jPanelTitulo.setName(""); // NOI18N
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(552, 60));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        textTitulo.setText("TITULO...");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Desde:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Hasta:");

        textDesde.setText("desde");

        textHasta.setText("hasta");

        txtCod_Desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_DesdeActionPerformed(evt);
            }
        });
        txtCod_Desde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_DesdeKeyPressed(evt);
            }
        });

        txtCod_Hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_HastaActionPerformed(evt);
            }
        });
        txtCod_Hasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_HastaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCod_Desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_Hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_Desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCod_Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnReporNuevo.setPreferredSize(new java.awt.Dimension(88, 30));
        btnReporNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporNuevoActionPerformed(evt);
            }
        });

        btnReporPantalla.setPreferredSize(new java.awt.Dimension(88, 30));
        btnReporPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporPantallaActionPerformed(evt);
            }
        });

        btnReporImpresora.setPreferredSize(new java.awt.Dimension(88, 30));
        btnReporImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporImpresoraActionPerformed(evt);
            }
        });

        btnReporCancelar.setPreferredSize(new java.awt.Dimension(88, 30));
        btnReporCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporCancelarActionPerformed(evt);
            }
        });

        btnReporSalir.setPreferredSize(new java.awt.Dimension(88, 30));
        btnReporSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporSalirActionPerformed(evt);
            }
        });

        btnReporExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCod_DesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_DesdeActionPerformed
        if (this.txtCod_Desde.verificarVacioSinMsj()) {
            String registro;
            if (UsarEmpresa && UsarSucursal) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, cod_sucursal, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Desde.getText()});
            } else if (UsarEmpresa) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCod_Desde.getText()});
            } else {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{idConsultada}, new String[]{this.txtCod_Desde.getText()});
            }
            if (registro == null) {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Desde.setText("");
                    this.txtCod_Desde.grabFocus();
                } else {
                    this.Inicializar();
                }
            } else {
                this.textDesde.setText(registro);
                this.txtCod_Hasta.setText(hasta);
                this.txtCod_Hasta.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCod_DesdeActionPerformed

    private void btnReporNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporNuevoActionPerformed
        this.Agregar();
    }//GEN-LAST:event_btnReporNuevoActionPerformed

    private void btnReporPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporPantallaActionPerformed
        this.Reporte('P');
    }//GEN-LAST:event_btnReporPantallaActionPerformed

    private void btnReporImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporImpresoraActionPerformed
        this.Reporte('I');
    }//GEN-LAST:event_btnReporImpresoraActionPerformed

    private void txtCod_HastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_HastaActionPerformed
        if (this.txtCod_Hasta.verificarVacioSinMsj()) {
            String registro;
            if (UsarEmpresa && UsarSucursal) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, cod_sucursal, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Hasta.getText()});
            } else if (UsarEmpresa) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCod_Hasta.getText()});
            } else {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{idConsultada}, new String[]{this.txtCod_Hasta.getText()});
            }
            if (registro == null) {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Hasta.setText("");
                    this.txtCod_Hasta.grabFocus();
                } else {
                    this.Inicializar();
                }
            } else {
                this.textHasta.setText(registro);
                this.btnReporPantalla.setEnabled(true);
                this.btnReporImpresora.setEnabled(true);
                this.btnReporPantalla.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCod_HastaActionPerformed

    private void btnReporCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporCancelarActionPerformed
        if (MensajeSistema.Cancelar()) {
            this.Inicializar();
        }
    }//GEN-LAST:event_btnReporCancelarActionPerformed

    private void btnReporSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporSalirActionPerformed
        this.Salir(this);
    }//GEN-LAST:event_btnReporSalirActionPerformed

    private void txtCod_DesdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_DesdeKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCod_Desde.requestFocus();
        }
    }//GEN-LAST:event_txtCod_DesdeKeyPressed

    private void txtCod_HastaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_HastaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCod_Hasta.requestFocus();
        }
    }//GEN-LAST:event_txtCod_HastaKeyPressed

    private void btnReporExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporExportarActionPerformed
        this.Reporte('E');
    }//GEN-LAST:event_btnReporExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.btnCancelar btnReporCancelar;
    private com.app.botones.btnExportar btnReporExportar;
    private com.app.botones.btnImpresora btnReporImpresora;
    private com.app.botones.btnNuevo btnReporNuevo;
    private com.app.botones.btnPantalla btnReporPantalla;
    private com.app.botones.btnSalir btnReporSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JLabel textDesde;
    private javax.swing.JLabel textHasta;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCod_Desde;
    private com.app.paleta.txtCodigo txtCod_Hasta;
    // End of variables declaration//GEN-END:variables

    private void Inicializar() {
        this.txtCod_Desde.setText("");
        this.txtCod_Hasta.setText("");
        this.textDesde.setText("");
        this.textHasta.setText("");
        ModoEdicion(false);
        if (this.Listar_OK == false) {
            this.btnReporNuevo.setEnabled(Listar_OK);
        }
        desde = "";
        hasta = "";
        this.btnReporNuevo.grabFocus();
    }

    private void ModoEdicion(boolean x) {
        this.txtCod_Desde.setEnabled(x);
        this.txtCod_Hasta.setEnabled(x);
        this.txtCod_Desde.setEnabled(x);
        this.txtCod_Hasta.setEnabled(x);
        this.btnReporNuevo.setEnabled(!x);
        this.btnReporPantalla.setEnabled(x);
        this.btnReporImpresora.setEnabled(x);
        this.btnReporExportar.setEnabled(x);
        this.btnReporCancelar.setEnabled(x);
        this.btnReporSalir.setEnabled(!x);
    }

    public void Agregar() {
        operacion = 'A';
        int x = getConexion.getMIN(tablaConsutada, idConsultada, null, null);
        if (x >= 0) {
            int y = getConexion.getMAX(tablaConsutada, idConsultada, null, null);
            if (y >= 0) {
                desde = x + "";
                hasta = y + "";
                this.ModoEdicion(true);
                this.btnReporPantalla.setEnabled(false);
                this.btnReporImpresora.setEnabled(false);
                this.txtCod_Desde.setText(desde);
                this.txtCod_Desde.grabFocus();
            }
        }
    }

    public void Reporte(char modalidad) {
        try {
            ResultSet resu = traerDatos();
            if (resu.next()) {
                if (modalidad == 'E') {
                    resu.beforeFirst();
                    Excel excel = new Excel();
                    excel.export(getConexion.getDefaultTableModel(resu), this.tituloVentanaActual);
                    if (MensajeSistema.Pregunta_YES_NO(this, "Desea abrir el archivo exportado???") == 0) {
                        excel.AbrirUltimo();
                    }
                    this.Inicializar();
                } else {
                    String vDesde = this.textDesde.getText().trim() + " (" + desde + ")";
                    String vHasta = this.textHasta.getText().trim() + " (" + hasta + ")";
                    Inicializar();
                    JRResultSetDataSource jrRS = new JRResultSetDataSource(resu);
                    try {
                        if (resu.last()) {
                            int cantidadRow = resu.getRow();
                            resu.beforeFirst();
                            HashMap parameters = new HashMap();
                            parameters.put("titulo", tituloVentanaActual);
                            parameters.put("desde", vDesde);
                            parameters.put("hasta", vHasta);
                            parameters.put("empresa", Configuracion.getNOM_EMPRESA());
                            parameters.put("sucursal", Configuracion.getNOM_SUCURSAL());
                            parameters.put("usuario", Configuracion.getNOM_USUARIO());
                            parameters.put("cantidadRow", cantidadRow + "");
                            parameters.put("tituloDescri1", this.Titulo1);
                            parameters.put("tituloDescri2", this.Titulo2);
                            this.reportes.mostrarReporteVentana(parameters, jrRS, reporte, modalidad, tituloVentanaActual);
                        }
                    } catch (SQLException ex) {
                        MensajeSistema.setException(this, "Se produjo un error al Contar el Registro!!!", ex);
                    }
                }
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Desde.setText("");
                    this.txtCod_Hasta.setText("");
                    this.textDesde.setText("");
                    this.textHasta.setText("");
                    this.txtCod_Desde.grabFocus();
                } else {
                    Inicializar();
                }
            }
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
    }

    private ResultSet traerDatos() {
        String[] campo = new String[]{idConsultada, NomDesc1, NomDesc2, descripcionConsultada};
        String[] nombres = new String[]{"codigo", "descri1", "descri2", "observacion"};
        String consulta;
        if (UsarEmpresa && UsarSucursal) {
            String[] campoCondicion = {cod_empresa, cod_sucursal, idConsultada, idConsultada};
            String[] igual = {"=", "=", ">=", "<="};
            String[] valores = {Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada};
            consulta = ConsultaSQL.getSelect(tablaConsutada, campo, nombres, campoCondicion,
                    igual, valores, ordenBy);
        } else if (UsarEmpresa) {
            String[] campoCondicion = {cod_empresa, idConsultada, idConsultada};
            String[] igual = {"=", ">=", "<="};
            String[] valores = {Configuracion.getCOD_EMPRESA(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada};
            consulta = ConsultaSQL.getSelect(tablaConsutada, campo, nombres, campoCondicion,
                    igual, valores, ordenBy);
        } else {
            String[] campoCondicion = {idConsultada, idConsultada};
            String[] igual = {">=", "<="};
            String[] valores = {this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada};
            consulta = ConsultaSQL.getSelect(tablaConsutada, campo, nombres, campoCondicion,
                    igual, valores, ordenBy);
        }
        return getConexion.ejecutaQuery(consulta);
    }
}
