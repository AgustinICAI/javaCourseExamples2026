package domain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ui.GamePanel;
import util.PropertiesLoader;

public class Slider extends Sprite {
  int width;
  int height;

  public Slider(){
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Slider");
    this.x = Integer.parseInt(propertiesPantalla.get("X_INICIAL"));
    this.y = Integer.parseInt(propertiesPantalla.get("Y_INICIAL"));
    this.vx = Integer.parseInt(propertiesPantalla.get("VELOCIDAD_INICIAL"));
    this.vy = 0;
    this.width = Integer.parseInt(propertiesPantalla.get("WIDTH"));
    this.height = Integer.parseInt(propertiesPantalla.get("HEIGHT"));
    this.dv = Integer.parseInt(propertiesPantalla.get("INCREMENTO_VELOCIDAD"));
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, width, height);
  }

  public void mover(HashSet<Integer> teclasPulsadas) {
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Pantalla");
    int tamPX = Integer.parseInt(propertiesPantalla.get("WIDTH"));
    
    if(teclasPulsadas.contains(KeyEvent.VK_LEFT))
      x -= vx/GamePanel.FPS;
    else if (teclasPulsadas.contains(KeyEvent.VK_RIGHT))
      x += vx/GamePanel.FPS;
    if(x<0)
      x = 0;
    else if (x>tamPX-width)
      x = tamPX-width;
  }

  @Override
  public String toString() {
    return "Slider [x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + ", width=" + width + ", height=" + height
        + "]";
  }

  @Override
  public Rectangle getShape() {
    return new Rectangle(x,y, width, height);
  }

  public void incrementaVelocidad() {


  }

  
}
