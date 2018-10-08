package araignee;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Grille extends JPanel {

    private Jeu _jeu;
    private ArrayList<Case> _cases = new ArrayList<Case>();
    
    public Grille(Jeu jeu) {
        super();
        
        _jeu = jeu;
        
        this.setLayout(new GridLayout(3, 3));
        
        for (int i=0; i<9; i++){
            Case c = new Case(i);
            
            c.addMouseListener(new OnCaseClickListener(_jeu, c));
            
            _cases.add(c); // initialisation grille avec les 9 cases
            this.add(c);
        }
    }
    
    public void changeEtat(int position, int occupe) {
        _cases.get(position)._occupe = occupe;
        _cases.get(position).repaint();
    }
    
    public boolean checkLine(int line){
        // vérifie pour une ligne si 3 pions sont alignés, l'argument line qui est passé doit être la position de la première case de la ligne à tester
        return ( _cases.get(line).getOccupe()!=0 &&_cases.get(line).getOccupe()==_cases.get(line+1).getOccupe()&&_cases.get(line).getOccupe() ==_cases.get(line+ 2).getOccupe());
    }
    
        public boolean checkColumn(int column){
        // vérifie pour une colonne si 3 pions sont alignés, l'argument column qui est passé doit être la position de la première case de la colonne à tester
        return ( _cases.get(column).getOccupe()!=0 && _cases.get(column).getOccupe()==_cases.get(column+3).getOccupe()&&_cases.get(column).getOccupe() ==_cases.get(column+ 6).getOccupe());
    }
        
        
        public boolean checkDiag(){
        // vérifie l'alignement sur les diagonales
        return ( _cases.get(0).getOccupe()!=0 && _cases.get(0).getOccupe()==_cases.get(4).getOccupe()&&_cases.get(0).getOccupe() ==_cases.get(8).getOccupe() || _cases.get(2).getOccupe()!=0 && _cases.get(2).getOccupe()==_cases.get(4).getOccupe()&&_cases.get(2).getOccupe() ==_cases.get(6).getOccupe());
    }
        
    public boolean check(){
        if (checkLine(0)||checkLine(3)||checkLine(6)||checkColumn(0)||checkColumn(1)||checkColumn(2)||checkDiag())
            return true;
        else
            return false;
        
    }
    

    public void resized() {
        for (int i = 0; i < _cases.size(); i++) {
            _cases.get(i).resized();
        }
    }

}
