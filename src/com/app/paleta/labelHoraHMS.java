package com.app.paleta;

import com.app.clases.ClaseHora;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class labelHoraHMS extends javax.swing.JLabel implements Runnable {

    public labelHoraHMS() {
        this.setPreferredSize(new Dimension(50, 20));
        this.setToolTipText("Hora actual del sistema");
        this.setText("Hora");
        new Hilo(this);
    }

    @Override
    public void run() {
    }

    private class Hilo extends Thread {

        private final JLabel lbText;

        /**
         * metodo que arranca el Thread Reloj, recibe un parametro: el jLabel
         * donde va a mostrar la hora en formato HH:MM:SS
         *
         * @param lbHora
         */
        public Hilo(JLabel lbText) {
            this.lbText = lbText;
            this.start();
        }

        @Override
        public void run() {
            while (true) {
                lbText.setText(ClaseHora.getHoraActualHMS());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
