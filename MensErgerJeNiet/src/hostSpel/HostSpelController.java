package hostSpel;

import beginScherm.BeginSchermFrame;
import subMenu.SubMenuController;

/**
 *
 * @author W. Kuik
 */
public class HostSpelController {
    private HostSpelPanel panel;
    
    public HostSpelController() {
        BeginSchermFrame frame = BeginSchermFrame.getInstance();
        this.panel = new HostSpelPanel(this);
        this.panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void closeFrame() {
        BeginSchermFrame.getInstance().dispose();
        System.exit(0);
    }
    
    public void disableView() {
        panel.setVisible(false);
        BeginSchermFrame.getInstance().remove(panel);
    }
    
    public void goBack() {
        new SubMenuController();
    }
    
    public void openAantalSpelersScherm() {
 //       new AantalSpelersController();
    }

}
