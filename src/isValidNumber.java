/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajan_gp8cx31
 */
public class isValidNumber {
    
    public static boolean validnumber(String s)
            
    {  
        byte b[]=s.getBytes();
        for(byte x:b)
        {
           if(x<48 || x>57 || b.length!=10)
               return false;
        }
        
        return true;
    }
    
    
}
