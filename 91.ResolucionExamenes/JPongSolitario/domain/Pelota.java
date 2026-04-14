package domain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

import ui.GamePanel;
import util.PropertiesLoader;

public class Pelota extends Sprite {
  
  int size;
  int tamPX;
  int tamPY;
  public Pelota(){
    HashMap<String, String> propertiesPelota = PropertiesLoader.loadProperties("properties.txt", "Pelota");
    this.x = Integer.parseInt(propertiesPelota.get("X_INICIAL"));
    this.y = Integer.parseInt(propertiesPelota.get("Y_INICIAL"));
    this.vx = Integer.parseInt(propertiesPelota.get("VELOCIDAD_INICIAL_X"));
    this.vy = Integer.parseInt(propertiesPelota.get("VELOCIDAD_INICIAL_Y"));
    this.dv = Integer.parseInt(propertiesPelota.get("INCREMENTO_VELOCIDAD"));
    this.size = Integer.parseInt(propertiesPelota.get("SIZE"));
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Pantalla");
    tamPX = Integer.parseInt(propertiesPantalla.get("WIDTH"));
    tamPY = Integer.parseInt(propertiesPantalla.get("HEIGHT"));
  }

  public int getDv() {
    return dv;
  }

  public int getSize() {
    return size;
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(x, y, size, size);
  }

  public void mover() {
    x += vx/GamePanel.FPS;
    y += vy/GamePanel.FPS;

    if(x > tamPX - size || x < 0 && vx < 0)
      vx = -vx;
    if(y > tamPY - size && vy > 0 || y < 0)
      vy = -vy;
  }

  @Override
  public String toString() {
    return "Pelota [x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + ", dv=" + dv + ", size=" + size + "]";
  }

  public void checkcolision(Slider slider) {
    if(slider.getShape().intersects(this.getShape()))
    {
      vy=-vy;
      if(this.getX() > slider.getX()+slider.getWidth()/2)
        vx = Math.abs(vx);
      else
        vx = -Math.abs(vx);

    }

  }

  public Rectangle getShape() {
    return new Rectangle(x,y, size, size);
  }

  public boolean isOut() {
    if(y+size >= tamPY)
      return true;
    else return false;
  }


  

  

  
  
}
