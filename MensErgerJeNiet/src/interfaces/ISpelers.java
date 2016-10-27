/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enumerations.Kleur;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public interface ISpelers extends Remote{

    public int createSpelerId() throws RemoteException;

    public int getAantalSpelers() throws RemoteException;

    public Object getSpeler(int index) throws RemoteException;

    public void addKleurObservers(KleurObserver ko) throws RemoteException;

    public void addSpeelObserver(SpeelSchermObserver so) throws RemoteException;

    public void setBeurt() throws RemoteException;

    public void setSpelerKleurIsGekozen(int index, boolean kleurIsGekozen) throws RemoteException;

    public void setSpelerNaam(int index, String naam) throws RemoteException;

    public void setSpelerKleur(int index, Kleur kleur) throws RemoteException;
    
}
