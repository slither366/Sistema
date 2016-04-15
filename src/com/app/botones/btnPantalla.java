package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnPantalla extends BotonMaestro {

    public btnPantalla() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/document-preview.png"))); // NOI18N
        this.setText("Pantalla");
        this.setToolTipText("Visualizar en pantalla el reporte generado");
        this.setMnemonic('P');
    }
}
