package invullenNaam;

import registry.HRegistry;
import java.rmi.RemoteException;
import kiezenKleur.KiezenKleurController;
import speler.SpelersController;
import beginScherm.BeginSchermController;
import beginScherm.BeginSchermFrame;
import interfaces.ILobby;

/**
 *
 * @author W. Kuik
 */
public class InvullenNaamController {
    private InvullenNaamPanel panel;
    private SpelersController spelersController;
    private int spelerId;
    private ILobby lobby;
    
    public InvullenNaamController (SpelersController spelersController, int spelerId) {
        
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new InvullenNaamPanel(this);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
        this.spelersController = spelersController;
        this.spelerId = spelerId;
        HRegistry registry = HRegistry.getInstance();
        this.lobby = registry.getRemoteLobby();
        
    }

    void disableView() {
        panel.setVisible(false);
    }

    void cmdSpSetNaam(String naam) throws RemoteException {
        this.spelersController.cmdSetNaam(spelerId, naam);
        this.lobby.addSpelerData(spelerId, naam);
    }

    void openKleurScherm() throws RemoteException {
        new KiezenKleurController(spelersController, spelerId, lobby);
    }

}
