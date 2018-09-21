/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Tanguy
 */
public class StockPions extends JPanel {
    
    private StockUnPion[] stocks;

    public StockPions(int coteStock) {
        super();
        
        stocks = new StockUnPion[6];
        this.setLayout(new GridLayout(3, 2));
        
        for (int i = 0; i < 6; i++) {
            StockUnPion stockUnPion;
            
            if (i % 2 == 0) {
                stockUnPion = new StockUnPion(Color.RED);
            }
            else {
                stockUnPion = new StockUnPion(Color.BLUE);
            }
            
            stocks[i] = stockUnPion;
            this.add(stockUnPion);
        }
    }
    
    public void test() {
        stocks[0].effacePion();
    }
}
