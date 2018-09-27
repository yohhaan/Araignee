
package araignee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu extends JPanel{
    
    public final static Color couleurJoueur1 = Color.RED;
    public final static Color couleurJoueur2 = Color.BLUE;
    
    JFrame _fenetre;
    
    private Grille _grille;
    private StockPions stockPions;
    private Joueur _joueur1;
    private Joueur _player;
    private Joueur _joueur2;
    

    Jeu(JFrame fenetre){
        super();
        _fenetre = fenetre;
    }
    
    /**
     * initialisation du jeu
     */
    void start(String nameP1, String nameP2){
        
        _joueur1 = new Joueur(nameP1, 1,0);
        _joueur2 = new Joueur(nameP2, 2,1);
        _player=_joueur1;
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new FlowLayout());
        
        _grille = new Grille(this); // Crée la grille et les pions
        sectionGauche.add(_grille);
        
        this.add("West", sectionGauche);
        
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new BorderLayout());
        
        JLabel message = new JLabel("Test de message un peu mais pas trop long !");
        sectionDroite.add("North", message);
        
        JPanel areaStockPions = new JPanel();
        areaStockPions.setLayout(new FlowLayout());
        sectionDroite.add("Center", areaStockPions);
        
        stockPions = new StockPions(100);
        areaStockPions.add(stockPions);
        
        this.add("East", sectionDroite);
        _fenetre.add(this);
        
        _fenetre.getContentPane().revalidate();
        _fenetre.getContentPane().repaint();
    }

    public void setPlayer(Joueur player) {
        _player = player;
    }

    public Joueur getPlayer() {
        return _player;
    }
    
    public void changePlayer(){
        if (this.getPlayer() ==_joueur1){
            this.setPlayer(_joueur2);
        }
        else
            this.setPlayer(_joueur1);
    }
    
    public void click(Case c) {
        System.out.println("La case " + c + " a été clickée !");
        
        if (c.getOccupe()==0){
           
            c.setOccupe(_player.getId()); // case occupée par un pion du joueur en train de jouer

            stockPions.test(this.getPlayer());
            
            _grille.test(c.getPosition(), this.getPlayer().getId());

            this.changePlayer();
            

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        Dimension dimensionFenetre = this.getSize();
        int width = (int)dimensionFenetre.getWidth();
        int height = (int)dimensionFenetre.getHeight();
        
        Image background = new ImageIcon("bois.jpg").getImage();
        Image bgResized = new ImageIcon(background.getScaledInstance(width, height, Image.SCALE_DEFAULT)).getImage();
        g.drawImage(bgResized, 0, 0, this);
    }
}

