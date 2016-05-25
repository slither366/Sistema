package com.app.botones;

import com.app.clases.ClaseBotones;
import java.awt.event.ActionListener;

/**
 *
 * @author Diego
 */
public class pnlBuscar extends javax.swing.JPanel {

    public btnBuscarPrimero btnPrimero;
    public btnBuscarAnterior btnAnterior;
    public btnBuscarSiguiente btnSiguiente;
    public btnBuscarUltimo btnUltimo;

    public pnlBuscar() {
        this.setPreferredSize(new java.awt.Dimension(238, 40));
        btnPrimero = new com.app.botones.btnBuscarPrimero();
        btnAnterior = new com.app.botones.btnBuscarAnterior();
        btnSiguiente = new com.app.botones.btnBuscarSiguiente();
        btnUltimo = new com.app.botones.btnBuscarUltimo();
        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
                jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
                jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ClaseBotones.botonesBUSCARKeyPressed(btnPrimero, btnAnterior, btnSiguiente, btnUltimo);
        this.btnPrimero.setActionCommand("btn1");
        this.btnAnterior.setActionCommand("btn2");
        this.btnSiguiente.setActionCommand("btn3");
        this.btnUltimo.setActionCommand("btn4");
    }

    /**
     * Este Metodo es para agregar el ActionListener a los botones
     *
     * @param a
     */
    public void addListener(ActionListener a) {
        this.btnPrimero.addActionListener(a);
        this.btnAnterior.addActionListener(a);
        this.btnSiguiente.addActionListener(a);
        this.btnUltimo.addActionListener(a);
    }

    /**
     * Metodo que Cambia el estado de los botones, setEnabled(true)
     *
     * @param b
     */
    public void ModoEdicion(boolean b) {
        this.btnPrimero.setEnabled(b);
        this.btnAnterior.setEnabled(b);
        this.btnSiguiente.setEnabled(b);
        this.btnUltimo.setEnabled(!b);
    }
}
