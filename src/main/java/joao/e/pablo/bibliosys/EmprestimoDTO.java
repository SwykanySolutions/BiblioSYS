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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spanp
 */
public class EmprestimoDTO {
    
    public static void cadastrar(
            Integer id_pessoa, 
            Integer id_livro, 
            Date data_retirada, 
            Date data_devolucao, 
            Integer status, 
            Integer quantidade
    ){
        
        try {
            String SQL = "INSERT INTO emprestimo ( id_pessoa, id_livro, data_retirada, data_devolucao, status, quantidade ) VALUES ( ?, ?, ?, ?, ?, ? )";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setInt(1, id_pessoa);
            STATMENT.setInt(2, id_livro);
            STATMENT.setDate(3, data_retirada);
            STATMENT.setDate(4, data_devolucao);
            STATMENT.setInt(5, status);
            STATMENT.setInt(6, quantidade);
            STATMENT.execute();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmprestimoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
    
    public static String All() throws SQLException, ClassNotFoundException{
        try{
            String SQL_SELECT = "SELECT * FROM emprestimo ",          
            SQL_SELECT_NOME_PESSOA = "SELECT * FROM pessoa WHERE id_pessoa = ? ",
            SQL_SELECT_NOME_LIVRO = "SELECT * FROM livro WHERE id_livro = ?";

            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT_SELECT = conn.prepareStatement(SQL_SELECT),
            STATMENT_SELECT_NOME_PESSOA = conn.prepareStatement(SQL_SELECT_NOME_PESSOA),
            STATMENT_SELECT_NOME_LIVRO = conn.prepareStatement(SQL_SELECT_NOME_LIVRO);
            ResultSet RESULT_SET = STATMENT_SELECT.executeQuery();
            String todos_os_emprestimos = "",
            PARAM_ITEMS_COLS = " :: ",
            PARAM_ITEMS_END = ";";
            
            while(RESULT_SET.next()){ 
               todos_os_emprestimos += RESULT_SET.getString("id_emprestimo") + PARAM_ITEMS_COLS;
               STATMENT_SELECT_NOME_PESSOA.setInt(1, RESULT_SET.getInt("id_pessoa"));
               ResultSet RESULT_SET_NOME_PESSOA = STATMENT_SELECT_NOME_PESSOA.executeQuery();
               while(RESULT_SET_NOME_PESSOA.next()){
                   todos_os_emprestimos += RESULT_SET_NOME_PESSOA.getNString("nome_completo") + PARAM_ITEMS_COLS;
               }
               STATMENT_SELECT_NOME_LIVRO.setInt(1, RESULT_SET.getInt("id_livro"));
               ResultSet RESULT_SET_NOME_LIVRO = STATMENT_SELECT_NOME_LIVRO.executeQuery();
               while(RESULT_SET_NOME_LIVRO.next()){
                   todos_os_emprestimos += RESULT_SET_NOME_LIVRO.getNString("nome") + PARAM_ITEMS_END;
               }
            }
            return todos_os_emprestimos;
        } catch ( ClassNotFoundException | SQLException error ) {
            throw error;
        }
    }
    
    public static Object[] getAlldata( Integer id_emrpestimo ){
        try {
            String SQL = "SELECT * FROM emprestimo WHERE id_emprestimo = ?",
            SQL_NOME_PESSOA = "SELECT * FROM pessoa WHERE id_pessoa = ?",
            SQL_NOME_LIVRO = "SELECT * FROM livro WHERE id_livro = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL),
            STATMENT_NOME_PESSOA = conn.prepareStatement(SQL_NOME_PESSOA),
            STATMENT_NOME_LIVRO = conn.prepareStatement(SQL_NOME_LIVRO);
            Object[] retorno = new Object[6];
            STATMENT.setInt(1, id_emrpestimo);
            ResultSet RESULT_SET = STATMENT.executeQuery();
            String Pessoa = null,
            Livro = null;
            while(RESULT_SET.next()){
                STATMENT_NOME_PESSOA.setInt(1, RESULT_SET.getInt("id_pessoa"));
                ResultSet RESULT_SET_NOME_PESSOA = STATMENT_NOME_PESSOA.executeQuery();
                while(RESULT_SET_NOME_PESSOA.next()){
                    Pessoa = RESULT_SET.getInt("id_pessoa") + " :: " + RESULT_SET_NOME_PESSOA.getString("nome_completo");
                }
                STATMENT_NOME_LIVRO.setInt(1, RESULT_SET.getInt("id_livro"));
                ResultSet RESULT_SET_NOME_LIVRO = STATMENT_NOME_LIVRO.executeQuery();
                while(RESULT_SET_NOME_LIVRO.next()){
                    Livro = RESULT_SET.getInt("id_livro") + " :: " + RESULT_SET_NOME_LIVRO.getString("nome");
                }
                retorno[0] = Pessoa;
                retorno[1] = Livro;
                retorno[2] = RESULT_SET.getDate("data_retirada");
                retorno[3] = RESULT_SET.getDate("data_devolucao");
                retorno[4] = RESULT_SET.getInt("status");
                retorno[5] = RESULT_SET.getInt("quantidade");
            }
            return retorno;
        } catch (SQLException | ClassNotFoundException ex) {
            Object[] erro = new Object[1];
            erro[0] = false;
            return erro;
        }
        
    }
    
    public static boolean validarExistencia(){
        try {
            return
                Conexao.Conectar()
                .prepareStatement("SELECT * FROM emprestimo")
                .executeQuery()
                .next();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmprestimoDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static Integer verificarPossibilidade(){
        try {
            Boolean statusPessoa = PessoaDTO.validarExistencia();            
            Boolean statusRegistro = PessoaDTO.validarExistencia();
            if(!statusPessoa){
                return 0;
            }
            if(!statusRegistro){
                return 1;
            }
            return 2;
            
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }
    }

    public static boolean atualizar 
    ( 
        Integer id, 
        Integer Id_Pessoa,
        Integer Id_Livro,
        Date Data_Retirada,
        Date Data_Devolucao,
        Integer Status,
        Integer Quantidade 
    )
    {
        try {
            String SQL = "UPDATE emprestimo SET id_pessoa = ?, id_livro = ?, data_retirada = ?, data_devolucao = ?, status = ?, quantidade = ? WHERE id_emprestimo = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setInt(1, Id_Pessoa);
            STATMENT.setInt(2, Id_Livro);
            STATMENT.setDate(3, Data_Retirada);
            STATMENT.setDate(4, Data_Devolucao);
            STATMENT.setInt(5, Status);
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
            String SQL = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
            Connection conn = Conexao.Conectar();
            PreparedStatement STATMENT = conn.prepareStatement(SQL);
            STATMENT.setInt(1, id);
            return !STATMENT.execute();
        } catch (SQLException | ClassNotFoundException ex ){
            Logger.getLogger(LivrosDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}