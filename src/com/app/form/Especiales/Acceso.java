package com.app.form.Especiales;

import com.app.clases.ClaseCampos;
import com.app.config.ConexionBD;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.config.Propiedades;

/**
 *
 * @author Diego
 */
public class Acceso extends frm_Padre {

    private int contador;
    private final String Emp_Codigo_Valor = "1";

    public Acceso(ConexionBD conexion, Propiedades pro) {
        initComponents();
        this.setName("acceso");
        frm_Padre.getConexion = conexion;
        this.getPropiedades = pro;
        this.setLocation((frm_Principal.escritorio.getSize().width - this.getSize().width) / 2,
                (frm_Principal.escritorio.getSize().height - this.getSize().height) / 2);

        this.txtCod_Sucursal.setBdTabla("Adm_Sucursales");
        this.txtCod_Sucursal.setBdCodigo("Suc_Codigo");
        this.txtCod_Sucursal.setBdDescrip("denominacion");
        this.txtCod_Sucursal.setBdTitulo("Sucursales");
        this.txtCod_Sucursal.setUsarEmpresa(true);
        this.txtCod_Sucursal.setUsarSucursal(false);
        this.txtCod_Sucursal.setBuscar(true);

        this.txtCod_Usuario.setBdTabla("Acc_Usuarios");
        this.txtCod_Usuario.setBdCodigo("Usu_Codigo");
        this.txtCod_Usuario.setBdDescrip("Usu_Nombre");
        this.txtCod_Usuario.setBdTitulo("Usuarios");
        this.txtCod_Usuario.setUsarEmpresa(true);
        this.txtCod_Usuario.setUsarSucursal(false);
        this.txtCod_Usuario.setBuscar(true);

        this.txtNomSucursal.setEditable(false);
        this.txtNomUsuario.setEditable(false);
        this.txtNomSucursal.setTextMayuscula();
        this.txtNomUsuario.setTextMayuscula();
        this.inicializar();
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
        jLabel4 = new javax.swing.JLabel();
        txtCod_Sucursal = new com.app.paleta.txtCodigo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new com.app.paleta.txtPassword();
        txtCod_Usuario = new com.app.paleta.txtCodigo();
        txtNomSucursal = new com.app.paleta.txtTexto();
        txtNomUsuario = new com.app.paleta.txtTexto();
        jPanelBotones = new javax.swing.JPanel();
        btnAceptar = new com.app.botones.btnAceptar();
        btnCancelar = new com.app.botones.btnCancelar();

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setMaximumSize(new java.awt.Dimension(422, 60));
        jPanelTitulo.setMinimumSize(new java.awt.Dimension(422, 60));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(422, 60));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitulo.setText("Acceso al Sistema");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Sucursal:");

        txtCod_Sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_SucursalActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Contraseña:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtCod_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_UsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(txtCod_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(txtCod_Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAceptar.setText("Ingresar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String rs = getConexion.getDescripcion("adm_empresas", "Emp_Descrip",
                new String[]{EMP_CODIGO}, new String[]{Emp_Codigo_Valor});
        Configuracion.setEMP_CODIGO(Emp_Codigo_Valor);
        Configuracion.setEMP_NOMBRE(rs);
        Configuracion.setSUC_CODIGO(this.txtCod_Sucursal.getText());
        Configuracion.setSUC_NOMBRE(this.txtNomSucursal.getText());
        Configuracion.setUSU_CODIGO(this.txtCod_Usuario.getText());
        Configuracion.setUSU_NOMBRE(this.txtNomUsuario.getText());
        Configuracion.setIMPRESORA(getPropiedades.getImpresora());
        Configuracion.cargarPermisos(getConexion);
        frm_Principal.MenuBar.setVisible(true);
        frm_Principal.habilitarMenus();
        frm_Principal.ubicarBotones();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        int valor = this.txtPassword.verificarVacioConMsj();
        if (valor == 0) {
            boolean vUser = getConexion.ValidarUsuario(Configuracion.getEMP_CODIGO(), this.txtCod_Usuario.getText(), this.txtPassword.getText());
            if (vUser) {
                contador = 0;
                this.txtCod_Usuario.setEnabled(false);
                this.txtPassword.setEnabled(false);
                this.btnAceptar.setEnabled(true);
                this.btnAceptar.grabFocus();
            } else {
                contador += 1;
                int preg = MensajeSistema.Pregunta_YES_NO(this, "La contraseña no es válida para el usuario indicado...\n"
                        + "Desea volver a intentar?...\n\n"
                        + "Intento " + contador + " de 3...");
                if (preg == MensajeSistema.YES_OPTION()) {
                    if (contador == 3) {
                        MensajeSistema.MensajeVarios(this, "Expulsado!!!", MensajeSistema.INFORMATION_MESSAGE());
                        System.exit(0);
                    } else {
                        this.txtPassword.setText("");
                        this.txtPassword.grabFocus();
                    }
                } else {
                    System.exit(0);
                }
            }
        } else if (valor == 1) {
            this.inicializar();
        }
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtCod_SucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_SucursalActionPerformed
        int valor = this.txtCod_Sucursal.verificarVacioConMsj();
        if (valor == 0) {
            String[] rs = this.getConexion.getDescripciones(txtCod_Sucursal.getBdTabla(),
                    new String[]{txtCod_Sucursal.getBdCodigo(), txtCod_Sucursal.getBdDescrip()},
                    new String[]{EMP_CODIGO},
                    new String[]{Emp_Codigo_Valor});
            if (rs[0] != null) {
                this.txtNomSucursal.setText(rs[1]);
                this.txtCod_Usuario.setEnabled(true);
                this.txtCod_Sucursal.setEnabled(false);
                this.txtCod_Usuario.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtNomSucursal.setText("");
                    this.txtCod_Sucursal.setText("");
                    this.txtCod_Sucursal.grabFocus();
                } else {
                    this.btnCancelar.doClick();
                }
            }
        } else if (valor == 1) {
            this.inicializar();
        }
    }//GEN-LAST:event_txtCod_SucursalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (MensajeSistema.Cancelar(this)) {
            this.inicializar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCod_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_UsuarioActionPerformed
        int valor = this.txtCod_Usuario.verificarVacioConMsj();
        if (valor == 0) {
            String[] rs = this.getConexion.getDescripciones("vst_" + txtCod_Usuario.getBdTabla(),
                    new String[]{EMP_CODIGO, txtCod_Usuario.getBdCodigo(), txtCod_Usuario.getBdDescrip(), "Perf_Codigo", "Perf_Descrip"},
                    new String[]{EMP_CODIGO, txtCod_Usuario.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Usuario.getText()});
            if (rs[0] != null) {
                this.txtNomUsuario.setText(rs[2]);
                Configuracion.setPERF_CODIGO(rs[3]);
                Configuracion.setPERF_NOMBRE(rs[4]);
                this.txtPassword.setEnabled(true);
                this.txtPassword.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Usuario.setText("");
                    this.txtNomUsuario.setText("");
                    this.txtCod_Usuario.grabFocus();
                } else {
                    this.btnCancelar.doClick();
                }
            }
        } else if (valor == 1) {
            this.inicializar();
        }
    }//GEN-LAST:event_txtCod_UsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.btnAceptar btnAceptar;
    private com.app.botones.btnCancelar btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCod_Sucursal;
    private com.app.paleta.txtCodigo txtCod_Usuario;
    private com.app.paleta.txtTexto txtNomSucursal;
    private com.app.paleta.txtTexto txtNomUsuario;
    private com.app.paleta.txtPassword txtPassword;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        ClaseCampos.setTextNull(jPanelDatos);
        ClaseCampos.setEnabled(jPanelDatos, false);
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
        this.contador = 0;
        this.txtNomSucursal.setText("");
        this.txtNomUsuario.setText("");
        this.txtCod_Sucursal.setEnabled(true);
        this.txtCod_Sucursal.grabFocus();
    }
}
