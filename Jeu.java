
package araignee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu {
    JFrame _fenetre;
    
    private Grille _grille;
    private StockPions stockPions;
    private int _player=1;
    private Joueur _joueur1;
    private Joueur _joueur2;
    

    Jeu(JFrame fenetre){
        
        _fenetre = fenetre;
        
        _joueur1 = new Joueur("Kyuhh", 1);
        _joueur2 = new Joueur("Gryffo",2);
        
        this.JeuInit();
    }
    
    /**
     * initialisation du jeu
     */
    void JeuInit(){
        
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new FlowLayout());
        
        _grille = new Grille(this); // Crée la grille et les pions
        sectionGauche.add(_grille);
        
        _fenetre.add("West", sectionGauche);
        
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new BorderLayout());
        
        JLabel message = new JLabel("Test de message un peu mais pas trop long !");
        sectionDroite.add("North", message);
        
        JPanel coinDroit = new JPanel();
        coinDroit.setLayout(new FlowLayout());
        sectionDroite.add("Center", coinDroit);
        
        stockPions = new StockPions(100);
        coinDroit.add(stockPions);
        
        _fenetre.add("East", sectionDroite);
    }

    public void setPlayer(int player) {
        _player = player;
    }

    public int getPlayer() {
        return _player;
    }
    
    public void click(Case c) {
        System.out.println("La case " + c + " a été clickée !");
        stockPions.test();
    }
}

