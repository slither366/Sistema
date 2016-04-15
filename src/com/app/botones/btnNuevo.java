package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnNuevo extends BotonMaestro {

    public btnNuevo() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/document-new-6.png")));
        this.setText("Nuevo");
        this.setToolTipText("Agregar nuevos registros...");
        this.setMnemonic('N');
    }   
}
