package subMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import beginScherm.BeginSchermFrame;
import java.awt.Color;
/**
 *
 * @author W. Kuik
 */
public class SubMenuPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton hostBtn, joinBtn, quitBtn;
    private SubMenuController controller;
    
    public SubMenuPanel (SubMenuController controller){
        this.controller = controller;
        BeginSchermFrame scherm = BeginSchermFrame.getInstance();
        this.setLayout(null);
        hostBtn = new JButton("host");
        hostBtn.setSize(100,50);
        hostBtn.setLocation(250,250);
        hostBtn.addActionListener(this);
        
        joinBtn = new JButton("join");
        joinBtn.setSize(100,50);
        joinBtn.setLocation(250,310);
        joinBtn.addActionListener(this);
        
        quitBtn = new JButton("quit");
        quitBtn.setSize(100,50);
        quitBtn.setLocation(250,370);
        quitBtn.addActionListener(this);
        
        this.add(hostBtn);
        this.add(joinBtn);
        this.add(quitBtn);
        
        this.setBackground(new Color(237,27,36));
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == quitBtn) {
            BeginSchermFrame.getInstance().dispose();
            System.exit(0);
        } else if (source == hostBtn) {
            controller.disableView();
            controller.openHostSpelScherm();
        } else if (source == joinBtn) {
            controller.disableView();
            controller.openSpelJoinenScherm();
        }
    }
    

}
