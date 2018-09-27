package araignee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu extends JPanel{
    public final static Color couleurJoueur1 = Color.RED;
    public final static Color couleurJoueur2 = Color.BLUE;
    
    private Grille _grille;
    private StockPions stockPions;
    private Joueur _joueur1;
    private Joueur _player;
    private Joueur _joueur2;
    private JLabel _message;
    

    Jeu(Fenetre fenetre){
        super();
        
        _message = new JLabel("Au tour du joueur 1 de jouer !");
        
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new FlowLayout());
        
        _grille = new Grille(this); // Crée la grille et les pions
        sectionGauche.add(_grille);
        
        this.add("West", sectionGauche);
        
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new BorderLayout());
        
        sectionDroite.add("North", _message);
        
        JPanel areaStockPions = new JPanel();
        areaStockPions.setLayout(new FlowLayout());
        sectionDroite.add("Center", areaStockPions);
        
        stockPions = new StockPions(100);
        areaStockPions.add(stockPions);
        
        this.add("East", sectionDroite);
    }
    
    /**
     * initialisation du jeu
     */
    void start(String nameP1, String nameP2){
        
        _joueur1 = new Joueur(nameP1, 1,0,couleurJoueur1 );
        _joueur2 = new Joueur(nameP2, 2,1,couleurJoueur2);
        _player=_joueur1;
        
        _message.setText("Au tour de " + _player.getNom() + " de jouer !");
        _message.setForeground(_player.getCouleur());
        _message.repaint();
    }
    
    public void display(Fenetre fenetre){
        
        fenetre.getContentPane().removeAll();
        fenetre.add(this);
        fenetre.getContentPane().revalidate();
        fenetre.getContentPane().repaint();
    }

    
    
    


    
         
        
    public void changePlayer(){
        if (this.getPlayer() ==_joueur1){
            this.setPlayer(_joueur2);
        }
        else
            this.setPlayer(_joueur1);
        _message.setText("Au tour de " + _player.getNom() + " de jouer !");
        _message.setForeground(_player.getCouleur());
        _message.repaint();
    }
    
    public void click(Case c) {
        System.out.println("La case " + c + " a été clickée !");
        
        try{
        if (c.getOccupe() != 0){
            if (c.getOccupe() != 0){
                throw new ExceptionCase("Tentative de placer un pion sur une case déjà occupée");
            }
            else {
                c.setOccupe(0);
                // transfert du pion ailleurs ?
            }
        }
        else {
            c.setOccupe(_player.getId()); // case à présent occupée par un pion du joueur en train de jouer

            stockPions.retrait(this.getPlayer()); // suppression d'un pion dans les stocks
            
            _grille.changeEtat(c.getPosition(), this.getPlayer().getId()); // modifie état de la case

            this.changePlayer();  //au tour du joueur suivant de jouer
        }
        } catch(ExceptionCase e){
            
            // gérer les exceptions
            
        }
        
        
        
        if (c.getOccupe()==0){
           
            
            

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
    

    /*
    GETTER
    */

    public Joueur getPlayer() {
        return _player;
    }
    
    /*
    SETTER
    */
    
    public void setPlayer(Joueur player) {
        _player = player;
    }

    public void resized(Fenetre fenetre) {}

}

