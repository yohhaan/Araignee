package araignee;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

public class OnButtonStartListener implements MouseListener, KeyListener{
    
    private Fenetre _fenetre;
    private Jeu _jeu;
    private JTextArea _nameP1, _nameP2;
    
    public OnButtonStartListener(Fenetre fenetre, JTextArea nameP1, JTextArea nameP2) {
        _fenetre = fenetre;
        _nameP1 = nameP1;
        _nameP2 = nameP2;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        buttonActivated();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonActivated();
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
    private void buttonActivated() {
        
        if (_nameP1.getText().equals("") || _nameP2.getText().equals("") || _nameP1.equals(_nameP2)) {
            System.out.println("Wrong names" + _nameP1.getText() + _nameP2.getText());
        }
        else {
            _fenetre.startJeu(_nameP1.getText(), _nameP2.getText());
        }
    }
}