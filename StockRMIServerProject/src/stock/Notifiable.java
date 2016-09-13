package stock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bilei
 */
import java.rmi.*;

public interface Notifiable extends Remote {

    public void notify(String stockSym, double price) throws RemoteException;

    public void exit() throws RemoteException;
}
