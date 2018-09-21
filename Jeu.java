
package araignee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu {
    
    public final static Color couleurJoueur1 = Color.RED;
    public final static Color couleurJoueur2 = Color.BLUE;
    
    JFrame _fenetre;
    
    private Grille _grille;
    private StockPions stockPions;
    private int _player=1;
    private Joueur _joueur1;
    private Joueur _joueur2;
    

    Jeu(JFrame fenetre){   
        _fenetre = fenetre;
    }
    
    /**
     * initialisation du jeu
     */
    void start(String nameP1, String nameP2){
        
        _joueur1 = new Joueur(nameP1, 1);
        _joueur2 = new Joueur(nameP2, 2);
        
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new FlowLayout());
        
        _grille = new Grille(this); // Crée la grille et les pions
        sectionGauche.add(_grille);
        
        _fenetre.add("West", sectionGauche);
        
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new BorderLayout());
        
        JLabel message = new JLabel("Test de message un peu mais pas trop long !");
        sectionDroite.add("North", message);
        
        JPanel areaStockPions = new JPanel();
        areaStockPions.setLayout(new FlowLayout());
        sectionDroite.add("Center", areaStockPions);
        
        stockPions = new StockPions(100);
        areaStockPions.add(stockPions);
        
        _fenetre.add("East", sectionDroite);
        
        _fenetre.repaint();
        _fenetre.setVisible(true);
    }

    public void setPlayer(int player) {
        _player = player;
    }

    public int getPlayer() {
        return _player;
    }
    
    public void click(Case c) {
        System.out.println("La case " + c + " a été clickée !");
        stockPions.test(); // Action temporaire
        _grille.test(); // Action temporaire
    }
}
