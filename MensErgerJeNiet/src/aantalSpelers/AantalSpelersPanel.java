package aantalSpelers;

import beginScherm.BeginSchermFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    
    }

}
