package araignee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class StockUnPion extends JPanel {

    public static final double RATIO_MARGE = 0.1; //Ratio par raport au pion
    public static int marge;
    public static int taille;
    
    private boolean _isEmpty;
    private Color _color;

    public StockUnPion(Color color) {
        super();
        
        _isEmpty = false;
        _color = color;
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!_isEmpty) {
            g.setColor(_color);
            g.fillOval(marge, marge, Pion.taille, Pion.taille); 
        }
    }
    
    public void reset() {
        _isEmpty = false;
    }
    
    public void effacePion() {
        _isEmpty = true;
        this.repaint();
    }
}
