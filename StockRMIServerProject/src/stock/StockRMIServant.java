/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Bilei Huang
 *  the StockRMIServant which implements functions of  stockrmi
 */
public class StockRMIServant extends UnicastRemoteObject implements StockRMI {
    /* Given a stock, get a list of users that are interested in that stock. */

    private static Map<String, LinkedList> stocks = new TreeMap<String, LinkedList>();
    /* Given a user, get the remote object reference to its callback method. */
    private static Map users = new TreeMap();

    public StockRMIServant() throws RemoteException {
    }

    /**
     * @param user who wants to subscribe
     * @param stockSym the stock you want to subscribe
     * to subscribe certain stocks
     */
    @Override
    public boolean subscribe(String user, String stockSym) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //   if the stock contains the key means the stock exists
        if (stocks.containsKey(stockSym)) {
            // get the list and add the user which means the user subscribes
            LinkedList ll = stocks.get(stockSym);
            if (!ll.contains(user)) {
                ll.add(user);
                return true;
            } else {
                // if the user alreay exists he or she doenst need to subscribe
                System.out.println("user exists");
                return false;
            }
        //  if the stock doesn't exist the user cannot subscribe
        } else {
            System.out.println("no such stock exists");
            return false;
        }

    }

    /**
     * @param user who wants to  unsubscribe
     * @param stockSym the stock you want to unsubscribe
     *  to unsubscribe certain stock
     */
    @Override
    public boolean unSubscribe(String user, String stockSym) throws RemoteException {
        // if stock tree contains the  stock we can unsubscribe the user
        if (stocks.containsKey(stockSym)) {
            LinkedList ll = stocks.get(stockSym);
            //user does exist : 
            if (ll.contains(user)) {
                ll.remove(user);
                return true;
            } else {
                //if user doesn't exist
                System.out.println("user doesn't exist");
                return false;
            }
          // if the stock doesn't exist
        } else {
            System.out.println("no such stock exists");
            return false;
        }
    }
    
    /**
     * @param stockSym the stock  you want to  update or add
     * @param price  the price of the stock you want to update 
     * updating stocks
     */
    @Override
    public void stockUpdate(String stockSym, double price) throws RemoteException {
        // need to know whether we have the linked list in  if(s)
        
        // if the stock is not null 
        if (stocks != null && stocks.get(stockSym) != null) {
            
            // get the linkedlist and update value of the stock
            LinkedList ll = stocks.get(stockSym);
            ll.removeFirst();
            ll.addFirst(price);
            Iterator itr = ll.iterator();
            itr.next();
            
            // if the user has subscribed the stock : notify 
            if (itr.hasNext()) {
                String username = (String) itr.next();
                if (users.containsKey(username)) {
//                    System.out.println(users);
                    Notifiable nUser = (Notifiable) users.get(username);
                    nUser.notify(stockSym, price);
                    
                }
            }

        } else {
            //if there is no such a stock new linkedlist add the price to the list
            LinkedList ll = new LinkedList();
            ll.add(price);
            // put the list in the tree
            stocks.put(stockSym, ll);
            
            // notify the people who subscribed
            Iterator itr = ll.iterator();
            itr.next();
            if (itr.hasNext()) {
                String username = (String) itr.next();
                if (users.containsKey(username)) {
                    Notifiable nUser = (Notifiable) users.get(username);
                    nUser.notify(stockSym, price);
                }
            }
        }

    }

     /**
     * @param remoteClient the client you need to add
     * @param user  the name of the user
     * user : to register in the server
     * 
     */
    
    @Override
    public void registerCallBack(Notifiable remoteClient, String user) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      // add the call back objects into the tree
        users.put(user, remoteClient);

    }

     /**
     * @param user who wants to  deregister
     
     * this method lets user exit
     */
    @Override
    public void deRegisterCallBack(String user) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      // to exit 
        Notifiable n = (Notifiable) users.get(user);
        n.exit();
    
    }

}
