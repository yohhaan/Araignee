/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class StockUnPion extends JPanel {
    
    public static final double RATIO_MARGE = 0.1; //Ratio par raport au pion
    public static int marge;
    public static int taille;
    
    private boolean isEmpty;
    private Color _color;

    public StockUnPion(Color color) {
        super();
        
        isEmpty = false;
        _color = color;
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!isEmpty) {
            g.setColor(_color);
            g.fillOval(marge, marge, Pion.taille, Pion.taille); 
        }
    }
    
    public void effacePion() {
        isEmpty = true;
        this.repaint();
    }
}
