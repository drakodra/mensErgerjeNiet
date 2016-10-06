package beginScherm;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author W. Kuik
 */
class BeginSchermPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JButton startBtn,quitBtn;
    private BeginSchermController controller;
    
    
    public BeginSchermPanel(BeginSchermController controller) {
        this.controller = controller;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        
        startBtn = new JButton("start");
        startBtn.setSize(100,50);
        startBtn.setLocation(250,300);
        startBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(250, 360);
        quitBtn.addActionListener(this);
        
        this.add(startBtn);
        this.add(quitBtn);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if(source == startBtn){
            
        } else if(source == quitBtn) {
            BeginSchermFrame.getInstance().dispose();
            System.exit(0);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
