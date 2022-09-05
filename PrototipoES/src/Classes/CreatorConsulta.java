/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Nozawa
 */
public class CreatorConsulta {
    public Consulta novaConsulta(Médico médico, Paciente paciente){
        System.out.println("CreatorConsulta.novaConsulta().");
        return new Consulta(médico, paciente);
    }
}
