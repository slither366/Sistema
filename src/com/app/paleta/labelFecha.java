package com.app.paleta;

import com.app.clases.ClaseFecha;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class labelFecha extends label implements Runnable {

    public labelFecha() {
        this.setPreferredSize(new Dimension(110, 20));
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
         * @param lbText
         */
        public Hilo(JLabel lbText) {
            this.lbText = lbText;
            this.start();
        }

        @Override
        public void run() {
            while (true) {
                lbText.setText("Fecha: " + ClaseFecha.getFechaActual());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
