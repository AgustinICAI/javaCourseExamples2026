package domain;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Sprite {
  int x;
  int y;
  int vx;
  int vy;
  int dv;
  
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getVx() {
    return vx;
  }
  public int getVy() {
    return vy;
  }

  public abstract void paint(Graphics g);
  public abstract Rectangle getShape();
  
  public void incrementaVelocidad() {
    if(vx < 0)
      vx -= dv;
    else 
      vx += dv;
    if(vy < 0)
      vy -= dv;
    else 
      vy += dv;    
  }

}
