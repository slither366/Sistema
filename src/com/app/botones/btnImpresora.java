package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnImpresora extends BotonMaestro {

    public btnImpresora() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/document-print-5.png"))); // NOI18N
        this.setText("Imprimir");
        this.setToolTipText("Imprimir reporte gererado");
        this.setMnemonic('I');
    }
}
