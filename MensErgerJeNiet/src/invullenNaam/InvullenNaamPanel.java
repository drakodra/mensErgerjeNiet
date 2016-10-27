package invullenNaam;

import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import beginScherm.BeginSchermFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;


/**
 *
 * @author W. Kuik
 */
public class InvullenNaamPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel voerNaamInLabel;
    private JTextField naamVeld;
    private JButton okBtn, quitBtn;
    private InvullenNaamController controller;
    

    InvullenNaamPanel(InvullenNaamController controller) {
        this.controller = controller;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        
        voerNaamInLabel = new JLabel("Voer Uw Naam in");
        voerNaamInLabel.setSize(200,50);
        voerNaamInLabel.setLocation(200, 60);
        voerNaamInLabel.setHorizontalAlignment(JTextField.CENTER);
        
        naamVeld = new JTextField();
        naamVeld.setSize(100,50);
        naamVeld.setLocation(250,130);
        naamVeld.setHorizontalAlignment(JTextField.CENTER);
        
        okBtn = new JButton("Ok");
        okBtn.setSize(100, 50);
        okBtn.setLocation(250,200);
        okBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100, 50);
        quitBtn.setLocation(250, 350);
        quitBtn.addActionListener(this);
        
        this.add(voerNaamInLabel);
        this.add(naamVeld);
        this.add(okBtn);
        this.add(quitBtn);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == okBtn) {
            String naam = naamVeld.getText();
            String vergelijking = new String("Invalid");
            if (naamVeld.getText().length() == 0 || naam.equals(vergelijking) == true || naamVeld.getText().length() > 7) {
                naamVeld.setText(vergelijking);
                naamVeld.setForeground(Color.RED);
                naamVeld.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            } else {
                try {
                    controller.cmdSpSetNaam(naamVeld.getText());
                } catch (RemoteException ex) {
                    Logger.getLogger(InvullenNaamPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                controller.disableView();
                try {
                    controller.openKleurScherm();
                } catch (RemoteException ex) {
                    Logger.getLogger(InvullenNaamPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (source == quitBtn) {
            BeginSchermFrame.getInstance().dispose();
            System.exit(0);
        }
    }

}
