package araignee;

public class Joueur {
    public String _nom;
    public int _id;
    public int _positionStock;
    
    Joueur(String nom, int id, int position){
        _nom=nom;
        _id = id;
        _positionStock =position;
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
    
}
