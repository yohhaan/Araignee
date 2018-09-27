package araignee;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class TextAreaListener implements KeyListener {
    
    JComponent _component1, _component2;

    public TextAreaListener(JComponent component1, JComponent component2) {
        _component1 = component1;
        _component2 = component2;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
            _component2.requestFocus();
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
