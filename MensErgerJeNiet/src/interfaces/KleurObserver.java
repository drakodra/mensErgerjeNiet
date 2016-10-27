package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public interface KleurObserver extends Remote {
    public void modelChanged(ISpeler speler) throws RemoteException;
    
}
