/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.clases.utilidades;

import com.lowagie.text.Anchor;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Diego
 */
public class utilJTableToPdf {

    private static final com.lowagie.text.Font categoryFont = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 18, com.lowagie.text.Font.BOLD);
    private static final com.lowagie.text.Font subCategoryFont = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 16, com.lowagie.text.Font.BOLD);

    /**
     * Explanation of the method by which we read the JTable we pass as
     * parameter, and where we copy its content in a PDF passed as a parameter.
     * Método con el que leemos cualquier JTable que pasamos como parámetro, y
     * donde copiamos su contenido en un PDF que se pasa como parámetro.
     *
     * @param jTable <code>JTable</code> the JTable we are going to extract to
     * excel El Jtable que vamos a extraer a excel.
     * @param pdfNewFile <code>String</code> pdf File we are going to write.
     * Fichero pdf en el que vamos a escribir.
     * @param title <code>String</code> title Título
     */
    public void utilJTableToPdf(JTable jTable, File pdfNewFile, String title) {
        try {
            // We create the document and set the file name.        
            // Creamos el documento e indicamos el nombre del fichero.
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF (No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Código Xules");
            document.addCreator("Código Xules");

            // First page (Primera página)
            Anchor anchor = new Anchor("Table export to PDF (Exportamos la tabla a PDF)", categoryFont);
            anchor.setName("Table export to PDF (Exportamos la tabla a PDF)");

            // Second parameter is the number of the chapter (El segundo parámetro es el número del capítulo).
            Chapter catPart = new Chapter(new Paragraph(anchor), 1);

            Paragraph subPara = new Paragraph("Do it by Xules (Realizado por Xules)", subCategoryFont);
            Section subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("This is a simple example (Este es un ejemplo sencillo)"));

            // Create the table (Creamos la tabla)
            PdfPTable table = new PdfPTable(jTable.getColumnCount());

            // Now we fill the rows of the PdfPTable (Ahora llenamos las filas de PdfPTable)
            PdfPCell columnHeader;
            // Fill table columns header 
            // Rellenamos las cabeceras de las columnas de la tabla.                
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                columnHeader = new PdfPCell(new Phrase(jTable.getColumnName(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int column = 0; column < jTable.getColumnCount(); column++) {
                    table.addCell(jTable.getValueAt(row, column).toString());
                }
            }
            subCatPart.add(table);

            document.add(catPart);

            document.close();
            JOptionPane.showMessageDialog(null, "Your PDF file has been generated!(¡Se ha generado tu hoja PDF!)",
                    "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
            JOptionPane.showMessageDialog(null, "The file not exists (Se ha producido un error al generar un documento): " + documentException,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
