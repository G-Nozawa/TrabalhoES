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
public class CatálogoMedicamentos {
    private ArrayList<Medicamento> medicamentos;
    
    public void carregar(){
        System.out.println("CatálogoMedicamentos.carregar().");
        this.medicamentos = new ArrayList();
    }
    
    public Medicamento buscarMedicamento(String nomeMedicamento){
        System.out.println("CatálogoMedicamentos.buscarMedicamento()");
        for(Medicamento medicamento: medicamentos){
            if(medicamento.buscarMedicamento(nomeMedicamento)!=null){
                return medicamento;
            }
        }
        return null;
    }
    
    public void incluirNovoMedicamento(String nomeMedicamento, String componentes[]){
        System.out.println("CatálogoMedicamentos.incluirNovoMedicamento()");
        CreatorMedicamento creator = new CreatorMedicamento();
        medicamentos.add(creator.novoMedicamento(nomeMedicamento, componentes));
    }

    public CatálogoMedicamentos() {
        System.out.println("CatálogoMedicamentos.novoCatálogo()");
        this.medicamentos = new ArrayList();
    }
}
