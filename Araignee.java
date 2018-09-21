/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class Araignee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Fenetre");
        fenetre.setSize(600, 600);
        fenetre.setLayout(new BorderLayout());
        
        Jeu _jeu = new Jeu(fenetre);
        
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
