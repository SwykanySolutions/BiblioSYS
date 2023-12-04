/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author spanp
 */
public class PessoaDTO {
    
    public static void cadastrar( 
            String NomeCompleto, 
            Date DataDeNascimento, 
            String Telefone, 
            String CPF, 
            String Tipo, 
            String Endereco, 
            String Bairro,
            String Complemento,
            Integer Numero
    ) throws SQLException, ClassNotFoundException{
        String SQL_ENDERECO_INSERT = "INSERT INTO endereco ( nome, tipo, numero, bairro, complemento ) VALUES ( ?, ?, ?, ?, ? )",
        SQL_ENDERECO_SELECT = "SELECT id_endereco FROM endereco WHERE nome = ? AND tipo = ? AND numero = ? AND bairro = ? AND complemento = ?",
        SQL_PESSOA_INSERT = "INSERT INTO pessoa ( nome_completo, data_de_nascimento, telefone, cpf, id_endereco ) VALUES ( ?, ?, ?, ?, ? )";
        try{
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_ENDERECO_INSERT = conn.prepareStatement(SQL_ENDERECO_INSERT);
            PreparedStatement STATMENT_ENDERECO_SELECT = conn.prepareStatement(SQL_ENDERECO_SELECT);
            PreparedStatement STATMENT_PESSOA_INSERT = conn.prepareStatement(SQL_PESSOA_INSERT);
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
            STATMENT_PESSOA_INSERT.setString(4, CPF);
            STATMENT_PESSOA_INSERT.setInt(5, id_endereco);
            STATMENT_PESSOA_INSERT.execute();
            JOptionPane.showMessageDialog(
                null, 
                "Pessoa foi cadastrado com sucesso", 
                "Sucesso ao cadastrar o usuário", 
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (ClassNotFoundException | SQLException error) {
            JOptionPane.showMessageDialog(
                null, 
                "Erro ao cadastrar o usuário tente novamente.", 
                "Erro ao cadastrar o usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            throw error;
        }
    }
    
    public static boolean validarExistencia() throws SQLException, ClassNotFoundException{
        return 
            Conexao.Conectar()
            .prepareStatement("SELECT * FROM pessoa")
            .executeQuery()
            .next();
    }
    
    public static String All() throws SQLException, ClassNotFoundException{
        try{
            String SQL_SELECT = "SELECT * FROM pessoa ";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL_SELECT);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            String todos_as_pessoas = "";
            while(RESULT_SET.next()){
               todos_as_pessoas += RESULT_SET.getString("id_pessoa") + " :: " + RESULT_SET.getString("nome_completo") + ";";
            }
            return todos_as_pessoas;
        } catch ( ClassNotFoundException | SQLException error ) {
            throw error;
        }
    }
}
