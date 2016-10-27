package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public interface ILobby extends Remote {
    public void addSpelerData(int index, String naam) throws RemoteException;
    
    public String[][] getLobbyData() throws RemoteException;
    
    public void addObserver(LobbyObserver lo) throws RemoteException;
    
    public int getAantalObservers() throws RemoteException;
    
    public void setReady(int index) throws RemoteException;
    
    public void go() throws RemoteException;
}
