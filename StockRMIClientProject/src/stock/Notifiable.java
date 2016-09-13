package stock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bilei Huang
 */
/**
 * Notifiable is an interface with two methods: The method notify(String
 * stockSym, double price) is called by the server and informs the callback
 * client that a change in the stock price has occurred. The method exit() is
 * also called by the server and tells the callback client that it should cease
 * listening for this client. The user has exited the * system.
 * 
* This interface will be implemented on the client side. The implementation
 * will be done by an object that extends the UnicastRemoteObject. The interface
 * will be available on the client and the server.
 */
import java.rmi.*;

public interface Notifiable extends Remote {

    public void notify(String stockSym, double price) throws RemoteException;

    public void exit() throws RemoteException;
}
