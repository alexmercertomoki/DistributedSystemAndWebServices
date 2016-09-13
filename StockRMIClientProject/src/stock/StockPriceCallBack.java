package stock;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bilei Huang
 * this is the call back class which is used to do call backs adding an object to 
 * server
 */
public class StockPriceCallBack extends UnicastRemoteObject implements Notifiable {
    // to notify users 
    /**
     * @param stockSym  the stock that is changed
     * @param price  the price of the stock
     */
    @Override
    public void notify(String stockSym, double price) throws RemoteException {

        System.out.println("Hey there is a change in : "+stockSym+"   "+price);
      
    }

    public StockPriceCallBack() throws RemoteException {

    }
    // to exit
    @Override
    public void exit() throws RemoteException {
        try {
            UnicastRemoteObject.unexportObject(this, true);
            System.out.println("StockPriceCallBack exiting.");
        } catch (Exception e) {
            System.out.println("Exception thrown" + e);
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Please input your name : ");
        Scanner sc = new Scanner(System.in);
        String nline = sc.nextLine();
        
            try {
                // initiate  a call back 
                StockPriceCallBack spcb = new StockPriceCallBack();
                //       Naming.rebind("CoolCalculator", c); 
                //  look up  on the server
                StockRMI sr = (StockRMI) Naming.lookup("//localhost/stockService");
                sr.registerCallBack(spcb, nline);
                //  the information
                System.out.println("Looking up the server in the registry\n"
                        + "Creating a callback object to handle calls from the server."
                        + " Registering the callback with a"
                        + " name at the server. Callback handler"
                        + " for StockDealer ready.+(REMEMGER WE NEED TO ADD STOCK FIRST "
                        + " AND USER CAN SUBSCRIBE )");

            } catch (NotBoundException ex) {
                Logger.getLogger(StockPriceCallBack.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(StockPriceCallBack.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(StockPriceCallBack.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }

   
}
