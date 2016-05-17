package com.app.config;

import com.app.form.Especiales.frm_Padre;
import com.app.paleta.txtCodigo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class ConexionBD {

    private String SQL;
    private PreparedStatement ejecutar;
    private static Connection ConnectionDB;

    /**
     * Esta clase ConexionBD cuenta con todo lo necesario para conectar con una
     * Base de Datos y con las opciones del Lenguaje SQL (DML - Lenguaje de
     * Manipulacion de Datos)
     *
     * @param host
     * @param port
     * @param user
     * @param pass
     * @param bd
     */
    public ConexionBD(String host, String port, String user, String pass, String bd) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + bd + "";
        String driver = "com.mysql.jdbc.Driver";// para la conectar con MySQL        
        try {
            Class.forName(driver).newInstance();
            ConnectionDB = (Connection) DriverManager.getConnection(url, user, pass);
            if (ConnectionDB != null) {
                System.out.println(url);
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
        } catch (IllegalAccessException | InstantiationException ex) {
            MensajeSistema.setException(ex);
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        } catch (ClassNotFoundException ex) {
            MensajeSistema.MensajeVarios("No se encontro el Controlador de Base de Datos...\n"
                    + ex.getMessage(), MensajeSistema.ERROR_MESSAGE());
        }
    }

    /**
     * Metodo que retorna la conexion con la Base de Datos
     *
     * @return
     */
    public Connection getConexion() {
        return ConnectionDB;
    }

    /**
     * Metodo que cierra la conexion con la Base de Datos
     */
    public void CerrarConexion() {
        try {
            ejecutar.close();
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
    }

    /**
     * Metodo ejecuta el Query que recibe como parametro
     *
     * @param Query
     * @return
     */
    public boolean ejecutaUpdate(String Query) {
        System.out.println(Query);
        try {
            if (Query.substring(0, 4).equals("CALL")) {
                ejecutar = getConexion().prepareCall(Query);
            } else {
                ejecutar = getConexion().prepareStatement(Query);
            }
            int rs = ejecutar.executeUpdate();
            CerrarConexion();
            return rs > 0;
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
            return false;
        }
    }

    /**
     * Metodo ejecuta el Query que recibe como parametro
     *
     * @param Query
     * @return
     */
    public ResultSet ejecutaQuery(String Query) {
        System.out.println(Query);
        try {
            if (Query.substring(0, 4).equals("CALL")) {
                ejecutar = getConexion().prepareCall(Query);
            } else {
                ejecutar = getConexion().prepareStatement(Query);
            }
            return ejecutar.executeQuery();
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
        return null;
    }

    /**
     * Metodo para insertar registros en la Base de Datos, recibe como parametro
     * la tabla, en un vector tipo String los campos de la Tabla y en otro
     * vector tipo String los valores que se agregaran a la Base de Datos
     *
     * @param tabla
     * @param campos
     * @param valores
     * @return
     */
    public boolean insertar(String tabla, String[] campos, String[] valores) {
        SQL = ConsultaSQL.getInsert(tabla, campos, valores);
        return ejecutaUpdate(SQL);
    }

    /**
     * Metodo para insertar registros en la Base de Datos, recibe como parametro
     * la tabla, en un vector tipo String los valores que se agregaran a la Base
     * de Datos
     *
     * @param tabla
     * @param valores
     * @return
     */
    public boolean insertar(String tabla, String[] valores) {
        SQL = ConsultaSQL.getInsert(tabla, new String[]{}, valores);
        return ejecutaUpdate(SQL);
    }

    public boolean insertar(String tabla, String[] campos, String[][] registros, int reg, int col) {
        SQL = "INSERT INTO " + tabla;
        try {
            if (campos.getClass().equals(String[].class)) {
                if (campos.length > 0 && !"".equals(campos[0])) {
                    SQL += " (";
                    for (int i = 0; i < campos.length; i++) {
                        SQL += campos[i];
                        if (i != campos.length - 1) {
                            SQL += ", ";
                        }
                    }
                    SQL += ")";
                }
            }
        } catch (Exception ex) {
        }
        SQL += " VALUES ";
        String valores = "";
        for (int registro = 0; registro < reg; registro++) {
            valores += "(";
            for (int columna = 0; columna < col; columna++) {
                valores += "'" + registros[registro][columna].trim() + "'";
                if (columna != col - 1) {
                    valores += ", ";
                }
            }
            valores += ")";
            boolean pC;
            if (registro != reg - 1) {
                valores += ",";
                pC = false;
            } else {
                pC = true;
            }
            if (pC) {
                valores += ";";
            }
        }
        return ejecutaUpdate(SQL + valores);
    }

    public boolean insertarSinMSJs(String tabla, String[] campos, String[] valores) {
        SQL = ConsultaSQL.getInsert(tabla, campos, valores);
        return ejecutaUpdate(SQL);
    }

    /**
     * Metodo para actualizar un registro o los registros que cumplan las
     * condiciones, recibe como parametro la tabla, en un vector tipo String los
     * campos que se va a modificar, en otro vector tipo String los nuevos
     * valores de los campos, en otro vector tipo String los campos de las
     * condiciones, en otro vector tipo String los valores de las condiciones
     *
     * @param tabla
     * @param campos
     * @param valores
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public boolean actualizar(String tabla, String[] campos, String[] valores,
            String[] camposCondicion, String[] valoresCondicion) {
        SQL = ConsultaSQL.getUpdate(tabla, campos, valores, camposCondicion, valoresCondicion);
        return ejecutaUpdate(SQL);
    }

    /**
     * Metodo para actualizar un registro o los registros que cumplan las
     * condiciones, recibe como parametro la tabla, en un vector tipo String los
     * campos que se va a modificar, en otro vector tipo String los nuevos
     * valores de los campos, en un String el campo de la condicion, en otro
     * String los valor de la condicion
     *
     * @param tabla
     * @param campos
     * @param valores
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public boolean actualizar(String tabla, String[] campos, String[] valores,
            String camposCondicion, String valoresCondicion) {
        SQL = ConsultaSQL.getUpdate(tabla, campos, valores, camposCondicion, valoresCondicion);
        return ejecutaUpdate(SQL);
    }

    /**
     * Metodo que sirve para eliminar el o los registros que cumplan con las
     * condiciones de borrado, recibe como parametro la tabla, en un vector tipo
     * String los campos de las condiciones, en otro vector tipo String los
     * valores de las condiciones
     *
     * @param tabla
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public boolean eliminar(String tabla, String[] camposCondicion, String[] valoresCondicion) {
        SQL = ConsultaSQL.getEliminar(tabla, camposCondicion, valoresCondicion);
        return ejecutaUpdate(SQL);
    }

    /**
     * Metodo que sirve para eliminar el o los registros que cumplan con las
     * condiciones de borrado, recibe como parametro la tabla, en un String el
     * campo de la condicion, en otro String el valor de la condicion
     *
     * @param tabla
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public boolean eliminar(String tabla, String camposCondicion, String valoresCondicion) {
        SQL = ConsultaSQL.getEliminar(tabla, camposCondicion, valoresCondicion);
        return ejecutaUpdate(SQL);
    }

    public boolean call(String proc, String[] campos) {
        try {
            SQL = "CALL " + proc + "(";
            if (campos.getClass().equals(String[].class)) {
                if (campos.length > 0 && !"".equals(campos[0])) {
                    for (int i = 0; i < campos.length; i++) {
                        SQL += "'" + campos[i] + "'";
                        if (i != campos.length - 1) {
                            SQL += ", ";
                        }
                    }
                }
            }
            SQL += ");";
            return ejecutaUpdate(SQL);
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return false;
    }

    public String[] callResultSet(String proc, String[] campos) {
        try {
            SQL = "CALL " + proc + "(";
            if (campos.getClass().equals(String[].class)) {
                if (campos.length > 0 && !"".equals(campos[0])) {
                    for (int i = 0; i < campos.length; i++) {
                        SQL += "'" + campos[i] + "'";
                        if (i != campos.length - 1) {
                            SQL += ", ";
                        }
                    }
                }
            }
            SQL += ");";
            try {
                ResultSet rs = ejecutaQuery(SQL);
                if (rs.next()) {
                    int lon = rs.getMetaData().getColumnCount();
                    String[] resu = new String[lon];
                    for (int i = 0; i < lon; i++) {
                        resu[i] = rs.getString(i + 1);
                    }
                    return resu;
                }
            } catch (SQLException ex) {
                MensajeSistema.setSQLException(ex);
            }
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return null;
    }

    /**
     * Metodo para obtener el codigo maximo de cualquier tabla, recibe tres
     * parametros, tipo String, tabla, campo del identificador y la condicion
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @return
     */
    public int getMAX(String tabla, String campo, String[] campoCondicion, String[] condicion) {
        String rs = getDescripcion(tabla, "IFNULL(MAX(" + campo + "),0)", campoCondicion, condicion);
        try {
            return Integer.parseInt(rs);
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return -1;
    }

    /**
     * Metodo para obtener el codigo mínimo de cualquier tabla, recibe tres
     * parametros tabla, campo, condicion
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @return
     */
    public int getMIN(String tabla, String campo, String[] campoCondicion, String[] condicion) {
        String rs = getDescripcion(tabla, "IFNULL(MIN(" + campo + "),0)", campoCondicion, condicion);
        try {
            return Integer.parseInt(rs);
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return -1;
    }

    /**
     * Metodo que retorna la suma de un campo numerico
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @return
     */
    public int getSUM(String tabla, String campo, String[] campoCondicion, String[] condicion) {
        String rs = getDescripcion(tabla, "IFNULL(SUM(" + campo + "),0)", campoCondicion, condicion);
        try {
            return Integer.parseInt(rs);
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return -1;
    }

    /**
     * Metodo que retorna el promedio de un campo numerico
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @return
     */
    public double getAVG(String tabla, String campo, String[] campoCondicion, String[] condicion) {
        String rs = getDescripcion(tabla, "IFNULL(AVG(" + campo + "),0)", campoCondicion, condicion);
        try {
            return Double.parseDouble(rs);
        } catch (Exception ex) {
            MensajeSistema.setException(ex);
        }
        return -1.0;
    }

    /**
     * Cuenta la cantidad de filas que tiene una consulta sql
     *
     * @param sql
     * @return
     */
    public int getCOUNTFila(String sql) {
        try {
            ResultSet rs = ejecutaQuery(sql);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            MensajeSistema.setSQLException(e);
        }
        return -1;
    }

    public int getCOUNTFila(String tabla, String[] campoCondicion, String[] condicion) {
        try {
            SQL = ConsultaSQL.getSelect(tabla, new String[]{"count(*)"}, null, campoCondicion, condicion);
            ResultSet rs = ejecutaQuery(SQL);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            MensajeSistema.setSQLException(e);
        }
        return -1;
    }

    public int getCOUNTFila(ResultSet rs) {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            MensajeSistema.setSQLException(e);
        }
        return -1;
    }

    /**
     * Devuelve la cantidad de columnas que halla contado durante una consulta
     * sql
     *
     * @param tabla
     * @return
     */
    public int getCOUNTColumna(String tabla) {
        try {
            ResultSet rs = ejecutaQuery("SHOW FIELDS FROM " + tabla + ";");
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            MensajeSistema.setSQLException(e);
        }
        return -1;
    }

    public int getCOUNTColumna(ResultSet rs) {
        try {
            rs.last();
            return rs.getMetaData().getColumnCount();
        } catch (SQLException e) {
            MensajeSistema.setSQLException(e);
        }
        return -1;
    }

    /**
     * Metodo para obtener el ultimo nro mas uno de una tabla e insertar el
     * valor devuelto en un JTextField que recibe como parametro.
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @param texto
     * @return
     */
    public boolean autoNumerico(String tabla, String campo, String[] campoCondicion,
            String[] condicion, JTextField texto) {
        int valor = getMAX(tabla, campo, campoCondicion, condicion);
        if (valor >= 0) {
            texto.setText((valor + 1) + "");
            return true;
        }
        return false;
    }

    /**
     * Metodo para obtener el ultimo nro mas uno de una tabla e insertar el
     * valor devuelto en un JTextField que recibe como parametro.
     *
     * @param tabla
     * @param campo
     * @param campoCondicion
     * @param condicion
     * @param texto
     * @return
     */
    public boolean autoNumerico(String tabla, String campo, String[] campoCondicion,
            String[] condicion, txtCodigo texto) {
        int valor = getMAX(tabla, campo, campoCondicion, condicion);
        if (valor >= 0) {
            texto.setText((valor + 1) + "");
            return true;
        }
        return false;
    }

    /**
     * Metodo para obtener el ultimo nro mas uno de una tabla e insertar el
     * valor devuelto en un JTextField que recibe como parametro.
     *
     * @param texto
     * @return
     */
    public boolean autoNumerico(txtCodigo texto) {
        String[] condicion, valores;
        if (texto.isUsarEmpresa() && texto.isUsarSucursal()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO, frm_Padre.SUC_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO()};
        } else if (texto.isUsarEmpresa()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO()};
        } else {
            condicion = new String[]{null};
            valores = new String[]{null};
        }
        int valor = getMAX(texto.getBdTabla(), texto.getBdCodigo(), condicion, valores);
        if (valor >= 0) {
            texto.setCodigo(valor + 1);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite consultar registros de una tabla, recibe como
     * parametros la tabla, en un vector tipo String las condiciones, en otro
     * vector tipo String los valores de las condiciones
     *
     * @param tabla
     * @param campo
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public ArrayList consultar(String tabla, String campo, String[] camposCondicion, String[] valoresCondicion) {
        SQL = ConsultaSQL.getSelect(tabla, new String[]{campo}, null, camposCondicion, valoresCondicion);
        return consultar(SQL);
    }

    public ArrayList consultar(String sql) {
        ArrayList lista = new ArrayList();
        try {
            ResultSet rs = ejecutaQuery(sql);
            if (rs.next()) {
                do {
                    lista.add(rs.getObject(1));
                } while (rs.next());
            } else {
                MensajeSistema.ConsultaSQLVacio();
            }
            CerrarConexion();
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
        return lista;
    }

    public String getDescripcion(String tabla, String campo, String[] CampoCondicion, String[] valores) {
        SQL = ConsultaSQL.getSelect(tabla, new String[]{campo}, null, CampoCondicion, valores);
        try {
            ResultSet rs = ejecutaQuery(SQL);
            String resu = null;
            if (rs.next()) {
                resu = rs.getString(1);
            }
            CerrarConexion();
            return resu;
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
        return null;
    }

    /**
     * Metodo para obtener uno o varios registros de una tabla foranea con una o
     * varias condiciones
     *
     * @param tabla
     * @param campos
     * @param CampoCondicion
     * @param valores
     * @return
     */
    public String[] getDescripciones(String tabla, String[] campos, String[] CampoCondicion, String[] valores) {
        String[] resu = new String[campos.length];
        SQL = ConsultaSQL.getSelect(tabla, campos, null, CampoCondicion, valores);
        try {
            ResultSet rs = ejecutaQuery(SQL);
            if (rs.next()) {
                for (int i = 0; i < campos.length; i++) {
                    resu[i] = rs.getString(campos[i]);
                }
            } else {
                resu[0] = null;
            }
            CerrarConexion();
        } catch (SQLException ex) {
            resu[0] = null;
            MensajeSistema.setSQLException(ex);
        }
        return resu;
    }

    /**
     * Metodo para obtener uno o varios registros de una tabla con una o varias
     * condiciones
     * <>String[][]<>
     * <>la primera es la fila y la segunda es la columna<>
     *
     * @param tabla
     * @param campos
     * @param condiciones
     * @param valores
     * @return
     */
    public String[][] getDescripcionesRow(String tabla, String[] campos, String[] condiciones, String[] valores) {
        SQL = ConsultaSQL.getSelect(tabla, campos, null, condiciones, valores);
        return getDescripcionesRow(SQL);
    }

    /**
     * Metodo para obtener uno o varios registros de una tabla foranea con una o
     * varias condiciones
     * <>String[][]
     * <>la primera es la columna y la segunda es la fila
     *
     * @param sql
     * @return
     */
    public String[][] getDescripcionesRow(String sql) {
        String[][] resu = new String[1][1];
        try {
            ResultSet rs = ejecutaQuery(sql);
            if (rs.next()) {
                rs.last();
                int columnas = rs.getMetaData().getColumnCount();
                resu = new String[rs.getRow()][columnas];
                rs.first();
                int fila = 0;
                do {
                    for (int i = 0; i < columnas; i++) {
                        resu[fila][i] = rs.getString(i + 1);
                    }
                    fila++;
                } while (rs.next());
            } else {
                resu[0][0] = null;
            }
            CerrarConexion();
        } catch (SQLException ex) {
            resu[0][0] = null;
            MensajeSistema.setSQLException(ex);
        }
        return resu;
    }

    public boolean Begin() {
        return ejecutaUpdate("BEGIN");
    }

    public boolean Commit() {
        return ejecutaUpdate("COMMIT");
    }

    public boolean RollBack() {
        return ejecutaUpdate("ROLLBACK");
    }

    /**
     * Metodo que retorna un DefaultTableModel con los datos que retorna de la
     * consulta que se recibe como parametro
     *
     * @param consulta
     * @return
     */
    public DefaultTableModel getDefaultTableModel(String consulta) {
        ResultSet rs = ejecutaQuery(consulta);
        return getDefaultTableModel(rs);
    }

    /**
     * Metodo que retorna un DefaultTableModel con los datos que retorna de la
     * consulta que se recibe como parametro
     *
     * @param rs
     * @return
     */
    public DefaultTableModel getDefaultTableModel(ResultSet rs) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            ResultSetMetaData metaDatos = rs.getMetaData();
            if (rs.next()) {
                for (int i = 0; i < metaDatos.getColumnCount(); i++) {
                    modelo.addColumn(metaDatos.getColumnLabel(i + 1));
                }
                do {
                    Object[] datos = new Object[metaDatos.getColumnCount()];
                    for (int i = 0; i < metaDatos.getColumnCount(); i++) {
                        datos[i] = rs.getString(i + 1);
                    }
                    modelo.addRow(datos);
                } while (rs.next());
            } else {
                MensajeSistema.ConsultaSQLVacio();
            }
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
        return modelo;
    }

    /**
     * Metodo que valida usuario y el password
     *
     * @param emp
     * @param user
     * @param pass
     * @return
     */
    public boolean ValidarUsuario(String emp, String user, String pass) {
        String sql = "select count(*) from acc_usuarios where Emp_Codigo=" + emp
                + " and Usu_Codigo=" + user + " and clave=password('" + pass + "')";
        return this.getCOUNTFila(sql) > 0;
    }
}
