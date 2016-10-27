package aantalSpelers;

import beginScherm.BeginSchermFrame;
import interfaces.ISpelers;
import invullenNaam.InvullenNaamController;
import java.net.ConnectException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import registry.HRegistry;
import server.Server;
import speler.SpelersController;
import subMenu.SubMenuController;

/**
 *
 * @author W. Kuik
 */
public class AantalSpelersController {
    private AantalSpelersPanel panel;
    private int spelerId;
    private SpelersController spelersController;
    
    public AantalSpelersController() {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new AantalSpelersPanel(this);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void disableView() {
        panel.setVisible(false);
        BeginSchermFrame.getInstance().remove(panel);
    }
    
    public void goBack() {
        new SubMenuController();
    }
    
    public void openInvullenNaamScherm() {
        new InvullenNaamController(spelersController, spelerId);
    }
    
    public void startServer(int aantalSpelers) throws AccessException, RemoteException, ConnectException, NotBoundException {
        Server server = new Server();
        server.setAantalSpelers(aantalSpelers);
        server.runServer(); 
        ISpelers sp = null;
        
        HRegistry registry = HRegistry.getInstance();
        registry.startRegistry("localhost");
        sp = registry.getRemoteSpelers();
        this.spelersController = new SpelersController(sp);
        this.spelerId = spelersController.cmdCreateSpelerId();
    }
}
