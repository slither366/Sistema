package com.app.clases.utilidades;

import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Esta clase contiene metodos para abrir un JFileChooser, se puede especificar
 * donde abrir el cuardro de dialogo, si se puede elegir carpetas, archivos o
 * ambos, por defecto el JFileChooser solo elige archivos, pero se puede
 * especificar pasando uno de estos tres parametros
 * setFileSelectionMode(JFileChooser.FILES_ONLY)
 * setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
 * setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES) tambien se puede
 * especificar donde se abre por defecto el cuadro de dialogo pasando el
 * siguiente parametro setCurrentDirectory(new File("direccion"))
 *
 * @author Diego
 */
public class jFileChooser extends javax.swing.JFileChooser {

    private final FileNameExtensionFilter filtroFotos, filtroSQL, filtroDoc, filtroXLS, filtroTXT;

    public jFileChooser() {
        this.filtroTXT = new FileNameExtensionFilter("Archivos TXT", "txt");
        this.filtroXLS = new FileNameExtensionFilter("Archivos XLS, XLSX", "xls", "xlsx");
        this.filtroDoc = new FileNameExtensionFilter("Archivos DOC, DOCX", "doc", "docx");
        this.filtroSQL = new FileNameExtensionFilter("Archivos SQL", "sql");
        this.filtroFotos = new FileNameExtensionFilter("Archivos JPG, JPEG, BMP, PNG", "jpg", "jpeg", "bmp", "png");
    }

    /**
     * Constructor que recibe un parametro donde se especifica el directorio por
     * defecto
     *
     * @param path
     */
    public jFileChooser(String path) {
        this.filtroTXT = new FileNameExtensionFilter("Archivos TXT", "txt");
        this.filtroXLS = new FileNameExtensionFilter("Archivos XLS, XLSX", "xls", "xlsx");
        this.filtroDoc = new FileNameExtensionFilter("Archivos DOC, DOCX", "doc", "docx");
        this.filtroSQL = new FileNameExtensionFilter("Archivos SQL", "sql");
        this.filtroFotos = new FileNameExtensionFilter("Archivos JPG, JPEG, BMP, PNG", "jpg", "jpeg", "bmp", "png");
        this.setCurrentDirectory(new File(path));
    }

    public String getDirectorioGuardar() {
        this.setApproveButtonText("Guardar");
        this.setDialogTitle(Configuracion.getTITULO_VENTANA() + " - Guardar Archivo");
        int seleccion = this.showSaveDialog(null);
        if (seleccion == this.APPROVE_OPTION) {
            File fileDB = this.getSelectedFile();
            return fileDB.getAbsolutePath();
        } else if (seleccion == this.CANCEL_OPTION) {
            return null;
        } else {
            MensajeSistema.MensajeVarios("Se produjo un error al seleccionar la ruta", MensajeSistema.ERROR_MESSAGE());
            return null;
        }
    }

    public String getDirectorioGuardar(String archivo) {
        this.setApproveButtonText("Guardar");
        this.setDialogTitle(Configuracion.getTITULO_VENTANA() + " - Guardar Archivo");
        this.setSelectedFile(new File(archivo));
        int seleccion = this.showSaveDialog(null);
        if (seleccion == this.APPROVE_OPTION) {
            File fileDB = this.getSelectedFile();
            return fileDB.getPath();
        } else if (seleccion == this.CANCEL_OPTION) {
            return null;
        } else {
            MensajeSistema.MensajeVarios("Se produjo un error al seleccionar la ruta", MensajeSistema.ERROR_MESSAGE());
            return null;
        }
    }

    public String getAbrirArchivo() {
        this.setApproveButtonText("Abrir");
        this.setDialogTitle("Busqueda de Archivos");
        this.addChoosableFileFilter(filtroDoc);
        this.addChoosableFileFilter(filtroXLS);
        this.addChoosableFileFilter(filtroFotos);
        this.addChoosableFileFilter(filtroSQL);
        this.addChoosableFileFilter(filtroTXT);
        int seleccion = this.showOpenDialog(null);
        if (seleccion == this.APPROVE_OPTION) {
            File fileDB = this.getSelectedFile();
            return fileDB.getAbsolutePath();
        } else if (seleccion == this.CANCEL_OPTION) {
            return null;
        } else {
            MensajeSistema.MensajeVarios("Se produjo un error al seleccionar la ruta", MensajeSistema.ERROR_MESSAGE());
            return null;
        }
    }
}
