/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testestringautomatica;

import java.util.Random;

/**
 *
 * @author Yuri Domingos 
 * Data   :  14 - 01 - 2021
 * Objectivo : Gerar String 
 */
public class TesteStringAutomatica {

    
        public static String gerarString(int tamanho, String letras)
        { 
            Random random = new Random(); 
            StringBuilder out_put = new StringBuilder();
            
            for (int i = 0; i < tamanho; i++)
            { 
               out_put.append(letras.charAt(random.nextInt(letras.length()))); 
             }
            return out_put.toString();
        
        }
    public static void main(String[] args) {
      
        
        String texto = gerarString(6, "ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxyz");
        System.out.println(texto);
    }
    
}
