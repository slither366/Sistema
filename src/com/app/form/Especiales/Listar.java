package com.app.form.Especiales;

import com.app.clases.utilidades.Excel;
import com.app.clases.GenerarReportes;
import com.app.config.Configuracion;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Listar extends frm_Padre {

    private String desde, hasta;
    private String tituloVentanaActual, descripcionForaneo, tituloVentanaForaneo;
    private GenerarReportes reportes;
    private String Reporte;
    private int foraneo;//0:listado cualquiera, 1: dos campos, 2: tres campos sin FK, 3:tres campos con FK        
    private String[] Campos;
    private String[] Nombres;

    /**
     * Listar para dos campos
     *
     * @param tabla
     * @param Empresa
     * @param cod_ventana
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo,
            String descripcion, String titulo) {
        initComponents();
        this.setName("listar" + titulo);
        this.reportes = new GenerarReportes();
        this.txtCod_Desde.setBdTabla(tabla);
        this.txtCod_Desde.setBdCodigo(codigo);
        this.txtCod_Desde.setBdDescrip(descripcion);
        this.txtCod_Desde.setBdTitulo(titulo);
        this.txtCod_Desde.setUsarEmpresa(Empresa);
        this.txtCod_Desde.setUsarSucursal(Sucursal);
        this.txtCod_Desde.setOperacion('x');
        this.txtCod_Hasta.setBdTabla(tabla);
        this.txtCod_Hasta.setBdCodigo(codigo);
        this.txtCod_Hasta.setBdDescrip(descripcion);
        this.txtCod_Hasta.setBdTitulo(titulo);
        this.txtCod_Hasta.setUsarEmpresa(Empresa);
        this.txtCod_Hasta.setUsarSucursal(Sucursal);
        this.txtCod_Hasta.setOperacion('x');
        this.tituloVentanaActual = titulo;
        this.Reporte = "";
        this.pnlListar.addListener(this);
        this.textTitulo.setText("Listado de " + titulo + "...");
        foraneo = 1;
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos SIN Campos Foraneos
     *
     * @param tabla
     * @param cod_ventana
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param descripcion2
     * @param tituloDescri2
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String descripcion2, String tituloDescri2) {
        this.reportes = new GenerarReportes();
        initComponents();
        this.setName("listar" + titulo);
        this.txtCod_Desde.setBdTabla(tabla);
        this.txtCod_Desde.setBdCodigo(codigo);
        this.txtCod_Desde.setBdDescrip(descripcion);
        this.txtCod_Desde.setBdTitulo(titulo);
        this.txtCod_Desde.setUsarEmpresa(Empresa);
        this.txtCod_Desde.setUsarSucursal(Sucursal);
        this.txtCod_Desde.setOperacion('x');
        this.txtCod_Hasta.setBdTabla(tabla);
        this.txtCod_Hasta.setBdCodigo(codigo);
        this.txtCod_Hasta.setBdDescrip(descripcion);
        this.txtCod_Hasta.setBdTitulo(titulo);
        this.txtCod_Hasta.setUsarEmpresa(Empresa);
        this.txtCod_Hasta.setUsarSucursal(Sucursal);
        this.txtCod_Hasta.setOperacion('x');
        this.Reporte = "";
        this.tituloVentanaActual = titulo;
        this.pnlListar.addListener(this);
        this.descripcionForaneo = descripcion2;
        this.tituloVentanaForaneo = tituloDescri2;
        this.textTitulo.setText("Listado de " + titulo + "...");
        foraneo = 2;
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos
     *
     * @param cod_ventana CON Campo Foraneo
     *
     * @param tabla
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param idForaneo
     * @param descripcionForaneo
     * @param tituloForaneo
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String idForaneo, String descripcionForaneo, String tituloForaneo) {
        this.reportes = new GenerarReportes();
        initComponents();
        this.setName("listar" + titulo);
        this.txtCod_Desde.setBdTabla(tabla);
        this.txtCod_Desde.setBdCodigo(codigo);
        this.txtCod_Desde.setBdDescrip(descripcion);
        this.txtCod_Desde.setBdTitulo(titulo);
        this.txtCod_Desde.setUsarEmpresa(Empresa);
        this.txtCod_Desde.setUsarSucursal(Sucursal);
        this.txtCod_Desde.setOperacion('x');
        this.txtCod_Hasta.setBdTabla(tabla);
        this.txtCod_Hasta.setBdCodigo(codigo);
        this.txtCod_Hasta.setBdDescrip(descripcion);
        this.txtCod_Hasta.setBdTitulo(titulo);
        this.txtCod_Hasta.setUsarEmpresa(Empresa);
        this.txtCod_Hasta.setUsarSucursal(Sucursal);
        this.txtCod_Hasta.setOperacion('x');
        this.Reporte = "";
        this.tituloVentanaActual = titulo;
        this.pnlListar.addListener(this);
        this.descripcionForaneo = descripcionForaneo;
        this.tituloVentanaForaneo = tituloForaneo;
        this.textTitulo.setText("Listado de " + titulo + "...");
        foraneo = 3;
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos
     *
     * @param cod_ventana CON Campo Foraneo
     *
     * @param tabla
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param reporte
     * @param campos
     * @param nombres
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String reporte, String[] campos, String[] nombres) {
        this.reportes = new GenerarReportes();
        initComponents();
        this.setName("listar" + titulo);
        this.txtCod_Desde.setBdTabla(tabla);
        this.txtCod_Desde.setBdCodigo(codigo);
        this.txtCod_Desde.setBdDescrip(descripcion);
        this.txtCod_Desde.setBdTitulo(titulo);
        this.txtCod_Desde.setUsarEmpresa(Empresa);
        this.txtCod_Desde.setUsarSucursal(Sucursal);
        this.txtCod_Desde.setOperacion('x');
        this.txtCod_Hasta.setBdTabla(tabla);
        this.txtCod_Hasta.setBdCodigo(codigo);
        this.txtCod_Hasta.setBdDescrip(descripcion);
        this.txtCod_Hasta.setBdTitulo(titulo);
        this.txtCod_Hasta.setUsarEmpresa(Empresa);
        this.txtCod_Hasta.setUsarSucursal(Sucursal);
        this.txtCod_Hasta.setOperacion('x');
        this.Reporte = reporte;
        this.Campos = campos;
        this.Nombres = nombres;
        this.tituloVentanaActual = titulo;
        this.pnlListar.addListener(this);
        this.textTitulo.setText("Listado de " + titulo + "...");
        foraneo = 0;
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Orden = e.getActionCommand();
        if (Orden.compareTo("btn1") == 0) {
            Agregar();
        } else if (Orden.compareTo("btn2") == 0) {
            this.Reporte('P');
        } else if (Orden.compareTo("btn3") == 0) {
            this.Reporte('I');
        } else if (Orden.compareTo("btn4") == 0) {
            this.Reporte('E');
        } else if (Orden.compareTo("btn5") == 0) {
            if (MensajeSistema.Cancelar(this)) {
                this.Inicializar();
            }
        } else if (Orden.compareTo("btn6") == 0) {
            Salir(this);
        }
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
        pnlListar = new com.app.botones.pnlListar();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
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

        txtCod_Hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_HastaActionPerformed(evt);
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
                    .addComponent(textHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 534, Short.MAX_VALUE))
                    .addComponent(pnlListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int valor = this.txtCod_Desde.verificarVacioConMsj();
        if (valor == 0) {
            String registro;
            if (this.txtCod_Desde.isUsarEmpresa() && this.txtCod_Desde.isUsarSucursal()) {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{EMP_CODIGO, SUC_CODIGO, txtCod_Desde.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCod_Desde.getText()});
            } else if (this.txtCod_Desde.isUsarEmpresa()) {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{EMP_CODIGO, txtCod_Desde.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Desde.getText()});
            } else {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{txtCod_Desde.getBdCodigo()}, new String[]{this.txtCod_Desde.getText()});
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
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_DesdeActionPerformed

    private void txtCod_HastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_HastaActionPerformed
        int valor = this.txtCod_Hasta.verificarVacioConMsj();
        if (valor == 0) {
            String registro;
            if (this.txtCod_Hasta.isUsarEmpresa() && this.txtCod_Hasta.isUsarSucursal()) {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{EMP_CODIGO, SUC_CODIGO, txtCod_Desde.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCod_Hasta.getText()});
            } else if (this.txtCod_Hasta.isUsarEmpresa()) {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{EMP_CODIGO, txtCod_Desde.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Hasta.getText()});
            } else {
                registro = getConexion.getDescripcion(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdDescrip(),
                        new String[]{txtCod_Desde.getBdCodigo()}, new String[]{this.txtCod_Hasta.getText()});
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
                this.pnlListar.btnPantalla.setEnabled(true);
                this.pnlListar.btnImpresora.setEnabled(true);
                this.pnlListar.btnExportar.setEnabled(true);
                this.pnlListar.btnPantalla.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_HastaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private com.app.botones.pnlListar pnlListar;
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
            this.pnlListar.btnNuevo.setEnabled(Listar_OK);
        }
        desde = "";
        hasta = "";
        this.pnlListar.btnNuevo.grabFocus();
    }

    private void ModoEdicion(boolean x) {
        this.txtCod_Desde.setEnabled(x);
        this.txtCod_Hasta.setEnabled(x);
        this.pnlListar.ModoEdicion(x);
    }

    public void Agregar() {
        int x = getConexion.getMIN(txtCod_Desde.getBdTabla(), txtCod_Desde.getBdCodigo(), null, null);
        if (x >= 0) {
            int y = getConexion.getMAX(txtCod_Hasta.getBdTabla(), txtCod_Hasta.getBdCodigo(), null, null);
            if (y >= 0) {
                desde = String.valueOf(x);
                hasta = String.valueOf(y);
                this.ModoEdicion(true);
                this.pnlListar.btnPantalla.setEnabled(false);
                this.pnlListar.btnImpresora.setEnabled(false);
                this.pnlListar.btnExportar.setEnabled(false);
                this.txtCod_Desde.setText(desde);
                this.txtCod_Desde.grabFocus();
            }
        }
    }

    public void Reporte(char modalidad) {
        try {
            ResultSet resu = traerDatos();
            if (resu.next()) {
                resu.beforeFirst();
                if (modalidad == 'E') {//Exportar                    
                    Excel excel = new Excel();
                    excel.export(getConexion.getDefaultTableModel(resu), this.tituloVentanaActual);
                    if (MensajeSistema.Pregunta_YES_NO(this, "Desea abrir el archivo exportado???") == 0) {
                        excel.AbrirUltimo();
                    }
                    this.Inicializar();
                } else {
                    String xdesde = this.textDesde.getText().trim() + " (" + desde + ")";
                    String xhasta = this.textHasta.getText().trim() + " (" + hasta + ")";
                    Inicializar();
                    if (foraneo == 0) {//Reporte especiales, donde se envia la ubicacion del reporte
                        reportes.MostrarReporte(resu, this.Reporte, xdesde, xhasta, modalidad, txtCod_Desde.getBdTabla());
                    } else {// Reportes predetermiandos de campos predefinidos
                        if (foraneo == 1) {
                            reportes.listadoDosCampos(resu, tituloVentanaActual, xdesde, xhasta, modalidad);
                        } else {
                            reportes.listadoTresCampos(resu, tituloVentanaActual, xdesde, xhasta, modalidad, tituloVentanaForaneo);
                        }
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
        String[] campo, nombre;
        String tabla;
        if (foraneo == 1) {
            campo = new String[]{txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip()};
            nombre = new String[]{"codigo", "descripcion"};
            tabla = txtCod_Desde.getBdTabla();
        } else if (foraneo == 2) {
            campo = new String[]{txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip(), descripcionForaneo};
            nombre = new String[]{"codigo", "descripcion", "referencia"};
            tabla = txtCod_Desde.getBdTabla();
        } else if (foraneo == 3) {
            campo = new String[]{txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip(), descripcionForaneo};
            nombre = new String[]{"codigo", "descripcion", "referencia"};
            tabla = "vst_" + txtCod_Desde.getBdTabla();
        } else {
            campo = this.Campos;
            nombre = this.Nombres;
            tabla = txtCod_Desde.getBdTabla();
        }
        String consulta;
        if (this.txtCod_Desde.isUsarEmpresa() && this.txtCod_Desde.isUsarSucursal()) {
            String[] campoCondicion = {EMP_CODIGO, SUC_CODIGO, txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdCodigo()};
            String[] igual = {"=", "=", ">=", "<="};
            String[] valores = {Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip()};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        } else if (this.txtCod_Desde.isUsarEmpresa()) {
            String[] campoCondicion = {EMP_CODIGO, txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdCodigo()};
            String[] igual = {"=", ">=", "<="};
            String[] valores = {Configuracion.getEMP_CODIGO(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip()};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        } else {
            String[] campoCondicion = {txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdCodigo()};
            String[] igual = {">=", "<="};
            String[] valores = {this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {txtCod_Desde.getBdCodigo(), txtCod_Desde.getBdDescrip()};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        }
        return getConexion.ejecutaQuery(consulta);
    }
}
