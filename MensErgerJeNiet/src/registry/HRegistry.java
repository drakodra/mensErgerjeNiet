package registry;

import interfaces.ILobby;
import interfaces.ISpelers;

import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author W. Kuik
 */
public class HRegistry {
    private static HRegistry classRegistry;
    private Registry registry;
    private ISpelers sp;
    private ILobby lobby;
    
    public static HRegistry getInstance() {
        if(classRegistry != null) {
            return classRegistry;
        } else {
            classRegistry = new HRegistry();
            return classRegistry;
        }
    }
    
    public void startRegistry(String ipAddress) throws RemoteException, NotBoundException, ConnectException {
        this.registry = LocateRegistry.getRegistry(ipAddress);
        this.sp = (ISpelers) this.registry.lookup("Spelers");
        this.lobby = (ILobby) this.registry.lookup("Lobby");
    }
    
    public ILobby getRemoteLobby() {
        return this.lobby;
    }
    
    public ISpelers getRemoteSpelers() {
        return this.sp;
    }
    

}
