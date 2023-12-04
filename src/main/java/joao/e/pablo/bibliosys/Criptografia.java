/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author spanp
 */
public class Criptografia {
    public static String Criptografar(String data){
        return BCrypt.hashpw(data, BCrypt.gensalt());
    }
    
    public static Boolean ValidarHash(String hash, String data){
        return BCrypt.checkpw(data, hash);
    }
}
