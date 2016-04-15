package com.app.clases.utilidades;

import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author Diego
 */
public class Excel {

    private WritableCellFormat fomato_fila;
    private WritableCellFormat fomato_columna;
    private String ult_export;

    public Excel() {
        ult_export = "";
    }

    /**
     * Metodo que abre
     *
     * @param arc
     */
    public void AbrirExcel(String arc) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + arc);
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error al Abrir del Documento...", ex);
        }
    }

    /**
     * Metodo que abre el ultimo archivo que se haya exportado
     */
    public void AbrirUltimo() {
        AbrirExcel(ult_export);
        ult_export = "";
    }

    public boolean export(DefaultTableModel tabla, String titulo) {
        String dir = new jFileChooser().getDirectorioGuardar(titulo);
        if (dir.endsWith("xlsx")) {
            dir = dir.replaceAll("xlsx", "");
        }
        if (dir.endsWith("xls")) {
            dir = dir.replaceAll("xls", "");
        }
        if (dir.endsWith(".")) {
            dir = dir + "xls";
        } else {
            dir = dir + ".xls";
        }
        return export(tabla, new File(dir), titulo);
    }

    public boolean export(DefaultTableModel tabla, File archi, String titulo) {
        try {
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(archi))) {
                WritableWorkbook w = Workbook.createWorkbook(out);
                w.createSheet(Configuracion.getTITULO_VENTANA() + " . " + titulo, 0);

                WritableSheet s = w.getSheet(0);
                for (int i = 0; i < tabla.getColumnCount(); i++) {
                    for (int j = 0; j < tabla.getRowCount(); j++) {
                        Object objeto = tabla.getValueAt(j, i);
                        createColumna(s, tabla.getColumnName(i), i);//crea la columna
                        createFilas(s, i, j + 1, objeto.toString());//crea las filas
                    }
                }
                this.ult_export = archi.getAbsolutePath();
                w.write();
                w.close();
            } catch (WriteException ex) {
                MensajeSistema.setException("Se produjo un error inesperado al exportar el archivo.", ex);
            }
            return true;
        } catch (IOException ex) {
            MensajeSistema.setIOException("Se produjo un error inesperado al exportar el archivo.", ex);
        }
        return false;
    }

    private void createColumna(WritableSheet sheet, String columna, int number_columna) throws WriteException {
        //creamos el tipo de letra
        WritableFont times10pt = new WritableFont(WritableFont.TAHOMA, 14);
        // definimos el formato d ela celda
        WritableCellFormat times = new WritableCellFormat(times10pt);
        // Permite si se ajusta autom�ticamente a las c�lulas
        //times.setWrap(true);
        // crea una negrita con subrayado
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD, false, UnderlineStyle.SINGLE);
        fomato_columna = new WritableCellFormat(times10ptBoldUnderline);
        // Permite que se ajusta autom�ticamente a las c�lulas
        //fomato_columna.setWrap(true);
        CellView cv = new CellView();
        cv.setSize(220);
        cv.setDimension(70);
        cv.setFormat(times);
        cv.setFormat(fomato_columna);
        //cv.setAutosize(true);
        // escribimos las columnas
        addColumna(sheet, number_columna, 0, columna, fomato_columna);//numero de columna , 0 es la fila
    }

    private void createFilas(WritableSheet sheet, int number_columna, int filas, String name_filas) throws WriteException {
        //creamos el tipo de letra
        WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 12);
        times10pt.setColour(Colour.GOLD);
        // definimos el formato d ela celda
        WritableCellFormat times = new WritableCellFormat(times10pt);
        times.setBorder(Border.TOP, BorderLineStyle.MEDIUM, Colour.GOLD);
        // Permite si se ajusta autom�ticamente a las c�lulas
        //times.setWrap(true);
        // crea una negrita con subrayado
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
        fomato_fila = new WritableCellFormat(times10ptBoldUnderline);
        // Permite que se ajusta autom�ticamente a las c�lulas
        // fomato_fila.setWrap(true);
        CellView cv = new CellView();
        cv.setDimension(70);
        cv.setFormat(times);
        cv.setFormat(fomato_fila);
        //cv.setAutosize(true);
        // escribimos las columnas
        addFilas(sheet, number_columna, filas, name_filas, fomato_fila);
    }

    private void addColumna(WritableSheet sheet, int column, int row, String s, WritableCellFormat format) throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, format);
        sheet.addCell(label);
    }

    private void addFilas(WritableSheet sheet, int column, int row, String s, WritableCellFormat format) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, format);
        sheet.addCell(label);
    }
}
