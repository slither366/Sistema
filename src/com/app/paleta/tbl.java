package com.app.paleta;

import com.app.clases.ClaseNumeros;
import com.app.clases.ClaseTableModel;
import com.app.config.ConexionBD;
import com.app.config.MensajeSistema;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class tbl extends javax.swing.JTable {

    public tbl() {

    }

    public void cargarDatos(ConexionBD con, String sql) {
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        modelo.setRowCount(0);
        try {
            ResultSet rs = con.ejecutaQuery(sql);
            ResultSetMetaData metaDatos = rs.getMetaData();
            if (rs.next()) {
                do {
                    Object[] datos = new Object[metaDatos.getColumnCount()];
                    for (int i = 0; i < modelo.getColumnCount(); i++) {
                        try {
                            datos[i] = rs.getString(i + 1);
                        } catch (Exception ex) {
                        }
                    }
                    modelo.addRow(datos);
                } while (rs.next());
                this.setModel(modelo);
                this.ordernar();
            }
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
    }

    public void setSeleccionarRegistro(int codigo) {
        int valorCelda;
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            try {
                valorCelda = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
                if (valorCelda == codigo) {
                    this.getSelectionModel().setSelectionInterval(fila, fila);
                    break;
                }
            } catch (NumberFormatException ex) {
            }
        }
    }

    public void setSeleccionarRegistro(String registro) {
        String valorCelda;
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            try {
                valorCelda = modelo.getValueAt(fila, 0).toString();
                if (valorCelda.equals(registro)) {
                    this.getSelectionModel().setSelectionInterval(fila, fila);
                    break;
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Metodo que retorna el Codigo Mínimo de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getMIN(int column) {
        double valor = getMAX(column);
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                double columna = Double.parseDouble(modelo.getValueAt(i, column).toString().replaceAll(",", ""));
                if (valor > columna) {
                    valor = columna;
                }
            } catch (Exception ex) {
            }
        }
        return valor;
    }

    /**
     * Metodo que retorna el Codigo Maximo de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getMAX(int column) {
        double valor = 0;
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                double columna = Double.parseDouble(modelo.getValueAt(i, column).toString().replaceAll(",", ""));
                if (valor < columna) {
                    valor = columna;
                }
            } catch (Exception ex) {
            }
        }
        return valor;
    }

    /**
     * Metodo que retorna el Promedio de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getAVG(int column) {
        double valor = 0;
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                valor += Double.parseDouble(modelo.getValueAt(i, column).toString().replaceAll(",", ""));
            } catch (Exception ex) {
            }
        }
        return valor / this.getRowCount();
    }

    /**
     * Metodo que retorna la Suma de una columna
     *
     * @param column Es el Numero de la columna que se va usar para hacer el
     * calculo
     * @return
     */
    public double getSUM(int column) {
        int valor = 0;
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                valor += Double.parseDouble(modelo.getValueAt(i, column).toString().replaceAll(",", ""));
            } catch (Exception ex) {
            }
        }
        return valor;
    }

    /**
     * Metodo que retorna el valor Entero de la fila seleccionada
     *
     * @return el codigo seleccionado de la primera columna obs: Solo funciona
     * con numeros enteros
     */
    public String getSeleccion() {
        return getSeleccion(0);
    }

    /**
     * Metodo que retorna el valor Entero de la fila seleccionada
     *
     * @param col el numero de la columna en donde se va a buscar el codigo
     * @return el codigo seleccionado de la primera columna obs: Solo funciona
     * con numeros enteros
     */
    public String getSeleccion(int col) {
        int fila = this.getSelectedRow(); // devuelve el numero de fila del registro seleccionado         
        if (fila == -1) {
            return "";
        } else { // devuelve el valor de la fila seleccionada
            try {
                return this.getValueAt(fila, col).toString();
            } catch (Exception ex) {
                return "";
            }
        }
    }

    /**
     * Vacia la Tabla asignandole un nuevo modelo
     *
     */
    public void vaciar() {
        DefaultTableModel m = (DefaultTableModel) this.getModel();
        m.setRowCount(0);
        this.setModel(m);
    }

    /**
     *
     * @param column
     * @param decimal
     */
    public void formatearColumna(int column, int decimal) {
        DefaultTableModel modelo = (DefaultTableModel) this.getModel();
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            try {
                String xnum = modelo.getValueAt(fila, column).toString();
                String valor = ClaseNumeros.formatoMiles(xnum, decimal);
                modelo.setValueAt(valor, fila, column);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void formatearColumna(int[] column, int decimal) {
        for (int i = 0; i < column.length; i++) {
            formatearColumna(column[i], decimal);
        }
    }

    /**
     * Permite alinear a una columna en el lado derecho
     *
     * @param Columna
     */
    public void setAlinearDerecha(int Columna) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            this.getColumnModel().getColumn(Columna).setCellRenderer(tcr);
            this.repaint();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * Permite alinear a una columna en el centro
     *
     * @param Columna
     */
    public void setAlinearCentro(int Columna) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        this.getColumnModel().getColumn(Columna).setCellRenderer(tcr);
        this.repaint();
    }

    /**
     * Permite alinear a una columna en el lado izquierdo
     *
     * @param Columna
     */
    public void setAlinearIzquierdo(int Columna) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        this.getColumnModel().getColumn(Columna).setCellRenderer(tcr);
        this.repaint();
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearDerecha(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            setAlinearDerecha(Columna[i]);
        }
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearCentro(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            setAlinearCentro(Columna[i]);
        }
    }

    /**
     * Recibe un conjunto de columnas para realizar en grupo las alineaciones
     *
     * @param Columna
     */
    public void setAlinearIzquierda(int[] Columna) {
        for (int i = 0; i < Columna.length; i++) {
            setAlinearIzquierdo(Columna[i]);
        }
    }

    /**
     * Deja a una columna en el modo oculto. Como es un vector, se puede dar
     * como parametro una o mas columnas.
     *
     * @param columna
     */
    public void setOcultar(int[] columna) {
        try {
            for (int i = 0; i < columna.length; i++) {
                this.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
                this.getColumnModel().getColumn(columna[i]).setMinWidth(0);
                this.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
                this.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Permite colocar a una columna en modo oculto
     *
     * @param columna
     */
    public void setOcultar(int columna) {
        try {
            this.getColumnModel().getColumn(columna).setMaxWidth(0);
            this.getColumnModel().getColumn(columna).setMinWidth(0);
            this.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
            this.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
        } catch (Exception e) {
        }
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
            this.getColumnModel().getColumn(columna[i]).setMaxWidth(450);
            this.getColumnModel().getColumn(columna[i]).setMinWidth(15);
            this.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(450);
            this.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(15);
            this.getColumnModel().getColumn(columna[i]).setPreferredWidth(75); //en vez de la utilizacion del setWidth que tiene otra funcion para su uso
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
        if (columna.length != tamaño.length) {
            return;
        }
        for (int i = 0; i < columna.length; i++) {
            this.setAncho(columna[i], tamaño[i]);
        }
    }

    public void setAncho(int columna, int tamaño) {
        this.getColumnModel().getColumn(columna).setPreferredWidth(tamaño); //en vez de la utilizacion del setWidth que tiene otra funcion para su uso        
    }

    /**
     * Se le coloca a todas las columnas con el mismo tamaño dentro de un jTable
     *
     * @param tamaño
     */
    public void setAnchoTodos(int tamaño) {
        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setPreferredWidth(tamaño); //en vez de la utilizacion del setWidth que tiene otra funcion para su uso
        }
    }

    public void ordernar() {
        ClaseTableModel.ordernar(this);
//        TableModel dtm = (TableModel) this.getModel();
//        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(dtm);
//        this.setRowSorter(rowSorter);
    }

    public void filtrar(String buscar, int posicion) {
        ClaseTableModel.filtrar(this, buscar, posicion);
    }

    /**
     * Metodo que imprime el contenido de la tabla directamente en la impresora
     *
     * @param titulo
     */
    public void print(String titulo) {
        try {            
            // tabla1.print();//envia los datos de la tabla a la impresora
            MessageFormat headerFormat = new MessageFormat(titulo);
            MessageFormat footerFormat = new MessageFormat("- Página {0} -");
            this.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            MensajeSistema.setException("No se ha podido imprimir correctamente, intentalo más tarde.", ex);
        }
    }
}
