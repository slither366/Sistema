package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnExportar extends BotonMaestro {

    public btnExportar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/excel.png"))); // NOI18N
        this.setText("Exportar");
        this.setToolTipText("Exportar reporte gererado");
        this.setMnemonic('E');
    }
}
