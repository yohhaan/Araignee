/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class StockPions extends JPanel {

    public StockPions(int coteStock) {
        super();
        
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new GridLayout(3, 2));
        
        for (int i = 0; i < 6; i++) {
            this.add(new StockUnPion());
        }
    }
    
}
