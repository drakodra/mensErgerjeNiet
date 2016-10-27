package kiezenKleur;

import beginScherm.BeginSchermFrame;
import enumerations.Kleur;
import static enumerations.Kleur.GEEL;
import static enumerations.Kleur.GROEN;
import static enumerations.Kleur.ROOD;
import static enumerations.Kleur.ZWART;
import interfaces.ISpeler;
import interfaces.KleurObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import speler.SpelersController;

/**
 *
 * @author W. Kuik
 */
public class KiezenKleurPanel extends UnicastRemoteObject implements ActionListener, KleurObserver {
    private static final long serialVersionUID = 1L;
    private JLabel kiesKleurLabel;
    private JButton groenBtn, roodBtn, geelBtn, zwartBtn, quitBtn;
    private KiezenKleurController controller;
    private SpelersController spelersController;
    
    public KiezenKleurPanel(KiezenKleurController controller, int spelerId, SpelersController spelersController, JPanel panel) throws RemoteException {
        this.controller = controller;
        this.spelersController = spelersController;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        spelersController.cmdAddKleurObservers(this);
        panel.setLayout(null);
        
        kiesKleurLabel = new JLabel("Kies je kleur");
        kiesKleurLabel.setSize(200,50);
        kiesKleurLabel.setLocation(200,60);
        kiesKleurLabel.setHorizontalAlignment(JTextField.CENTER);
        
        geelBtn = new JButton("geel");
        geelBtn.setSize(100,50);
        geelBtn.setLocation(175,130);
        geelBtn.addActionListener(this);
        
        groenBtn = new JButton("groen");
        groenBtn.setSize(100,50);
        groenBtn.setLocation(325,130);
        groenBtn.addActionListener(this);
        
        roodBtn = new JButton("rood");
        roodBtn.setSize(100,50);
        roodBtn.setLocation(175,200);
        roodBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(250,270);
        quitBtn.addActionListener(this);
        
        zwartBtn = new JButton("zwart");
        zwartBtn.setSize(100,50);
        zwartBtn.setLocation(325,200);
        zwartBtn.addActionListener(this);
        
        panel.add(kiesKleurLabel);
        panel.add(geelBtn);
        panel.add(groenBtn);
        panel.add(roodBtn);
        panel.add(quitBtn);
        panel.add(zwartBtn);
        
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == geelBtn) {
            this.kleurBtnAction(GEEL);
        } else if (source == groenBtn) {
            this.kleurBtnAction(GROEN);
        } else if (source == roodBtn) {
            this.kleurBtnAction(ROOD);
        } else if (source == quitBtn) {
            controller.closeFrame();
        } else if (source == zwartBtn) {
            this.kleurBtnAction(ZWART);
        }
    }

    @Override
    public void modelChanged(ISpeler speler) throws RemoteException {
        Kleur kleur = speler.getKleur();
        if (kleur == GROEN) {
            groenBtn.setEnabled(false);
        } else if (kleur ==  GEEL) {
            geelBtn.setEnabled(false);
        } else if (kleur == ROOD) {
            roodBtn.setEnabled(false);
        } else if (kleur == ZWART) {
            zwartBtn.setEnabled(false);
        }
    }
    
    private void kleurBtnAction(Kleur kleur) {
        try {
                controller.cmdSpSetKleur(kleur);
                controller.disableView();
                controller.openLobbyScherm();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
    }
}
