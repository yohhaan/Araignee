
package araignee;

public class Jeu {
    private Grille _grille;
    private int _player=1;
    private Joueur _joueur1;
    private Joueur _joueur2;
    

    Jeu(){
        //
        _joueur1 = new Joueur("Kyuhh", 1);
        _joueur2 = new Joueur("Gryffo",2);
        this.JeuInit();
    }
    
    /**
     * initialisation du jeu
     */
    void JeuInit(){
        _grille = new Grille(this); // crée la grille et les pions
    }

    public void setPlayer(int player) {
        _player = player;
    }

    public int getPlayer() {
        return _player;
    }
    
    public void click(Case c) {
        System.out.println("La case " + c + " a été clickée !");
    }
}

