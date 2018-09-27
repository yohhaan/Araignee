package araignee;

public class Pion {

    public final static double RATIO_TAILLE = 0.1;
    public static int taille;
    
    public final int _type;
    public int _position = 9;
    public boolean _deplacable = true;
    
    Pion(int type, int position){
        _type = type;
    }
    
    
    /*
    GETTER
    */
    
    public int getType() {
        return _type;
    }

    public int getPosition() {
        return _position;
    }
    
    /*
    SETTER
    */

    public void setPosition(int _position) {
        this._position = _position;
    }

    public void setDeplacable(boolean _deplacable) {
        this._deplacable = _deplacable;
    }
    
}
