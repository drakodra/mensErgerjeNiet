package speler;

import interfaces.ISpeler;
import interfaces.ISpelers;
import interfaces.KleurObserver;
import interfaces.SpeelSchermObserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enumerations.Kleur;

/**
 *
 * @author W. Kuik
 */
public class Spelers implements Serializable, ISpelers {
    private static final long serialVersionUID = 1L;
    private int spelerCounter;
    private int aantalSpelers;
    private ArrayList<ISpeler> spelerList;
    private ArrayList<SpeelSchermObserver> tempObservers = new ArrayList<SpeelSchermObserver>();
    private int observerCounter = 1;
    
    public Spelers(int aantalSpelers) {
        this.aantalSpelers = aantalSpelers;
        spelerList = new ArrayList<ISpeler>();
        
        for (int i = 0; i < aantalSpelers; i++) {
            ISpeler s = new Speler();
            spelerList.add(s);
        }
    }

    @Override
    public int createSpelerId() throws RemoteException {
        spelerList.get(spelerCounter).setId(spelerCounter);
        return spelerCounter++;
    }

    @Override
    public int getAantalSpelers() throws RemoteException {
        return this.aantalSpelers;
    }

    @Override
    public Object getSpeler(int index) throws RemoteException {
        return spelerList.get(index);
    }

    @Override
    public void addKleurObservers(KleurObserver ko) throws RemoteException {
        for (int i = 0; i < spelerList.size(); i++) {
            spelerList.get(i).addKleurObservers(ko);
        }
    }

    @Override
    public void addSpeelObserver(SpeelSchermObserver so) throws RemoteException {
        this.tempObservers.add(so);
        for (int i = 0; i < spelerList.size(); i++) {
            spelerList.get(i).addSpeelObservers(so);
        }
    }

    @Override
    public void setBeurt() throws RemoteException {
        SpeelSchermObserver speelObserver = this.tempObservers.get(observerCounter % aantalSpelers);
        speelObserver.enableBeurt();
        observerCounter++;
    }

    @Override
    public void setSpelerKleurIsGekozen(int index, boolean kleurIsGekozen) throws RemoteException {
        this.spelerList.get(index).setKleurIsgekozen(kleurIsGekozen);
    }

    @Override
    public void setSpelerNaam(int index, String naam) throws RemoteException {
        this.spelerList.get(index).setNaam(naam);
    }

    @Override
    public void setSpelerKleur(int index, Kleur kleur) throws RemoteException {
        this.spelerList.get(index).setKleur(kleur);
    }

}
