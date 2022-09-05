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
public class CreatorReceita {
    public Receita novaReceita(Medicamento medicamento, String descrição, String validade){
        System.out.println("CreatorReceita.novaReceita().");
        Date data;
        try{
            data = new SimpleDateFormat("dd/MM/yyyy").parse(validade);
        }catch(ParseException e){
            data = new Date();
        }
        return new Receita(medicamento, descrição, data);
    }
}
