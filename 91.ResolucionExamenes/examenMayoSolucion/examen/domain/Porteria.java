package examen.domain;

import java.awt.Color;
import java.awt.Graphics;

import examen.ui.GamePanel;

public class Porteria extends Elemento {
  public static final int ANCHO_PORTERIA = 120;
  public static final int ALTO_PORTERIA = 4;

  public Porteria(double y) {
    super((GamePanel.ANCHO_MESA - ANCHO_PORTERIA) / 2, y, ANCHO_PORTERIA, ALTO_PORTERIA);
  }

  @Override
  public void pintar(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect((int) x, (int) y, width, height);
  }

}
