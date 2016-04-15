package com.app.clases;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class ClaseTextoIO {

    /**
     * Metodo que escribe en un archivo de texto nuevo
     *
     * @param directorio
     * @param nombreArchivo
     * @param texto
     * @throws java.io.IOException
     */
    public static void escribirArchivoNuevo(String directorio, String nombreArchivo, 
            String texto) throws IOException {
        try (FileWriter fichero = new FileWriter(directorio +ClaseUtilidades.getSeparator()+ nombreArchivo)) {
            try (PrintWriter pw = new PrintWriter(fichero)) {
                pw.println(texto);
                pw.close();
            }
        }
    }
    
    public static void escribirArchivoNuevo(String file, String texto) throws IOException {
        try (FileWriter fichero = new FileWriter(file)) {
            try (PrintWriter pw = new PrintWriter(fichero)) {
                pw.println(texto);
                pw.close();
            }
        }
    }

    /**
     * Metodo que escribe en un archivo existente
     *
     * @param directorio
     * @param nombreArchivo
     * @param texto
     * @throws java.io.IOException
     */
    public static void escribirArchivo(String directorio, String nombreArchivo, 
            String texto) throws IOException {
        FileWriter fichero = new FileWriter(directorio + nombreArchivo, true);
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println(texto);
            pw.close();
            fichero.close();
        }
    }
    
    public static void escribirArchivo(String file, String texto) throws IOException {
        FileWriter fichero = new FileWriter(file, true);
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println(texto);
            pw.close();
            fichero.close();
        }
    }

    /**
     * Metodo que abre un archivo y devuelve un DefaulTableModel
     *
     * @param file
     * @return
     */
    public static DefaultTableModel abrirArchivo(String file) {
        try {
            FileReader fileR = new FileReader(new File(file));
            try (BufferedReader bufferR = new BufferedReader(fileR)) {
                DefaultTableModel TableModel = new DefaultTableModel();
                TableModel.addColumn("Columna1");
                String datos;
                while ((datos = bufferR.readLine()) != null) {
                    Object[] dato = new Object[1];
                    dato[0] = datos;
                    TableModel.addRow(dato);
                }
                bufferR.close();
                fileR.close();
                return TableModel;
            } catch (Exception e) {
            }
        } catch (FileNotFoundException e) {
        }
        return null;
    }

    /**
     * Metodo que lee un archivo de texto y carga la informacion contenida en un
     * DefaultTableModel que se pasa como parametro
     *
     * @param file
     * @param TableModel
     * @return
     */
    public static boolean abrirArchivo(String file, DefaultTableModel TableModel) {
        try {
            FileReader fileR = new FileReader(new File(file));
            try (BufferedReader bufferR = new BufferedReader(fileR)) {
                String datos;
                boolean existeDatos = false;
                while ((datos = bufferR.readLine()) != null) {
                    TableModel.addRow(datos.split(";"));
                    existeDatos = true;
                }
                bufferR.close();
                fileR.close();
                return existeDatos;
            } catch (Exception e) {
            }
        } catch (FileNotFoundException e) {
        }
        return false;
    }

    public static String[] abrirArchivos(String file) {

        try {
            FileReader fileR = new FileReader(new File(file));
            String datos;
            try (BufferedReader bufferR = new BufferedReader(fileR)) {
                String[] registros = new String[1];
                boolean existeDatos = false;
                while ((datos = bufferR.readLine()) != null) {
                    registros[0] = datos;
                    existeDatos = true;
                }
                bufferR.close();
                fileR.close();
                return existeDatos ? registros : null;
            } catch (Exception e) {
            }
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}
