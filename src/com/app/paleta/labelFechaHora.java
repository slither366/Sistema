package com.app.paleta;

import com.app.clases.ClaseFecha;
import com.app.clases.ClaseHora;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Diego
 */
public class labelFechaHora extends javax.swing.JLabel implements Runnable {

    public labelFechaHora() {
        this.setPreferredSize(new Dimension(190, 20));
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
                lbText.setText("Fecha: " + ClaseFecha.getFechaActual() +" Hora: "+ClaseHora.getHoraActualAMPM());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
