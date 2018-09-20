/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class Grille extends JPanel {

    private Jeu _jeu;
    private ArrayList<Case> _grille = new ArrayList<Case>();
    
    private final static int COTE = 300;
    
    public Grille(Jeu jeu) {
        super();
        
        _jeu = jeu;
        
        this.setLayout(new GridLayout(3, 3));
        this.setPreferredSize(new Dimension(COTE + 1, COTE + 1));
        
        for (int i=0; i<9; i++){
            Case c = new Case(i);
            
            c.addMouseListener(new OnCaseClickListener(_jeu, c));
            
            _grille.add(c); // initialisation grille avec les 9 cases
            this.add(c);
        }
        
        Case._cote = COTE / 3;
    }
}
