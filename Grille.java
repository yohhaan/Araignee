package araignee;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

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
    
    public boolean checkLine(int line){
        // vérifie pour une ligne si 3 pions sont alignés, l'argument line qui est passé doit être la position de la première case de la ligne à tester
        return ( _grille.get(line).getOccupe()!=0 &&_grille.get(line).getOccupe()==_grille.get(line+1).getOccupe()&&_grille.get(line).getOccupe() ==_grille.get(line+ 2).getOccupe());
    }
    
        public boolean checkColumn(int column){
        // vérifie pour une colonne si 3 pions sont alignés, l'argument column qui est passé doit être la position de la première case de la colonne à tester
        return ( _grille.get(column).getOccupe()!=0 && _grille.get(column).getOccupe()==_grille.get(column+3).getOccupe()&&_grille.get(column).getOccupe() ==_grille.get(column+ 6).getOccupe());
    }
        
        
        public boolean checkDiag(){
        // vérifie l'alignement sur les diagonales
        return ( _grille.get(0).getOccupe()!=0 && _grille.get(0).getOccupe()==_grille.get(4).getOccupe()&&_grille.get(0).getOccupe() ==_grille.get(8).getOccupe() || _grille.get(2).getOccupe()!=0 && _grille.get(2).getOccupe()==_grille.get(4).getOccupe()&&_grille.get(2).getOccupe() ==_grille.get(6).getOccupe());
    }
        
    public boolean check(){
        if (checkLine(0)||checkLine(3)||checkLine(6)||checkColumn(0)||checkColumn(1)||checkColumn(2)||checkDiag())
            return true;
        else
            return false;
        
    }
    
    public boolean checkProximity(int i){
        switch (i){
            case 0:
                if (_grille.get(1).getOccupe()==0 || _grille.get(3).getOccupe()==0 || _grille.get(4).getOccupe()==0)
                    return true;
                break;
            case 1:
                if (_grille.get(0).getOccupe()==0 || _grille.get(2).getOccupe()==0 || _grille.get(3).getOccupe()==0|| _grille.get(4).getOccupe()==0|| _grille.get(5).getOccupe()==0)
                    return true;
                break;
            case 2:
                if (_grille.get(1).getOccupe()==0 || _grille.get(4).getOccupe()==0 || _grille.get(5).getOccupe()==0)
                    return true;
                break;
            case 3:
                if (_grille.get(0).getOccupe()==0 || _grille.get(1).getOccupe()==0 || _grille.get(4).getOccupe()==0|| _grille.get(6).getOccupe()==0|| _grille.get(7).getOccupe()==0)
                    return true;
                break;
            case 4:
                return true;
            case 5:
                if (_grille.get(1).getOccupe()==0 || _grille.get(2).getOccupe()==0 || _grille.get(4).getOccupe()==0|| _grille.get(7).getOccupe()==0|| _grille.get(8).getOccupe()==0)
                    return true;
                break;
            case 6:
                if (_grille.get(3).getOccupe()==0 || _grille.get(4).getOccupe()==0 || _grille.get(7).getOccupe()==0)
                    return true;
                break;
            case 7:
                if (_grille.get(6).getOccupe()==0 || _grille.get(3).getOccupe()==0 || _grille.get(4).getOccupe()==0|| _grille.get(5).getOccupe()==0|| _grille.get(8).getOccupe()==0)
                    return true;
                break;
            case 8:
                if (_grille.get(4).getOccupe()==0 || _grille.get(5).getOccupe()==0 || _grille.get(7).getOccupe()==0)
                    return true;
                break;
    }
        return false;
    }
    
    
    
    public boolean checkIfAtProximity(int i, int j){
        switch (i){
            case 0:
                if (j==1 || j==3 || j==4)
                    return true;
                break;
            case 1:
                if (j==0 || j==2 ||j==3||j==4||j==5)
                    return true;
                break;
            case 2:
                if (j==1||j==4||j==5)
                    return true;
                break;
            case 3:
                if (j==0||j==1||j==4||j==6||j==7)
                    return true;
                break;
            case 4:
                return true;
            case 5:
                if (j==1 || j==2 || j==4|| j==7|| j==8)
                    return true;
                break;
            case 6:
                if (j==3 || j==4 || j==7)
                    return true;
                break;
            case 7:
                if (j==6 || j==3 || j==4|| j==5|| j==8)
                    return true;
                break;
            case 8:
                if (j==4 || j==5 || j==7)
                    return true;
                break;
    }
        return false;
    }

    public void resized() {
        for (int i = 0; i < _grille.size(); i++) {
            _grille.get(i).resized();
        }
    }

}
