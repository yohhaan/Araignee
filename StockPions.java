package araignee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class StockPions extends JPanel {
    
    private StockUnPion[] stocks;

    public StockPions() {
        super();
        
        stocks = new StockUnPion[6];
        this.setLayout(new GridLayout(3, 2));
        setPreferredSize(new Dimension(2 * StockUnPion.taille, 3 * StockUnPion.taille));
        
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
    
    public void reset() {
        for (int i = 0; i < 6; i++) {
            stocks[i].reset();
        }
    }
    
    public void retrait(Joueur player) {
        
        stocks[player.getPositionStock()].effacePion();
        player.setPositionStock(player.getPositionStock()+2); 
        
        if (player.getPositionStock() >=6){
            player.setPhaseJeu(2);
        }
    }
    
    public void resized() {
        setPreferredSize(new Dimension(2 * StockUnPion.taille, 3 * StockUnPion.taille));
    }
}
