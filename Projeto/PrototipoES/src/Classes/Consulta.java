/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Nozawa
 */
public class Consulta implements Serializable{
    private Paciente paciente;
    private Médico médico;
    private Date data;
    private String doença;
    private String observações;
    private ArrayList<Receita> receitas;
    private boolean finalizada;
    
    public Consulta próximaConsulta(Médico m){
        System.out.println("Consulta.próximaConsulta()");
        if(this.finalizada == false){
            return this;
        }
        return null;
    }
    
    public void diagnosticar(String doença, String observações){
        System.out.println("Consulta.diagnosticar()");
        this.doença = doença;
        this.observações = observações;
    }
    
    public void incluirReceita(Medicamento m, String descrição, String validade){
        System.out.println("Consulta.incluirReceita()");
        CreatorReceita creator = new CreatorReceita();
        receitas.add(creator.novaReceita(m, descrição, validade));
    }
    
    public void finalizar(){
        System.out.println("Consulta.finalizar()");
        this.finalizada = true;
    }

    public String getDoença() {
        System.out.println("Consulta.getDoenca()");
        return doença;
    }
    
    public String doençaDiagnosticada(String dataInicial) {
        System.out.println("Consulta.doençaDiagnostica()");
        return doença;
    }
    
    public Paciente getPaciente() {
        System.out.println("Consulta.getPaciente()");
        return paciente;
    }
    
    public String receitasVálidas(Paciente p){
        System.out.println("Consulta.receitasVálidas().");
        String resumo = "";
        if(this.paciente.equals(p)){
            for(Receita receita: receitas){
                resumo += receita.imprimirReceita();
            }
        }
        return resumo;
    }    
    
    public String históricoPaciente(Paciente p){
        System.out.println("Consulta.históricoPaciente().");
        if(this.paciente.equals(p)){
            String resumo = "Data: " + this.data.toString() + "\n";
            resumo += "Doença diagnosticada: " + this.doença + "\n";
            resumo += "Médico: " + this.médico.getNome() + "\n";
            resumo += "Receitas: " + "\n";
            if(this.paciente.equals(p)){
                for(Receita receita: receitas){
                    resumo += receita.imprimirReceita();
                }
            }
            return resumo;
        }
        return "";
    }   
    
    public ArrayList<Medicamento> medicamentosParaDoença(String doença){
        System.out.println("Consulta.medicamentosParaDoença()");
        ArrayList<Medicamento> m = new ArrayList();
        if(this.doença.equals(doença)){
            for(Receita receita: receitas){
                m.add(receita.getMedicamento());
            }
        }
        return m;
    }
    
    public Consulta(Médico médico, Paciente paciente) {
        System.out.println("Consulta.novaConsulta()");
        this.paciente = paciente;
        this.médico = médico;
        this.finalizada = false;
        this.receitas = new ArrayList();
        this.data = new Date();
    }
}
