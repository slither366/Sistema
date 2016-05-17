package com.app.form.adm;

import com.app.clases.ClaseBotones;
import com.app.clases.ClaseCampos;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.clases.ClaseTeclas;
import com.app.form.Especiales.frm_Padre;

/**
 *
 * @author Diego
 */
public class Usuarios extends frm_Padre {

    /**
     * @param cod_ventana
     */
    public Usuarios(int cod_ventana) {
        initComponents();
        this.setResizable(false);
        this.setName("frm_usuarios");
        this.Cod_Ventana = cod_ventana;
        this.textTitulo.setText("Mantenimiento de Usuarios...");
        this.txtCodigo.setBdTabla("acc_usuarios");
        this.txtCodigo.setBdCodigo("Usu_Codigo");
        this.txtCodigo.setBdDescrip("Usu_Nombres");
        this.txtCodigo.setBdTitulo("Usuarios");
        this.txtCodigo.setUsarEmpresa(true);
        this.txtCodigo.setUsarSucursal(false);
        this.getPermisos(this.Cod_Ventana);
        this.txtCod_Perfil.setBdTabla("acc_perfiles");
        this.txtCod_Perfil.setBdCodigo("Perf_Codigo");
        this.txtCod_Perfil.setBdDescrip("Perf_Descrip");
        this.txtCod_Perfil.setBdTitulo("Perfiles");
        ClaseBotones.botonesABMKeyPressed(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir);
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

        pnlManteUsuario = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new com.app.paleta.txtCodigo();
        txtNom_User = new com.app.paleta.txtTexto();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCod_Perfil = new com.app.paleta.txtCodigo();
        textNomPerfil = new javax.swing.JLabel();
        txtPass1_User = new com.app.paleta.txtPassword();
        txtPass2_User = new com.app.paleta.txtPassword();
        jLabel5 = new javax.swing.JLabel();
        textClave1 = new javax.swing.JLabel();
        textClave2 = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        btnNuevo = new com.app.botones.btnNuevo();
        btnModificar = new com.app.botones.btnEditar();
        btnBorrar = new com.app.botones.btnBorrar();
        btnGrabar = new com.app.botones.btnGrabar();
        btnCancelar = new com.app.botones.btnCancelar();
        btnSalir = new com.app.botones.btnSalir();

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(208, 50));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                .addComponent(textTitulo)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNom_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNom_UserActionPerformed(evt);
            }
        });
        txtNom_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNom_UserKeyTyped(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Perfil:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Clave:");

        txtCod_Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_PerfilActionPerformed(evt);
            }
        });
        txtCod_Perfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_PerfilKeyPressed(evt);
            }
        });

        textNomPerfil.setText("jLabel10");

        txtPass1_User.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass1_UserFocusGained(evt);
            }
        });
        txtPass1_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass1_UserActionPerformed(evt);
            }
        });

        txtPass2_User.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass2_UserFocusGained(evt);
            }
        });
        txtPass2_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2_UserActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Repita:");

        textClave1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        textClave1.setText("La Clave tiene que ser, min. 5 y max. 15 caracteres. ");

        textClave2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        textClave2.setText("Repita la contraseña por favor...");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtNom_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtCod_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNomPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPass2_User, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtPass1_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textClave1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textClave2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNom_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textNomPerfil)
                        .addComponent(txtCod_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textClave1)
                        .addComponent(txtPass1_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textClave2)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPass2_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap())
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

        javax.swing.GroupLayout pnlManteUsuarioLayout = new javax.swing.GroupLayout(pnlManteUsuario);
        pnlManteUsuario.setLayout(pnlManteUsuarioLayout);
        pnlManteUsuarioLayout.setHorizontalGroup(
            pnlManteUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManteUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManteUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlManteUsuarioLayout.setVerticalGroup(
            pnlManteUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManteUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlManteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlManteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNom_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNom_UserActionPerformed
        int valor = this.txtNom_User.verificarVacioConMsj();
        if (valor == 0) {
            this.txtCod_Perfil.setEnabled(true);
            this.txtCod_Perfil.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtNom_UserActionPerformed

    private void txtNom_UserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNom_UserKeyTyped
        this.txtNom_User.CantidadLetras(evt, 25);
    }//GEN-LAST:event_txtNom_UserKeyTyped

    private void txtCod_PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_PerfilActionPerformed
        if (this.txtCod_Perfil.verificarVacioSinMsj()) {
            String rs = this.getConexion.getDescripcion(this.txtCod_Perfil.getBdTabla(), this.txtCod_Perfil.getBdDescrip(),
                    new String[]{EMP_CODIGO, this.txtCod_Perfil.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Perfil.getText()});
            if (rs != null) {
                this.textNomPerfil.setText(rs);
                this.txtPass1_User.setEnabled(true);
                this.txtPass1_User.setSelectionEnd(this.txtPass1_User.getText().length());
                this.txtPass1_User.grabFocus();
            } else {
                MensajeSistema.ConsultaSQLVacio(this);
                this.txtCod_Perfil.setText("");
                this.textNomPerfil.setText("");
                this.txtCod_Perfil.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCod_PerfilActionPerformed

    private void txtPass1_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass1_UserActionPerformed
        if (this.txtCodigo.getOperacion() == 'A') {
            int valor = txtPass1_User.verificarVacioConMsj();
            if (valor == 0) {
                if (this.txtPass1_User.verificarCantidadMinima()) {
                    this.txtPass1_User.setEnabled(false);
                    this.txtPass2_User.setEnabled(true);
                    this.txtPass2_User.setSelectionStart(0);
                    this.txtPass2_User.setSelectionEnd(this.txtPass2_User.getText().length());
                    this.txtPass2_User.grabFocus();
                }
            } else if (valor == 1) {
                this.Inicializar();
            }
        } else {
            if (this.txtPass1_User.isEmpty()) {
                this.btnGrabar.setEnabled(true);
                this.btnGrabar.grabFocus();
            } else {
                if (this.txtPass1_User.verificarCantidadMinima()) {
                    this.txtPass1_User.setEnabled(false);
                    this.txtPass2_User.setEnabled(true);
                    this.txtPass2_User.setSelectionStart(0);
                    this.txtPass2_User.setSelectionEnd(this.txtPass2_User.getText().length());
                    this.txtPass2_User.grabFocus();
                }
            }
        }

    }//GEN-LAST:event_txtPass1_UserActionPerformed

    private void txtPass2_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass2_UserActionPerformed
        int valor = txtPass2_User.verificarVacioConMsj();
        if (valor == 0) {
            if (txtPass2_User.verificarCantidadMinima()) {
                if (this.txtPass1_User.getText().equals(this.txtPass2_User.getText())) {
                    this.btnGrabar.setEnabled(true);
                    this.textClave2.setVisible(false);
                    this.btnGrabar.grabFocus();
                } else {
                    int preg = MensajeSistema.Pregunta_YES_NO(this, "No coiciden las contraseñas...\nQuiere volver a intentar?...");
                    if (preg == MensajeSistema.YES_OPTION()) {
                        this.txtPass1_User.setText("");
                        this.txtPass2_User.setText("");
                        this.txtPass1_User.setEnabled(true);
                        this.txtPass1_User.grabFocus();
                    } else {
                        this.Inicializar();
                    }
                }
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtPass2_UserActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int valor = this.txtCodigo.verificarVacioConMsj();
        if (valor == 0) {
            if (this.txtCodigo.getOperacion() == 'M' || this.txtCodigo.getOperacion() == 'E') {
                this.RecuperarDatos(this.txtCodigo.getText());
            } else {
                this.txtNom_User.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtPass1_UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1_UserFocusGained
        this.textClave1.setVisible(true);
    }//GEN-LAST:event_txtPass1_UserFocusGained

    private void txtPass2_UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass2_UserFocusGained
        this.textClave2.setVisible(true);
    }//GEN-LAST:event_txtPass2_UserFocusGained

    private void txtCod_PerfilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_PerfilKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(this.txtCod_Perfil.getBdTabla(), true, false, this.txtCod_Perfil.getBdCodigo(),
                    this.txtCod_Perfil.getBdDescrip(), this.txtCod_Perfil.getBdTitulo());
            this.txtCod_Perfil.requestFocus();
        }
    }//GEN-LAST:event_txtCod_PerfilKeyPressed

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JPanel pnlManteUsuario;
    private javax.swing.JLabel textClave1;
    private javax.swing.JLabel textClave2;
    private javax.swing.JLabel textNomPerfil;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCod_Perfil;
    private com.app.paleta.txtCodigo txtCodigo;
    private com.app.paleta.txtTexto txtNom_User;
    private com.app.paleta.txtPassword txtPass1_User;
    private com.app.paleta.txtPassword txtPass2_User;
    // End of variables declaration//GEN-END:variables

    private void Inicializar() {
        ClaseCampos.setEnabled(jPanelDatos, false);
        ClaseCampos.setTextNull(this.jPanelDatos);
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, true);
        this.textClave1.setVisible(false);
        this.textClave2.setVisible(false);
        this.textNomPerfil.setText("");
        this.btnNuevo.setEnabled(Agrega_OK);
        this.btnModificar.setEnabled(Modifica_OK);
        this.btnBorrar.setEnabled(Borra_OK);
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

    private void Editar(char c) {
        this.txtCodigo.setEnabled(true);
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
        this.txtPass1_User.setEnabled(false);
        this.txtPass2_User.setEnabled(false);
        this.txtCodigo.setOperacion(c);
        this.txtCodigo.grabFocus();
    }

    private void Agregar() {
        if (this.txtCodigo.autoNumerico()) {
            ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
            ClaseCampos.setEnabled(jPanelDatos, true);
            this.txtNom_User.setEnabled(true);
            this.txtCodigo.setOperacion('A');
            this.txtNom_User.grabFocus();
        } else {
            Inicializar();
        }
    }

    private void RecuperarDatos(String codigo) {
        String[] rs = this.getConexion.getDescripciones("vst_" + this.txtCodigo.getBdTabla(),
                new String[]{this.txtCodigo.getBdCodigo(), this.txtCodigo.getBdDescrip(), this.txtCod_Perfil.getBdCodigo(), this.txtCod_Perfil.getBdDescrip()},
                new String[]{EMP_CODIGO, this.txtCodigo.getBdCodigo()},
                new String[]{Configuracion.getEMP_CODIGO(), codigo});
        if (rs[0] != null) {
            this.txtNom_User.setText(rs[1]);
            this.txtCod_Perfil.setText(rs[2]);
            this.textNomPerfil.setText(rs[3]);
            if (this.txtCodigo.getOperacion() == 'M') {
                this.txtCodigo.setEnabled(false);
                this.txtNom_User.setEnabled(true);
                this.txtCod_Perfil.setEnabled(true);
                this.txtNom_User.grabFocus();
            } else {
                this.txtCodigo.Borrar();
                this.Inicializar();
            }
        } else {
            if (MensajeSistema.ConsultaSQLVacio(this)) {
                this.txtCodigo.setText("");
                this.txtCodigo.grabFocus();
            } else {
                this.Inicializar();
            }
        }
    }

    private void Grabar() {
        if (this.txtCodigo.getOperacion() == 'A') {
            if (MensajeSistema.Guardar(this)) {
                String sql = "INSERT INTO " + this.txtCodigo.getBdTabla() + " ";
                sql += "(" + EMP_CODIGO + ", " + this.txtCodigo.getBdCodigo() + ", " + this.txtCodigo.getBdDescrip() + ", clave, " + this.txtCod_Perfil.getBdCodigo() + ") ";
                sql += "VALUES ('" + Configuracion.getEMP_CODIGO() + "', '" + this.txtCodigo.getText() + "', '";
                sql += this.txtNom_User.getText() + "', PASSWORD('" + this.txtPass1_User.getText() + "'), '" + this.txtCod_Perfil.getText() + "');";
                this.getConexion.ejecutaUpdate(sql);
            }
        } else {
            if (MensajeSistema.Modificar(this)) {
                String sql = "UPDATE " + this.txtCodigo.getBdTabla();
                sql += " SET " + this.txtCodigo.getBdDescrip() + "='" + this.txtNom_User.getText();
                sql += "', " + this.txtCod_Perfil.getBdCodigo() + "='" + this.txtCod_Perfil.getText() + "'";
                if (this.txtPass1_User.isEmpty()) {
                    sql += " ";
                } else {
                    sql += ", clave=PASSWORD('" + this.txtPass1_User.getText() + "') ";
                }
                sql += "WHERE " + EMP_CODIGO + "=" + Configuracion.getEMP_CODIGO();
                sql += " AND " + this.txtCodigo.getBdCodigo() + "=" + this.txtCodigo.getText() + ";";
                this.getConexion.ejecutaUpdate(sql);
            }
        }
        this.Inicializar();
    }
}
