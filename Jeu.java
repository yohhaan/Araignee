package araignee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jeu extends JPanel{
    public final static Color COULEUR_JOUEUR_1 = Color.RED;
    public final static Color COULEUR_JOUEUR_2 = Color.BLUE;
    
    public final static double RATIO_TEXT = 0.02;
    public static int tailleTexte;
    
    private Grille _grille;
    private StockPions _stockPions;
    private Joueur _joueur1;
    private Joueur _player;
    private Joueur _joueur2;
    private JLabel _message;
    private Fenetre _fenetre;
    

    Jeu(Fenetre fenetre){
        super();
        _fenetre=fenetre;
        
        this.setLayout(new BorderLayout());

        setSizes(fenetre);
        _message = new JLabel("Au tour du joueur 1 de jouer !");
        _message.setFont(new Font("Lucida Handwritting", Font.PLAIN, tailleTexte));
        
        JPanel sectionGauche = new JPanel();
        sectionGauche.setLayout(new GridBagLayout());
        sectionGauche.setBackground(new Color(0, 0, 0, 0));
        
        _grille = new Grille(this); // Crée la grille et les pions
        sectionGauche.add(_grille);
        
        this.add("Center", sectionGauche);
        
        JPanel sectionDroite = new JPanel();
        sectionDroite.setLayout(new GridBagLayout());
        sectionDroite.setBackground(new Color(0, 0, 0, 0));
        
        JPanel sectionDroiteContent = new JPanel();
        sectionDroiteContent.setLayout(new BorderLayout());
        
        sectionDroiteContent.add("North", _message);
        
        JPanel areaStockPions = new JPanel();
        areaStockPions.setLayout(new FlowLayout());
        sectionDroiteContent.add("Center", areaStockPions);
        
        _stockPions = new StockPions();
        areaStockPions.add(_stockPions);
        
        sectionDroite.add(sectionDroiteContent);
        
        this.add("East", sectionDroite);
    }
    
    /**
     * initialisation du jeu
     */
    public void start(String nameP1, String nameP2){
        
        _joueur1 = new Joueur(nameP1, 1,0,COULEUR_JOUEUR_1);
        _joueur2 = new Joueur(nameP2, 2,1,COULEUR_JOUEUR_2);
        _player=_joueur1;
        
        _message.setText("Au tour de " + _player.getNom() + " de jouer !");
        _message.setForeground(_player.getCouleur());
        _message.repaint();
    }
    
    public void display(Fenetre fenetre){
        
        resized(fenetre);
        
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
            throw new ExceptionCase("Tentative de placer un pion sur une case déjà occupée");
        }
        else {
            c.setOccupe(_player.getId()); // case à présent occupée par un pion du joueur en train de jouer
            _stockPions.retrait(this.getPlayer()); // suppression d'un pion dans les stocks
            _grille.changeEtat(c.getPosition(), this.getPlayer().getId()); // modifie état de la case
            if (_grille.check()){
                
                JOptionPane.showMessageDialog(_fenetre,_player.getNom()+" a gagné !","Gagné !",JOptionPane.PLAIN_MESSAGE);
                
                
                _fenetre.stopJeu();
            }
            else
                this.changePlayer();  //au tour du joueur suivant de jouer
            
            
        }
        } catch(ExceptionCase e){
            
            JOptionPane.showMessageDialog(_fenetre,"Vous ne pouvez pas placer plus d'un pion par case !","Erreur",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);// gérer les exceptions
            
        }      
           
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        Image background = new ImageIcon("bois.jpg").getImage();
        Image bgResized = new ImageIcon(background.getScaledInstance(_fenetre.getWidth(), _fenetre.getHeight(), Image.SCALE_DEFAULT)).getImage();
        g.drawImage(bgResized, 0, 0, this);
    }
    
    public void resized(Fenetre fenetre) {
        
        setSizes(fenetre);
        
        _message.setFont(new Font("Lucida Handwritting", Font.PLAIN, tailleTexte));
        
        _grille.resized();
        _stockPions.resized();
    }
    
    private void setSizes(Fenetre fenetre) {
                
        Jeu.tailleTexte = (int) (Jeu.RATIO_TEXT * fenetre.getWidth());
        
        Pion.taille = (int) (Pion.RATIO_TAILLE * fenetre.getWidth());
        
        StockUnPion.marge = (int) (StockUnPion.RATIO_MARGE * Pion.taille);
        StockUnPion.taille = 2*StockUnPion.marge + Pion.taille;
        
        Case.marge = (int) (Case.RATIO_MARGE * Pion.taille);
        Case.taille = 2*Case.marge + Pion.taille;
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
}

