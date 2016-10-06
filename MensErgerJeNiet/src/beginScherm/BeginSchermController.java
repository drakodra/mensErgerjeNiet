package beginScherm;

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
}
