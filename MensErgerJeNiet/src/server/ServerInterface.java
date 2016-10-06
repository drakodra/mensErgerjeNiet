package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author W. Kuik
 */
public interface ServerInterface extends Remote{
    public void rollDice() throws RemoteException;
}
