package com.app.clases.utilidades;

import com.app.config.Configuracion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class impresora {

    public boolean setImprimirDefault(String cadena) {
        boolean correcto = false;
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        cadena = cadena + "\n\n\n\n";
        byte[] bytes = cadena.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        DocPrintJob pj;
        PrintService[] impresoras = PrintServiceLookup.lookupPrintServices(null, null);
        if (impresoras.length > 0) {
            for (PrintService impresora : impresoras) {
                if (impresora.getName().equals(Configuracion.getIMPRESORA())) {
                    pj = impresora.createPrintJob();
                    try {
                        pj.print(doc, null);
                        correcto = true;
                        break;
                    } catch (PrintException ex) {
                        correcto = false;
                    }
                }
            }
        }
        return correcto;
    }

    /**
     * Metodo que retorna el nombre de todas las impresoras instaldas en la
     * computadora, si no esta instalada ninguna impresora instalada, retorna
     * NULL
     *
     * @return
     */
    public String[] getImpresoras() {
        PrintService[] impresoras = PrintServiceLookup.lookupPrintServices(null, null);
        if (impresoras.length > 0) {
            String[] imp = new String[impresoras.length];
            for (int i = 0; i < impresoras.length; i++) {
                imp[i] = impresoras[i].getName();
            }
            return imp;
        }
        return null;
    }

    //Variables de  acceso   al dispositivo
    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;
    private String dispositivo = "";

    /**
     * Esta funcion inicia el dispositivo donde se va a imprimir
     *
     * @param texto
     */
    public void setDispositivo(String texto) {
        dispositivo = texto;
        if (texto.trim().length() <= 0) {//Si el    dispositivo viene en  blanco el  sistema tratara de definirlo
//            Session misession = new Session() {};
//            dispositivo = misession.impresora_tiquets();
//            if (dispositivo.trim().length() <= 0) {
//                if (misession.isWindows()) {
//                    dispositivo = "LPT1";//Esto si  es windows
//                } else {
//                    dispositivo = "/dev/lp0";//Esto si  es linux
//                }
//            }
        }
        try {
            fw = new FileWriter(dispositivo);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void escribir(String texto) {
        try {
            pw.println(texto);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void cortar() {
        try {
            char[] ESC_CUT_PAPER = new char[]{0x1B, 'm'};
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(ESC_CUT_PAPER);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void avanza_pagina() {
        try {
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(0x0C);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void setRojo() {
        try {
            char[] ESC_CUT_PAPER = new char[]{0x1B, 'r', 1};
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(ESC_CUT_PAPER);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void setNegro() {
        try {
            char[] ESC_CUT_PAPER = new char[]{0x1B, 'r', 0};
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(ESC_CUT_PAPER);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void setTipoCaracterLatino() {
        try {
            char[] ESC_CUT_PAPER = new char[]{0x1B, 'R', 18};
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(ESC_CUT_PAPER);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void setFormato(int formato) {
        try {
            char[] ESC_CUT_PAPER = new char[]{0x1B, '!', (char) formato};
            if (!this.dispositivo.trim().equals("pantalla.txt")) {
                pw.write(ESC_CUT_PAPER);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void correr(int fin) {
        try {
            for (int i = 1; i <= fin; i++) {
                this.salto();
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void salto() {
        try {
            pw.println("");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void dividir() {
        escribir("—————————————-");
    }

    public void cerrarDispositivo() {
        try {
            pw.close();
            if (this.dispositivo.trim().equals("pantalla.txt")) {
                java.io.File archivo = new java.io.File("pantalla.txt");
                java.awt.Desktop.getDesktop().open(archivo);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void main(String args[]) {
        impresora p = new impresora();

        //p.setDispositivo("Microsoft XPS Document Writer");
        PrintService[] impresoras = PrintServiceLookup.lookupPrintServices(null, null);
        p.setDispositivo(impresoras[3].toString());
        p.escribir((char) 27 + "m");
        p.setTipoCaracterLatino();
        p.setRojo();
        p.escribir("Esto es una prueba");
        p.setNegro();
        p.escribir("esto es negro" + (char) 130);
        p.setFormato(24);
        p.escribir("esto es negro con formato");
        p.setFormato(1);
        p.dividir();
        p.escribir("esto es negro con formato");
        p.correr(10);
        p.cortar();
        p.cerrarDispositivo();

    }
}
