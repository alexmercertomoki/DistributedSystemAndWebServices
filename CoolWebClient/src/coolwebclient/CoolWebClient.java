/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolwebclient;

/**
 *
 * @author mac
 */
public class CoolWebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(foo(900));
        System.out.println(purchase(900,"car",4));
        // TODO code application logic here
    }

    private static double foo(double x) {
        edu.andrew.bhuang.CoolWebService_Service service = new edu.andrew.bhuang.CoolWebService_Service();
        edu.andrew.bhuang.CoolWebService port = service.getCoolWebServicePort();
        return port.foo(x);
    }

    private static String purchase(int pid, java.lang.String name, int quantity) {
        edu.andrew.bhuang.CoolWebService_Service service = new edu.andrew.bhuang.CoolWebService_Service();
        edu.andrew.bhuang.CoolWebService port = service.getCoolWebServicePort();
        return port.purchase(pid, name, quantity);
    }
    
}
