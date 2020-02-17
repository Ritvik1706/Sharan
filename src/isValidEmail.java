/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajan_gp8cx31
 */
public class isValidEmail {

    public static boolean validemail(String mail) {
        int count = 0, dot = 0, at = 0;
        String s2 = "@_-";
        byte b1[] = s2.getBytes();

        boolean b = mail.startsWith(".");
        boolean b2 = mail.endsWith(".com");
        boolean b3 = mail.endsWith(".co.in");
        boolean b4 = mail.endsWith(".org");
        boolean b5 = mail.contains(".@.");

        char x[] = mail.toCharArray();
        for (int i = 0; i < x.length; i++) {
            if (x[i] >= 65 && x[i] <= 90 || x[i] >= 97 && x[i] <= 122 || x[i] == 46 || x[i] == b1[0] || x[i] == b1[1] || x[i] == b1[2] || x[i] >= 48 && x[i] <= 57) {
                count++;
            }
            if (x[i] == 46) {
                dot++;
            }
            if (x[i] == b1[0]) {
                at++;
            }
        }
        if (count == x.length && b != true && dot <= 4 && (b2 == true || b3 == true || b4 == true) && b5 != true) {
            return true;
        }
       else
        {
            return false;
        }
    }
}
