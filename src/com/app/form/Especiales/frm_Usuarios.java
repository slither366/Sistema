package com.app.form.Especiales;

import com.app.clases.ClaseBotones;
import com.app.clases.ClaseCampos;
import com.app.config.ConexionBD;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.clases.ClaseEncriptacion;
import com.app.clases.ClaseTeclas;

/**
 *
 * @author Diego
 */
public class frm_Usuarios extends frm_Padre {

    /**
     * @param cod_ventana
     * @param conexion
     */
    public frm_Usuarios(int cod_ventana, ConexionBD conexion) {
        initComponents();
        this.setResizable(false);
        this.setName("frm_usuarios");
        this.getConexion = conexion;
        this.Cod_Ventana = cod_ventana;
        this.textTitulo.setText("Mantenimiento de Usuarios...");
        this.tablaConsutada = "acc_usuarios";
        this.idConsultada = "cod_usuario";
        this.descripcionConsultada = "nom_usuario";
        this.tituloVentanaActual = "Usuarios";
        this.tablaForaneo = "acc_perfiles";
        this.idForaneo = "cod_perfil";
        this.descripcionForaneo = "nom_perfil";
        this.tituloVentanaForaneo = "Perfiles";
        this.getPermisos(this.Cod_Ventana);
        ClaseBotones.botonesABMKeyPressed(btnNuevo, btnModificar, btnBorrar, btnListar, btnGrabar, btnCancelar, btnSalir);
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
        txtAlias_User = new com.app.paleta.txtTexto();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCod_Perfil = new com.app.paleta.txtCodigo();
        textNomPerfil = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPass1_User = new com.app.paleta.txtPassword();
        txtPass2_User = new com.app.paleta.txtPassword();
        jLabel5 = new javax.swing.JLabel();
        textClave1 = new javax.swing.JLabel();
        textClave2 = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        btnNuevo = new com.app.botones.btnNuevo();
        btnModificar = new com.app.botones.btnModificar();
        btnBorrar = new com.app.botones.btnBorrar();
        btnListar = new com.app.botones.btnListar();
        btnImagen = new com.app.botones.btnImagen();
        btnGrabar = new com.app.botones.btnGrabar();
        btnCancelar = new com.app.botones.btnCancelar();
        btnSalir = new com.app.botones.btnSalir();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
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

        txtAlias_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlias_UserActionPerformed(evt);
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

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Alias:");

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
        txtPass1_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPass1_UserKeyTyped(evt);
            }
        });

        txtPass2_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2_UserActionPerformed(evt);
            }
        });
        txtPass2_User.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass2_UserFocusGained(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Repita:");

        textClave1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        textClave1.setText("La Clave tiene que ser, min. 3 y max. 15 caracteres. ");

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
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlias_User, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNom_User, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))))
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
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(textClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAlias_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
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
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlManteUsuarioLayout = new javax.swing.GroupLayout(pnlManteUsuario);
        pnlManteUsuario.setLayout(pnlManteUsuarioLayout);
        pnlManteUsuarioLayout.setHorizontalGroup(
            pnlManteUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManteUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManteUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            this.txtAlias_User.setEnabled(true);
            this.txtAlias_User.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtNom_UserActionPerformed

    private void txtNom_UserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNom_UserKeyTyped
        this.txtNom_User.CantidadLetras(evt, 25);
    }//GEN-LAST:event_txtNom_UserKeyTyped

    private void txtCod_PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_PerfilActionPerformed
        if (this.txtCod_Perfil.verificarVacioSinMsj()) {
            String rs = this.getConexion.getDescripcion(tablaForaneo, descripcionForaneo,
                    new String[]{cod_empresa, idForaneo},
                    new String[]{Configuracion.getCOD_EMPRESA(), this.txtCod_Perfil.getText()});
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

    private void txtAlias_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlias_UserActionPerformed
        int valor = this.txtAlias_User.verificarVacioConMsj();
        if (valor == 0) {
            this.txtCod_Perfil.setEnabled(true);
            this.txtCod_Perfil.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtAlias_UserActionPerformed

    private void txtPass1_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass1_UserActionPerformed
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.Agregar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.Editar('M');
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.Editar('E');
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        this.Listar("vst_" + tablaConsutada, true, false, idConsultada, descripcionConsultada, tituloVentanaActual,
                "/Reportes/listadosUsuarios.jasper",
                new String[]{"cod_usuario", "nom_usuario", "alias", "nom_perfil", "comentario"},
                new String[]{"Codigo", "Nombre", "Alias", "Perfil", "Comentario"}, getConexion);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        this.Grabar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Inicializar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.Salir(this);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        if (txtCodigo.verificarVacioSinMsj()) {
            if (operacion == 'M' || operacion == 'E') {
                this.RecuperarDatos(this.txtCodigo.getText());
            } else {
                this.txtNom_User.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtPass1_UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1_UserFocusGained
        this.textClave1.setVisible(true);
    }//GEN-LAST:event_txtPass1_UserFocusGained

    private void txtPass2_UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass2_UserFocusGained
        this.textClave2.setVisible(true);
    }//GEN-LAST:event_txtPass2_UserFocusGained

    private void txtPass1_UserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1_UserKeyTyped
        ClaseEncriptacion.isCaracterPermitido(evt);
    }//GEN-LAST:event_txtPass1_UserKeyTyped

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, true, false, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCodigo.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCod_PerfilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_PerfilKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaForaneo, true, false, idForaneo, descripcionForaneo, tituloVentanaForaneo);
            this.txtCod_Perfil.requestFocus();
        }
    }//GEN-LAST:event_txtCod_PerfilKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.btnBorrar btnBorrar;
    private com.app.botones.btnCancelar btnCancelar;
    private com.app.botones.btnGrabar btnGrabar;
    private com.app.botones.btnImagen btnImagen;
    private com.app.botones.btnListar btnListar;
    private com.app.botones.btnModificar btnModificar;
    private com.app.botones.btnNuevo btnNuevo;
    private com.app.botones.btnSalir btnSalir;
    private javax.swing.JLabel jLabel10;
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
    private com.app.paleta.txtTexto txtAlias_User;
    private com.app.paleta.txtCodigo txtCod_Perfil;
    private com.app.paleta.txtCodigo txtCodigo;
    private com.app.paleta.txtTexto txtNom_User;
    private com.app.paleta.txtPassword txtPass1_User;
    private com.app.paleta.txtPassword txtPass2_User;
    // End of variables declaration//GEN-END:variables

    private void Inicializar() {
        ClaseCampos.setEnabled(jPanelDatos, false);
        ClaseCampos.SetTextNull(this.jPanelDatos);
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnListar, btnGrabar, btnCancelar, btnSalir, true);
        this.textClave1.setVisible(false);
        this.textClave2.setVisible(false);
        this.textNomPerfil.setText("");
        this.btnNuevo.setEnabled(Agrega_OK);
        this.btnModificar.setEnabled(Modifica_OK);
        this.btnBorrar.setEnabled(Borra_OK);
        this.btnListar.setEnabled(Listar_OK);
        if (this.btnNuevo.isEnabled()) {
            this.btnNuevo.grabFocus();
        } else if (this.btnModificar.isEnabled()) {
            this.btnModificar.grabFocus();
        } else if (this.btnBorrar.isEnabled()) {
            this.btnBorrar.grabFocus();
        } else if (this.btnListar.isEnabled()) {
            this.btnListar.grabFocus();
        } else {
            this.btnSalir.grabFocus();
        }
    }

    private void Editar(char c) {
        this.txtCodigo.setEnabled(true);
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnListar, btnGrabar, btnCancelar, btnSalir, false);
        operacion = c;
        this.txtCodigo.grabFocus();
    }

    private void Agregar() {
        String[] campos = new String[]{cod_empresa};
        String[] valores = new String[]{Configuracion.getCOD_EMPRESA()};
        if (getConexion.autoNumerico(tablaConsutada, idConsultada, campos, valores, this.txtCodigo)) {
            ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnListar, btnGrabar, btnCancelar, btnSalir, false);
            ClaseCampos.setEnabled(jPanelDatos, true);
            this.txtCodigo.setEnabled(false);
            this.btnGrabar.setEnabled(false);
            this.txtNom_User.setEnabled(true);
            operacion = 'A';
            this.txtNom_User.grabFocus();
        } else {
            Inicializar();
        }
    }

    private void RecuperarDatos(String codigo) {
        String[] rs = this.getConexion.getDescripciones("vst_" + tablaConsutada,
                new String[]{idConsultada, descripcionConsultada, "alias", "clave", idForaneo, descripcionForaneo},
                new String[]{cod_empresa, idConsultada},
                new String[]{Configuracion.getCOD_EMPRESA(), codigo});
        if (rs[0] != null) {
            this.txtNom_User.setText(rs[1]);
            this.txtAlias_User.setText(rs[2]);
            this.txtCod_Perfil.setText(rs[4]);
            this.textNomPerfil.setText(rs[5]);

            if (operacion == 'M') {
                ClaseCampos.setEnabled(jPanelDatos, true);
                this.txtCodigo.setEnabled(false);
                this.txtNom_User.grabFocus();
            } else {
                this.Borrar(this, tablaConsutada,
                        new String[]{cod_empresa, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), codigo});
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
        if (operacion == 'A') {
            if (MensajeSistema.Guardar(this)) {
                this.getConexion.insertar(tablaConsutada,
                        new String[]{cod_empresa, idConsultada, descripcionConsultada, "alias", "clave", idForaneo},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCodigo.getText(), this.txtNom_User.getText(),
                            this.txtAlias_User.getText(), "PASSWORD(" + this.txtPass1_User.getText() + ")", this.txtCod_Perfil.getText()});
            }
        } else {
//            if (MensajeSistema.Modificar(this)) {
//                this.getConexion.actualizar(tablaConsutada,
//                        new String[]{descripcionConsultada, "alias", "clave", idForaneo},
//                        new String[]{this.txtNom_User.getText(), this.txtAlias_User.getText(),
//                            this.txtPass1_User.getPass(), this.txtCod_Perfil.getText()},
//                        new String[]{cod_empresa, idConsultada},
//                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCodigo.getText()});
//            }
        }
        this.Inicializar();
    }
}
