package com.app.clases.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Utility class, where we will create methods for training read and write excel
 * files, with <a href="https://poi.apache.org/">Apache POI</a>, we use
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java
 * API To Access Microsoft</a>
 * HSSF is the POI Project's pure Java implementation of the Excel '97(-2007)
 * file.
 *
 * Clase de utilidades, donde crearemos métodos para el aprendizaje de la
 * lectura y escritura de ficheros excel con
 * <a href="https://poi.apache.org/">Apache POI</a>, usaremos
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java
 * API To Access Microsoft</a>
 * HSSF es el proyecto POI de implementación total en Java para ficheros Excel
 * '97(-2007).
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class JavaPoiUtils {

    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, in this example we print the content in the console.
     * Explicación del método con el que leemos el fichero excel que pasamos
     * como parámetro si existe, en este ejemplo mostramos el contenido por la
     * consola.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     * JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
     * javaPoiUtils.readExcelFile(new File("/home/xules/codigoxules/apachepoi/PaisesIdiomasMonedas.xls"));
     * </pre>
     *
     * @param excelFile <code>String</code> excel File we are going to read.
     * Fichero excel que vamos a leer.
     */
    public void LeerExcelFile(File excelFile) {
        InputStream excelStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            // We chose the sheet is passed as parameter. 
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow;
            // Initialize the object to read the value of the cell 
            // Inicializo el objeto que leerá el valor de la celda
            HSSFCell cell;
            // I get the number of rows occupied on the sheet
            // Obtengo el número de filas ocupadas en la hoja
            int rows = hssfSheet.getLastRowNum();
            // I get the number of columns occupied on the sheet
            // Obtengo el número de columnas ocupadas en la hoja
            int cols = 0;
            // A string used to store the reading cell
            // Cadena que usamos para almacenar la lectura de la celda
            String cellValue;
            // For this example we'll loop through the rows getting the data we want
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (int r = 0; r < rows; r++) {
                hssfRow = hssfSheet.getRow(r);
                if (hssfRow == null) {
                    break;
                } else {
                    System.out.print("Row: " + r + " -> ");
                    for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
                        /* 
                         We have those cell types (tenemos estos tipos de celda): 
                         CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                         */
                        cellValue = hssfRow.getCell(c) == null ? ""
                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_STRING) ? hssfRow.getCell(c).getStringCellValue()
                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC) ? "" + hssfRow.getCell(c).getNumericCellValue()
                                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN) ? "" + hssfRow.getCell(c).getBooleanCellValue()
                                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK) ? "BLANK"
                                                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_FORMULA) ? "FORMULA"
                                                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_ERROR) ? "ERROR" : "";
                        System.out.print("[Column " + c + ": " + cellValue + "] ");
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }

    /**
     * Explanation of the method by which we read the excel file we pass as
     * parameter if exists, and where we copy its content in a new excel
     * spreadsheet is also passed as a parameter. Método con el que leemos el
     * fichero excel que pasamos como parámetro si existe y donde copiamos su
     * contenido en una nueva hoja excel que también se pasa como parámetro.
     *
     * @param excelFile <code>String</code> excel File we are going to read.
     * Fichero excel que vamos a leer.
     * @param excelNewFile <code>String</code> excel File we are going to write.
     * Fichero excel en el que vamos a escribir.
     */
    public void EscribirExcelFile(File excelFile, File excelNewFile) {
        InputStream excelStream = null;
        OutputStream excelNewOutputStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            excelNewOutputStream = new FileOutputStream(excelNewFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            HSSFWorkbook hssfWorkbookNew = new HSSFWorkbook();
            // We chose the sheet is passed as parameter. 
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // We create the new sheet we are going to use.
            // Creamos la hoja nueva que vamos a utilizar.
            HSSFSheet hssfSheetNew = hssfWorkbookNew.createSheet("Copy-Copia");
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow;
            HSSFRow hssfRowNew;
            // Initialize the object to read the value of the cell 
            // Inicializo el objeto que leerá el valor de la celda
            HSSFCell cellNew;
            // I get the number of rows occupied on the sheet
            // Obtengo el número de filas ocupadas en la hoja
            int rows = hssfSheet.getLastRowNum();
            String cellValue;

            // Creating title row (creando unas filas con título)
            // ENGLISH TITLE (Titulo en inglés)
            hssfRowNew = hssfSheetNew.createRow(1);
            cellNew = hssfRowNew.createCell(1);
            cellNew.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellNew.setCellValue("THIS IS A COPY");
            // SPANISH TITLE (Título en español)
            hssfRowNew = hssfSheetNew.createRow(3);
            cellNew = hssfRowNew.createCell(1);
            cellNew.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellNew.setCellValue("ESTO ES UNA COPIA");
            // For this example we'll loop through the rows getting all the cells to copy them in the new sheet.
            // Para este ejemplo vamos a recorrer todas las filas para obtener todas las celdas y copiarlas en la nueva hoja.
            for (int r = 0; r < rows; r++) {
                hssfRow = hssfSheet.getRow(r);
                if (hssfRow == null) {
                    break;
                } else {
                    System.out.print("Row: " + r + " -> ");
                    // Creamos la columna en la nueva excel
                    hssfRowNew = hssfSheetNew.createRow(r + 10);
                    for (int c = 0; c < hssfRow.getLastCellNum(); c++) {
                        /* 
                         We have those cell types (tenemos estos tipos de celda): 
                         CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                         */
                        cellValue = hssfRow.getCell(c) == null ? ""
                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_STRING) ? hssfRow.getCell(c).getStringCellValue()
                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC) ? "" + hssfRow.getCell(c).getNumericCellValue()
                                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN) ? "" + hssfRow.getCell(c).getBooleanCellValue()
                                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK) ? "BLANK"
                                                                : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_FORMULA) ? "FORMULA"
                                                                        : (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_ERROR) ? "ERROR" : "";
                        System.out.print("[Column " + c + ": " + cellValue + "] ");
                        cellNew = hssfRowNew.createCell(c);
                        cellNew.setCellType(HSSFCell.CELL_TYPE_STRING);
                        cellNew.setCellValue(cellValue);
                    }
                    System.out.println();
                }
            }
            hssfWorkbookNew.write(excelNewOutputStream);
            excelNewOutputStream.close();
            System.out.println("Your excel file has been generated!(¡Se ha generado tu hoja excel!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }

    /**
     * Main method for the tests for the methods of the class <strong>Java read
     * excel</strong> and <strong>Java create excel</strong>
     * with <a href="https://poi.apache.org/">Apache POI</a>.
     * <br />
     * Método main para las pruebas para los método de la clase, pruebas de
     * <strong>Java leer excel</strong> y  <strong>Java crear excel</strong>
     * con <a href="https://poi.apache.org/">Apache POI</a>.
     *
     * @param args
     */
    public static void main(String[] args) {
        JavaPoiUtils javaPoiUtils = new JavaPoiUtils();
        //javaPoiUtils.LeerExcelFile(new File("C:\\Users\\Diego\\Desktop\\analisis.xls"));
        
        
        File excelFile = new File("C:\\Users\\Diego\\Desktop\\analisis.xls");
        File newExcelFile = new File("C:\\Users\\Diego\\Desktop\\analisis_nuevo.xls");
        if (!newExcelFile.exists()){
            try {
                newExcelFile.createNewFile();
            } catch (IOException ioe) {
                System.out.println("(Error al crear el fichero nuevo)" + ioe);
            }
        }
        javaPoiUtils.EscribirExcelFile(excelFile, newExcelFile);
    }
}
