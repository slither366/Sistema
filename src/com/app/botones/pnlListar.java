package com.app.botones;

import com.app.clases.ClaseBotones;
import java.awt.event.ActionListener;

/**
 * Esta Clase extiende de un JPanel, que sirve como botones de Listado Ya esta
 * preparado para funcionar con todo lo que tiene que tener un boton
 *
 * @author Diego
 */
public class pnlListar extends javax.swing.JPanel {

    public btnCancelar btnCancelar;
    public btnExportar btnExportar;
    public btnImpresora btnImpresora;
    public btnNuevo btnNuevo;
    public btnPantalla btnPantalla;
    public btnSalir btnSalir;

    public pnlListar() {
        this.setPreferredSize(new java.awt.Dimension(534, 56));
        btnNuevo = new com.app.botones.btnNuevo();
        btnPantalla = new com.app.botones.btnPantalla();
        btnImpresora = new com.app.botones.btnImpresora();
        btnExportar = new com.app.botones.btnExportar();
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
                        .addComponent(btnPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(btnPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ClaseBotones.botonesReporte(btnNuevo, btnPantalla, btnImpresora, btnExportar, btnCancelar, btnSalir);
        this.btnNuevo.setActionCommand("btn1");
        this.btnPantalla.setActionCommand("btn2");
        this.btnImpresora.setActionCommand("btn3");
        this.btnExportar.setActionCommand("btn4");
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
        this.btnPantalla.addActionListener(a);
        this.btnImpresora.addActionListener(a);
        this.btnExportar.addActionListener(a);
        this.btnCancelar.addActionListener(a);
        this.btnSalir.addActionListener(a);
    }

    /**
     * Metodo que Cambia el estado de los botones, setEnabled(true)
     *
     * @param b
     */
    public void ModoEdicion(boolean b) {
        this.btnNuevo.setEnabled(!b);
        this.btnPantalla.setEnabled(b);
        this.btnImpresora.setEnabled(b);
        this.btnExportar.setEnabled(b);
        this.btnCancelar.setEnabled(b);
        this.btnSalir.setEnabled(!b);
    }
}
