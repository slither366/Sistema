package com.app.form;

import com.app.form.Especiales.frm_Principal;
import com.app.form.Especiales.frm_Padre;
import com.app.clases.ClaseBotones;
import com.app.clases.ClaseCampos;
import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;

/**
 * @author Diego
 */
public class Productos_Farm extends frm_Padre {

    private final String Tabla1, Tabla2, IdCod1, IdCod2, NomDesc1, NomDesc2, Titulo1, Titulo2;

    public Productos_Farm(String tablaPrin, int cod_ventana, boolean empresa, boolean sucursal,
            String codigo, String tabla1, String idCod1, String nomDesc1, String titulo1,
            String tabla2, String idCod2, String nomDesc2, String titulo2,
            String Observacion, String tituloPrincipal) {
        initComponents();
        this.setResizable(false);
        this.setName(tablaPrin);
        this.tablaConsutada = tablaPrin;
        this.Cod_Ventana = cod_ventana;
        this.UsarEmpresa = empresa;
        this.UsarSucursal = sucursal;
        this.Tabla1 = tabla1;
        this.IdCod1 = idCod1;
        this.NomDesc1 = nomDesc1;
        this.Titulo1 = titulo1;
        this.Tabla2 = tabla2;
        this.IdCod2 = idCod2;
        this.NomDesc2 = nomDesc2;
        this.Titulo2 = titulo2;
        this.idConsultada = codigo;
        this.descripcionConsultada = Observacion;
        this.tituloVentanaActual = tituloPrincipal;
        this.jLabeltitulo1.setText(Titulo1);
        this.jLabeltitulo2.setText(Titulo2);
        ClaseBotones.botonesABMKeyPressed(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir);
        this.textTitulo.setText("Mantenimiento de " + tituloVentanaActual + "...");
        this.getPermisos(this.Cod_Ventana);
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
        pnlDatos = new javax.swing.JPanel();
        jLabeltituloPrincipal = new javax.swing.JLabel();
        jLabeltitulo1 = new javax.swing.JLabel();
        jLabeltitulo2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoPrincipal = new com.app.paleta.txtCodigo();
        txtCodigo1 = new com.app.paleta.txtCodigo();
        txtCodigo2 = new com.app.paleta.txtCodigo();
        txtObservacion = new com.app.paleta.txtTexto();
        textDescripcion1 = new javax.swing.JLabel();
        textDescripcion2 = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        btnNuevo = new com.app.botones.btnNuevo();
        btnModificar = new com.app.botones.btnEditar();
        btnBorrar = new com.app.botones.btnBorrar();
        btnGrabar = new com.app.botones.btnGrabar();
        btnCancelar = new com.app.botones.btnCancelar();
        btnSalir = new com.app.botones.btnSalir();

        pnlDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDatos.setMaximumSize(new java.awt.Dimension(482, 73));
        pnlDatos.setMinimumSize(new java.awt.Dimension(482, 73));
        pnlDatos.setPreferredSize(new java.awt.Dimension(482, 73));

        jLabeltituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeltituloPrincipal.setText("Código:");

        jLabeltitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeltitulo1.setText("Codigo1:");

        jLabeltitulo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeltitulo2.setText("Codigo2:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Observación:");

        txtCodigoPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPrincipalActionPerformed(evt);
            }
        });
        txtCodigoPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPrincipalKeyPressed(evt);
            }
        });

        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });
        txtCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo1KeyPressed(evt);
            }
        });

        txtCodigo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo2ActionPerformed(evt);
            }
        });
        txtCodigo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo2KeyPressed(evt);
            }
        });

        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });

        textDescripcion1.setText("text");

        textDescripcion2.setText("text");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabeltituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabeltitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabeltitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescripcion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescripcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltitulo2)
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCodigoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPrincipalActionPerformed
        if (this.txtCodigoPrincipal.verificarVacioSinMsj()) {
            this.txtCodigoPrincipal.setEnabled(false);
            if (operacion == 'M' || operacion == 'E') {
                this.RecuperarDatos(this.txtCodigoPrincipal.getText());
            } else {
                this.txtCodigo1.setEnabled(true);
                this.txtCodigo1.grabFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoPrincipalActionPerformed

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        if (txtCodigo1.verificarVacioSinMsj()) {
            String consulta;
            if (UsarEmpresa && UsarSucursal) {
                consulta = getConexion.getDescripcion(Tabla1, NomDesc1,
                        new String[]{cod_empresa, cod_sucursal, IdCod1},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCodigo1.getText()});
            } else if (UsarEmpresa) {
                consulta = getConexion.getDescripcion(Tabla1, NomDesc1,
                        new String[]{cod_empresa, IdCod1},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCodigo1.getText()});
            } else {
                consulta = getConexion.getDescripcion(Tabla1, NomDesc1,
                        new String[]{IdCod1}, new String[]{this.txtCodigo1.getText()});
            }
            if (consulta != null) {
                this.textDescripcion1.setText(consulta);
                this.txtCodigo2.setEnabled(true);
                this.txtCodigo2.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCodigo1.setText("");
                    this.jLabeltitulo1.setText("");
                    this.txtCodigo1.grabFocus();
                } else {
                    this.Inicializar();
                }
            }
        }
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void txtCodigo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo2ActionPerformed
        if (txtCodigo2.verificarVacioSinMsj()) {
            String consulta;
            if (UsarEmpresa && UsarSucursal) {
                consulta = getConexion.getDescripcion(Tabla2, NomDesc2,
                        new String[]{cod_empresa, cod_sucursal, IdCod2},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCodigo2.getText()});
            } else if (UsarEmpresa) {
                consulta = getConexion.getDescripcion(Tabla2, NomDesc2,
                        new String[]{cod_empresa, IdCod2},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCodigo2.getText()});
            } else {
                consulta = getConexion.getDescripcion(Tabla2, NomDesc2,
                        new String[]{IdCod2}, new String[]{this.txtCodigo2.getText()});
            }
            if (consulta != null) {
                this.textDescripcion2.setText(consulta);
                this.txtObservacion.setEnabled(true);
                this.txtObservacion.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCodigo2.setText("");
                    this.jLabeltitulo2.setText("");
                    this.txtCodigo2.grabFocus();
                } else {
                    this.Inicializar();
                }
            }
        }
    }//GEN-LAST:event_txtCodigo2ActionPerformed

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        int valor = txtObservacion.verificarVacioConMsj();
        if (valor == 0) {
            this.txtObservacion.setTextMayuscula();
            this.btnGrabar.setEnabled(true);
            this.btnGrabar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void txtCodigoPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPrincipalKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCodigoPrincipal.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoPrincipalKeyPressed

    private void txtCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo1KeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(Tabla1, UsarEmpresa, UsarSucursal, IdCod1, NomDesc1, Titulo1);
            this.txtCodigo1.requestFocus();
        }
    }//GEN-LAST:event_txtCodigo1KeyPressed

    private void txtCodigo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo2KeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(Tabla2, UsarEmpresa, UsarSucursal, IdCod2, NomDesc2, Titulo2);
            this.txtCodigo2.requestFocus();
        }
    }//GEN-LAST:event_txtCodigo2KeyPressed

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabeltitulo1;
    private javax.swing.JLabel jLabeltitulo2;
    private javax.swing.JLabel jLabeltituloPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JLabel textDescripcion1;
    private javax.swing.JLabel textDescripcion2;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCodigo1;
    private com.app.paleta.txtCodigo txtCodigo2;
    private com.app.paleta.txtCodigo txtCodigoPrincipal;
    private com.app.paleta.txtTexto txtObservacion;
    // End of variables declaration//GEN-END:variables

    private void Inicializar() {
        ClaseCampos.setEnabled(pnlDatos, false);
        ClaseCampos.SetTextNull(pnlDatos);
        this.textDescripcion1.setText("");
        this.textDescripcion2.setText("");
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, true);
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

    private void Grabar() {
        String vCod = this.txtCodigoPrincipal.getText();
        String vId1 = this.txtCodigo1.getText();
        String vId2 = this.txtCodigo2.getText();
        String vDes = this.txtObservacion.getText().trim();
        if (operacion == 'A') {
            if (MensajeSistema.Guardar(this)) {
                if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
                    getConexion.insertar(tablaConsutada,
                            new String[]{cod_empresa, cod_sucursal, idConsultada, IdCod1, IdCod2, descripcionConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), vCod, vId1, vId2, vDes});
                } else if (UsarEmpresa) { // Cuando se usar solo Empresa
                    getConexion.insertar(tablaConsutada,
                            new String[]{cod_empresa, idConsultada, IdCod1, IdCod2, descripcionConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), vCod, vId1, vId2, vDes});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.insertar(tablaConsutada,
                            new String[]{idConsultada, IdCod1, IdCod2, descripcionConsultada},
                            new String[]{vCod, vId1, vId2, vDes});
                }
            }
        } else if (operacion == 'M') {
            if (MensajeSistema.Modificar(this)) {
                if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada}, new String[]{vDes},
                            new String[]{cod_empresa, cod_sucursal, idConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), vCod});
                } else if (UsarEmpresa) { // Cuando se usar solo Empresa
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada}, new String[]{vDes},
                            new String[]{cod_empresa, idConsultada},
                            new String[]{Configuracion.getCOD_EMPRESA(), vCod});
                } else { // Cuando no se usar Ni empresa Ni sucursal
                    getConexion.actualizar(tablaConsutada,
                            new String[]{descripcionConsultada}, new String[]{vDes},
                            new String[]{idConsultada}, new String[]{vCod});
                }
            }
        }
        Inicializar();
    }

    private void Agregar() {
        String[] campos, valores;
        if (UsarEmpresa && UsarSucursal) {
            campos = new String[]{cod_empresa, cod_sucursal};
            valores = new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL()};
        } else if (UsarEmpresa) {
            campos = new String[]{cod_empresa};
            valores = new String[]{Configuracion.getCOD_EMPRESA()};
        } else {
            campos = new String[]{null};
            valores = new String[]{null,};
        }
        if (getConexion.autoNumerico(tablaConsutada, idConsultada, campos, valores, this.txtCodigoPrincipal)) {
            ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
            this.btnGrabar.setEnabled(false);
            this.txtCodigo1.setEnabled(true);
            operacion = 'A';
            this.txtCodigo1.grabFocus();
        } else {
            Inicializar();
        }
    }

    private void Editar(char c) {
        this.operacion = c;
        ClaseBotones.modoEdicionABM(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir, false);
        this.btnGrabar.setEnabled(false);
        this.txtCodigoPrincipal.setEnabled(true);
        this.txtCodigoPrincipal.grabFocus();
    }

    private void RecuperarDatos(String codigo) {
        String[] resu;
        if (UsarEmpresa && UsarSucursal) { // Cuando se usar Empresa y Sucursal
            resu = getConexion.getDescripciones("vst_" + tablaConsutada,
                    new String[]{idConsultada, IdCod1, NomDesc1, IdCod2, NomDesc2, descripcionConsultada},
                    new String[]{cod_empresa, cod_sucursal, idConsultada},
                    new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), codigo});
        } else if (UsarEmpresa) { // Cuando se usar solo Empresa
            resu = getConexion.getDescripciones("vst_" + tablaConsutada,
                    new String[]{idConsultada, IdCod1, NomDesc1, IdCod2, NomDesc2, descripcionConsultada},
                    new String[]{cod_empresa, idConsultada},
                    new String[]{Configuracion.getCOD_EMPRESA(), codigo});
        } else { // Cuando no se usar Ni empresa Ni sucursal
            resu = getConexion.getDescripciones("vst_" + tablaConsutada,
                    new String[]{idConsultada, IdCod1, NomDesc1, IdCod2, NomDesc2, descripcionConsultada},
                    new String[]{idConsultada}, new String[]{codigo});
        }
        if (resu[0] != null) {
            this.txtCodigo1.setText(resu[1]);
            this.textDescripcion1.setText(resu[2]);
            this.txtCodigo2.setText(resu[3]);
            this.textDescripcion2.setText(resu[4]);
            this.txtObservacion.setText(resu[5]);
            if (operacion == 'E') {
                Borrar(this, tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, codigo);
                Inicializar();
            } else if (operacion == 'M') {
                this.txtCodigo1.setEnabled(true);
                this.txtCodigo1.grabFocus();
            }
        } else {
            if (MensajeSistema.ConsultaSQLVacio(this)) {
                this.txtCodigoPrincipal.setText("");
                this.txtCodigoPrincipal.setEnabled(true);
                this.txtCodigoPrincipal.grabFocus();
            } else {
                this.Inicializar();
            }
        }
    }

    private void Listar() {
        Productos_Farm_Lst listar = new Productos_Farm_Lst(
                "vst_" + tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada,
                NomDesc1, Titulo1, NomDesc2, Titulo2,
                descripcionConsultada, tituloVentanaActual);
        frm_Principal.llamarFormulario.llamarInternalFrame(listar, frm_Principal.escritorio);
    }
}
