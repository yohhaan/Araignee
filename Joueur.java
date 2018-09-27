package araignee;

import java.awt.Color;

public class Joueur {
    public String _nom;
    public int _id;
    public int _positionStock;
    public final Color _couleur;
    
    Joueur(String nom, int id, int position, Color couleur){
        _nom=nom;
        _id = id;
        _positionStock =position;
        _couleur=couleur;
    }

    public int getId() {
        return _id;
    }

    public int getPositionStock() {
        return _positionStock;
    }

    public void setPositionStock(int _positionStock) {
        this._positionStock = _positionStock;
    }

    public String getNom() {
        return _nom;
    }

    public Color getCouleur() {
        return _couleur;
    }
    
}
