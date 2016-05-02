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

    public btnCancelar btnReporCancelar;
    public btnExportar btnReporExportar;
    public btnImpresora btnReporImpresora;
    public btnNuevo btnReporNuevo;
    public btnPantalla btnReporPantalla;
    public btnSalir btnReporSalir;

    public pnlListar() {
        this.setPreferredSize(new java.awt.Dimension(534, 56));
        btnReporNuevo = new com.app.botones.btnNuevo();
        btnReporPantalla = new com.app.botones.btnPantalla();
        btnReporImpresora = new com.app.botones.btnImpresora();
        btnReporExportar = new com.app.botones.btnExportar();
        btnReporCancelar = new com.app.botones.btnCancelar();
        btnReporSalir = new com.app.botones.btnSalir();
        this.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
                jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
                jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.btnReporNuevo.setActionCommand("btn1");
        this.btnReporPantalla.setActionCommand("btn2");
        this.btnReporImpresora.setActionCommand("btn3");
        this.btnReporExportar.setActionCommand("btn4");
        this.btnReporCancelar.setActionCommand("btn5");
        this.btnReporSalir.setActionCommand("btn6");
    }

    /**
     * Este Metodo es para agregar el ActionListener a los botones
     *
     * @param a
     */
    public void addListener(ActionListener a) {
        this.btnReporNuevo.addActionListener(a);
        this.btnReporPantalla.addActionListener(a);
        this.btnReporImpresora.addActionListener(a);
        this.btnReporExportar.addActionListener(a);
        this.btnReporCancelar.addActionListener(a);
        this.btnReporSalir.addActionListener(a);
    }

    /**
     * Metodo que Cambia el estado de los botones, setEnabled(true)
     *
     * @param b
     */
    public void ModoEdicion(boolean b) {
        this.btnReporNuevo.setEnabled(!b);
        this.btnReporPantalla.setEnabled(b);
        this.btnReporImpresora.setEnabled(b);
        this.btnReporExportar.setEnabled(b);
        this.btnReporCancelar.setEnabled(b);
        this.btnReporSalir.setEnabled(!b);
    }
}
