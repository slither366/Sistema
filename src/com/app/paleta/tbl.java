package com.app.paleta;

import com.app.clases.ClaseTable;
import com.app.config.ConexionBD;
import java.sql.ResultSet;

/**
 *
 * @author Diego
 */
public class tbl extends javax.swing.JTable {

    public tbl() {

    }

    public void cargarDatos(ConexionBD con, String sql) {
        ResultSet rs = con.ejecutaQuery(sql);
        ClaseTable.cargarDatos(this, rs);
        this.ordernar();
    }

    public boolean isEmptyJtable() {
        return ClaseTable.isEmptyJtable(this);
    }

    public void setSeleccionarRegistro(int codigo) {
        ClaseTable.setSeleccionarRegistro(this, codigo);
    }

    public void setSeleccionarRegistro(String registro) {
        ClaseTable.setSeleccionarRegistro(this, registro);
    }

    /**
     * Metodo que retorna el Codigo Mínimo de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getMIN(int column) {
        return ClaseTable.getMIN(this, column);
    }

    /**
     * Metodo que retorna el Codigo Maximo de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getMAX(int column) {
        return ClaseTable.getMAX(this, column);
    }

    /**
     * Metodo que retorna el Promedio de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getAVG(int column) {
        return ClaseTable.getAVG(this, column);
    }

    /**
     * Metodo que retorna la Suma de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getSUM(int column) {
        return ClaseTable.getSUM(this, column);
    }

    /**
     * A partir de una columna (dentro de un jtable) lo convierte en un vector
     * de String. Ejemplo: String[]vedat = comJTable.getColumnaToVector(jTable1,
     * 3);
     *
     * @param column
     * @return
     */
    public String[] getColumnaToVector(int column) {
        return ClaseTable.getColumnaToVector(this, column);
    }

    /**
     * Metodo que retorna el valor Entero de la fila seleccionada
     *
     * @return el codigo seleccionado de la primera columna obs: Solo funciona
     * con numeros enteros
     */
    public String getValorSeleccionado() {
        return getValorSeleccionado(0);
    }

    /**
     * Metodo que retorna el valor Entero de la fila seleccionada
     *
     * @param col el numero de la columna en donde se va a buscar el codigo
     * @return el codigo seleccionado de la primera columna obs: Solo funciona
     * con numeros enteros
     */
    public String getValorSeleccionado(int col) {
        return ClaseTable.getValorSeleccionado(this, col);
    }

    /**
     * Vacia la Tabla asignandole un nuevo modelo
     *
     */
    public void vaciar() {
        ClaseTable.vaciarJtable(this);
    }

    public void enTextoValorSeleccionado(txtTexto texto, int columna) {
        ClaseTable.enTextoValorSelect(texto, this, columna);
    }

    public void formatearColumna(int column, int decimal) {
        ClaseTable.formatearColumna(this, column, decimal);
    }

    public void formatearColumna(int[] column, int decimal) {
        for (int i = 0; i < column.length; i++) {
            ClaseTable.formatearColumna(this, column[i], decimal);
        }
    }

    /**
     * Permite alinear a una columna en el lado derecho
     *
     * @param Columna
     */
    public void setAlinearDerecha(int Columna) {
        ClaseTable.setAlinearDerecha(this, Columna);
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearDerecha(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            ClaseTable.setAlinearDerecha(this, Columna[i]);
        }
    }

    /**
     * Permite alinear a una columna en el centro
     *
     * @param Columna
     */
    public void setAlinearCentro(int Columna) {
        ClaseTable.setAlinearCentro(this, Columna);
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearCentro(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            ClaseTable.setAlinearCentro(this, Columna[i]);
        }
    }

    /**
     * Permite alinear a una columna en el lado izquierdo
     *
     * @param Columna
     */
    public void setAlinearIzquierdo(int Columna) {
        ClaseTable.setAlinearIzquierdo(this, Columna);
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearIzquierda(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            ClaseTable.setAlinearIzquierdo(this, i);
        }
    }

    /**
     * Deja a una columna en el modo oculto. Como es un vector, se puede dar
     * como parametro una o mas columnas.
     *
     * @param columna
     */
    public void setOcultar(int[] columna) {
        for (int i = 0; i < columna.length; i++) {
            ClaseTable.setOcultar(this, columna[i]);
        }
    }

    /**
     * Permite colocar a una columna en modo oculto
     *
     * @param columna
     */
    public void setOcultar(int columna) {
        ClaseTable.setOcultar(this, columna);
    }

    /**
     * Coloca a una columna en el modo visible.
     * <p>
     * Su ancho estandar es como minimo 15 y su maximo es 300. El modo normal
     * con que se muestra es de 75 pulgadas.
     *
     * @param columna
     */
    public void setMostrar(int[] columna) {
        for (int i = 0; i < columna.length; i++) {
            ClaseTable.setMostrar(this, columna[i]);
        }
    }

    /**
     * Coloca a un conjunto de columnas un tamaño especificado segun los
     * parametros que le vallemos asignando. Ejemplo:
     * <p>
     * setWidth(tablaLocal, new int[]{1,2,3}, new int[]{100,120,60}); <br>
     * Donde decimos que la columna 1 su tamaño es 100, columna 2 es 120 y
     * columna 3 es 60
     *
     * @param columna
     * @param tamaño
     */
    public void setAncho(int[] columna, int[] tamaño) {
        for (int i = 0; i < columna.length; i++) {
            ClaseTable.setAncho(this, i, i);
        }

    }

    public void setAncho(int columna, int tamaño) {
        ClaseTable.setAncho(this, columna, tamaño);
    }

    /**
     * Se le coloca a todas las columnas con el mismo tamaño dentro de un jTable
     *
     * @param tamaño
     */
    public void setAnchoTodos(int tamaño) {
        ClaseTable.setAnchoTodos(this, tamaño);
    }

    public void ordernar() {
        ClaseTable.ordernar(this);
    }

    public void filtrar(String buscar, int posicion) {
        ClaseTable.filtrar(this, buscar, posicion);
    }

    /**
     * Metodo que imprime el contenido de la tabla directamente en la impresora
     *
     * @param titulo
     */
    public void print(String titulo) {
        ClaseTable.print(this, titulo);
    }
}
