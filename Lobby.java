
package araignee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Lobby {
    
    private Jeu _jeu;
    
    public Lobby(JFrame screen, Jeu jeu) {
        _jeu = jeu;
        
        JLabel title = new JLabel("Le jeu de l'arraigné, par ECLAIR, ou presque :p");
        screen.add("North", title);
        
        JPanel names = new JPanel();
        names.setLayout(new FlowLayout());
        
        
        JPanel areaPlayer1 = new JPanel();
        areaPlayer1.setLayout(new BorderLayout());
        
        JLabel textP1 = new JLabel("Nom du joueur 1 :");
        areaPlayer1.add("North", textP1);
        
        JTextArea nameP1 = new JTextArea();
        areaPlayer1.add("Center", nameP1);
        
        
        JPanel areaPlayer2 = new JPanel();
        areaPlayer2.setLayout(new BorderLayout());
        
        JLabel textP2 = new JLabel("Nom du joueur 2 :");
        areaPlayer2.add("North", textP2);
        
        JTextArea nameP2 = new JTextArea();
        areaPlayer2.add("Center", nameP2);
        
        
        names.add("West", areaPlayer1);
        names.add("East", areaPlayer2);
        
        screen.add("Center", names);
        
        
        JButton startButton = new JButton("Start");
        startButton.addMouseListener(new OnButtonStartListener(screen, jeu, nameP1, nameP2));
        screen.add("South", startButton);
    }
}
