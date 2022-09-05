/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.Serializable;
/**
 *
 * @author Nozawa
 */
public class Secretário extends Funcionário implements Serializable{
    public Secretário autenticarSecretário(String login, String senha){
        System.out.println("Secretário.autenticarSecretário().");
        return this;
    }
}
