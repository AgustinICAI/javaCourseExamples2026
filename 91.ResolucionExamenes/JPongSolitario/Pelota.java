import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import util.PropertiesLoader;

public class Pelota extends Sprite {
  
  int dv;
  int size;

  public Pelota(){
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Pelota");
    this.x = Integer.parseInt(propertiesPantalla.get("X_INICIAL"));
    this.y = Integer.parseInt(propertiesPantalla.get("Y_INICIAL"));
    this.vx = Integer.parseInt(propertiesPantalla.get("VELOCIDAD_INICIAL_X"));
    this.vy = Integer.parseInt(propertiesPantalla.get("VELOCIDAD_INICIAL_Y"));
    this.dv = Integer.parseInt(propertiesPantalla.get("INCREMENTO_VELOCIDAD"));
    this.size = Integer.parseInt(propertiesPantalla.get("SIZE"));
  }

  public int getDv() {
    return dv;
  }

  public int getSize() {
    return size;
  }

  @Override
  void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(x, y, size, size);
  }

  void mover() {
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Pantalla");
    int tamPX = Integer.parseInt(propertiesPantalla.get("WIDTH"));
    int tamPY = Integer.parseInt(propertiesPantalla.get("HEIGHT"));
    x += vx/GamePanel.FPS;
    y += vy/GamePanel.FPS;

    if(x > tamPX || x < 0)
      vx = -vx;
    if(y > tamPY || y < 0)
      vy = -vy;
  }

  @Override
  public String toString() {
    return "Pelota [x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + ", dv=" + dv + ", size=" + size + "]";
  }

  

  
  
}
