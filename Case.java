package araignee;

import static araignee.StockUnPion.MARGE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class Case extends JPanel{
    public final static int MARGE = 5;
    
    public int _occupe = 0; // 0 si pas de pion, 1 si le pion du joueur 1 est sur la case, 2 si c'est le pion du joueur 2 qui est présent
    public final int _position; // position dans la grille de la case
    private Jeu jeu;
    
    public Case(int position) {
        super();
        
        int _taille = 2*MARGE + Pion.TAILLE;
        this.setPreferredSize(new Dimension(_taille, _taille));
        
        this.setBackground(Color.YELLOW);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        _position = position;
    }
    
    void ModifierEtatCase(int occupe){
        
        try{
        if (_occupe != 0){
            if (occupe != 0){
                throw new ExceptionCase("Tentative de placer un pion sur une case déjà occupée");
            }
            else {
                _occupe = 0;
                // transfert du pion ailleurs ?
            }
        }
        else if (occupe==0) {
            throw new ExceptionCase("Aucun pion sélectionné");
        }
        else {
            _occupe = occupe;
        }
        } catch(ExceptionCase e){
            
            // gérer les exceptions
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int taille = 2*MARGE + Pion.TAILLE;
        
        Image marbre = new ImageIcon("marbre.jpg").getImage();
        Image marbreResized = new ImageIcon(marbre.getScaledInstance(taille, taille, Image.SCALE_DEFAULT)).getImage();
        g.drawImage(marbreResized, 0, 0, this);
        
        switch(_occupe) {
            case 0:
                return;
            case 1:
                g.setColor(Jeu.couleurJoueur1);
                break;
            case 2:
                g.setColor(Jeu.couleurJoueur2);
                break;
        }

        g.fillOval(MARGE, MARGE, Pion.TAILLE, Pion.TAILLE); 
    }

    public void setOccupe(int _occupe) {
        this._occupe = _occupe;
    }

    public int getPosition() {
        return _position;
    }

    public int getOccupe() {
        return _occupe;
    }
}
