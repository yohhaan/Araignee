package araignee;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

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
    
    public void retrait(Joueur player) {
        
        stocks[player.getPositionStock()].effacePion();
        
        if (player.getPositionStock() <=4){
            player.setPositionStock(player.getPositionStock()+2);
        }
        else
            System.out.println("plus de pion en stock pour le joueur qui vient de jouer");
        
    }
}
