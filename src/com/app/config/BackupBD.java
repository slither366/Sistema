package com.app.config;


import com.app.clases.utilidades.jFileChooser;
import com.app.clases.ClaseFecha;
import com.app.clases.ClaseUtilidades;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileWriter;

/** 
 * @author Diego
 */
public class BackupBD {

    jFileChooser guardar = new jFileChooser();
    public void GenerarBackupMySQL(){        
        String resp=guardar.getDirectorioGuardar();//JFileChooser de nombre RealizarBackupMySQL
        if (resp!=null) {//Si el usuario presiona aceptar; se genera el Backup
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(resp+ClaseFecha.getFechaActualAMD()+".sql");
                FileWriter fw = new FileWriter(backupFile);
                Process child = runtime.exec("mysqldump --opt --password=secreto --user=root --databases bd_acceso");
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);
                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();
                MensajeSistema.MensajeVarios("Backup generado correctamente... Verifique!", MensajeSistema.INFORMATION_MESSAGE());
            }catch(Exception e){
                MensajeSistema.MensajeVarios("Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), MensajeSistema.INFORMATION_MESSAGE());                
            }            
        } else {
            MensajeSistema.MensajeVarios("Ha sido cancelada la generacion del Backup",MensajeSistema.ERROR_MESSAGE());
        }
    }
        
    public static void main(String[]args){
        BackupBD backupBD = new BackupBD();
        backupBD.GenerarBackupMySQL();
    }
    
//    void ActualizarBackupMySQL(){
//        int resp;
//        resp=RealizarBackupMySQL.showOpenDialog(this);//Mustra el cuadro con la Opcion Guardar
//        if (resp==JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar(Guardar); Backup
//            try{
//                String ubicacion= String.valueOf(RealizarBackupMySQL.getSelectedFile().toString().trim());
//                
//                Process child = Runtime.getRuntime().exec("cmd /c mysql --password=HdMc --user=root --databases bd_ueta_mysql > " + ubicacion);
//             OptionPane.showMessageDialog(null,"BaseActualizada","Verificar",JOptionPane.INFORMATION_MESSAGE);
//                }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Error no se actualizo la DB por el siguiente motivo: " + e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
//                }
//            
//        }else{
//            JOptionPane.showMessageDialog(null,"Ha sido cancelada la actualizacion del Backup");
//        }
//    }
}