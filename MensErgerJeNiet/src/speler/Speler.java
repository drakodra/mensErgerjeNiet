package speler;

import enumerations.Kleur;
import interfaces.ISpeler;
import interfaces.KleurObserver;
import interfaces.SpeelSchermObserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author W. Kuik
 */
public class Speler implements Serializable, ISpeler{
    private static final long serialVersionUID = 1L;
    private int id;
    private String naam;
    private Kleur kleur;
    private boolean kleurIsGekozen;
    private ArrayList<KleurObserver> kleurObservers = new ArrayList<KleurObserver>();
    private ArrayList<SpeelSchermObserver> speelObservers = new ArrayList<SpeelSchermObserver>();

    @Override
    public void setId(int i) throws RemoteException {
        this.id = i;
    }

    @Override
    public void setNaam(String n) throws RemoteException {
        this.naam = n;
    }

    @Override
    public void setKleur(Kleur k) throws RemoteException {
        this.kleur = k;
        this.notifyKleurObservers();
    }

    @Override
    public void setKleurIsgekozen(boolean kleurIsGekozen) throws RemoteException {
        this.kleurIsGekozen = kleurIsGekozen;
    }

    @Override
    public int getId() throws RemoteException {
        return this.id;
    }

    @Override
    public String getNaam() throws RemoteException {
       return this.naam;
    }

    @Override
    public Kleur getKleur() throws RemoteException {
        return this.kleur;
    }

    @Override
    public boolean kleurIsGekozen() throws RemoteException {
        return this.kleurIsGekozen;
    }

    @Override
    public void addKleurObservers(KleurObserver ko) throws RemoteException {
        this.kleurObservers.add(ko);
    }
    
    @Override
    public void addSpeelObservers(SpeelSchermObserver so) throws RemoteException {
        this.speelObservers.add(so);
        this.notifySpeelObservers();
    }

    @Override
    public void removeAllSpeelObservers() throws RemoteException {
        this.speelObservers.removeAll(speelObservers);
    }

    @Override
    public void removeAllKleurObservers() throws RemoteException {
        this.kleurObservers.removeAll(kleurObservers);
    }

    private void notifyKleurObservers() throws RemoteException {
        for (KleurObserver ko : kleurObservers) {
            ko.modelChanged(this);
        }
    }

    private void notifySpeelObservers() throws RemoteException {
        for (SpeelSchermObserver so : speelObservers) {
            so.modelChanged(this);
        }
    }

}
