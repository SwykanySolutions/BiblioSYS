/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author spanp
 */

public class Conexao {
    
    private static final Dotenv dotenv = Dotenv.load();
    private static String servername;
    private static int port;
    private static String database;
    private static String username;
    private static String password;
    public static Connection Conexao;

    public static Connection Conectar() throws SQLException, ClassNotFoundException{
        servername = dotenv.get("DB_HOST");
        port = Integer.parseInt(dotenv.get("DB_PORT"));
        database = dotenv.get("DB_NAME");
        username = dotenv.get("DB_USERNAME");
        password = dotenv.get("DB_PASSWORD");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://"+servername+":"+port+"/"+database+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Conexao = DriverManager.getConnection(url,username, password);
            return Conexao;
        } catch (SQLException erro) {
            throw erro;
        }
    }
    
    public static ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
        try{
            Conectar();
            PreparedStatement statement = Conexao.prepareStatement(query);
            return statement.executeQuery();
        } catch(SQLException erro) {
            throw new SQLException("Erro ao executar a consulta", erro);
        }
    }
    
    public static ResultSet executeQuery(String query, Object... params) throws SQLException, ClassNotFoundException {
        try{
            Conectar();
            PreparedStatement statement = Conexao.prepareStatement(query);
           
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            return statement.executeQuery();
             
        } catch(SQLException erro) {
            throw new SQLException("Erro ao executar a consulta", erro);
        }
    }
    
}
