package com.app.form.Especiales;

import com.app.clases.ClaseCampos;
import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 * Este formulario sirve para cualquier tabla de dos campos existe en la base de
 * datos
 *
 * @author Diego
 */
public final class ABMDosCampos extends frm_Padre implements Metodos {

    public ABMDosCampos(String tabla, int cod_ventana, boolean empresa, boolean sucursal,
            String codigo, String descripcion, String titulo) {
        initComponents();
        this.setName(titulo);
        this.tablaConsutada = tabla;
        this.Cod_Ventana = cod_ventana;
        this.UsarEmpresa = empresa;
        this.UsarSucursal = sucursal;
        this.idConsultada = codigo;
        this.descripcionConsultada = descripcion;
        this.tituloVentanaActual = titulo;
        this.pnlTitulo1.setTextTitulo("Mantenimiento de " + tituloVentanaActual + "...");
        this.getPermisos(this.Cod_Ventana);
        this.txtDescripcion.setEnMayuscula(true);
        this.botonesABM.addListener(this);
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
        jPanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new com.app.paleta.txtCodigo();
        txtDescripcion = new com.app.paleta.txtTexto();
        pnlTitulo1 = new com.app.paleta.panelTitulo();
        botonesABM = new com.app.botones.pnlABM();

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descripción:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonesABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonesABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int valor = this.txtCodigo.verificarVacioConMsj();
        if (valor == 0) {
            this.txtCodigo.setEnabled(false);
            if (operacion == 'M' || operacion == 'E') {
                this.RecuperarDatos(this.txtCodigo.getText());
            } else {
                this.txtDescripcion.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        int valor = this.txtDescripcion.verificarVacioConMsj();
        if (valor == 0) {
            this.txtDescripcion.setTextMayuscula();
            this.botonesABM.btnGrabar.setEnabled(true);
            this.botonesABM.btnGrabar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            if (operacion != 'A') {
                Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
                this.txtCodigo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.pnlABM botonesABM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private com.app.paleta.panelTitulo pnlTitulo1;
    private com.app.paleta.txtCodigo txtCodigo;
    private com.app.paleta.txtTexto txtDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Inicializar() {
        this.txtCodigo.setText("");
        this.txtDescripcion.setText("");
        this.txtCodigo.setEnabled(false);
        this.txtDescripcion.setEnabled(false);
        this.botonesABM.btnNuevo.setEnabled(Agrega_OK);
        this.botonesABM.btnModificar.setEnabled(Modifica_OK);
        this.botonesABM.btnBorrar.setEnabled(Borra_OK);
        this.botonesABM.btnGrabar.setEnabled(false);
        this.botonesABM.btnCancelar.setEnabled(false);
        this.botonesABM.btnSalir.setEnabled(true);
        if (this.botonesABM.btnNuevo.isEnabled()) {
            this.botonesABM.btnNuevo.grabFocus();
        } else if (this.botonesABM.btnModificar.isEnabled()) {
            this.botonesABM.btnModificar.grabFocus();
        } else if (this.botonesABM.btnBorrar.isEnabled()) {
            this.botonesABM.btnBorrar.grabFocus();
        } else {
            this.botonesABM.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        if (ClaseCampos.setValidate(this.jPanelDatos)) {
            MensajeSistema.validarVacio(this);
        } else {
            if (operacion == 'A') {
                if (MensajeSistema.Guardar(this)) {
                    if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
                        getConexion.insertar(tablaConsutada,
                                new String[]{EMP_CODIGO, SUC_CODIGO, idConsultada, descripcionConsultada},
                                new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCodigo.getText(), this.txtDescripcion.getText()});
                    } else if (UsarEmpresa) { // Cuando se usar solo Empresa
                        getConexion.insertar(tablaConsutada,
                                new String[]{EMP_CODIGO, idConsultada, descripcionConsultada},
                                new String[]{Configuracion.getEMP_CODIGO(), this.txtCodigo.getText(), this.txtDescripcion.getText()});
                    } else { // Cuando no se usar Ni empresa Ni sucursal
                        getConexion.insertar(tablaConsutada,
                                new String[]{idConsultada, descripcionConsultada},
                                new String[]{this.txtCodigo.getText(), this.txtDescripcion.getText()});
                    }
                }
            } else if (operacion == 'M') {
                if (MensajeSistema.Modificar(this)) {
                    if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
                        getConexion.actualizar(tablaConsutada, new String[]{descripcionConsultada},
                                new String[]{this.txtDescripcion.getText()},
                                new String[]{EMP_CODIGO, SUC_CODIGO, idConsultada},
                                new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCodigo.getText()});
                    } else if (UsarEmpresa) { // Cuando se usar solo Empresa
                        getConexion.actualizar(tablaConsutada, new String[]{descripcionConsultada},
                                new String[]{this.txtDescripcion.getText()},
                                new String[]{EMP_CODIGO, idConsultada},
                                new String[]{Configuracion.getEMP_CODIGO(), this.txtCodigo.getText()});
                    } else { // Cuando no se usar Ni empresa Ni sucursal
                        getConexion.actualizar(tablaConsutada, new String[]{descripcionConsultada},
                                new String[]{this.txtDescripcion.getText()}, idConsultada, this.txtCodigo.getText());
                    }
                }

            }
            Inicializar();
        }
    }

    @Override
    public void Agregar() {
        String[] campos, valores;
        if (UsarEmpresa && UsarSucursal) {
            campos = new String[]{EMP_CODIGO, SUC_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO()};
        } else if (UsarEmpresa) {
            campos = new String[]{EMP_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO()};
        } else {
            campos = null;
            valores = null;
        }
        if (getConexion.autoNumerico(tablaConsutada, idConsultada, campos, valores, this.txtCodigo)) {
            this.botonesABM.ModoEdicion(false);
            this.botonesABM.btnGrabar.setEnabled(false);
            this.txtDescripcion.setEnabled(true);
            operacion = 'A';
            this.txtDescripcion.grabFocus();
        } else {
            Inicializar();
        }
    }

    @Override
    public void Editar(char c) {
        operacion = c;
        this.botonesABM.ModoEdicion(false);
        this.txtCodigo.setEnabled(true);
        this.botonesABM.btnGrabar.setEnabled(false);
        this.txtCodigo.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String resultado;
        if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
            resultado = getConexion.getDescripcion(tablaConsutada,
                    descripcionConsultada,
                    new String[]{EMP_CODIGO, SUC_CODIGO, idConsultada},
                    new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), codigo});
        } else if (UsarEmpresa) { // Cuando se usar solo Empresa
            resultado = getConexion.getDescripcion(tablaConsutada,
                    descripcionConsultada,
                    new String[]{EMP_CODIGO, idConsultada},
                    new String[]{Configuracion.getEMP_CODIGO(), codigo});
        } else { // Cuando no se usar Ni empresa Ni sucursal
            resultado = getConexion.getDescripcion(tablaConsutada,
                    descripcionConsultada, new String[]{idConsultada}, new String[]{codigo});
        }
        if (resultado != null) {
            txtDescripcion.setText(resultado);
            if (operacion == 'E') {
                Borrar(this, tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, codigo);
                Inicializar();
            } else if (operacion == 'M') {
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
