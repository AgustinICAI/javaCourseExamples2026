package examen.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import examen.ui.GamePanel;

public class Mazo extends Sprite {
  public static final int ANCHO_MAZO = 60;
  public static final int ALTO_MAZO = 15;
  public static final int VELOCIDAD_MAZO = 5;

  private final boolean jugador1;
  private final Color color;
  private final double Y_INICIAL;

  public Mazo(boolean jugador1) {
    super(GamePanel.ANCHO_MESA / 2 - Mazo.ANCHO_MAZO / 2, 
          jugador1 ? GamePanel.ALTO_MESA - 60 : 45, 
          ANCHO_MAZO, ALTO_MAZO, VELOCIDAD_MAZO, VELOCIDAD_MAZO);
    this.jugador1 = jugador1;
    color = jugador1 ? Color.RED : Color.BLUE;
    Y_INICIAL = jugador1 ? GamePanel.ALTO_MESA - 60 : 45;
  }

  @Override
  public void updatePosicion(HashSet<Integer> teclasPulsadas) {
    teclasPulsadas.forEach(k -> {
      if (jugador1) {
        switch (k) {
          case KeyEvent.VK_UP:
            y = Math.max(GamePanel.ALTO_MESA / 2, Math.min(y - vy, GamePanel.ALTO_MESA - height));
            break;
          case KeyEvent.VK_DOWN:
            y = Math.max(GamePanel.ALTO_MESA / 2, Math.min(y + vy, GamePanel.ALTO_MESA - height));
            break;
          case KeyEvent.VK_LEFT:
            x = Math.max(0, Math.min(x - vx, GamePanel.ANCHO_MESA - width));
            break;
          case KeyEvent.VK_RIGHT:
            x = Math.max(0, Math.min(x + vx, GamePanel.ANCHO_MESA - width));
            break;
          default:
            break;
        }
      } else {
        switch (k) {
          case KeyEvent.VK_W:
            y = Math.max(0, Math.min(y - vy, GamePanel.ALTO_MESA / 2 - height));
            break;
          case KeyEvent.VK_S:
            y = Math.max(0, Math.min(y + vy, GamePanel.ALTO_MESA / 2 - height));
            break;
          case KeyEvent.VK_A:
            x = Math.max(0, Math.min(x - vx, GamePanel.ANCHO_MESA - width));
            break;
          case KeyEvent.VK_D:
            x = Math.max(0, Math.min(x + vx, GamePanel.ANCHO_MESA - width));
            break;
          default:
            break;
        }
      }
    });
  }

  @Override
  public void pintar(Graphics g) {
    g.setColor(color);
    g.fillRect((int) x, (int) y, width, height);
  }

  public boolean isJugadorUno() {
    return jugador1;
  }

  @Override
  public void reset() {
    x = GamePanel.ANCHO_MESA / 2 - Mazo.ANCHO_MAZO / 2;
    y = Y_INICIAL;
  }

}
