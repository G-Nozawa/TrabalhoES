/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.Serializable;
/**
 *
 * @author Nozawa
 */
public class ItemExame implements Serializable{
    private String nomeItem;
    private String resultado;
    
    public String imprimirItemExame(){
        System.out.println("ItemExame.imprimirItemExame().");
        return nomeItem + " " + resultado;
    }
}
