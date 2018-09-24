package araignee;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Tanguy
 */
public class OnCaseClickListener implements MouseListener {
    
    private Jeu _jeu;
    private Case _case;

    public OnCaseClickListener(Jeu jeu, Case c) {
        _jeu = jeu;
        _case = c;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        _jeu.click(_case);
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
