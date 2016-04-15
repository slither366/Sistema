package com.app.config;

import com.app.clases.ClaseUtilidades;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

/**
 *
 * @author diego
 */
public class Decoracion {

    private static String skin;
    private static int tipo = 1;

    public static void setLookAndFeel(int tipo, String skin) {
        Decoracion.tipo = tipo;
        Decoracion.skin = skin;
    }

    public static void getLookAndFeel() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        if (tipo == 1) {
            String s = ClaseUtilidades.getSistemaOperativo().toUpperCase();
            s = s.substring(0, 3);
            switch (s) {
                case "LIN":
                    Decoracion.skin = "javax.swing.plaf.metal.MetalLookAndFeel";
                    break;
                case "WIN":
                    Decoracion.skin = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                    break;
                case "MAC":
                    Decoracion.skin = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
                    break;
                default:
                    Decoracion.skin = "UIManager.getSystemLookAndFeelClassName()";
                    break;
            }
            try {
                UIManager.setLookAndFeel(Decoracion.skin);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.out.println("Error en LookAndFeel");                
            }
        } else {
            //SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin." + Decoracion.skin);
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");
//            SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceSunGlareTheme");
//            SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark("Resourses/logoZulia.jpg"));
            SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.20));
        }
    }
}
