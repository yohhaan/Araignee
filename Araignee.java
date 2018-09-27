package araignee;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Tanguy
 */
public class Araignee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
