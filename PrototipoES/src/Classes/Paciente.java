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
public class Paciente implements Serializable{
    private String CPF;
    private String nome;
    private Date aniversário;
    private String endereço;
    private String telefone;
    private ArrayList<Exame> exames;
    private ArrayList<Medicamento> alergias;
    
    public Paciente(){
        System.out.println("Paciente.novoPaciente().");
        this.CPF = "";
        this.nome = "";
        this.aniversário = new Date();
        this.endereço = "";
        this.telefone = "";
        this.exames = new ArrayList();
        this.alergias = new ArrayList();
    }
    
    public Paciente(String CPF, String nomePaciente, Date aniversário, String endereço, String telefonePaciente){
        System.out.println("Paciente.novoPaciente().");
        this.CPF = CPF;
        this.nome = nomePaciente;
        this.aniversário = aniversário;
        this.endereço = endereço;
        this.telefone = telefonePaciente;
        this.exames = new ArrayList();
        this.alergias = new ArrayList();
    }
    
    public boolean verificarAlergia(Medicamento m){
        System.out.println("Paciente.verificarAlergia()");
        ArrayList<String> componentesAlergicos = new ArrayList();
        for(Medicamento medicamento: alergias){
            componentesAlergicos.addAll(medicamento.getComponentes());
        }
        for(String componente: m.getComponentes()){
            if(componentesAlergicos.contains(componente)){
                return true;
            }
        }
        return false;
    }
    
    public void adicionarAlergia(Medicamento m){
        System.out.println("Paciente.adicionarAlergia()");
        alergias.add(m);
    }

    public Paciente buscarPaciente(String CPF){
        System.out.println("Paciente.buscarPaciente()");
        if(this.CPF.equals(CPF)){
            return this;
        }
        return null;
    }

    public String exibirAlergias(){
        System.out.println("Paciente.exibirAlergias()");
        String resumo = "";
        for(Medicamento medicamento: alergias){
            resumo += medicamento.getNome();
        }
        return resumo;
    }
    
    public String exibirExames(String dataInicial){
        System.out.println("Paciente.exibirExames().");
        String resumo = "";
        if(exames.isEmpty()){
            exames.add(new Exame());
        }
        for(Exame exame: exames){
            exame.getData();
            resumo += "Exame: \n"+exame.imprimirExame(dataInicial);
        }
        return resumo;
    }
    
    public String[] dadosPaciente(){
        System.out.println("Paciente.dadosPaciente().");
        String[] resumo = new String[] {this.nome, this.endereço};
        return resumo;
    }
    
    public String filtrarMedicamentosNãoAlérgicos(ArrayList<Medicamento> medicamentos){
        System.out.println("Paciente.filtrarMedicamentosNãoAlérgicos().");
        String resumo = "";
        for(Medicamento m:medicamentos){
            if(this.verificarAlergia(m) == false){
                resumo += m.getNome();
            }
        }
        return resumo;
    }
}
