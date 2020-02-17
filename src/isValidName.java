
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajan_gp8cname31
 */
public class isValidName {

    public static boolean validname(String name) {
        
            
            
if(name.length()<3)
  return false;

if(name.startsWith("."))
  return false;

if(name.contains(".."))
  return false;

if(name.contains(". "))
  return false;

if(name.contains(" ."))
  return false;

String h=name.toLowerCase();

char a;
for(int i=0;i<h.length();i++)
{
   a=h.charAt(i);
   
   if(a<97 || a>122)
   {
	if(a!='.' && a!=' ')
        { 
	  return false;
          
        }
   }	
}

return true;

}
        }
    
 