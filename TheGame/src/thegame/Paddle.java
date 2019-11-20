package thegame;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle
{
    private static final int paddleWidth = 10, paddleHeight = 60;
    private TheGame game;
    private int up, down;
    private int x;
    private int y, ya;
 
    public Paddle(TheGame game, int up, int down, int x) {
        
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }
    
    private boolean inGameBounds()
    {
        return y > 0 && y < game.getHeight() - paddleHeight - 29;
    }
    
    private boolean moveUp()
    {
        return y == 0;
    }
    
    private boolean moveDown()
    {
        return y == game.getHeight() - paddleHeight - 29;
    }
    
    public void updateLocation()
    {
        if (inGameBounds())
            y += ya;
        else if (moveUp())
            y++;
        else if (moveDown())
            y--; 
    }
    public void update() 
    {
        updateLocation();
    }
    
    public void pressed(int keyCode) {
        if (keyCode == up)
          ya = -3;
        else if (keyCode == down)
            ya = 3;
    }
 
    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }
 
     public Rectangle getBounds() {
        return new Rectangle(x, y, paddleWidth, paddleHeight);
    }
 
    public void paint(Graphics g) {
        g.fillRect(x, y, paddleWidth, paddleHeight);
    }
 
    
}
