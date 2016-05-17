package com.app.form.Especiales;

import com.app.clases.ClaseCampos;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Acceso extends frm_Padre {

    private int contador;

    public Acceso() {
        initComponents();
        this.setName("acceso");
        this.txtCod_Usuario.setBdTabla("acc_usuarios");
        this.txtCod_Usuario.setBdCodigo("Usu_Codigo");
        this.txtCod_Usuario.setBdDescrip("Usu_Descrip");
        this.txtCod_Usuario.setBdTitulo("Usuarios");
        this.txtCod_Usuario.setUsarEmpresa(true);
        this.txtCod_Usuario.setUsarSucursal(false);
        this.txtCod_Usuario.setOperacion('x');
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new com.app.paleta.txtPassword();
        txtCod_Usuario = new com.app.paleta.txtCodigo();
        textNom_Usuario = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        btnAceptar = new com.app.botones.btnAceptar();
        btnCancelar = new com.app.botones.btnCancelar();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setMaximumSize(new java.awt.Dimension(378, 60));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitulo.setText("Acceso al Sistema");

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
                .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        textNom_Usuario.setText("jLabel5");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(txtCod_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNom_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNom_Usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Configuracion.setUSU_CODIGO(this.txtCod_Usuario.getText());
        Configuracion.setUSU_NOMBRE(this.textNom_Usuario.getText());
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
            String sql = "select " + txtCod_Usuario.getBdDescrip() + " from " + txtCod_Usuario.getBdTabla()
                    + " where " + EMP_CODIGO + "=" + Configuracion.getEMP_CODIGO()
                    + " and " + txtCod_Usuario.getBdCodigo() + "=" + this.txtCod_Usuario.getText()
                    + " and clave=password('" + this.txtPassword.getText().trim() + "')";
            ArrayList clave = getConexion.consultar(sql);
            if (clave.size() > 0) {
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
                        this.dispose();
                    } else {
                        this.txtPassword.setText("");
                        this.txtPassword.grabFocus();
                    }
                } else {
                    this.dispose();
                }
            }
        } else if (valor == 1) {
            this.inicializar();
        }
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.inicializar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCod_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_UsuarioActionPerformed
        int valor = this.txtCod_Usuario.verificarVacioConMsj();
        if (valor == 0) {
            String[] rs = this.getConexion.getDescripciones("vst_" + txtCod_Usuario.getBdTabla(),
                    new String[]{EMP_CODIGO, txtCod_Usuario.getBdCodigo(), txtCod_Usuario.getBdDescrip(), "Perf_Codigo", "Perf_Descrip"},
                    new String[]{EMP_CODIGO, txtCod_Usuario.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Usuario.getText()});
            if (rs[0] != null) {
                this.textNom_Usuario.setText(rs[2]);
                Configuracion.setPERF_CODIGO(rs[3]);
                Configuracion.setPERF_NOMBRE(rs[4]);
                this.txtPassword.setEnabled(true);
                this.txtPassword.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Usuario.setText("");
                    this.textNom_Usuario.setText("");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JLabel textNom_Usuario;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCod_Usuario;
    private com.app.paleta.txtPassword txtPassword;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        ClaseCampos.setTextNull(jPanelDatos);
        this.btnAceptar.setEnabled(false);
        this.txtPassword.setEnabled(false);
        this.txtCod_Usuario.setEnabled(true);
        this.textNom_Usuario.setText("");
        this.contador = 0;
        this.txtCod_Usuario.grabFocus();
    }
}
