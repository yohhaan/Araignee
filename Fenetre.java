/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

/**
 *
 * @author Tanguy
 */
public class Fenetre extends JFrame implements ComponentListener{
    
    private enum Etat {JEU, LOBBY};
    
    private Etat _etat;
    private Lobby _lobby;
    private Jeu _jeu;
    
    public Fenetre() {
        super("Jeu de l'arraignée !");
        
        setSize(600, 600);
        setLayout(new BorderLayout());
        addComponentListener(this);
        
        _etat = Etat.LOBBY;
        
        _lobby = new Lobby(this);
        _jeu = new Jeu(this);
        
        _lobby.display(this);
    }
    
    public void startJeu(String nameP1, String nameP2) {
        _jeu.display(this);
        _jeu.start(nameP1, nameP2);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if (_etat == Etat.LOBBY) {
            _lobby.resized(this);
        }
        else {
            _jeu.resized(this);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
    
}
