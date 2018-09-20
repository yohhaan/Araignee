/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class Case extends JPanel{
    public static int _cote = 20;
    
    public int _occupe = 0; // 0 si pas de pion, 1 si le pion du joueur 1 est sur la case, 2 si c'est le pion du joueur 2 qui est présent
    public final int _position; // position dans la grille de la case
    private Jeu jeu;
    
    public Case(int position) {
        super();
        
        this.setBackground(Color.RED);
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
}
