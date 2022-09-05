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
public class CreatorMedicamento {
    public Medicamento novoMedicamento(String nomeMedicamento, String componentes[]){
        System.out.println("CreatorMedicamento.novoMedicamento()");
        return new Medicamento(nomeMedicamento, componentes);
    }
    
    public Medicamento novoMedicamento(){
        System.out.println("CreatorMedicamento.novoMedicamento()");
        return new Medicamento();
    }
}
