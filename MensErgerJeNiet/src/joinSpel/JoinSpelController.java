package joinSpel;

import beginScherm.BeginSchermFrame;
import interfaces.ISpelers;
import invullenNaam.InvullenNaamController;
import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import registry.HRegistry;
import speler.SpelersController;

/**
 *
 * @author W. Kuik
 */
public class JoinSpelController {
    private JoinSpelPanel panel;
    private int spelerId;
    private SpelersController spelersController;
    
    public JoinSpelController() {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new JoinSpelPanel(this);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
    }

    void opnVolgendScherm() {
        new InvullenNaamController(spelersController, spelerId);
        
    }

    void disableView() {
        panel.setVisible(false);
       BeginSchermFrame.getInstance().remove(panel);
    }

    void joinServer(String ipAddress) throws RemoteException, NotBoundException, ConnectException {
        ISpelers sp = null;
        HRegistry registry = HRegistry.getInstance();
        registry.startRegistry(ipAddress);
        sp = registry.getRemoteSpelers();
        this.spelersController = new SpelersController(sp);
        this.spelerId = this.spelersController.cmdCreateSpelerId();
    }
    
}
