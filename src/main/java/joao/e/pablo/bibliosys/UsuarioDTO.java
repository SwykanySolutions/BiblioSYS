/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.validator.EmailValidator;


/**
 *
 * @author spanp
 */
public class UsuarioDTO {
    
    public static void Login(String Login, String Senha) throws SQLException, ClassNotFoundException{
        
        String SQL;
        
        if(EmailValidator.getInstance().isValid(Login)){
            SQL = "SELECT * FROM usuario WHERE email = ?";
        } else {
            SQL = "SELECT * FROM usuario WHERE username = ?";
        }
        
        try{
            Connection conn = Conexao.Conectar();
            PreparedStatement prepare = conn.prepareStatement(SQL);
            prepare.setString(1, Login);
            ResultSet result = prepare.executeQuery();
            String SenhaBanco = null;
            if(result.next()){
               SenhaBanco = result.getString("senha");
            }
            if(Criptografia.ValidarHash(SenhaBanco, Senha)){
                Session.set("login_status", true);
                Session.set("user", result.getString("user"));
                Session.set("nivel", result.getString("nivel"));
            } else {
                Session.set("login_status", false);
            }
        } catch (SQLException error) {
            
            JOptionPane.showMessageDialog(null, """
                Erro ao realizar o login tente novamente mais tarde.
                Caso prefira contato o seu suporte. Código de erro: """ + error.getErrorCode() + ".", 
                "Erro de Autenticação",
                JOptionPane.ERROR_MESSAGE
            );
            throw error;
        }
    }
    
    public static void Cadastrar (
        String NomeCompleto, 
        Date DataDeNascimento, 
        String Telefone, 
        String Cpf, String 
        Usuario, 
        String Endereco, 
        String Tipo, 
        Integer Numero, 
        String Bairro, 
        String Complemento,
        String Email,
        String Senha,
        Integer Nivel
    ) throws SQLException, ClassNotFoundException {
        try{
            String SQL_ENDERECO_INSERT = "INSERT INTO endereco ( nome, tipo, numero, bairro, complemento ) VALUES ( ?, ?, ?, ?, ? )",
            SQL_ENDERECO_SELECT = "SELECT id_endereco FROM endereco WHERE nome = ? AND tipo = ? AND numero = ? AND bairro = ? AND complemento = ?",
            SQL_PESSOA_INSERT = "INSERT INTO pessoa ( nome_completo, data_de_nascimento, telefone, cpf, id_endereco ) VALUES ( ?, ?, ?, ?, ? )",
            SQL_PESSOA_SELECT = "SELECT id_pessoa FROM pessoa WHERE cpf = ?",
            SQL_USUARIO_INSERT = "INSERT INTO usuario (id_pessoa, username, email, senha, nivel ) VALUES ( ?, ?, ?, ?, ? )";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_ENDERECO_INSERT = conn.prepareStatement(SQL_ENDERECO_INSERT);
            PreparedStatement STATMENT_ENDERECO_SELECT = conn.prepareStatement(SQL_ENDERECO_SELECT);
            PreparedStatement STATMENT_PESSOA_INSERT = conn.prepareStatement(SQL_PESSOA_INSERT);
            PreparedStatement STATMENT_PESSOA_SELECT = conn.prepareStatement(SQL_PESSOA_SELECT);
            PreparedStatement STATMENT_USUARIO_INSERT = conn.prepareStatement(SQL_USUARIO_INSERT);
            STATMENT_ENDERECO_INSERT.setString(1, Endereco);
            STATMENT_ENDERECO_INSERT.setString(2, Tipo);
            STATMENT_ENDERECO_INSERT.setInt(3, Numero);
            STATMENT_ENDERECO_INSERT.setString(4, Bairro);
            STATMENT_ENDERECO_INSERT.setString(5, Complemento);
            STATMENT_ENDERECO_INSERT.execute();
            STATMENT_ENDERECO_SELECT.setString(1, Endereco);
            STATMENT_ENDERECO_SELECT.setString(2, Tipo);
            STATMENT_ENDERECO_SELECT.setInt(3, Numero);
            STATMENT_ENDERECO_SELECT.setString(4, Bairro);
            STATMENT_ENDERECO_SELECT.setString(5, Complemento);
            ResultSet RESULT_SET_ENDERECO = STATMENT_ENDERECO_SELECT.executeQuery();
            Integer id_endereco = null;
            while(RESULT_SET_ENDERECO.next()){
                id_endereco = RESULT_SET_ENDERECO.getInt("id_endereco");
            }
            STATMENT_PESSOA_INSERT.setString(1, NomeCompleto);
            STATMENT_PESSOA_INSERT.setDate(2, DataDeNascimento);
            STATMENT_PESSOA_INSERT.setString(3, Telefone);
            STATMENT_PESSOA_INSERT.setString(4, Cpf);
            STATMENT_PESSOA_INSERT.setInt(5, id_endereco);
            STATMENT_PESSOA_INSERT.execute();
            STATMENT_PESSOA_SELECT.setString(1, Cpf);
            ResultSet RESULT_SET_PESSOA = STATMENT_PESSOA_SELECT.executeQuery();
            Integer id_pessoa = null;
            while(RESULT_SET_PESSOA.next()){
                id_pessoa = RESULT_SET_PESSOA.getInt("id_pessoa");
            }
            String Senha_Encriptada = Criptografia.Criptografar(Senha);
            STATMENT_USUARIO_INSERT.setInt(1, id_pessoa);
            STATMENT_USUARIO_INSERT.setString(2, Usuario);
            STATMENT_USUARIO_INSERT.setString(3, Email);
            STATMENT_USUARIO_INSERT.setString(4, Senha_Encriptada);
            STATMENT_USUARIO_INSERT.setInt(5, Nivel);
            STATMENT_USUARIO_INSERT.execute();
        } catch( SQLException Error ){
            throw Error;
        }
    }
    
    public static boolean VerificarCPF(String Cpf) throws ClassNotFoundException, SQLException{
        try{
            String SQL = "SELECT * FROM pessoa WHERE cpf = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL);
            STATMENT_SELECT.setString(1, Cpf);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            return RESULT_SET.next();
        } catch( ClassNotFoundException | SQLException error ){
           throw error;
        }
    }
    
    public static boolean VerificarEMAIL(String Email) throws ClassNotFoundException, SQLException{
        try{
            String SQL = "SELECT * FROM usuario WHERE email = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL);
            STATMENT_SELECT.setString(1, Email);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            return RESULT_SET.next();
        } catch( ClassNotFoundException | SQLException error ){
           throw error;
        }
    }
    
    public static boolean VerificarUSERNAME(String Username) throws ClassNotFoundException, SQLException{
        try{
            String SQL = "SELECT * FROM usuario WHERE username = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL);
            STATMENT_SELECT.setString(1, Username);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            return RESULT_SET.next();
        } catch( ClassNotFoundException | SQLException error ){
           throw error;
        }
    }
    
}
