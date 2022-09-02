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
public class CreatorCatálogoMedicamentos {
    public CatálogoMedicamentos novoCatálogoMedicamentos(){
        System.out.println("CreatorCatálogoMedicamentos.novoCatálogoMedicamentos()");
        return new CatálogoMedicamentos();
    }
}
