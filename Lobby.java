package araignee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Lobby extends JPanel{
    
    private Jeu _jeu;
    
    public Lobby(JFrame screen, Jeu jeu) {
        super();
        _jeu = jeu;
        
        this.setLayout(new GridBagLayout());
        
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(new Color(200, 200, 200, 200));
        
        JLabel title = new JLabel("Le jeu de l'arraigné, par ECLAIR, ou presque");
        title.setFont(new Font("Lucida Handwriting", Font.BOLD, 14));
        content.add("North", title);
        
        JPanel names = new JPanel();
        names.setLayout(new FlowLayout());
        names.setBackground(new Color(200, 200, 200, 0));
        
        
        JPanel areaPlayer1 = new JPanel();
        areaPlayer1.setLayout(new BorderLayout());
        
        JLabel textP1 = new JLabel("Nom du joueur 1 :");
        areaPlayer1.add("North", textP1);
        
        JTextArea nameP1 = new JTextArea();
        areaPlayer1.add("Center", nameP1);
        
        
        JPanel areaPlayer2 = new JPanel();
        areaPlayer2.setLayout(new BorderLayout());
        
        JLabel textP2 = new JLabel("Nom du joueur 2 :");
        areaPlayer2.add("North", textP2);
        
        JTextArea nameP2 = new JTextArea();
        areaPlayer2.add("Center", nameP2);
        
        
        names.add("West", areaPlayer1);
        names.add("East", areaPlayer2);
        
        content.add("Center", names);
        
        
        JButton startButton = new JButton("Start");
        startButton.addMouseListener(new OnButtonStartListener(screen, jeu, nameP1, nameP2));
        content.add("South", startButton);
        
        
        this.add(content);
        screen.add(this);
        
        
        nameP1.addKeyListener(new TextAreaListener(nameP1, nameP2));
        nameP2.addKeyListener(new TextAreaListener(nameP2, startButton));
        startButton.addKeyListener(new OnButtonStartListener(screen, jeu, nameP1, nameP2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Dimension dimensionFenetre = this.getSize();
        int width = (int)dimensionFenetre.getWidth();
        int height = (int)dimensionFenetre.getHeight();
        
        Image background = new ImageIcon("toilearaignee.jpg").getImage();
        Image bgResized = new ImageIcon(background.getScaledInstance(width, height, Image.SCALE_DEFAULT)).getImage();
        g.drawImage(bgResized, 0, 0, this);
    }
    
    
}
