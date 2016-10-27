package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import speler.Speler;




/**
 *
 * @author W. Kuik
 */
public interface SpeelSchermObserver extends Remote {
    public void modelChanged(Speler speler) throws RemoteException;
    
    public void enableBeurt() throws RemoteException;
    
    public void endGame() throws RemoteException;
    
}
