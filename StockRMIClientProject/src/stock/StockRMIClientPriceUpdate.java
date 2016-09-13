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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilei Huang
 *  to do  Price update  of the stocks
 */
public class StockRMIClientPriceUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            try {
                // lookup the binding
                StockRMI sr = (StockRMI) Naming.lookup("//localhost/stockService");
                System.out.println("enter the stock you want to UPDATE OR ADD(THEN "
                        + "USER CAN SUBSCRIBE):");
                //  get the stock  that you want to update or add
                Scanner sc = new Scanner(System.in);
                
                String stock = sc.nextLine();
                // if ! is detected exit
                if (stock.equals("!")) {
                    System.out.println("Exited!");
                    System.exit(0);
                }
                // split by " "
                String[] strArray=stock.split(" ");
                //  this is the name of stock
                String StockName=strArray[0];
                //  the second one is the price
                double price = Double.parseDouble(strArray[1]);
                 //  update the stock
                sr.stockUpdate(StockName, price);

            } catch (NotBoundException ex) {
                Logger.getLogger(StockRMIClientPriceUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(StockRMIClientPriceUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StockRMIClientPriceUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
