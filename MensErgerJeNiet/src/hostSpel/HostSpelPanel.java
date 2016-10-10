package hostSpel;

import beginScherm.BeginSchermFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author W. Kuik
 */
public class HostSpelPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
       
    private JLabel serverStartLabel;
    private JTextField ipVeld;
    private String ipAddress;
    private JButton okBtn, quitBtn, backBtn;
    private HostSpelController controller;
    
    public HostSpelPanel(HostSpelController controller) {
        this.controller = controller;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        
        serverStartLabel = new JLabel ("Jouw IP");
        serverStartLabel.setSize(100, 50);
        serverStartLabel.setLocation(250,250);
        
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException uhe) {
            ipAddress = "check your internet";
        }
        
        ipVeld = new JTextField(ipAddress);
        ipVeld.setSize(100,50);
        ipVeld.setLocation(250, 310);
        ipVeld.setFocusable(false);
        ipVeld.setHorizontalAlignment(JTextField.CENTER);
        
        okBtn = new JButton("ok");
        okBtn.setSize(100,50);
        okBtn.setLocation(250,370);
        okBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(250,490);
        quitBtn.addActionListener(this);
        
        backBtn = new JButton("back");
        backBtn.setSize(100,50);
        backBtn.setLocation(250,430);
        backBtn.addActionListener(this);
        
        this.add(serverStartLabel);
        this.add(ipVeld);
        this.add(okBtn);
        this.add(quitBtn);
        this.add(backBtn);
        this.setBackground(new Color(237,27,36));
    }
    
    
    
    
    
    
    
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == quitBtn) {
            controller.closeFrame();
        } else if (source == okBtn) {
            controller.disableView();
            controller.openAantalSpelersScherm();
        } else if (source == backBtn) {
            controller.disableView();
            controller.goBack();
        }
        
    }

}
