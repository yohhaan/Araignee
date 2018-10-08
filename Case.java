package araignee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Case extends JPanel{
    public final static double RATIO_MARGE = 0.1;
    public static int taille;
    public static int marge;
    
    public int _occupe = 0; // 0 si pas de pion, 1 si le pion du joueur 1 est sur la case, 2 si c'est le pion du joueur 2 qui est présent
    public final int _position; // position dans la grille de la case
    
    public Case(int position) {
        super();
        
        int taille = (int) ((2*RATIO_MARGE + 1) * Pion.taille);
        this.setPreferredSize(new Dimension(taille, taille));
        
        this.setBackground(Color.YELLOW);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        _position = position;
    }
    
 
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image marbre = new ImageIcon("marbre.jpg").getImage();
        Image marbreResized = new ImageIcon(marbre.getScaledInstance(taille, taille, Image.SCALE_DEFAULT)).getImage();
        g.drawImage(marbreResized, 0, 0, this);
        
        switch(_occupe) {
            case 0:
                return;
            case 1:
                g.setColor(Jeu.COULEUR_JOUEUR_1);
                break;
            case 2:
                g.setColor(Jeu.COULEUR_JOUEUR_2);
                break;
        }

        g.fillOval(marge, marge, Pion.taille, Pion.taille); 
    }

    
    /*
    GETTER
    */
    public int getPosition() {
        return _position;
    }

    public int getOccupe() {
        return _occupe;
    }
    
    public void resized() {
        setPreferredSize(new Dimension(taille, taille));
    }
    /*
    SETTER
    */
    
    public void setOccupe(int occupe) {
        this._occupe = occupe;
    }
}
