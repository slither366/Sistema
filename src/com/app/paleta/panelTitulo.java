package com.app.paleta;

import javax.swing.JLabel;

/**
 * Componente JPanel especial para titulo de un formulario.
 *
 * @author Diego
 */
public class panelTitulo extends panel {

    private final JLabel textTitulo;

    public panelTitulo() {
        this.setBackground(new java.awt.Color(204, 204, 204));
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.textTitulo = new javax.swing.JLabel();
        this.textTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        this.textTitulo.setText("TITULO...");
        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
                jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
                jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }

    /**
     * Metodo que agrega el titulo que va mostrara en el jLabel del jPanel
     *
     * @param text
     */
    public void setTextTitulo(String text) {
        this.textTitulo.setText(text);
    }
}
