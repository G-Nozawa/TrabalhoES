/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.ArrayList;
/**
 *
 * @author Nozawa
 */
public class TerminalConsultas {
    private Clínica clínica;
    private Funcionário usuário;
    private Consulta consulta = null;
    
    public boolean autenticarMédico(String login, String senha){
        System.out.println("\nTerminalConsultas.autenticarMédico().");
        this.usuário = clínica.autenticarMédico(login, senha);
        if(this.usuário == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean autenticarSecretário(String login, String senha){
        System.out.println("\nTerminalConsultas.autenticarSecretário()");
        this.usuário = clínica.autenticarSecretário(login, senha);
        if(this.usuário == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int novaConsulta(String CPF, String nomeMédico, String especialização, String telefoneMédico){
        System.out.println("\nTerminalConsultas.novaConsulta().");
        return clínica.novaConsulta(CPF, nomeMédico, especialização, telefoneMédico);
    }
    
    public void diagnosticar(String nomeDoença, String observações){
        System.out.println("\nTerminalConsultas.diagnosticar()");
        this.consulta.diagnosticar(nomeDoença, observações);
    }
    
    public void finalizarConsulta(){
        System.out.println("\nTerminalConsultas.finalizarConsulta()");
        this.consulta.finalizar();
    }
    
    public int receitarMedicamento(String nomeMedicamento, String descrição, String validade){
        System.out.println("\nTerminalConsultas.receitarMedicamento().");
        CatálogoMedicamentos catálogoMedicamentos = clínica.getCatálogo();
        Medicamento m = catálogoMedicamentos.buscarMedicamento(nomeMedicamento);
        if(m != null){
            Paciente paciente = consulta.getPaciente();
            boolean alergico = paciente.verificarAlergia(m);
            if(alergico == false){
                this.consulta.incluirReceita(m, descrição, validade);
                return 0;
            }else{
                return 2;
            }
        }else{
            return 1;
        }
    }
    
    public String exibirAlergias(){
        System.out.println("\nTerminalConsultas.exibirAlergias()");
        Paciente paciente = consulta.getPaciente();
        return paciente.exibirAlergias();
    }
    
    public String exibirExames(String dataInicial){
        System.out.println("\nTerminalConsultas.exibirExames()");
        Paciente paciente = consulta.getPaciente();
        return paciente.exibirExames(dataInicial);
    }
    
    public boolean adicionarAlergia(String nomeMedicamento){
        System.out.println("\nTerminalConsultas.adicionarAlergia()");
        CatálogoMedicamentos catálogoMedicamentos = clínica.getCatálogo();
        Medicamento m = catálogoMedicamentos.buscarMedicamento(nomeMedicamento);
        if(m == null){
            return false;
        }
        Paciente p = consulta.getPaciente();
        p.adicionarAlergia(m);
        return true;
    }

    public String exibirMedicamentosAlternativos(){
        System.out.println("\nTerminalConsultas.exibirMedicamentosAlternativos().");
        String doença = this.consulta.getDoença();
        ArrayList<Medicamento> m = new ArrayList();
        for(Consulta consulta :clínica.getConsultas()){
            if(consulta.getDoença().equals(doença)){
                m.addAll(consulta.medicamentosReceitados());
            }
        }
        Paciente p = this.consulta.getPaciente();
        String resumo = p.filtrarMedicamentosNãoAlérgicos(m);
        return resumo;
    }
    
    public void novoPaciente(String CPF, String nome, String aniversario, String endereco, String telefone){
        System.out.println("\nTerminalConsultas.novoPaciente().");
        clínica.novoPaciente(CPF, nome, aniversario, endereco, telefone);
    }
    
    public void novoMedicamento(String nomeMedicamento, String[] componentes){
        System.out.println("\nTerminalConsultas.novoMedicamento().");
        CatálogoMedicamentos catálogo = this.clínica.getCatálogo();
        catálogo.incluirNovoMedicamento(nomeMedicamento, componentes);
    }
    
    public void setClínica(Clínica clínica) {
        System.out.println("TerminalConsultas.setClínica().");
        this.clínica = clínica;
    }
    
    public boolean próximaConsulta(){
        System.out.println("\nTerminalConsultas.próximaConsulta().");
        this.consulta = clínica.próximaConsulta(((Médico) this.usuário));
        if(this.consulta == null){
            return false;
        }else{
            return true;
        }
    }
    
    public String exibirReceitasVálidas(){
        System.out.println("\nTerminalConsultas.exibirReceitasVálidas().");
        String resumo = "";
        Paciente p = this.consulta.getPaciente();
        for(Consulta consulta :clínica.getConsultas()){
            resumo += consulta.receitasVálidas(p);
        }
        return resumo;
    }
    
    public String exibirHistóricoPaciente(){
        System.out.println("\nTerminalConsultas.exibirHistóricoPaciente().");
        Paciente p = this.consulta.getPaciente();
        String resumo = clínica.históricoPaciente(p);
        return resumo;
    }
    
    public String doençasComMaiorNúmeroDeCasos(String dataInicial){
        System.out.println("\nTerminalConsultas.doençasComMaiorNúmeroDeCasos().");
        return clínica.doençasMaisComuns(dataInicial);
    }
}
