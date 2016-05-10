package com.app.paleta;

import com.app.clases.ClaseCampos;

/**
 *
 * @author Diego
 */
public class panel extends javax.swing.JPanel {

    public panel() {
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }

    public void setTextNull() {
        ClaseCampos.setTextNull(this);
    }

    @Override
    public void setEnabled(boolean b) {
        ClaseCampos.setEnabled(this, b);
    }

    @Override
    public void setVisible(boolean b) {
        ClaseCampos.setVisible(this, b);
    }

    public void setAllNullComponents() {
        ClaseCampos.setAllNullComponents(this);
    }
}
