package server;

import interfaces.ILobby;
import interfaces.ISpelers;
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import lobby.Lobby;
import speler.Spelers;
/**
 *
 * @author W. Kuik
 */
public class Server {
    private int aantalSpelers;
    
    
    

    public void setAantalSpelers(int aantalSpelers) {
        this.aantalSpelers = aantalSpelers;
    }

    public void runServer() throws RemoteException {
        Spelers spelersImpl = new Spelers(aantalSpelers);
        System.out.println("1");
        Lobby lobbyImpl = new Lobby();
        System.out.println("2");
        
        ILobby lobbySkeleton = (ILobby) UnicastRemoteObject.exportObject(lobbyImpl, 0);
        System.out.println("3");
        ISpelers spelersSkeleton;
        System.out.println("4");
        Object skeleton = UnicastRemoteObject.exportObject(spelersImpl, 0);
        spelersSkeleton =(ISpelers) skeleton;
        
        
        Registry registry = LocateRegistry.createRegistry(1099);
        System.out.println("RMI Registry started");
        
        registry.rebind("Spelers", (Remote) spelersSkeleton);
        registry.rebind("Lobby", lobbySkeleton);
        
        System.out.println("Skeletons bound");
        System.out.println("Server Running");
        
        
    }
    
}
