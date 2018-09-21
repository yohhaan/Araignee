/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        JFrame screen = new JFrame("Fenetre");
        screen.setSize(600, 600);
        screen.setLayout(new BorderLayout());
        
        Jeu jeu = new Jeu(screen);
        Lobby lobby = new Lobby(screen, jeu);
        
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
