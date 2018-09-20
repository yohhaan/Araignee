package araignee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Araignee {


    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Fenetre");
        fenetre.setSize(600, 600);
        fenetre.setLayout(new BorderLayout());
        
        Jeu _jeu = new Jeu();
        
        //un commentaire
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new FlowLayout());
        
        Grille grille = new Grille(_jeu);
        sectionGauche.add(grille);
        
        fenetre.add("West", sectionGauche);
        
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new BorderLayout());
        
        JLabel message = new JLabel("Test de message un peu mais pas trop long !");
        sectionDroite.add("North", message);
        
        JPanel coinDroit = new JPanel();
        coinDroit.setLayout(new FlowLayout());
        sectionDroite.add("Center", coinDroit);
        
        StockPions stockPions = new StockPions(100);
        coinDroit.add(stockPions);
        
        fenetre.add("East", sectionDroite);

        
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
