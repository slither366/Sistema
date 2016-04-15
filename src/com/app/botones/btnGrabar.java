package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnGrabar extends BotonMaestro {

    public btnGrabar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/save.png"))); 
        this.setText("Grabar");
        this.setToolTipText("Clic para Grabar Registros...");
        this.setMnemonic('G');
    }
}
