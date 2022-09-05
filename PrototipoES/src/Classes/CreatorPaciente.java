/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Nozawa
 */
public class CreatorPaciente {
    public Paciente novoPaciente(String CPF, String nomePaciente, String aniversário, String endereço, String telefonePaciente){
        System.out.println("CreatorPaciente.novoPaciente()");
        Date data;
        try{
            data = new SimpleDateFormat("dd/MM/yyyy").parse(aniversário);
        }catch(ParseException e){
            data = new Date();
        }
        return new Paciente(CPF, nomePaciente, data, endereço, telefonePaciente);
    }
    
    public Paciente novoPaciente(){
        System.out.println("CreatorPaciente.novoPaciente()");
        return new Paciente();
    }
}
