package lobby;

import interfaces.ILobby;
import interfaces.LobbyObserver;
import java.io.Serializable;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author W. Kuik
 */
public class Lobby implements Serializable, ILobby {
    private static final long serialVersionUID = 1L;
    private String[][] lobbyData;
    private ArrayList<LobbyObserver> observers = new ArrayList<LobbyObserver>();
    
    public Lobby() {
        this.lobbyData = new String[4][3];
        for (int i = 0; i < 4; i++){
            for (int j = 0 ; j < 3; j++){
                this.lobbyData[i][j] = "-";
            }
        }
    }

    @Override
    public void addSpelerData(int index, String naam) throws RemoteException {
        this.lobbyData[index][0] = naam;
        
        if (index == 0) {
            this.lobbyData[index][1] = "Host";
        } else {
            this.lobbyData[index][1] = "Speler";
        }
        notifyObservers();
    }

    @Override
    public String[][] getLobbyData() throws RemoteException {
        return this.lobbyData;
    }

    @Override
    public void addObserver(LobbyObserver lo) throws RemoteException {
        observers.add(lo);
    }

    @Override
    public int getAantalObservers() throws RemoteException {
        return observers.size();
    }

    @Override
    public void setReady(int index) throws RemoteException {
        this.lobbyData[index][2] = "Ready";
        notifyObservers();
    }

    @Override
    public void go() throws RemoteException {
       for (LobbyObserver lo : observers) {
           lo.startGame(this);
       }
    }

    private void notifyObservers() throws RemoteException {
        for (LobbyObserver lo : observers) {
            lo.modelChanged(this);
        }
    }
    
    private void setLobbydata(String[][] lobbyData) {
        this.lobbyData = lobbyData;
        for (int i = 0; i < 4; i++) {
            this.lobbyData[i][2] = "-";
        }
    }

}
