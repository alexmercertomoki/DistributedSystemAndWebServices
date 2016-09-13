/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bilei Huang
 * Main server 
 */
public class StockRMIServer {

   
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // TODO code application logic here
        //register
        Registry registry = LocateRegistry.createRegistry(1099);
        //bind
        StockRMI stockService =  new StockRMIServant();
        registry.rebind ("stockService", stockService);
        System.out.println("Stock system starts, waiting !");
        
    }
    
}
