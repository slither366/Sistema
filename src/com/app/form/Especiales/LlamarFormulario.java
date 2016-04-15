package com.app.form.Especiales;

import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public final class LlamarFormulario {

    private static int MAXIMOCHIX, MAXIMOCHIY, PXactualC, PYactualC, EspacioXC;
    private static int anchoVentana, altoVentana, anchoEscritorio, altoEscritorio;
    private static int alto, ancho;
    private static String[] instancias;
    private final MensajeSistema mensaje = new MensajeSistema();   

    public LlamarFormulario() {
        LlamarFormulario.instancias = new String[Configuracion.getCantidadMaxVAbierta()];
        for (int i = 0; i < instancias.length; i++) {
            instancias[i] = "";
        }
        PXactualC = 0;
        PYactualC = 300;
        EspacioXC = 20;
    }

    public void llamarInternalFrame(JInternalFrame ventana, JDesktopPane escritorio) {
        if (VerificarVentana(ventana)) {// si ya fue abierto la ventana 
            JInternalFrame[] jVentanas = escritorio.getAllFrames();
            for (JInternalFrame jVentana : jVentanas) {
                if (jVentana.getName().equals(ventana.getName())) {
                    this.MostrarVentana(jVentana, 0, 0, 1);
                    break;
                }
            }
        } else {//si todavia no fue abierto
            if (this.verificarCantVentanas()) {
                Configuracion.sumaContador();
                for (int i = 0; i < instancias.length; i++) {
                    if ("".equals(instancias[i])) {
                        instancias[i] = ventana.getName();
                        break;
                    }
                }
                escritorio.add(ventana);//Agrega la ventana al JDesktopPane
                anchoEscritorio = escritorio.getSize().width;//X
                altoEscritorio = escritorio.getSize().height;//Y
                anchoVentana = ventana.getSize().width;//X
                altoVentana = ventana.getSize().height;//Y
                if (altoVentana <= 350) {//Cuando es ventana chica                    
                    MAXIMOCHIY = (altoEscritorio - altoVentana) - 50;
                    MAXIMOCHIX = (anchoEscritorio - anchoVentana) - 100;
                    if (PYactualC < MAXIMOCHIY) {
                        PYactualC = PYactualC + 20;
                        if (PXactualC <= MAXIMOCHIX) {
                            PXactualC = PXactualC + 40;
                        }
                    } else {
                        EspacioXC = EspacioXC + 40;
                        PYactualC = 300;
                        if (EspacioXC > MAXIMOCHIY) {
                            EspacioXC = 20;
                        }
                        PXactualC = EspacioXC;
                    }
                    alto = PYactualC;
                    ancho = PXactualC;
                } else {//Cuando es ventana grande
                    alto = (altoEscritorio - altoVentana) / 2;
                    ancho = (anchoEscritorio - anchoVentana) / 2;
                }
                this.MostrarVentana(ventana, ancho, alto, 0);
            } else {
                ventana.dispose();
            }
        }
    }

    /**
     * Metodo que verifica la cantidad de ventanas abiertas, retorna un true si
     * es que no alcanzo el maximo, sino retorna false
     *
     * @return
     */
    public boolean verificarCantVentanas() {
        if (Configuracion.getContador() < Configuracion.getCantidadMaxVAbierta()) {
            return true;
        } else {
            mensaje.MensajeVarios("Se alcanzo la cantidad maxima permitida de ventanas abiertas\n"
                    + "Cierre alguno de los formularios para seguir trabajando...", mensaje.ERROR_MESSAGE());
        }
        return false;
    }

    private boolean VerificarVentana(JInternalFrame ventana) {
        boolean existe = false;
        for (String instancia1 : instancias) {
            if (ventana.getName().equals(instancia1)) {
                String vVentana = instancia1;
                int vContador = 0;
                for (String instancia : instancias) {
                    if (vVentana.equals(instancia)) {
                        vContador++;
                        if (vContador >= Configuracion.getCantidadVentanaAbierta()) {
                            existe = true;
                            break;
                        }
                    }
                }
            }
        }
        return existe;
    }

    private void MostrarVentana(JInternalFrame ventana, int ancho, int alto, int tipo) {
        if (tipo == 0) {//cuando es primera ves, tipo 2 es cuando ya existe el Frame
            ventana.setLocation(ancho, alto);
        }
        ventana.toFront();
        try {
            ventana.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }

    /**
     * Metodo para cerrar una ventana enviada como parametro
     *
     * @param ventana
     * @return
     */
    public boolean CloseFrame(JInternalFrame ventana) {
        boolean valor = false;
        for (int i = 0; i < instancias.length; i++) {
            if (ventana.getName().equals(instancias[i])) {
                instancias[i] = "";
                ventana.dispose();
                Configuracion.restaContador();
                valor = true;
                break;
            }
        }
        return valor;
    }

    /**
     * Metodo para cerrar todas las ventanas instanciadas
     *
     * @param escritorio
     */
    public void CloseAllFrame(JDesktopPane escritorio) {
        for (int i = 0; i < instancias.length; i++) {
            instancias[i] = "";
        }
        JInternalFrame[] ventanas = escritorio.getAllFrames();
        for (JInternalFrame ventana : ventanas) {
            escritorio.remove(ventana);
        }
        Configuracion.SetContador(0);
    }

    /**
     * Metodo para Cerrar Ventanas que NO fueron abiertos con LLamarMenu, como
     * los reportes
     *
     * @param escritorio
     */
    public void CloseFrameVarios(JDesktopPane escritorio) {
        JInternalFrame[] jVentanas = escritorio.getAllFrames();
        boolean Existe = false;
        for (JInternalFrame jVentana : jVentanas) {
            for (String instancia : instancias) {
                if (instancia.equals(jVentana.getName())) {
                    Existe = true;
                    break;
                } else {
                    Existe = false;
                }
            }
            if (Existe == false) {
                try {
                    jVentana.setClosed(true);
                    Configuracion.restaContador();
                } catch (PropertyVetoException ex) {
                }
            }
        }
    }
}
