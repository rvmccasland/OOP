package thegame;

import java.awt.Color;
import javax.swing.JFrame;
 
public class TheGame extends JFrame {
    private final static int gameWidth = 700, gameHeight = 450;
    private Pong panel;
 
    public TheGame() {
        setSize(gameWidth, gameHeight);
        setTitle("Ping Pong Game");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new Pong(this);
        add(panel);
    }
     
    public Pong getPanel() {
        return panel;
    }
     
    public static void main(String[] args) {
        new TheGame();
    }
}
