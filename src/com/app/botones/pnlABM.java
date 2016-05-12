package com.app.botones;

import com.app.clases.ClaseBotones;
import java.awt.event.ActionListener;

/** 
 * 
 * @author Diego
 */
public class pnlABM extends javax.swing.JPanel {

    public btnNuevo btnNuevo;
    public btnEditar btnModificar;
    public btnBorrar btnBorrar;
    public btnGrabar btnGrabar;
    public btnCancelar btnCancelar;
    public btnSalir btnSalir;
    
    public pnlABM() {
        this.setPreferredSize(new java.awt.Dimension(534, 56));
        btnNuevo = new com.app.botones.btnNuevo();
        btnModificar = new com.app.botones.btnEditar();
        btnBorrar = new com.app.botones.btnBorrar();
        btnGrabar = new com.app.botones.btnGrabar();
        btnCancelar = new com.app.botones.btnCancelar();
        btnSalir = new com.app.botones.btnSalir();
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanelBotonesLayout);
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
        ClaseBotones.botonesABMKeyPressed(btnNuevo, btnModificar, btnBorrar, btnGrabar, btnCancelar, btnSalir);
        this.btnNuevo.setActionCommand("btn1");
        this.btnModificar.setActionCommand("btn2");
        this.btnBorrar.setActionCommand("btn3");
        this.btnGrabar.setActionCommand("btn4");
        this.btnCancelar.setActionCommand("btn5");
        this.btnSalir.setActionCommand("btn6");
    }

    /**
     * Este Metodo es para agregar el ActionListener a los botones
     *
     * @param a
     */
    public void addListener(ActionListener a) {
        this.btnNuevo.addActionListener(a);
        this.btnModificar.addActionListener(a);
        this.btnBorrar.addActionListener(a);
        this.btnGrabar.addActionListener(a);
        this.btnCancelar.addActionListener(a);
        this.btnSalir.addActionListener(a);
    }

    /**
     * Metodo que Cambia el estado de los botones, setEnabled(true)
     *
     * @param b
     */
    public void ModoEdicion(boolean b) {
        this.btnNuevo.setEnabled(b);
        this.btnModificar.setEnabled(b);
        this.btnBorrar.setEnabled(b);
        this.btnGrabar.setEnabled(!b);
        this.btnCancelar.setEnabled(!b);
        this.btnSalir.setEnabled(b);
    }
    public void btnNuevoSetFocus(){
        this.btnNuevo.grabFocus();
    }
}
