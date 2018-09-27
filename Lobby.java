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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Lobby extends JPanel{
    
    private final static double WIDTH_RATIO = 0.5, HEIGHT_RATIO = 0.2;
    
    private JPanel _content;
    
    public Lobby(Fenetre fenetre) {
        super();
        
        this.setLayout(new GridBagLayout());
        
        Dimension dimensionFenetre = fenetre.getSize();
        int width = (int)dimensionFenetre.getWidth();
        int height = (int)dimensionFenetre.getHeight();
        
        _content = new JPanel();
        _content.setLayout(new BorderLayout());
        _content.setBackground(new Color(200, 200, 200, 200));
        _content.setPreferredSize(new Dimension((int) (WIDTH_RATIO * width), (int) (HEIGHT_RATIO * height)));
        
        JLabel title = new JLabel("Le jeu de l'arraigné, par ECLAIR, ou presque");
        title.setFont(new Font("Lucida Handwriting", Font.BOLD, 14));
        _content.add("North", title);
        
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
        
        _content.add("Center", names);
        
        
        JButton startButton = new JButton("Start");
        OnButtonStartListener buttonStartListener = new OnButtonStartListener(fenetre, nameP1, nameP2);
        startButton.addMouseListener(buttonStartListener);
        _content.add("South", startButton);
        
        
        this.add(_content);
        
        
        nameP1.addKeyListener(new TextAreaListener(nameP1, nameP2));
        nameP2.addKeyListener(new TextAreaListener(nameP2, startButton));
        startButton.addKeyListener(buttonStartListener);
    }
    
    public void display(Fenetre fenetre) {
        fenetre.getContentPane().removeAll();
        fenetre.add(this);
        fenetre.getContentPane().revalidate();
        fenetre.getContentPane().repaint();
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
    
    public void resized(Fenetre fenetre) {
        Dimension dimensionFenetre = fenetre.getSize();
        int width = (int)dimensionFenetre.getWidth();
        int height = (int)dimensionFenetre.getHeight();
        
        _content.setPreferredSize(new Dimension((int) (WIDTH_RATIO * width), (int) (HEIGHT_RATIO * height)));
    }
}
