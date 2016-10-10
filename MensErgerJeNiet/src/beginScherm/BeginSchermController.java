package beginScherm;

import subMenu.SubMenuController;

/**
 *
 * @author W. Kuik
 */
public class BeginSchermController {
    private BeginSchermPanel panel;
    
    public BeginSchermController() {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new BeginSchermPanel(this);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void disableView() {
        panel.setVisible(false);
	BeginSchermFrame.getInstance().remove(panel);
    }
    public void openSubMenuScherm() {
        new SubMenuController();
    }
    
    
}
