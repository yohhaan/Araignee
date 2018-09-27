package araignee;

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
    
    public Grille(Jeu jeu) {
        super();
        
        _jeu = jeu;
        
        this.setLayout(new GridLayout(3, 3));
        
        for (int i=0; i<9; i++){
            Case c = new Case(i);
            
            c.addMouseListener(new OnCaseClickListener(_jeu, c));
            
            _grille.add(c); // initialisation grille avec les 9 cases
            this.add(c);
        }
    }
    
    public void changeEtat(int position, int occupe) {
        _grille.get(position)._occupe = occupe;
        _grille.get(position).repaint();
    }
}
