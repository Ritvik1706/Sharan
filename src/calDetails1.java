
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
public class calDetails1 {
    
   public static String cal(String x)
   {
       SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                Date d=f.parse(x);
                
                 SimpleDateFormat f1=new SimpleDateFormat("yyyy");
                 
                 String s1=f1.format(d);
                 
                 return s1;
                
                
                
                
            } catch (ParseException ex) {
                ex.printStackTrace();
               
            }
            
   return null;}
    
}
