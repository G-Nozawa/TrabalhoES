/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Nozawa
 */
public class Exame implements Serializable{
    private Date data;
    private ArrayList<ItemExame> itensExame;

    public Date getData() {
        return data;
    }
    
    public String imprimirExame(String dataInicial){
        System.out.println("Exame.imprimirExame().");
        String resumo = "Tipo exame: resultado\n";
        if(itensExame.isEmpty()){
            itensExame.add(new ItemExame());
        }
        for(ItemExame itemExame: itensExame){
            resumo += itemExame.imprimirItemExame() + "\n";
        }
        return resumo;
    }
    
    public Exame(){
        this.data = new Date();
        this.itensExame = new ArrayList();
    }
}
