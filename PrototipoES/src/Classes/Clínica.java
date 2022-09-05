/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Nozawa
 */
public class Clínica {
    String nome;
    Date dataDeAbertura;
    private ArrayList<Funcionário> funcionários;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Consulta> consultas;
    private CatálogoMedicamentos catálogo;
    
    public Médico autenticarMédico(String login, String senha){
        System.out.println("Clínica.autenticarMédico()");
        for(Funcionário usuário: funcionários){
            if(usuário instanceof Médico){
                if(((Médico)usuário).autenticarMédico(login, senha) != null)
                    return ((Médico)usuário);
            }
        }
        return null;
    }
    
    public Secretário autenticarSecretário(String login, String senha){
        System.out.println("Clínica.autenticarSecretário().");
        for(Funcionário usuário: funcionários){
            if(usuário instanceof Secretário){
                if(((Secretário)usuário).autenticarSecretário(login, senha) != null)
                    return ((Secretário)usuário);
            }
        }
        return null;
    }
    
    public int novaConsulta(String CPF, String nomeMédico, String especialização, String telefoneMédico){
        System.out.println("Clínica.novaConsulta().");
        Paciente p = null;
        Médico m = null;
        for(Paciente paciente: pacientes){
            if(paciente.buscarPaciente(CPF) != null){
                p = paciente;
                break;
            }
        }
        if(p == null){
            return 1;
        }
        for(Funcionário médico: funcionários){
            if(médico instanceof Médico){
                if(((Médico) médico).buscarMédico(nomeMédico, especialização, telefoneMédico) != null){
                    m = ((Médico) médico);
                    break;
                }
            }
        }
        if(m == null){
            return 2;
        }
        CreatorConsulta creator = new CreatorConsulta();
        consultas.add(creator.novaConsulta(m, p));
        return 0;
    }
    
    public void novoPaciente(String CPF, String nome, String aniversario, String endereco, String telefone){
        System.out.println("Clínica.novoPaciente().");
        CreatorPaciente creator = new CreatorPaciente();
        this.pacientes.add(creator.novoPaciente(CPF, nome, aniversario, endereco, telefone));
    }

    public Consulta próximaConsulta(Médico médico){
        System.out.println("Clínica.próximaConsulta().");
        for(Consulta consulta : consultas){
            if(consulta.próximaConsulta(médico) != null){
                return consulta;
            }
        }
        return null;
    }
    
    public String históricoPaciente(Paciente paciente){
        System.out.println("Clínica.históricoPaciente().");
        String resumo = "";
        for(Consulta consulta : consultas){
            if(consulta.getPaciente().equals(paciente)){
                resumo += consulta.históricoPaciente(paciente);
            }
        }
        return resumo;
    }
    
    public String doençasMaisComuns(String dataInicial){
        System.out.println("Clínica.doençasMaisComuns().");
        String resumo = "";
        Date data;
        try{
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
        }catch(ParseException e){
            data = new Date();
        }
        for(Consulta consulta : consultas){
            if(consulta.getData().after(data)){
                resumo += consulta.getDoença();
            }
        }
        return resumo;
    }
    
    public CatálogoMedicamentos getCatálogo() {
        System.out.println("Clínica.getCatálogo().");
        return catálogo;
    }

    public ArrayList<Consulta> getConsultas() {
        System.out.println("Clínica.getConsultas().");
        return consultas;
    }
    
    public TerminalConsultas iniciar(){
        System.out.println("Clínica.iniciar().");
        CreatorCatálogoMedicamentos creator = new CreatorCatálogoMedicamentos();
        this.catálogo = creator.novoCatálogoMedicamentos();
        this.carregarPaciente();
        this.carregarFuncionários();
        this.carregarConsulta();
        catálogo.carregar();
        TerminalConsultas terminal = new TerminalConsultas();
        terminal.setClínica(this);
        return terminal;
    }
    
    public void carregarFuncionários(){
        funcionários = new ArrayList();
        System.out.println("Clínica.carregarFuncionários().");
        Médico médico = new Médico();
        funcionários.add(médico);
        Secretário secretário = new Secretário();
        funcionários.add(secretário);
    }
    
    public void carregarConsulta(){
        consultas = new ArrayList();
        System.out.println("Clínica.carregarConsulta().");
    }
    
    public void carregarPaciente(){
        pacientes = new ArrayList();
        System.out.println("Clínica.carregarPaciente().");
    }
}
