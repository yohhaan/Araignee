package araignee;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Araignee {

    public static void main(String[] args) {
        JFrame screen = new JFrame("Fenetre");
        screen.setSize(600, 600);
        screen.setLayout(new BorderLayout());
        
        Jeu jeu = new Jeu(screen);
        Lobby lobby = new Lobby(screen, jeu);
        
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
