package lobby;

import beginScherm.BeginSchermFrame;
import interfaces.ILobby;
import interfaces.LobbyObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import speler.SpelersController;

/**
 *
 * @author W. Kuik
 */
public class LobbyPanel extends UnicastRemoteObject implements ActionListener, LobbyObserver {
    private static final long serialVersionUID = 1L;
    private JLabel lobbyLabel, ipAddressLabel;
    private int spelerId;
    private String columnNames[] = {"naam" , "Type", "Ready"};
    private ILobby lobby;
    private JTable lobbyTable;
    private JButton okBtn, quitBtn;
    private BeginSchermFrame scherm;
    private JPanel panel;
    private LobbyController controller;
    private SpelersController spelersController;
    
    
    public LobbyPanel(LobbyController controller, SpelersController spelersController, int spelerId, ILobby lobby, JPanel panel)throws RemoteException, UnknownHostException {
        this.scherm = BeginSchermFrame.getInstance();
        this.controller = controller;
        this.spelersController = spelersController;
        this.spelerId = spelerId;
        this.panel = panel;
	lobby.addObserver(this);
	this.lobby = lobby;
	this.panel.setLayout(null);
	
        lobbyLabel = new JLabel("Lobby");
        lobbyLabel.setSize(200,50);
        lobbyLabel.setLocation(75,60);
        lobbyLabel.setHorizontalAlignment(JTextField.CENTER);
        this.panel.add(lobbyLabel);
        
        ipAddressLabel = new JLabel(InetAddress.getLocalHost().getHostAddress());
        ipAddressLabel.setSize(200,50);
        ipAddressLabel.setLocation(325,60);
        ipAddressLabel.setHorizontalAlignment(JTextField.CENTER);
        this.panel.add(ipAddressLabel);
        
        lobbyTable = new JTable(lobby.getLobbyData(), columnNames);
        lobbyTable.setRowHeight(50);
        lobbyTable.setEnabled(false);
        lobbyTable.setOpaque(true);
        lobbyTable.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnNames.length; i++) {
            lobbyTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        this.lobby.setReady(spelerId);
        
	JScrollPane lobbyTableContainer = new JScrollPane(lobbyTable);
	lobbyTableContainer.setSize(400,200);
	lobbyTableContainer.setLocation(100,130);
	this.panel.add(lobbyTableContainer);
	
        okBtn = new JButton("start");
        okBtn.setSize(100,50);
        okBtn.setLocation(175,360);
        okBtn.setEnabled(false);
        okBtn.addActionListener(this);
        this.panel.add(okBtn);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(325,360);
        quitBtn.addActionListener(this);
	this.panel.add(quitBtn);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == okBtn) {
            try {
                controller.cmdStartGame();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        } else if (source == quitBtn) {
            controller.closeFrame();
        }
    }

    @Override
    public void modelChanged(ILobby lobby) throws RemoteException {
        for(int i = 0; i < 4; i++) {
            lobbyTable.setValueAt(lobby.getLobbyData()[i][0], i, 0);
            lobbyTable.setValueAt(lobby.getLobbyData()[i][1], i, 1);
            lobbyTable.setValueAt(lobby.getLobbyData()[i][2], i, 2);
        }
        
        if (lobby.getAantalObservers() == spelersController.cmdGetAantalSpelers() && spelerId == 0 && okBtn != null) {
            okBtn.setEnabled(true);
        }
    }

    @Override
    public void startGame(ILobby lobby) throws RemoteException {
        controller.disableView();
        controller.openSpeelScherm();
    }
}
