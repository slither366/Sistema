package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnBorrar extends BotonMaestro {

    public btnBorrar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/delete.png")));
        this.setText("Borrar");
        this.setToolTipText("Clic para Borrar Registros...");
        this.setMnemonic('B');
    }
}
