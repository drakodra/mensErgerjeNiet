package interfaces;

import enumerations.Kleur;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public interface ISpeler extends Remote {
    public void setId(int i) throws RemoteException;
    
    public void setNaam(String n) throws RemoteException;
    
    public void setKleur(Kleur k) throws RemoteException;
    
    public void setKleurIsgekozen(boolean kleurIsGekozen) throws RemoteException;
    
    public int getId() throws RemoteException;
    
    public String getNaam() throws RemoteException;
    
    public Kleur getKleur() throws RemoteException;
    
    public boolean kleurIsGekozen() throws RemoteException;
    
    public void addKleurObservers(KleurObserver ko) throws RemoteException;
    
    public void addSpeelObservers(SpeelSchermObserver so) throws RemoteException;
    
    public void removeAllSpeelObservers() throws RemoteException;
    
    public void removeAllKleurObservers() throws RemoteException;
}
