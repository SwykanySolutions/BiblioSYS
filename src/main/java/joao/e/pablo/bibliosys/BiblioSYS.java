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
        System.out.println("Hello World!");
        Session.start();
        if(Session.getBoolean("login_status")){
            
        } else {
            Login loginScreen = new Login();
            loginScreen.setVisible(true);
        }
    }
}
