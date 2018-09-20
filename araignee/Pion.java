package araignee;

public class Pion {
    public final int _type;
    public int _position = 9;
    public boolean _deplacable = true;
    
    Pion(int type, int position){
        _type = type;
    }
    
    public int getType() {
        return _type;
    }

    public int getPosition() {
        return _position;
    }

    public void setPosition(int _position) {
        this._position = _position;
    }

    public void setDeplacable(boolean _deplacable) {
        this._deplacable = _deplacable;
    }
    
}
