package com.app.form.Especiales;

import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 * Este formulario sirve para cualquier tabla de dos campos y un foranero que
 * existe en la base de datos
 *
 * @author Diego
 */
public final class ABMTresCamposFK extends frm_Padre implements Metodos {

    public ABMTresCamposFK(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion, String titulo,
            String tablaForaneo, String codigoForaneo, String descripcionForaneo, String tituloForaneo) {
        initComponents();
        this.setResizable(false);
        this.setName(titulo);
        this.Cod_Ventana = cod_ventana;

        this.txtCodigo.setBdTabla(tabla);
        this.txtCodigo.setBdCodigo(codigo);
        this.txtCodigo.setBdDescrip(descripcion);
        this.txtCodigo.setBdTitulo(titulo);
        this.txtCodigo.setUsarEmpresa(Empresa);
        this.txtCodigo.setUsarSucursal(Sucursal);

        this.txtCod_Referencia.setBdTabla(tablaForaneo);
        this.txtCod_Referencia.setBdCodigo(codigoForaneo);
        this.txtCod_Referencia.setBdDescrip(descripcionForaneo);
        this.txtCod_Referencia.setBdTitulo(tituloForaneo);
        this.txtCod_Referencia.setUsarEmpresa(Empresa);
        this.txtCod_Referencia.setUsarEmpresa(Sucursal);
        this.txtCod_Referencia.setBuscar(true);

        this.getPermisos(this.Cod_Ventana);
        this.pnlABM.addListener(this);
        this.pnlTitulo1.setTextTitulo("Mantenimiento de " + titulo + "...");
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
        txtCod_Referencia = new com.app.paleta.txtCodigo();
        textNom_Referencia = new javax.swing.JLabel();
        pnlABM = new com.app.botones.pnlABM();
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

        txtCod_Referencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ReferenciaActionPerformed(evt);
            }
        });

        textNom_Referencia.setText("text");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCod_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNom_Referencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNom_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(pnlABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtCod_ReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ReferenciaActionPerformed
        if (txtCod_Referencia.verificarVacioSinMsj()) {
            String valor = this.txtCod_Referencia.getDescripcion();
            if (valor != null) {
                this.textNom_Referencia.setText(valor);
                this.pnlABM.btnGrabar.setEnabled(true);
                this.pnlABM.btnGrabar.grabFocus();
            } else {
                MensajeSistema.ConsultaSQLVacio(this);
                this.txtCod_Referencia.setText("");
                this.textNom_Referencia.setText("");
                this.txtCod_Referencia.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCod_ReferenciaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int valor = this.txtCodigo.verificarVacioConMsj();
        if (valor == 0) {
            if (Operacion == 'M' || Operacion == 'E') {
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
            this.txtDescripcion.setTextMayuscula();
            this.txtCod_Referencia.setEnabled(true);
            this.txtCod_Referencia.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.app.botones.pnlABM pnlABM;
    private javax.swing.JPanel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo1;
    private javax.swing.JLabel textNom_Referencia;
    private com.app.paleta.txtCodigo txtCod_Referencia;
    private com.app.paleta.txtCodigo txtCodigo;
    private com.app.paleta.txtTexto txtDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Inicializar() {
        this.txtCodigo.setText("");
        this.txtDescripcion.setText("");
        this.txtCod_Referencia.setText("");
        this.textNom_Referencia.setText("");
        this.txtCodigo.setEnabled(false);
        this.txtDescripcion.setEnabled(false);
        this.txtCod_Referencia.setEnabled(false);
        this.pnlABM.btnNuevo.setEnabled(Agrega_OK);
        this.pnlABM.btnModificar.setEnabled(Modifica_OK);
        this.pnlABM.btnBorrar.setEnabled(Borra_OK);
        this.pnlABM.btnGrabar.setEnabled(false);
        this.pnlABM.btnCancelar.setEnabled(false);
        this.pnlABM.btnSalir.setEnabled(true);
        this.txtCodigo.setBuscar(true);
        if (this.pnlABM.btnNuevo.isEnabled()) {
            this.pnlABM.btnNuevo.grabFocus();
        } else if (this.pnlABM.btnModificar.isEnabled()) {
            this.pnlABM.btnModificar.grabFocus();
        } else if (this.pnlABM.btnBorrar.isEnabled()) {
            this.pnlABM.btnBorrar.grabFocus();
        } else {
            this.pnlABM.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        String xide = this.txtCodigo.getText();
        String xdes = this.txtDescripcion.getText().trim();
        String xfor = this.txtCod_Referencia.getText();
        if (Operacion == 'A') {
            if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) { // Cuando se usar Empresa y Sucursal
                getConexion.insertar(txtCodigo.getBdTabla(),
                        new String[]{EMP_CODIGO, SUC_CODIGO, txtCodigo.getBdCodigo(), txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), xide, xdes, xfor});
            } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa
                getConexion.insertar(txtCodigo.getBdTabla(),
                        new String[]{EMP_CODIGO, txtCodigo.getBdCodigo(), txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), xide, xdes, xfor});
            } else { // Cuando no se usar Ni empresa Ni sucursal
                getConexion.insertar(txtCodigo.getBdTabla(),
                        new String[]{txtCodigo.getBdCodigo(), txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{xide, xdes, xfor});
            }
        } else if (Operacion == 'M') {
            if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) { // Cuando se usar Empresa y Sucursal
                getConexion.actualizar(txtCodigo.getBdTabla(),
                        new String[]{txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{xdes, xfor},
                        new String[]{EMP_CODIGO, SUC_CODIGO, txtCodigo.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), xide});
            } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa
                getConexion.actualizar(txtCodigo.getBdTabla(),
                        new String[]{txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{xdes, xfor},
                        new String[]{EMP_CODIGO, txtCodigo.getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), xide});
            } else { // Cuando no se usar Ni empresa Ni sucursal
                getConexion.actualizar(txtCodigo.getBdTabla(),
                        new String[]{txtCodigo.getBdDescrip(), this.txtCod_Referencia.getBdCodigo()},
                        new String[]{xdes, xfor},
                        txtCodigo.getBdCodigo(), xide);
            }
        }
        Inicializar();
    }

    @Override
    public void Agregar() {
        if (this.txtCodigo.autoNumerico()) {
            this.pnlABM.ModoEdicion(false);
            this.txtCodigo.setEnabled(false);
            this.txtDescripcion.setEnabled(true);
            this.pnlABM.btnGrabar.setEnabled(false);
            Operacion = 'A';
            this.txtCodigo.setBuscar(false);
            this.txtDescripcion.grabFocus();
        } else {
            Inicializar();
        }
    }

    @Override
    public void Editar(char c) {
        Operacion = c;
        this.pnlABM.ModoEdicion(false);
        this.pnlABM.btnGrabar.setEnabled(false);
        this.txtCodigo.setEnabled(true);
        this.txtCodigo.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String[] resultado;
        if (this.txtCodigo.isUsarEmpresa() && this.txtCodigo.isUsarSucursal()) { // Cuando se usar Empresa y Sucursal
            resultado = getConexion.getDescripciones(txtCodigo.getBdTabla(),
                    new String[]{txtCodigo.getBdDescrip()},
                    new String[]{EMP_CODIGO, SUC_CODIGO, txtCodigo.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), codigo});
        } else if (this.txtCodigo.isUsarEmpresa()) { // Cuando se usar solo Empresa
            resultado = getConexion.getDescripciones(txtCodigo.getBdTabla(),
                    new String[]{txtCodigo.getBdDescrip()},
                    new String[]{EMP_CODIGO, txtCodigo.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), codigo});
        } else { // Cuando no se usar Ni empresa Ni sucursal
            resultado = getConexion.getDescripciones(txtCodigo.getBdTabla(),
                    new String[]{txtCodigo.getBdDescrip()},
                    new String[]{txtCodigo.getBdCodigo()},
                    new String[]{codigo});
        }
        if (resultado[0] != null) {
            txtDescripcion.setText(resultado[0]);
            txtCod_Referencia.setText(resultado[1]);
            textNom_Referencia.setText(resultado[2]);
            if (Operacion == 'E') {
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
