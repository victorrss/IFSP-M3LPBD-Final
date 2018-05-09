//******************************************************
// Instituto Federal de São Paulo - Campus Sertãozinho
// Disciplina......: M3LPBD
// Programação de Computadores e Dispositivos Móveis
// Aluno...........: Victor Rubens da Silva Santos
//******************************************************
package br.edu.ifsp.srt.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    // retorna uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/ifsp";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "");

        try {
            con = DriverManager.getConnection(url, prop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // fecha a conexão com o banco de dados
    public static void closeConnection(Connection con) throws SQLException {
        if (con != null || !con.isClosed()) {
            con.close();
        }
    }

    // finaliza o Statement e conexão
    public static void finalizeConnection(PreparedStatement stmt, Connection con) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
        }
    }

    // finaliza o Resulset, Statement e conexão
    public static void finalizeConnection(ResultSet result, PreparedStatement stmt, Connection con) {
        try {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            ConnectionUtils.finalizeConnection(stmt, con);
        } catch (Exception e) {
        }
    }

}
