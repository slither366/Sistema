package com.app.clases.utilidades;

import java.io.File;
import java.io.IOException;
 
import java.io.FileNotFoundException;
import java.io.PrintStream;
 
 
/**
 * Utility class, where we will create methods for training in the use of files,
 * ultimately, Java I / O Basic. 
 * Clase de utilidades, donde crearemos métodos
 * para el aprendizaje del manejo de ficheros, en definitiva, Java I/O Básico.
 *
 * @author xulescode You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class JavaIOUtils {
 
    /**
     * Explanation of the method by which we create a file if it does not exist,
     * returns true if created and false if not created. Explicación del método
     * con el que creamos un fichero si no existe, devolviendo true si se crea y
     * false si no se crea.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     *      boolean result = javaIOUtils.createFile("/home/xules/JavaIO", "myfile.txt");
     *      System.out.println("Result of file creation (Resultado de la creación del fichero): " + result);
     * </pre>
     *
     * @param filePath <code>String</code> ruta donde vamos a crear el fichero.
     * @param fileName <code>String</code> nombre del fichero que queremos crear
     * con la extensión
     * @return <code>boolean</code> true si crea el fichero, false si ya existe
     * o sino se puede crear.
     */
    public boolean createFile(String filePath, String fileName) {
        boolean result;
        File newFile = new File(filePath, fileName);
        if ((result = !newFile.exists())) {
            try {
                result = newFile.createNewFile();
            } catch (IOException ex) {
                result = false;
                System.out.println("File create exception (Excepción al crear el fichero): \n     " + ex);
            }
        }
        return result;
    }
 
 
    /**
     * Explanation of the method by which we read the folder we pass as
     * parameter if exists, returning true in this case and false if not.
     * Explicación del método con el que leemos la carpeta que pasamos como
     * parámetro si existe, devolviendo true si existe y false si no existe.
     * <h3>Example (Ejemplo)</h3>
     * <pre>
     *      JavaIOUtils javaIOUtils = new JavaIOUtils();
     *      javaIOUtils.readFolderFiles("/home/xules/codigoxules");
     * </pre>
     *
     * @param folder <code>String</code> 
     *      path where we are going to read the files. 
     *      Ruta donde vamos a leer los ficheros.
     * @return <code>boolean</code> 
     *      we return true if the directory that we pass for read exists.
     *      Devolvemos true si existe el directorio que se pasa para leer.
     */
    public boolean readFolderFiles(String folder) {
       return readFolderFiles(folder, false, System.out);
    }
    /**
     *
     * @param folder <code>String</code> 
     *      path where we are going to read the files. 
     *      Ruta donde vamos a leer los ficheros.
     * @param onlyFiles
     * @param output
     * @return <code>boolean</code> 
     *      we return true if the directory that we pass for read exists.
     *      Devolvemos true si existe el directorio que se pasa para leer. 
     */
    public boolean readFolderFiles(String folder, boolean onlyFiles, PrintStream output) {
        boolean resultado;
        File folderFile = new File(folder);
        if ((resultado = folderFile.exists())) {
            File[] files = folderFile.listFiles();
            for (File file : files) {
                boolean isFolder = file.isDirectory();
                if ((onlyFiles && !isFolder) || (!onlyFiles)) {
                    output.println((isFolder ? "FOLDER: " : "  FILE: ") + file.getName());
                }
            }
        }
        return resultado;
    }
    /**
     * Main method for the tests for the created method, pruebas de <strong>Java
     * read folder</strong>. Método main para las pruebas para el método creado,
     * pruebas de <strong>Java leer carpeta</strong>.
     *
     * @param args
     */
    public static void main(String args[]) {
        // Second example (Segundo ejemplo)
        JavaIOUtils javaIOUtils = new JavaIOUtils();
        String folder = "C:\\SysGAnalisis";
        PrintStream printStream = System.out;
        javaIOUtils.readFolderFiles(folder, false, printStream);
        // Third example (Tercer ejemplo)
        boolean result = javaIOUtils.createFile(folder, "outPut.txt");
        System.out.println("result: "+result);
        if (result) {
            try {
                printStream = new PrintStream(new File(folder + "/outPut.txt"));
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
            javaIOUtils.readFolderFiles(folder, false, printStream);
        }
        // If all was good, we have to see in the console the new file: outPut.txt
        // Si todo fue bien en la consola tiene que aparecer el nuevo fichero: outPut.txt
        javaIOUtils.readFolderFiles(folder+"\\outPut.txt");
    }
}
