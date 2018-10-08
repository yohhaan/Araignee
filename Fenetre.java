package araignee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

public class Fenetre extends JFrame implements ComponentListener{
    
    private enum Etat {JEU, LOBBY};
    
    private final static int INITIAL_WIDTH = 600, INITIAL_HEIGHT = 600;
    
    private Etat _etat;
    private Lobby _lobby;
    private Jeu _jeu;
    
    private int _width, _height;
    
    public Fenetre() {
        super("Jeu de l'araignée !");
        
        _width = INITIAL_WIDTH;
        _height = INITIAL_HEIGHT;
        
        setSize(_width, _height);
        getContentPane().setLayout(new BorderLayout());
        addComponentListener(this);
        
        _etat = Etat.LOBBY;
        
        _lobby = new Lobby(this);
        _jeu = new Jeu(this);
        
        _lobby.display(this);
    }
    
    public void startJeu(String nameP1, String nameP2) {
        _etat = Etat.JEU;
        _jeu.display(this);
        _jeu.start(nameP1, nameP2);
    }

    public void stopJeu() {
        _etat=Etat.LOBBY;
        _lobby.display(this);
    }
    @Override
    public void componentResized(ComponentEvent e) {
        
        Dimension dimensionFenetre = getSize();
        _width = (int)dimensionFenetre.getWidth();
        _height = (int)dimensionFenetre.getHeight();
        
        if (_etat == Etat.LOBBY) {
            _lobby.display(this);
        }
        else {
            _jeu.display(this);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
    
    @Override
    public int getWidth() {
        return _width;
    }
    
    @Override
    public int getHeight() {
        return _height;
    }
}
