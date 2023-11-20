/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joao.e.pablo.bibliosys;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spanp
 */
public class Session {

    private static final Map<String, Object> dadosSessao = new HashMap<>();
    private static Boolean session_status = false;

    private Session() {
        // Construtor privado para evitar a criação de instâncias adicionais
    }
    
    public static void start (){
        session_status = true;
    }
    
    public static void set(String chave, Object valor) {
        if(session_status){            
            dadosSessao.put(chave, valor);
        }
    }
    
    public static void set(String chave, String valor) {
        if(session_status){
            dadosSessao.put(chave, valor);
        }
    }
    
    public static void set(String chave, Integer valor) {
        if(session_status){
            dadosSessao.put(chave, valor);
        }
    }
    
    public static void set(String chave, Boolean valor) {
        if(session_status){
            dadosSessao.put(chave, valor);
        }
    }

    public static Object getObject(String chave) {
        if(session_status){
            return dadosSessao.get(chave);
        }
        return new Object();
    }
    
    public static String getString(String chave) {
        if(session_status){
            return String.valueOf(dadosSessao.get(chave));
        }
        return "";
    }
    
    public static Integer getInteger(String chave) {
        if(session_status){
            return Integer.valueOf(String.valueOf(dadosSessao.get(chave)));
        }
        return 0;
    }
    
    public static Boolean getBoolean(String chave ) {
        if(session_status){
            return Boolean.valueOf(String.valueOf(dadosSessao.get(chave)));
        }
        return false;
    }
    
    public static void remmove(String chave) {
        if(session_status){
            dadosSessao.remove(chave);
        }
    }

    public static void clearSession() {
        if(session_status){
            dadosSessao.clear();
        }
    }
}
