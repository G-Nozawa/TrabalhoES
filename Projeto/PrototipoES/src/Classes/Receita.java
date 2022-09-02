/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Nozawa
 */
public class Receita implements Serializable{
    private Medicamento medicamento;
    private Date validade;
    private String descrição;
    
    public Receita(Medicamento medicamento, String descrição, Date validade) {
        System.out.println("Receita.novaReceita().");
        this.medicamento = medicamento;
        this.descrição = descrição;
        this.validade = validade;
    }

    public Receita() {
        System.out.println("Receita.novaReceita().");
    }
    
    public Medicamento getMedicamento() {
        System.out.println("Receita.getMedicamento().");
        return medicamento;
    }
    
    public String imprimirReceita(){
        System.out.println("Receita.imprimirReceita().");
        String resumo = "Medicamento: " + this.medicamento.getNome() + "\n";
        resumo += "Validade: " + this.validade.toString() + "\n";
        resumo += "Descrição: " + this.descrição + "\n";
        return resumo;
    }
}
