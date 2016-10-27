package kiezenKleur;

import interfaces.ILobby;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import lobby.LobbyController;
import speler.SpelersController;
import beginScherm.BeginSchermFrame;
import enumerations.Kleur;
import java.net.UnknownHostException;

/**
 *
 * @author W. Kuik
 */
public class KiezenKleurController {
    private JPanel panel;
    private SpelersController spelersController;
    private int spelerId;
    private ILobby lobby;
    
    public KiezenKleurController(SpelersController spelersController, int spelerId, ILobby lobby) throws RemoteException {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.spelersController = spelersController;
        this.lobby = lobby;
        this.panel = new JPanel();
        new KiezenKleurPanel(this,spelerId,spelersController, panel);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void cmdSpSetKleur(Kleur kleur) throws RemoteException {
        spelersController.cmdSetKleur(spelerId, kleur);
    }
    
    public void openLobbyScherm() throws RemoteException, UnknownHostException {
        new LobbyController(spelersController, spelerId, lobby);
    }
    
    public void closeFrame() {
        BeginSchermFrame.getInstance().dispose();
        System.exit(0);
    }
    
    public void disableView() {
        panel.setVisible(false);
        BeginSchermFrame.getInstance().remove(panel);
    }
}
