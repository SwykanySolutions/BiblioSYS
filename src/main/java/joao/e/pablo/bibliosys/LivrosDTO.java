/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author spanp
 */
public class LivrosDTO {
    
    public static void cadastrar(
        String NomeLivro,
        Integer Lancamento,
        String Colecao,
        String Autor,
        String Editora,
        Integer Quantidade
    )throws SQLException, ClassNotFoundException {
        try {
            String SQL = "INSERT INTO livro ( nome, lancamento, colecao, autor, editora, quantidade ) VALUES ( ?, ?, ?, ?, ?, ? )";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setString(1, NomeLivro);
            STATMENT.setInt(2, Lancamento);
            STATMENT.setString(3, Colecao);
            STATMENT.setString(4, Autor);
            STATMENT.setString(5, Editora);
            STATMENT.setInt(6, Quantidade);
            STATMENT.execute();
        } catch( SQLException Error ){
            JOptionPane.showMessageDialog(
                null, 
                Error.getMessage(), 
                "Erro ao cadastrar o usuário", 
                JOptionPane.ERROR_MESSAGE);
            throw Error;
        }
    }
    
    public static void deletar(){
        
    }
    
    public static Object[] getAlldata( Integer id_livro ){
        try {
            String SQL = "SELECT * FROM livro WHERE id_livro = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            Object[] retorno = new Object[6];
            STATMENT.setInt(1, id_livro);
            ResultSet RESULT_SET = STATMENT.executeQuery();
            Integer i = 0;
            while(RESULT_SET.next()){
                retorno[0] = RESULT_SET.getString("nome");
                retorno[1] = RESULT_SET.getInt("lancamento");
                retorno[2] = RESULT_SET.getString("colecao");
                retorno[3] = RESULT_SET.getString("autor");
                retorno[4] = RESULT_SET.getString("editora");
                retorno[5] = RESULT_SET.getInt("quantidade");
            }
            return retorno;
        } catch (SQLException | ClassNotFoundException ex) {
            Object[] erro = new Object[1];
            erro[0] = false;
            return erro;
        }
        
    }
    
    public static boolean validarExistencia() throws ClassNotFoundException, SQLException {
        try{
            String SQL_SELECT = "SELECT * FROM livro ";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL_SELECT);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            return RESULT_SET.next();
        } catch ( ClassNotFoundException | SQLException error ) {
            throw error;
        }
    }
    
    public static String TodosOsLivros() 
        throws 
            SQLException, 
            ClassNotFoundException
    {
        try{
            String SQL_SELECT = "SELECT * FROM livro ";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL_SELECT);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            String todos_os_livros = "";
            while(RESULT_SET.next()){
               todos_os_livros += RESULT_SET.getString("id_livro") + " :: " + RESULT_SET.getString("nome") + ";";
            }
            return todos_os_livros;
        } catch ( ClassNotFoundException | SQLException error ) {
            throw error;
        }
    }
    
    public static boolean atualizar ( 
        Integer id, 
        String NomeLivro,
        Integer Lancamento,
        String Colecao,
        String Autor,
        String Editora,
        Integer Quantidade 
    ){
        try {
            String SQL = "UPDATE livro SET nome = ?, lancamento = ?, colecao = ?, autor = ?, editora = ?, quantidade = ? WHERE id_livro = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setString(1, NomeLivro);
            STATMENT.setInt(2, Lancamento);
            STATMENT.setString(3, Colecao);
            STATMENT.setString(4, Autor);
            STATMENT.setString(5, Editora);
            STATMENT.setInt(6, Quantidade);
            STATMENT.setInt(7, id);
            return !STATMENT.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LivrosDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean deletar(Integer id){
        try{
            String SQL = "DELETE FROM livro WHERE id_livro = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setInt(1, id);
            return !STATMENT.execute();
        } catch (SQLException | ClassNotFoundException ex ){
            if(ex.getMessage().contains("Cannot delete or update a parent row: a foreign key constraint fails")){
                JOptionPane.showMessageDialog(
                    null, 
                    "Este livro está vinculado a um ou mais emprestimos exlua o(s) emprestimo(s) e tente novamente.", 
                    "Erro ao excluir", 
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog
                (
                    null, 
                    "Não foi possivel deletar o livro selecionado tente novamente.", 
                    "Erro ao Deletar", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
            Logger.getLogger(LivrosDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
