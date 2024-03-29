package thegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pong extends JPanel implements ActionListener, KeyListener {
    private TheGame game;
    private Ball ball;
    private Paddle player1, player2;
    private int score1, score2;
    
    public Pong(TheGame game) {
        setBackground(Color.WHITE);
        this.game = game;
        ball = new Ball(game);
        player1 = new Paddle(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
        player2 = new Paddle(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    public Paddle getPlayer(int playerNo) {
        if(playerNo == 1)
            return player1;
        else
            return player2; 
    }
    
    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }
    
    public int getScore(int playerNo){
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }
    
    private void update() {
        ball.update();
        player1.update();
        player2.update();  
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
        g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2, 75);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }
}