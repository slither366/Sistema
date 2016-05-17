package com.app.form.Especiales;

import com.app.clases.ClaseCampos;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 * Este formulario sirve para cualquier tabla de TRES campos existe en la base
 * de datos
 *
 * @author Diego
 */
public final class ABMTresCampos extends frm_Padre implements Metodos {

    String descripcion2;

    public ABMTresCampos(String tabla, int cod_ventana, boolean empresa, boolean sucursal,
            String codigo, String descripcion,
            String descripcion2, String titulo) {
        initComponents();
        this.setResizable(false);
        this.setName(titulo);
        this.txtCodigo.setBdTabla(tabla);
        this.txtCodigo.setBdCodigo(codigo);
        this.txtCodigo.setBdDescrip(descripcion);
        this.txtCodigo.setBdTitulo(titulo);
        this.txtCodigo.setUsarEmpresa(empresa);
        this.txtCodigo.setUsarSucursal(sucursal);
        this.descripcion2 = descripcion2;
        this.getPermisos(cod_ventana);
        this.pnlTitulo1.setTextTitulo("Mantenimiento de " + titulo + "...");
        this.pnlABM1.addListener(this);
        this.txtDescripcion.setEnMayuscula(true);
        this.txtDescripcion2.setEnMayuscula(true);
        this.Inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Orden = e.getActionCommand();
        if (Orden.compareTo("btn1") == 0) {
            Agregar();
        } else if (Orden.compareTo("btn2") == 0) {
            Editar('M');
        } else if (Orden.compareTo("btn3") == 0) {
            Editar('E');
        } else if (Orden.compareTo("btn4") == 0) {
            Grabar();
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
        pnlDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new com.app.paleta.txtCodigo();
        txtDescripcion = new com.app.paleta.txtTexto();
        txtDescripcion2 = new com.app.paleta.txtTexto();
        pnlABM1 = new com.app.botones.pnlABM();
        pnlTitulo1 = new com.app.paleta.panelTitulo();

        pnlDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDatos.setMaximumSize(new java.awt.Dimension(482, 73));
        pnlDatos.setMinimumSize(new java.awt.Dimension(482, 73));
        pnlDatos.setPreferredSize(new java.awt.Dimension(482, 73));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Referencia:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtDescripcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcion2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescripcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlABM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlABM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int valor = this.txtCodigo.verificarVacioConMsj();
        if (valor == 0) {
            if (this.txtCodigo.getOperacion() == 'M' || this.txtCodigo.getOperacion() == 'E') {
                this.txtCodigo.setEnabled(false);
                this.RecuperarDatos(this.txtCodigo.getText());
            } else {
                this.txtDescripcion.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        int valor = txtDescripcion.verificarVacioConMsj();
        if (valor == 0) {
            this.txtDescripcion2.setEnabled(true);
            this.txtDescripcion2.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDescripcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcion2ActionPerformed
        int valor = txtDescripcion2.verificarVacioConMsj();
        if (valor == 0) {
            this.pnlABM1.btnGrabar.setEnabled(true);
            this.pnlABM1.btnGrabar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcion2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.app.botones.pnlABM pnlABM1;
    private javax.swing.JPanel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo1;
    private com.app.paleta.txtCodigo txtCodigo;
    private com.app.paleta.txtTexto txtDescripcion;
    private com.app.paleta.txtTexto txtDescripcion2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Inicializar() {
        this.txtCodigo.setText("");
        this.txtDescripcion.setText("");
        this.txtDescripcion2.setText("");
        this.txtCodigo.setEnabled(false);
        this.txtDescripcion.setEnabled(false);
        this.txtDescripcion2.setEnabled(false);
        this.pnlABM1.btnNuevo.setEnabled(Agrega_OK);
        this.pnlABM1.btnModificar.setEnabled(Modifica_OK);
        this.pnlABM1.btnBorrar.setEnabled(Borra_OK);
        this.pnlABM1.btnGrabar.setEnabled(false);
        this.pnlABM1.btnCancelar.setEnabled(false);
        this.pnlABM1.btnSalir.setEnabled(true);
        if (this.pnlABM1.btnNuevo.isEnabled()) {
            this.pnlABM1.btnNuevo.grabFocus();
        } else if (this.pnlABM1.btnModificar.isEnabled()) {
            this.pnlABM1.btnModificar.grabFocus();
        } else if (this.pnlABM1.btnBorrar.isEnabled()) {
            this.pnlABM1.btnBorrar.grabFocus();
        } else {
            this.pnlABM1.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        if (ClaseCampos.setValidate(pnlDatos)) {
            MensajeSistema.validarVacio(this);
        } else {
            String xide = this.txtCodigo.getText();
            String xdes = this.txtDescripcion.getText().trim();
            String xfor = this.txtDescripcion2.getText();
            if (this.txtCodigo.getOperacion() == 'A') { // Cuando se usar Empresa y Sucursal
                if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) {
                    getConexion.insertar(this.txtCodigo.getBdTabla(),
                            new String[]{EMP_CODIGO, SUC_CODIGO, this.txtCodigo.getBdCodigo(), this.txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), xide, xdes, xfor});
                } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa 
                    getConexion.insertar(this.txtCodigo.getBdTabla(),
                            new String[]{EMP_CODIGO, this.txtCodigo.getBdCodigo(), this.txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{Configuracion.getEMP_CODIGO(), xide, xdes, xfor});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.insertar(this.txtCodigo.getBdTabla(),
                            new String[]{this.txtCodigo.getBdCodigo(), txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{xide, xdes, xfor});
                }
            } else if (this.txtCodigo.getOperacion() == 'M') {
                if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) { // Cuando se usar Empresa y Sucursal
                    getConexion.actualizar(this.txtCodigo.getBdTabla(),
                            new String[]{this.txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{xdes, xfor},
                            new String[]{EMP_CODIGO, SUC_CODIGO, this.txtCodigo.getBdCodigo()},
                            new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), xide});
                } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa
                    getConexion.actualizar(this.txtCodigo.getBdTabla(),
                            new String[]{this.txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{xdes, xfor},
                            new String[]{EMP_CODIGO, this.txtCodigo.getBdCodigo()},
                            new String[]{Configuracion.getEMP_CODIGO(), xide});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.actualizar(this.txtCodigo.getBdTabla(),
                            new String[]{this.txtCodigo.getBdDescrip(), descripcion2},
                            new String[]{xdes, xfor},
                            txtCodigo.getBdCodigo(), xide);
                }
            }
            Inicializar();
        }
    }

    @Override
    public void Agregar() {
        if (this.txtCodigo.autoNumerico()) {
            this.pnlABM1.ModoEdicion(false);
            this.txtCodigo.setEnabled(false);
            this.txtDescripcion.setEnabled(true);
            this.pnlABM1.btnGrabar.setEnabled(false);
            this.txtCodigo.setOperacion('A');
            this.txtDescripcion.grabFocus();
        } else {
            Inicializar();
        }
    }

    @Override
    public void Editar(char c) {
        this.txtCodigo.setOperacion(c);
        this.pnlABM1.ModoEdicion(false);
        this.pnlABM1.btnGrabar.setEnabled(false);
        this.txtCodigo.setEnabled(true);
        this.txtCodigo.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String[] resultado;
        String[] campo = {this.txtCodigo.getBdDescrip(), descripcion2};
        if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) { // Cuando se usar Empresa y Sucursal            
            resultado = getConexion.getDescripciones(this.txtCodigo.getBdTabla(), campo,
                    new String[]{EMP_CODIGO, SUC_CODIGO, this.txtCodigo.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), codigo});
        } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa            
            resultado = getConexion.getDescripciones(this.txtCodigo.getBdTabla(), campo,
                    new String[]{EMP_CODIGO, this.txtCodigo.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), codigo});
        } else {
            resultado = getConexion.getDescripciones(this.txtCodigo.getBdTabla(), campo,
                    new String[]{this.txtCodigo.getBdCodigo()}, new String[]{codigo});
        }
        if (resultado[0] != null) {
            txtDescripcion.setText(resultado[0]);
            txtDescripcion2.setText(resultado[1]);
            if (this.txtCodigo.getOperacion() == 'E') {                
                this.txtCodigo.Borrar();
                Inicializar();
            } else {
                this.txtDescripcion.setEnabled(true);
                this.txtDescripcion.grabFocus();
            }
        } else {
            if (MensajeSistema.ConsultaSQLVacio(this)) {
                this.txtCodigo.setText("");
                this.txtCodigo.setEnabled(true);
                this.txtCodigo.grabFocus();
            } else {
                this.Inicializar();
            }
        }
    }
}
