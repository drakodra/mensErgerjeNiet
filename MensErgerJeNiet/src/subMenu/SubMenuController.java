package subMenu;

import beginScherm.BeginSchermFrame;
import hostSpel.HostSpelController;

/**
 *
 * @author W. Kuik
 */
public class SubMenuController {
    private SubMenuPanel panel;
    
    public SubMenuController() {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        
        this.panel = new SubMenuPanel(this);
        this.panel.setSize(frame.getSize());
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public void disableView() {
	panel.setVisible(false);
	BeginSchermFrame.getInstance().remove(panel);
    }
    
    public void openHostSpelScherm() {
	new HostSpelController();
    }  
    
    public void openSpelJoinenScherm() {
	
    }
}
