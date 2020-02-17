
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajan_gp8cx31
 */
public class isValidDate {
    
    public static boolean validdate(String date)
    {
    
    SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                 Date d=f.parse(date);
                
                 
            } catch (ParseException ex) {
                return false;
               
            }
    return true;}
    
}
