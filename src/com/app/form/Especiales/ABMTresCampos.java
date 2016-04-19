package com.app.form.Especiales;

import com.app.clases.ClaseBotones;
import com.app.clases.ClaseCampos;
import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre.Metodos;

/**
 * este formulario sirve para cualquier tabla de dos campos y un foranero que
 * existe en la base de datos
 *
 * @author Diego
 */
public final class ABMTresCampos extends frm_Padre implements Metodos {

    String descripcion2;

    public ABMTresCampos(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal,
            String codigo, String descripcion,
            String descripcion2, String titulo) {
        initComponents();
        this.setResizable(false);
        this.setName(titulo);
        this.tablaConsutada = tabla;
        this.Cod_Ventana = cod_ventana;
        this.UsarEmpresa = Empresa;
        this.UsarSucursal = Sucursal;
        this.idConsultada = codigo;
        this.descripcionConsultada = descripcion;
        this.descripcion2 = descripcion2;
        this.tituloVentanaActual = titulo;
        this.getPermisos(this.Cod_Ventana);
        ClaseBotones.botonesABMKeyPressed(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir);
        this.textTitulo.setText("Mantenimiento de " + tituloVentanaActual + "...");
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
        pnlTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new com.app.paleta.txtCodigo();
        txtDescripcion = new com.app.paleta.txtTexto();
        txtDescripcion2 = new com.app.paleta.txtTexto();
        jPanelBotones = new javax.swing.JPanel();
        btnNuevo = new com.app.botones.btnNuevo();
        btnModificar = new com.app.botones.btnEditar();
        btnBorrar = new com.app.botones.btnBorrar();
        btnGrabar = new com.app.botones.btnGrabar();
        btnCancelar = new com.app.botones.btnCancelar();
        btnSalir = new com.app.botones.btnSalir();

        pnlTitulo.setBackground(new java.awt.Color(204, 204, 204));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTitulo.setMaximumSize(new java.awt.Dimension(486, 60));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(486, 60));
        pnlTitulo.setName(""); // NOI18N
        pnlTitulo.setPreferredSize(new java.awt.Dimension(486, 60));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        textTitulo.setText("TITULO...");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jPanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setMaximumSize(new java.awt.Dimension(90, 30));
        btnSalir.setMinimumSize(new java.awt.Dimension(90, 30));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int valor = this.txtCodigo.verificarVacioConMsj();
        if (valor == 0) {
            if (operacion == 'M' || operacion == 'E') {
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
            this.txtDescripcion2.setEnabled(true);
            this.txtDescripcion2.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDescripcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcion2ActionPerformed
        int valor = txtDescripcion2.verificarVacioConMsj();
        if (valor == 0) {
            this.txtDescripcion2.setTextMayuscula();
            this.btnGrabar.setEnabled(true);
            this.btnGrabar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtDescripcion2ActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            if (operacion != 'A') {
                Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
                this.txtCodigo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.Agregar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.Editar('M');
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.Editar('E');
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        this.Grabar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Inicializar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Salir(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.btnBorrar btnBorrar;
    private com.app.botones.btnCancelar btnCancelar;
    private com.app.botones.btnGrabar btnGrabar;
    private com.app.botones.btnEditar btnModificar;
    private com.app.botones.btnNuevo btnNuevo;
    private com.app.botones.btnSalir btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JLabel textTitulo;
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
        this.btnNuevo.setEnabled(Agrega_OK);
        this.btnModificar.setEnabled(Modifica_OK);
        this.btnBorrar.setEnabled(Borra_OK);
        this.btnGrabar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnSalir.setEnabled(true);
        if (this.btnNuevo.isEnabled()) {
            this.btnNuevo.grabFocus();
        } else if (this.btnModificar.isEnabled()) {
            this.btnModificar.grabFocus();
        } else if (this.btnBorrar.isEnabled()) {
            this.btnBorrar.grabFocus();
        } else {
            this.btnSalir.grabFocus();
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
            if (operacion == 'A') { // Cuando se usar Empresa y Sucursal
                if (UsarEmpresa && UsarSucursal) {
                    getConexion.insertar(tablaConsutada,
                            new String[]{cod_empresa, cod_sucursal, idConsultada, descripcionConsultada, descripcion2},
                            new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), xide, xdes, xfor});
                } else if (UsarEmpresa) { // Cuando se usar solo Empresa 
                    getConexion.insertar(tablaConsutada,
                            new String[]{cod_empresa, idConsultada, descripcionConsultada, descripcion2},
                            new String[]{Configuracion.getCOD_EMPRESA(), xide, xdes, xfor});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.insertar(tablaConsutada,
                            new String[]{idConsultada, descripcionConsultada, descripcion2},
                            new String[]{xide, xdes, xfor});
                }
            } else if (operacion == 'M') {
                if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada, descripcion2},
                            new String[]{xdes, xfor},
                            new String[]{cod_empresa, cod_sucursal, idConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), xide});
                } else if (UsarEmpresa) { // Cuando se usar solo Empresa
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada, descripcion2},
                            new String[]{xdes, xfor},
                            new String[]{cod_empresa, idConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), xide});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada, descripcion2},
                            new String[]{xdes, xfor},
                            idConsultada, xide);
                }
            }
            Inicializar();
        }
    }

    @Override
    public void Agregar() {
        String[] campos, valores;
        if (UsarEmpresa && UsarSucursal) {
            campos = new String[]{cod_empresa, cod_sucursal};
            valores = new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL()};
        } else if (UsarEmpresa) {
            campos = new String[]{cod_empresa};
            valores = new String[]{Configuracion.getCOD_EMPRESA()};
        } else {
            campos = null;
            valores = null;
        }
        if (getConexion.autoNumerico(tablaConsutada, idConsultada, campos, valores, this.txtCodigo)) {
            ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
            this.txtCodigo.setEnabled(false);
            this.txtDescripcion.setEnabled(true);
            this.btnGrabar.setEnabled(false);
            operacion = 'A';
            this.txtDescripcion.grabFocus();
        } else {
            Inicializar();
        }
    }

    @Override
    public void Editar(char c) {
        this.operacion = c;
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
        this.btnGrabar.setEnabled(false);
        this.txtCodigo.setEnabled(true);
        this.txtCodigo.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String[] resultado;
        String[] campo = {descripcionConsultada, descripcion2};
        if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal            
            resultado = getConexion.getDescripciones(tablaConsutada, campo,
                    new String[]{cod_empresa, cod_sucursal, idConsultada},
                    new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), codigo});
        } else if (UsarEmpresa) { // Cuando se usar solo Empresa            
            resultado = getConexion.getDescripciones(tablaConsutada, campo,
                    new String[]{cod_empresa, idConsultada},
                    new String[]{Configuracion.getCOD_EMPRESA(), codigo});
        } else {
            resultado = getConexion.getDescripciones(tablaConsutada, campo,
                    new String[]{idConsultada}, new String[]{codigo});
        }
        if (resultado[0] != null) {
            txtDescripcion.setText(resultado[0]);
            txtDescripcion2.setText(resultado[1]);
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
