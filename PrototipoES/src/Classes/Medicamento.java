/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Nozawa
 */
public class Medicamento implements Serializable{
    private String nome;
    private ArrayList<String> componentes;
    
    public String getNome(){
        System.out.println("Medicamento.getNome().");
        return nome;
    }
    
    public ArrayList<String> getComponentes(){
        System.out.println("Medicamento.getComponentes().");
        return componentes;
    }
    
    public Medicamento buscarMedicamento(String nomeMedicamento){
        System.out.println("Medicamento.buscarMedicamento().");
        if(nomeMedicamento.equals(nome)){
            return this;
        }
        return null;
    }
    
    public Medicamento(String nome, String[] componentes){
        System.out.println("Medicamento.novoMedicamento().");
        this.nome = nome;
        this.componentes = new ArrayList();
        for(String componente:componentes){
            this.componentes.add(componente);
        }
    }

    public Medicamento() {
        System.out.println("Medicamento.novoMedicamento().");
    }
}
