package com.app.clases;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author pcsproject
 */
public class ClaseComboBox {

    /**
     * Ubica la posicion del item buscado si encuentra segun la columna que le
     * pasemos para dicha busqueda.
     *
     * @param jComboxTemp
     * @param itemBuscar
     * @param ColumnBuscar
     */
    public static void setComboxPosition(JComboBox jComboxTemp, String itemBuscar, int ColumnBuscar) {
        ColumnBuscar -= 1;
        int passDato = 0; //es el que recorre el vector y captura la posicion
        boolean encontrado = false;
        try {
            for (int x = 0; x < jComboxTemp.getItemCount(); x++) {
                jComboxTemp.setSelectedIndex(x);
                if (String.valueOf((((String[]) jComboxTemp.getSelectedItem())[ColumnBuscar])).equals(itemBuscar.trim())) {
                    encontrado = true;
                    passDato = x;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar, asegurese que esten cargados los combox", "Busquedas", 0);
            return;
        }
        if (encontrado) {
            jComboxTemp.setSelectedIndex(passDato);
        } else {
            JOptionPane.showMessageDialog(null, "El item buscado no fue encontrado, por tanto, vuelve al estandar de " + (((String[]) jComboxTemp.getSelectedItem())[1]), "Items Buscar", 0);
        }
    }

    /**
     * Recibe de un combox los datos como un String, el returnColumn se refiere
     * a que columna segun nuestra consulta debe retornar, ya sea Codigo o
     * Descripcion.
     *
     * @param jcombox
     * @param returnColumn
     * @return
     */
    public static String getComboxString(JComboBox jcombox, int returnColumn) {
        returnColumn -= 1;
        return (((String[]) jcombox.getSelectedItem())[returnColumn]);
    }

    /**
     * Recibe de un combox los datos como un int, el returnColumn se refiere a
     * que columna segun nuestra consulta debe retornar, ya sea Codigo o
     * Descripcion.
     *
     * @param jcombox
     * @param returnColumn
     * @return
     */
    public static int getComboxInt(JComboBox jcombox, int returnColumn) {
        returnColumn -= 1;
        return Integer.parseInt((((String[]) jcombox.getSelectedItem())[returnColumn]));
    }

    /**
     * Permite cargar un combox con la forma de vector una dimension (String[])
     *
     * @param comboBox
     * @param veDatos
     */
    public static void cargarDatos(JComboBox comboBox, String[] veDatos) {
        comboBox.removeAllItems();
        for (String veDato : veDatos) {
            comboBox.addItem(veDato);
        }
    }

    /**
     * Permite posicionar el indice de un combo a partir de la busqueda de un
     * String.
     * <br>Este metodo solamente evalua un combo predeterminado y no de doble
     * dimension</br>
     *
     * @param comboBox
     * @param datoBuscar
     */
    public static void setComboxManual(JComboBox comboBox, String datoBuscar) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().equals(datoBuscar)) {
                comboBox.setSelectedIndex(i);
            }
        }
    }

    /**
     * Recibe los datos de un combo seleccionado. Su nombre se debe porque el
     * combox no fue cargado a traves de una consulta sql
     *
     * @param comboBox
     * @return
     */
    public static String getComboxManual(JComboBox comboBox) {
        return comboBox.getSelectedItem().toString();
    }

}
