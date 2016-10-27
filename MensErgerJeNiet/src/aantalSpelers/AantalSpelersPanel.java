package aantalSpelers;

import beginScherm.BeginSchermFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author W. Kuik
 */
public class AantalSpelersPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel voerSpelersInLabel;
    private JTextField aantalSpelersVeld;
    private JButton okBtn, quitBtn, backBtn;
    private AantalSpelersController controller;
    
    public AantalSpelersPanel(AantalSpelersController controller) {
        this.controller = controller;
        this.setLayout(null);
        
        voerSpelersInLabel = new JLabel("Hoeveel Spelers?(2-4)");
        voerSpelersInLabel.setSize(200,50);
        voerSpelersInLabel.setLocation(200, 60);
        voerSpelersInLabel.setHorizontalAlignment(JTextField.CENTER);
        
        aantalSpelersVeld = new JTextField();
        aantalSpelersVeld.setSize(100,50);
        aantalSpelersVeld.setLocation(250,130);
        aantalSpelersVeld.setHorizontalAlignment(JTextField.CENTER);
        
        okBtn = new JButton("Ok");
        okBtn.setSize(100, 50);
        okBtn.setLocation(250,200);
        okBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100, 50);
        quitBtn.setLocation(250, 350);
        quitBtn.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.setSize(100,50);
        backBtn.setLocation(250,270);
        backBtn.addActionListener(this);
        
        this.add(voerSpelersInLabel);
        this.add(aantalSpelersVeld);
        this.add(okBtn);
        this.add(quitBtn);
        this.add(backBtn);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == okBtn){
            String aantalSpelersS = aantalSpelersVeld.getText();
            int aantalSpelersI = Integer.parseInt(aantalSpelersS);
            if (aantalSpelersI >= 2 && aantalSpelersI <= 4 && aantalSpelersS.isEmpty() == false) {
                try {
                    controller.startServer(aantalSpelersI);
                    controller.disableView();
                    controller.openInvullenNaamScherm();
                } catch (RemoteException ex) {
                    
                } catch (ConnectException ex) {
                    
                } catch (NotBoundException ex) {
                    
                }
            } else {
                aantalSpelersVeld.setText("-");
		aantalSpelersVeld.setForeground(Color.RED);
		aantalSpelersVeld.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            }
        } else if (source == quitBtn) {
            BeginSchermFrame.getInstance().dispose();
            System.exit(0);
        } else if (source == backBtn) {
            controller.disableView();
            controller.goBack();
        }   
    }
}
