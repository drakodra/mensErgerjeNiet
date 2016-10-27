package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public interface LobbyObserver extends Remote {
    public void modelChanged(ILobby lobby) throws RemoteException;
    
    public void startGame(ILobby lobby) throws RemoteException;
    
}
