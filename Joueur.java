package araignee;

import java.awt.Color;

public class Joueur {
    public String _nom;
    public int _id;
    public int _positionStock;
    public final Color _couleur;
    public int _phaseJeu;
    
    Joueur(String nom, int id, int position, Color couleur){
        _nom=nom;
        _id = id;
        _positionStock =position;
        _couleur=couleur;
        _phaseJeu =1;
    }

    /*
    GETTER
    */
    public int getId() {
        return _id;
    }
    
    public int getPhaseJeu() {
        return _phaseJeu;
    }

    public int getPositionStock() {
        return _positionStock;
    }
    
        public String getNom() {
        return _nom;
    }

    public Color getCouleur() {
        return _couleur;
    }

    /*
    SETTER
    */
    public void setPositionStock(int positionStock) {
        this._positionStock = positionStock;
    }

    public void setPhaseJeu(int _phaseJeu) {
        this._phaseJeu = _phaseJeu;
    }
    
    

}
