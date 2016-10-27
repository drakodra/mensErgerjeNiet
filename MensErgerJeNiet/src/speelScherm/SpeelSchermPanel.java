package speelScherm;

import beginScherm.BeginSchermFrame;
import interfaces.SpeelSchermObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JPanel;
import speler.Speler;
import speler.SpelersController;

/**
 *
 * @author W. Kuik
 */
public class SpeelSchermPanel extends UnicastRemoteObject implements ActionListener, SpeelSchermObserver {
    private static final long serialVersionUID = 1L;
    
    private JButton dobbel, nieuwPion, beweeg1, beweeg2, beweeg3, beweeg4;
    private SpeelSchermController controller;
    private SpelersController spelersController;
    private int spelerId;
    private JPanel panel;
    
    public SpeelSchermPanel (SpeelSchermController controller, SpelersController spelersController, int spelerId, JPanel panel) throws RemoteException {
        this.controller = controller;
        this.spelersController = spelersController;
        this.spelerId = spelerId;
        this.panel = panel;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modelChanged(Speler speler) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableBeurt() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endGame() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
