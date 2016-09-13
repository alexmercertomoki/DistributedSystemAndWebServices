/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilei Huang
 * This class does the subscribing by the user, the user can subscribe multiple
 * stocks
 */
public class StockRMIClientSubscription {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("please enter a user name:");
        //get the user name
        Scanner sc = new Scanner(System.in);
        String nameline = sc.nextLine();
        System.out.println("Enter S for subscribe or U for unsubscribe "
                + "followed by the stock symbol of "
                + "interest. Enter ! to quit."+" REMEMBER YOU CAN ONLY SUBSCRIBE THE "
                + "STOCKS THAT EXIST ");
        //get the nextline
       
        // look up  call the proper method
        StockRMI sr;
        while(true){
            try {
                 //look up 
                String suStock = sc.nextLine();
                sr = (StockRMI) Naming.lookup("//localhost/stockService");
                String[] content = suStock.split(" ");
                 // if s or S call subscribe u or U call unsubcribe method
                if(content[0].equals("S") || content[0].equals("s")) {
                    sr.subscribe(nameline, content[1]);
                 // unsubscribe
                } else if (content[0].equals("u") || content[0].equals("U")) {
                    sr.unSubscribe(nameline, content[1]);
                } else if (content[0].equals("!")) { // exit
                    sr.deRegisterCallBack(nameline);
                    System.exit(0);
                } else {
                    throw new RuntimeException("Please  enter  in  the  right  way");
                    
                }
                
            } catch (NotBoundException ex) {
                Logger.getLogger(StockRMIClientSubscription.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(StockRMIClientSubscription.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StockRMIClientSubscription.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
