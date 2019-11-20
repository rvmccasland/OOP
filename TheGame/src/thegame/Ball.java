package thegame;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
 
public class Ball
{
  private static final int ballWidth = 20, ballHeight = 20;
  private TheGame game;
  private int x, y, xa = 4, ya = 4;
   
  public Ball(TheGame game)
  {
    this.game = game;
    x = game.getWidth() / 2;
    y = game.getHeight() / 2;
  }
  
  private boolean exitLeftSide()
  {
      return x < 0;
  }
  
  private boolean exitRightSide()
  {
      return x > game.getWidth() - ballWidth - 7;
  }
  
  private boolean hitTopOrBottom()
  {
      return y < 0 || y > game.getHeight() - ballHeight - 29;
  }
  
  private int resetToMiddle()
  {
      return game.getWidth() / 2;
  }
  
  public void checkCollisionWithSides()
  {
    x += xa;
    y += ya;
    if (exitLeftSide())
    {
      game.getPanel().increaseScore(1);
      x = resetToMiddle();
      xa = -xa;
    }
    else if (exitRightSide())
    {
      game.getPanel().increaseScore(2);
      x = resetToMiddle();
      xa = -xa;
    }
    else if (hitTopOrBottom())
      ya = -ya;
  }
  
  public void checkVictoryConditions()
  {
      if(game.getPanel().getScore(1) == 10)
      {
        JOptionPane.showMessageDialog(null, "Player 1 wins!!", "Ping Pong Game", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
      }
          
      else if(game.getPanel().getScore(2) == 10)
      {
        JOptionPane.showMessageDialog(null, "Player 2 wins!!", "Ping Pong Game", JOptionPane.PLAIN_MESSAGE); 
        System.exit(0);
      }    
  }
   
  public void checkCollisionWithPaddles()
  {
    if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds()
            .intersects(getBounds()))
        xa = -xa;
  }
  
  public void update()
  {
      checkCollisionWithSides();
      checkCollisionWithPaddles();
      checkVictoryConditions();
  }
   
  public Rectangle getBounds()
  {
    return new Rectangle(x, y, ballWidth, ballHeight);
  }
   
  public void paint(Graphics g)
  {
    g.fillRect(x, y, ballWidth, ballHeight);
  }
}
