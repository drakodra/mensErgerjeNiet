package speler;

import enumerations.Kleur;
import interfaces.ISpeler;
import interfaces.ISpelers;
import interfaces.KleurObserver;
import interfaces.SpeelSchermObserver;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author W. Kuik
 */
public class SpelersController implements Serializable {
    private static final long serialVersionUID = 1L;
    private ISpelers spelers;
    
    public SpelersController(ISpelers spelers) {
        this.spelers = spelers;
    }
    
    public int cmdCreateSpelerId() throws RemoteException {
	return this.spelers.createSpelerId();
    }
	
    public int cmdGetAantalSpelers() throws RemoteException {
	return this.spelers.getAantalSpelers();
    }
	
    public int cmdGetId(int index) throws RemoteException {
	ISpeler s =(ISpeler) this.spelers.getSpeler(index);
        return s.getId();
    }

    public ISpeler cmdGetSpeler(int index) throws RemoteException {
	return (ISpeler) this.spelers.getSpeler(index);    
    }
    
    public void cmdAddKleurObservers(KleurObserver ko) throws RemoteException {
        this.spelers.addKleurObservers(ko);
    }
    
    public void cmdAddSpeelObservers(SpeelSchermObserver so) throws RemoteException {
	this.spelers.addSpeelObserver(so);
    }
    
    public void cmdSetBeurt() throws RemoteException {
	this.spelers.setBeurt();
    }

    public void cmdSetKleur(int index, Kleur kleur) throws RemoteException {
        this.spelers.setSpelerKleur(index, kleur);
    }

    public void cmdSetKleurIsGekozen(int index, boolean kleurIsGekozen) throws RemoteException {
	this.spelers.setSpelerKleurIsGekozen(index, kleurIsGekozen);
    }
	
    public void cmdSetNaam(int index, String naam) throws RemoteException {
	this.spelers.setSpelerNaam(index, naam);
    }
    
}