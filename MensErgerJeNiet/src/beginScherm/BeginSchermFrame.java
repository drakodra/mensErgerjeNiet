package beginScherm;

import javax.swing.JFrame;

/**
 *
 * @author W. Kuik
 */
public class BeginSchermFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static BeginSchermFrame frame;
    
    public static void main(String[] args) {
        new BeginSchermFrame();
    }
    
    public BeginSchermFrame() {
        this.setSize(600,600);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public static BeginSchermFrame getInstance() {
        if (frame != null){
            return frame;
        } else {
            frame = new BeginSchermFrame();
            frame.setTitle("Mens Erger Je Niet!");
            return frame;
        }
    }
    

}
