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
public class Médico extends Funcionário implements Serializable{
    private String nome;
    private String especialização;
    private String telefone;
    
    public Médico buscarMédico(String nome, String especialização, String telefone){
        System.out.println("Médico.buscarMédico()");
        return this;
    }
    
    public Médico autenticarMédico(String login, String senha){
        System.out.println("Médico.autenticarMédico().");
        return this;
    }
    
    public String getNome() {
        return nome;
    }
}
