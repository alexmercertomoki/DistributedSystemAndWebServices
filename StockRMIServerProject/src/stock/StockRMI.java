/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

/**
 *
 * @author Bilei
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockRMI extends Remote {

    public boolean subscribe(String user, String stockSym) throws RemoteException;

    boolean unSubscribe(String user, String stockSym) throws RemoteException;

    public void stockUpdate(String stockSym, double price) throws RemoteException;

    public void registerCallBack(Notifiable remoteClient, String user) throws
            RemoteException;

    public void deRegisterCallBack(String user) throws RemoteException;
}
