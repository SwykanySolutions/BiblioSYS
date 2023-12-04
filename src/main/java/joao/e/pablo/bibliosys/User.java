/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author spanp
 */
public class User {
    
    public static void Login(String Login, String Senha) throws SQLException, ClassNotFoundException{
        String SQL;
        if(Login.contains("@")){
            SQL = "SELECT * FROM usuario WHERE email = ?";
        } else {
            SQL = "SELECT * FROM usuario WHERE username = ?";
        }
        try{
            ResultSet result = Conexao.executeQuery(SQL, Login);
            if(result.next()){
                String SenhaBanco = result.getString("senha");
                if(Criptografia.ValidarHash(SenhaBanco, Senha)){
                    Session.set("login_status", true);
                    Session.set("user", result.getString("username"));
                    Session.set("nivel", result.getString("nivel"));
                } else {
                    Session.set("login_status", false);
                }
            }
            
        } catch (SQLException error) {
            throw error;
        }
    }
}
