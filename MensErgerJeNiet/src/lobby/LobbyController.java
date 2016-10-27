package lobby;

import beginScherm.BeginSchermFrame;
import interfaces.ILobby;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import speelScherm.SpeelSchermController;
import speler.SpelersController;

/**
 *
 * @author W. Kuik
 */
public class LobbyController {
    private JPanel panel;
    private SpelersController spelersController;
    private int spelerId;
    private ILobby lobby;
    
    public LobbyController(SpelersController spelersController, int spelerId, ILobby lobby) throws RemoteException, UnknownHostException {
        this.spelersController = spelersController;
        this.spelerId = spelerId;
        this.lobby = lobby;
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new JPanel();
        this.panel.setSize(frame.getSize());
        new LobbyPanel(this, spelersController, spelerId, lobby, panel);
        frame.add(panel);
        frame.setVisible(true);
    }
      
    void openSpeelScherm() {
        new SpeelSchermController(spelersController, spelerId);
        BeginSchermFrame.getInstance().repaint();
    }

    void disableView() {
        panel.setVisible(false);
        BeginSchermFrame.getInstance().remove(panel);
    }

    void closeFrame() {
        BeginSchermFrame.getInstance().dispose();
        System.exit(0);
    }

    void cmdStartGame() throws RemoteException {
        this.lobby.go();
    }

}
