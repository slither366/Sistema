package com.app.form.Practicas;

import com.app.config.ConexionBD;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class prueba_clase {

    public prueba_clase() {
    }

    public static void main(String[] args) throws IOException {
        //        PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame("Elegir"), "SCAT", null);
        //        Graphics pagina= pj.getGraphics();
//        new Backup().CrearBackup("localhost", "3306", "root", "secreto", "bd_repuestos",
//                "C:\\Users\\Diego\\Desktop\\bd_repuestos.sql");
        //ConexionBD conexion = new ConexionBD("localhost", "3306", "root", "secreto", "bd_sistemas");

        

        String valor="5235.123";
        System.out.println(valor.indexOf("."));
    }
}
