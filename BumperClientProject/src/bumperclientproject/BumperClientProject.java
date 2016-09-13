/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bumperclientproject;

import java.math.BigInteger;
import static oracle.jrockit.jfr.JFR.get;
import sun.applet.Main;

/**
 *
 * @author mac
 */
public class BumperClientProject {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
         for(int i = 0; i<1000; i++) 
         bump();
         long stop =System.currentTimeMillis();
          System.out.println(get());
          
          System.out.println("Time Elapsed: " + (stop-start));
        // TODO code application logic here
    }

    private static boolean bump() {
        bumperservice.BumperService_Service service = new bumperservice.BumperService_Service();
        bumperservice.BumperService port = service.getBumperServicePort();
        return port.bump();
    }

    private static BigInteger get() {
        bumperservice.BumperService_Service service = new bumperservice.BumperService_Service();
        bumperservice.BumperService port = service.getBumperServicePort();
        return port.get();
    }
 
  
}
