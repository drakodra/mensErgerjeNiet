package joinSpel;

import beginScherm.BeginSchermFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author W. Kuik
 */
public class JoinSpelPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel voerIpInLabel;
    private JTextField ipVeld;
    private JButton okBtn, quitBtn, backBtn;
    private JoinSpelController controller;
    
    public JoinSpelPanel(JoinSpelController controller) {
        this.controller = controller;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        
        voerIpInLabel = new JLabel("voer het server ip in:");
        voerIpInLabel.setSize(200,50);
        voerIpInLabel.setLocation(200,60);
        voerIpInLabel.setHorizontalAlignment(JTextField.CENTER);
        this.add(voerIpInLabel);
        
        ipVeld = new JTextField();
        ipVeld.setSize(200,50);
        ipVeld.setLocation(200,130);
        ipVeld.setHorizontalAlignment(JTextField.CENTER);
        this.add(ipVeld);
        
        okBtn = new JButton("ok");
        okBtn.setSize(100,50);
        okBtn.setLocation(250,200);
        okBtn.addActionListener(this);
        this.add(okBtn);
        
	quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(250,270);
        quitBtn.addActionListener(this);
        this.add(quitBtn);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == okBtn) {
            try {
                controller.joinServer(ipVeld.getText());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            } catch (NotBoundException ex) {
                ex.printStackTrace();
            } catch (ConnectException ex) {
                ex.printStackTrace();
            }
            controller.disableView();
            controller.opnVolgendScherm();
        } else if (source == quitBtn) {
            BeginSchermFrame.getInstance().dispose();
        }
    }
}