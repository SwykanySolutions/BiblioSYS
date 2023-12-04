/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author spanp
 */
public class FormRegistro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public FormRegistro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LabelNomeCompleto = new javax.swing.JLabel();
        InputNomeCompleto = new javax.swing.JTextField();
        LabelDataDeNascimento = new javax.swing.JLabel();
        InputDataDeNascimento = new com.toedter.calendar.JDateChooser();
        LabelCpf = new javax.swing.JLabel();
        InputCpf = new javax.swing.JFormattedTextField();
        LabelTelefone = new javax.swing.JLabel();
        InputTelefone = new javax.swing.JFormattedTextField();
        LabelUsuario = new javax.swing.JLabel();
        InputUsuario = new javax.swing.JTextField();
        LabelTipo = new javax.swing.JLabel();
        SelectTipo = new javax.swing.JComboBox<>();
        LabelEndereco = new javax.swing.JLabel();
        InputEndereco = new javax.swing.JTextField();
        LabelNumero = new javax.swing.JLabel();
        InputNumero = new javax.swing.JFormattedTextField();
        LabelBairro = new javax.swing.JLabel();
        InputBairro = new javax.swing.JTextField();
        LabelComplemento = new javax.swing.JLabel();
        InputComplemento = new javax.swing.JTextField();
        LabelNivel = new javax.swing.JLabel();
        SelectNivel = new javax.swing.JComboBox<>();
        LabelEmail = new javax.swing.JLabel();
        InputEmail = new javax.swing.JTextField();
        LabelConfirmaEmail = new javax.swing.JLabel();
        InputConfirmaEmail = new javax.swing.JTextField();
        LabelSenha = new javax.swing.JLabel();
        InputSenha = new javax.swing.JPasswordField();
        LabelConfirmaSenha = new javax.swing.JLabel();
        InputConfirmaSenha = new javax.swing.JPasswordField();
        ButtonCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Faça o registro do usuário");

        LabelNomeCompleto.setText("Nome Completo");

        LabelDataDeNascimento.setText("Data de nascimento");

        InputDataDeNascimento.setDateFormatString("dd/MM/y");

        LabelCpf.setText("Cpf");

        try {
            InputCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        LabelTelefone.setText("Telefone");

        try {
            InputTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        LabelUsuario.setText("Usuario");

        LabelTipo.setText("Tipo");

        SelectTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo de endereço", "Rua", "Avenida", "Estrada" }));

        LabelEndereco.setText("Endereço");

        LabelNumero.setText("Nº");

        InputNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####"))));
        InputNumero.setActionCommand("<Not Set>");
        InputNumero.setMinimumSize(new java.awt.Dimension(80, 22));

        LabelBairro.setText("Bairro");

        LabelComplemento.setText("Complemento");

        LabelNivel.setText("Nível");

        SelectNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um nível de usuário", "Usuário", "Administrador" }));

        LabelEmail.setText("Email");

        LabelConfirmaEmail.setText("Confirma Email");

        LabelSenha.setText("Senha");

        LabelConfirmaSenha.setText("Confirma Senha");

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelUsuario)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelBairro)
                                .addComponent(InputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelComplemento))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNivel)
                                    .addComponent(SelectNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelEndereco)
                                    .addComponent(InputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelNumero))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelTipo)
                                    .addComponent(SelectTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNomeCompleto)
                                    .addComponent(InputNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDataDeNascimento)
                                    .addComponent(InputDataDeNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(LabelEmail)
                            .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelSenha)
                            .addComponent(InputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelConfirmaSenha)
                            .addComponent(InputConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelTelefone)
                                    .addComponent(InputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelCpf)))
                            .addComponent(LabelConfirmaEmail)
                            .addComponent(InputConfirmaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(ButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelNomeCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelDataDeNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTelefone)
                            .addComponent(LabelCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(LabelEndereco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(InputEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(LabelUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(InputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNumero)
                            .addComponent(LabelTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SelectTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNivel)
                                    .addComponent(LabelComplemento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SelectNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InputComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LabelBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(LabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelConfirmaEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputConfirmaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelConfirmaSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ButtonCadastrar))
        );

        jLabel2.setText("Ja é cadstrado? Faça o Login");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCadastrarMouseClicked
        try {                                             
            // TODO add your handling code here:
            if(!ValidarCampos()){
                return;
            }
            String tipo = "";
            Integer index_tipo = SelectTipo.getSelectedIndex();
            switch(index_tipo){
                case 1 -> tipo = "Rua";
                case 2 -> tipo = "Avenida";
                case 3 -> tipo = "Estrada";
                default -> {
                }
            }
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String data = format.format(InputDataDeNascimento.getDate());
            Date data_de_nascimento = Date.valueOf(data);
            
            Integer numero = Integer.valueOf(InputNumero.getText()),
            nivel = SelectNivel.getSelectedIndex();
            
            String nome_completo = InputNomeCompleto.getText(),
            telefone = InputTelefone.getText(),
            cpf = InputCpf.getText(),
            usuario = InputUsuario.getText(),
            endereco = InputEndereco.getText(),
            bairro = InputBairro.getText(),
            complemento = InputComplemento.getText(),
            email = InputEmail.getText(),
            senha = String.valueOf(InputSenha.getPassword());
            
            if(UsuarioDTO.VerificarCPF(cpf)){
                JOptionPane.showMessageDialog(null, 
                    "O cpf já existe por favor informe um cpf que não exista", 
                    "Erro a cadastrar usuário", 
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            UsuarioDTO.Cadastrar(nome_completo, data_de_nascimento, telefone, cpf, usuario, endereco, tipo, numero, bairro, complemento, email, senha, nivel);
            JOptionPane.showMessageDialog(
                null, 
                "Usuário cadastrado com sucesso", 
                "Sucesso no Cadastro", 
                JOptionPane.INFORMATION_MESSAGE);
            FormLogin formLogin = new FormLogin();
            formLogin.setVisible(true);
            this.close();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                "Ocorreu um erro ao cadastrar o usuário.\n Aguarde alguns minutos e tente novamente.\n Ou entre em contato com o suporte", 
                "Erro ao cadastrar o usuário",  
                JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonCadastrarMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        FormLogin formLogin = new FormLogin();
        formLogin.setVisible(true);
        this.close();
    }//GEN-LAST:event_jLabel2MouseClicked
    
    private boolean ValidarCampos() throws ClassNotFoundException, SQLException{
        if(InputNomeCompleto.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Nome Completo não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputNomeCompleto.requestFocus();
            return false;
        }
        if(InputDataDeNascimento.getDate() == null){
            JOptionPane.showMessageDialog(
                null, 
                "O campo Data de nascimento não pode ser vázio", 
                "Erro ao cadastrar usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            InputDataDeNascimento.requestFocus();
            return false;
        }
        if(!InputTelefone.getText().matches("\\([1-9]{2}\\) 9[7-9]{1}[0-9]{3}\\-[0-9]{4}$")){
            JOptionPane.showMessageDialog(
                null, 
                "O campo Telefone está inválido", 
                "Erro ao cadastrar usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            InputTelefone.requestFocus();
            return false;
        }
        if(InputCpf.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Cpf não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputCpf.requestFocus();
            return false;
        }
        if(!InputCpf.getText().matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")){
            JOptionPane.showMessageDialog(null, "O campo cpf está inválido", "Erro ao cadastrar o usuário", JOptionPane.ERROR_MESSAGE);
            InputCpf.requestFocus();
            return false;
        }
        if(InputUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Usuário não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputUsuario.requestFocus();
            return false;
        }
        if(InputEndereco.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Endereço não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputEndereco.requestFocus();
            return false;
        }
        if(SelectTipo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Voê deve selecionar um tipo de endereço válido", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            SelectTipo.requestFocus();
            return false;
        }
        if(InputNumero.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Número não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputNumero.requestFocus();
            return false;
        }
        if(InputBairro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Bairro não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputBairro.requestFocus();
            return false;
        }
        if(InputComplemento.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Complemento não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputComplemento.requestFocus();
            return false;
        }
        if(InputEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Email não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputEmail.requestFocus();
            return false;
        }
        
        if(InputConfirmaEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Confirma Email não pode ser vázio", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputConfirmaEmail.requestFocus();
            return false;
        }
        if(String.valueOf(InputSenha.getPassword()).equals("")){
            JOptionPane.showMessageDialog(
                null, "O campo Senha não pode ser vázio", 
                "Erro ao cadastrar usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            InputSenha.requestFocus();
            return false;
        }
        if(String.valueOf(InputConfirmaSenha.getPassword()).equals("")){
            JOptionPane.showMessageDialog(null, 
                "O campo Nome Completo não pode ser vázio", 
                "Erro ao cadastrar usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            InputConfirmaSenha.requestFocus();
            return false;
        }
        
        String Cpf = InputCpf.getText(),
        usuario = InputUsuario.getText(),
        email = InputEmail.getText(),
        confirma_email = InputConfirmaEmail.getText(),
        senha = String.valueOf(InputSenha.getPassword()),
        confirma_senha = String.valueOf(InputConfirmaSenha.getPassword());
        if(!FormRegistro.validarEmail(email)){
            String Message_Erro_Email_Invalido = "o email "+email+" não é válido";
            JOptionPane.showMessageDialog(
                null, 
                Message_Erro_Email_Invalido,
                "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputEmail.requestFocus();
            return false;
        }
        if(!FormRegistro.validarEmail(confirma_email)){
            JOptionPane.showMessageDialog(null, "o email de confirmação  "+ confirma_email + " não é válido", "Erro ao cadastrar usuário", JOptionPane.ERROR_MESSAGE);
            InputConfirmaEmail.requestFocus();
            return false;
        }
        if(!email.equals(confirma_email)){
            String Message_Erro_Emails_Divergentes = "os emails "+ email + " e "+ confirma_email + " estão divergentes por favor corrija-os";
            JOptionPane.showMessageDialog(
                null, 
                Message_Erro_Emails_Divergentes,
                "Erro ao cadastrar usuário",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if(!senha.equals(confirma_senha)){
            String Message_Erro_Senhas_Divergentes = "as senhas" + senha +  " e " + confirma_senha + " estão divergentes por favor corrija-as";
            JOptionPane.showMessageDialog(
                null, 
                Message_Erro_Senhas_Divergentes, 
                "Erro ao cadastrar usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        try{
            if(UsuarioDTO.VerificarCPF(Cpf)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Erro o cpf informado já está cadastrado no sistema", 
                    "Erro de cadastro de usuário", 
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
            if (UsuarioDTO.VerificarEMAIL(email)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Erro o email informado já está cadastrado no sistema", 
                    "Erro de cadastro de usuário", 
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
            if(UsuarioDTO.VerificarUSERNAME(usuario)){
                JOptionPane.showMessageDialog(
                    null, 
                    "Erro o usuário já está cadastrado no sistema", 
                    "Erro de cadastro de usuário", 
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
            return true;
        } catch (ClassNotFoundException | SQLException error) {
            JOptionPane.showMessageDialog(
                null, 
                "Erro o email já está cadastrado no sistema", 
                "Erro de cadastro de usuário", 
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }
   
    public static boolean validarEmail(String email){
        return EmailValidator.getInstance()
      .isValid(email);
    }
    
    public void close () {
        this.setVisible(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegistro().setVisible(true); 
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JTextField InputBairro;
    private javax.swing.JTextField InputComplemento;
    private javax.swing.JTextField InputConfirmaEmail;
    private javax.swing.JPasswordField InputConfirmaSenha;
    private javax.swing.JFormattedTextField InputCpf;
    private com.toedter.calendar.JDateChooser InputDataDeNascimento;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputEndereco;
    private javax.swing.JTextField InputNomeCompleto;
    private javax.swing.JFormattedTextField InputNumero;
    private javax.swing.JPasswordField InputSenha;
    private javax.swing.JFormattedTextField InputTelefone;
    private javax.swing.JTextField InputUsuario;
    private javax.swing.JLabel LabelBairro;
    private javax.swing.JLabel LabelComplemento;
    private javax.swing.JLabel LabelConfirmaEmail;
    private javax.swing.JLabel LabelConfirmaSenha;
    private javax.swing.JLabel LabelCpf;
    private javax.swing.JLabel LabelDataDeNascimento;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelEndereco;
    private javax.swing.JLabel LabelNivel;
    private javax.swing.JLabel LabelNomeCompleto;
    private javax.swing.JLabel LabelNumero;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelTelefone;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JComboBox<String> SelectNivel;
    private javax.swing.JComboBox<String> SelectTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
