/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package joao.e.pablo.bibliosys;

import java.sql.SQLException;


/**
 *
 * @author spanp
 */
public class BiblioSYS {

    public static void main(String[] args) {
        Session.start();
        if(Session.getBoolean("login_status")){
            FormPainel Painel = new FormPainel();
            Painel.setVisible(true);
        } else {
            FormLogin loginScreen = new FormLogin();
            loginScreen.setVisible(true);
        }
    }
}
