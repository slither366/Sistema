package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnSalir extends BotonMaestro {

    public btnSalir() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/cerrar.png")));
        this.setText("Salir");
        this.setToolTipText("Clic para Salir de la ventana actual...");
        this.setMnemonic('S');
    }
}
