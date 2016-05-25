package com.app.config;

/**
 *
 * @author Diego
 */
public class ConsultaSQL {

    private static final String[] vacio = {};

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param condicion
     * @param valor
     * @return
     */
    public static String getSelect(String tabla, String condicion, String valor) {
        if (!tabla.trim().isEmpty() && !condicion.trim().isEmpty() && !valor.trim().isEmpty()) {
            return "SELECT * FROM " + tabla + " WHERE " + condicion + "='" + valor + "';";
        }
        return null;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @return
     */
    public static String getSelect(String tabla, String[] campos) {
        if (!tabla.trim().isEmpty() && campos[0] != null) {
            return "SELECT " + campoNombres(campos, vacio) + " FROM " + tabla + ";";
        }
        return null;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres) {
        if (!tabla.trim().isEmpty()) {
            return "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla + ";";
        }
        return null;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param ORDERBY
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres, String[] ORDERBY) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += OrderBy(ORDERBY, vacio) + ";";
        return SQL;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param valores
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] valores) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, vacio, vacio, valores);
        return SQL += ";";
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param valores
     * @param ORDERBY
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] valores, String[] ORDERBY) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, vacio, vacio, valores);
        SQL += OrderBy(ORDERBY, vacio) + ";";
        return SQL;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param igual
     * @param valores
     * @param ORDERBY
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] igual, String[] valores, String[] ORDERBY) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, igual, vacio, valores);
        SQL += OrderBy(ORDERBY, vacio) + ";";
        return SQL;
    }

    /**
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param igual
     * @param AndOrNot
     * @param valores
     * @param ORDERBY
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] igual, String[] AndOrNot,
            String[] valores, String[] ORDERBY) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, igual, AndOrNot, valores);
        SQL += OrderBy(ORDERBY, vacio) + ";";
        return SQL;
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param igual
     * @param AndOrNot
     * @param valores
     * @param ORDERBY
     * @param modo
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] igual, String[] AndOrNot,
            String[] valores, String[] ORDERBY, String[] modo) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, igual, AndOrNot, valores);
        SQL += OrderBy(ORDERBY, modo) + ";";
        return SQL += ";";
    }

    /**
     * Metodo para crear una consulta SQL con los parametros ingresados
     *
     * @param tabla
     * @param campos
     * @param nombres
     * @param CampoCondicion
     * @param igual
     * @param AndOrNot
     * @param valores
     * @param ORDERBY
     * @param modo
     * @param limite
     * @return
     */
    public static String getSelect(String tabla, String[] campos, String[] nombres,
            String[] CampoCondicion, String[] igual, String[] AndOrNot, String[] valores,
            String[] ORDERBY, String[] modo, int limite) {
        String SQL = "SELECT " + campoNombres(campos, nombres) + " FROM " + tabla;
        SQL += campoCondicion(CampoCondicion, igual, AndOrNot, valores);
        SQL += OrderBy(ORDERBY, modo);
        SQL += limite <= 0 ? " LIMIT 1000" : " LIMIT " + limite;
        return SQL += ";";
    }

    /**
     * Metodo para crear una instruccion SQL para insertar registros en la BD
     *
     * @param tabla
     * @param valores
     * @return
     */
    public static String getInsert(String tabla, String[] valores) {
        String SQL = "INSERT INTO " + tabla + " VALUES (";
        for (int i = 0; i < valores.length; i++) {
            SQL += valores[i].equals("null") ? null : "\"" + valores[i] + "\"";
            if (i != valores.length - 1) {
                SQL += ", ";
            }
        }
        SQL += ");";
        return SQL;
    }

    /**
     * Metodo para crear una instruccion SQL para insertar registros en la BD
     *
     * @param tabla
     * @param campos
     * @param valores
     * @return
     */
    public static String getInsert(String tabla, String[] campos, String[] valores) {
        String SQL = "INSERT INTO " + tabla;
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
        SQL += " VALUES (";
        for (int i = 0; i < valores.length; i++) {
            SQL += valores[i].equals("null") ? null : "\"" + valores[i] + "\"";
            if (i != valores.length - 1) {
                SQL += ", ";
            }
        }
        SQL += ");";
        return SQL;
    }

    /**
     * Metodo para crear una instruccion SQL para modificar registros en la BD
     *
     * @param tabla
     * @param campos
     * @param valores
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public static String getUpdate(String tabla, String[] campos, String[] valores,
            String[] camposCondicion, String[] valoresCondicion) {
        String SQL = "UPDATE " + tabla + " SET ";
        for (int i = 0; i < campos.length; i++) {
            String valor = valores[i].equals("null") ? null : "\"" + valores[i] + "\"";
            SQL += campos[i] + "=" + valor;
            if (i != campos.length - 1) {
                SQL += ", ";
            }
        }
        if (camposCondicion[0] != null && camposCondicion.length > 0) {
            SQL += " WHERE ";
            for (int i = 0; i < camposCondicion.length; i++) {
                SQL += camposCondicion[i] + "=\"" + valoresCondicion[i] + "\"";
                if (i != camposCondicion.length - 1) {
                    SQL += " AND ";
                }
            }
        }
        return SQL += ";";
    }

    /**
     * Metodo para crear una instruccion SQL para modificar registros en la BD
     *
     * @param tabla
     * @param campos
     * @param valores
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public static String getUpdate(String tabla, String[] campos, String[] valores, String camposCondicion, String valoresCondicion) {
        String SQL = "UPDATE " + tabla + " SET ";
        for (int i = 0; i < campos.length; i++) {
            String valor = valores[i].equals("null") ? null : "\"" + valores[i] + "\"";
            SQL += campos[i] + "=" + valor;
            if (i != campos.length - 1) {
                SQL += ", ";
            }
        }
        if (camposCondicion != null && camposCondicion.length() > 0) {
            SQL += " WHERE " + camposCondicion + "=\"" + valoresCondicion + "\"";
        }
        return SQL += ";";
    }

    /**
     * Metodo para crear una instruccion SQL para eliminar registros en la BD
     *
     * @param tabla
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public static String getEliminar(String tabla, String[] camposCondicion, String[] valoresCondicion) {
        String SQL = "DELETE FROM " + tabla;
        if (camposCondicion[0] != null && camposCondicion.length > 0) {
            SQL += " WHERE ";
            for (int i = 0; i < camposCondicion.length; i++) {
                SQL += camposCondicion[i] + "=\"" + valoresCondicion[i] + "\"";
                if (i != camposCondicion.length - 1) {
                    SQL += " AND ";
                }
            }
        }
        return SQL += ";";
    }

    /**
     * Metodo para crear una instruccion SQL para eliminar registros en la BD
     *
     * @param tabla
     * @param camposCondicion
     * @param valoresCondicion
     * @return
     */
    public static String getEliminar(String tabla, String camposCondicion, String valoresCondicion) {
        String SQL = "DELETE FROM " + tabla;
        if (camposCondicion.length() > 0 && !"".equals(camposCondicion)) {
            SQL += " WHERE " + camposCondicion + "=\"" + valoresCondicion + "\"";
        }
        return SQL += ";";
    }

    private static String campoNombres(String[] campos, String[] nombres) {
        try {
            String sql = "";
            if (campos.getClass().equals(String[].class) || nombres.getClass().equals(String[].class)) {
                for (int i = 0; i < campos.length; i++) {
                    if (campos[i] == null || campos[i].equals("")) {
                        sql = "*";
                        break;
                    } else {
                        try {
                            if (nombres[i] == null || nombres[i].equals("")) {
                                sql += campos[i];
                            } else {
                                sql += campos[i] + " AS " + nombres[i];
                            }
                        } catch (Exception e) {
                            sql += campos[i];
                        }
                        if (i != campos.length - 1) {
                            sql += ", ";
                        }
                    }
                }
            } else {
                sql = "*";
            }
            return sql;
        } catch (Exception ex) {
            return "*";
        }
    }

    private static String campoCondicion(String[] CampoCondicion, String[] igual, String[] AndOrNot, String[] valores) {
        try {
            int posicion, y = 0;
            String sql = "";
            boolean seCargo = false;
            boolean CuandoEsOr = false;
            if (CampoCondicion.getClass().equals(String[].class)
                    || igual.getClass().equals(String[].class)
                    || AndOrNot.getClass().equals(String[].class)
                    || valores.getClass().equals(String[].class)) {
                for (int i = 0; i < CampoCondicion.length; i++) {
                    if (CampoCondicion[i] != null || !"".equals(CampoCondicion[i])) {
                        try {
                            if (igual[0] == null) {
                                sql += CampoCondicion[i] + " = \"" + valores[i] + "\"";
                            } else {
                                switch (igual[i].toUpperCase().trim()) {
                                    case "LIKE":
                                        sql += CampoCondicion[i] + " LIKE (\"%" + valores[i] + "%\")";
                                        break;
                                    case "NOT IN":
                                        sql += CampoCondicion[i] + " NOT IN (\"" + valores[i] + "\")";
                                        break;
                                    case "IN":
                                        sql += CampoCondicion[i] + " IN (\"" + valores[i] + "\")";
                                        break;
                                    default:
                                        sql += CampoCondicion[i] + " " + igual[i] + " \"" + valores[i] + "\"";
                                        break;
                                }
                            }
                        } catch (Exception e) {
                            sql += CampoCondicion[i] + " = \"" + valores[i] + "\"";
                        }
                        if (CuandoEsOr) {//esto va a pasar si la condicion del vector IGUAL es OR
                            sql += ")";// para cerar ) la condicion OR
                            CuandoEsOr = false;//vuelve a poner la variable en 0 para la siguiente vuelta
                        }
                        if (i != CampoCondicion.length - 1) {
                            try {
                                if (AndOrNot[i] == null || "".equals(AndOrNot[i])) {
                                    sql += " AND ";
                                } else {//en caso de que si haya algun valor dentro de la condicion de esta posicion
                            /*
                                     * verificamos si es OR la condicion porque para la consulta sql cuando es OR, tiene que
                                     * haber mas de una condicion para que sea verdadera, asi que si hay mas de tres condiciones
                                     * va a quedar asi si no le ponemos entre parentesis la condicion OR 
                                     * "campo1=valor OR campo2=valor AND campo2=valor";
                                     * pero tiene que quedar asi
                                     * "(campo1=valor OR campo2=valor) AND campo2=valor";
                                     * para que verifique solamente como verdadero los dos bloques.
                                     */
                                    if ("OR".equals(AndOrNot[i].toUpperCase())) {//es es OR la condicion de esta posicion                            
                                        if (")".equals(sql.substring(sql.length() - 1, sql.length()))) {//verifica en que posicion esta el parentesis
                                            sql += sql.substring(0, sql.length() - 1);//borra el parentesis
                                            y = 1;
                                        }
                                        if (y == 1) {
                                            sql += " OR ";
                                        } else {
                                            posicion = sql.lastIndexOf(CampoCondicion[i]);
                                            sql += sql.substring(0, posicion) + "(" + sql.substring(posicion) + " OR ";
                                        }
                                        CuandoEsOr = true;
                                    } else {
                                        sql += " " + AndOrNot[i].toUpperCase() + " ";
                                    }
                                }
                            } catch (Exception e) {//si hubo un error
                                sql += " AND ";// se pone la condicion AND si hubo algun error
                            }
                        }
                        seCargo = true;
                    } else {
                        seCargo = false;
                    }
                }
            }
            return seCargo ? " WHERE " + sql : "";
        } catch (Exception ex) {
            return "";
        }
    }

    private static String OrderBy(String[] orden, String[] modo) {
        String sql = "";
        try {
            boolean seCargo = false;
            if (orden.getClass().equals(String[].class) || modo.getClass().equals(String[].class)) {
                for (int i = 0; i < orden.length; i++) {
                    if (orden[i] != null) {
                        try {
                            sql += orden[i] + " " + modo[i];
                        } catch (Exception ex) {
                            sql += orden[i];
                        }
                        if (i != orden.length - 1) {
                            sql += ", ";
                        }
                        seCargo = true;
                    }
                }
            }
            return seCargo ? " ORDER BY " + sql : "";
        } catch (Exception ex) {
            return "";
        }
    }
}
