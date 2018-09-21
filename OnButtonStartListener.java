/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Tanguy
 */
public class OnButtonStartListener implements MouseListener {
    
    private JFrame _screen;
    private Jeu _jeu;
    private JTextArea _nameP1, _nameP2;
    
    public OnButtonStartListener(JFrame screen, Jeu jeu, JTextArea nameP1, JTextArea nameP2) {
        _screen = screen;
        _jeu = jeu;
        _nameP1 = nameP1;
        _nameP2 = nameP2;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (_nameP1.getText().equals("") || _nameP2.getText().equals("") || _nameP1.equals(_nameP2)) {
            System.out.println("Wrong names" + _nameP1.getText() + _nameP2.getText());
        }
        else {
            _screen.getContentPane().removeAll();
            _jeu.start(_nameP1.getText(), _nameP2.getText());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}