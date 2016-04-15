package com.app.form.Practicas;

import com.app.config.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ClaseCombo {

    private String Codigo;
    private String Descripcion;

    public ClaseCombo(String codigo, String descripcion) {
        this.Codigo = codigo;
        this.Descripcion = descripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return Codigo + "-" + Descripcion;
    }

    public static ArrayList ObtenerLista(String tabla, String codigo, String descripcion,
            String condicion, String valor, ConexionBD conexion) {
        ArrayList<ClaseCombo> lista = new ArrayList<>();
        String[][] rs = conexion.getDescripcionesRow(tabla,
                new String[]{codigo, descripcion},
                "".equals(condicion) ? new String[]{} : new String[]{condicion},
                "".equals(valor) ? new String[]{} : new String[]{valor});
        if (!"".equals(rs[0][0])) {
            for (String[] resu : rs) {
                ClaseCombo combo = new ClaseCombo(resu[0], resu[1]);
                lista.add(combo);
            }
        } else {
            lista = null;
        }

        return lista;
    }
}
