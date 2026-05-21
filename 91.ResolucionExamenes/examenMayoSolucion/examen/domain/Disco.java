package examen.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;

import examen.ui.GamePanel;

public class Disco extends Sprite {
  public static final int LADO_DISCO = 20;
  public static final int VELOCIDAD_DISCO = 3;

  public Disco() {
    super(
        (double) (GamePanel.ANCHO_MESA / 2 - Disco.LADO_DISCO / 2),
        (double) (GamePanel.ALTO_MESA / 2 - Disco.LADO_DISCO / 2),
        LADO_DISCO,
        LADO_DISCO,
        VELOCIDAD_DISCO,
        VELOCIDAD_DISCO);
  }

  @Override
  public void pintar(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillOval((int) x, (int) y, width, height);
  }

  @Override
  public void updatePosicion(HashSet<Integer> teclasPulsadas) {
    x += vx;
    y += vy;
  }

  public void checkColisionConBordes() {
    if (x <= 0) {
      vx *= -1;
      x = 0;
    } else if (x + width >= GamePanel.ANCHO_MESA) {
      vx *= -1;
      x = GamePanel.ANCHO_MESA - width;
    }
    if (y <= 0) {
      vy *= -1;
      y = 0;
    } else if (y + height >= GamePanel.ALTO_MESA) {
      vy *= -1;
      y = GamePanel.ALTO_MESA - height;
    }
  }

  public void checkColisionesConMazos(ArrayList<Elemento> elementos) {
    for (Elemento e : elementos) {
      if (e instanceof Mazo m) {
        if (m.getArea().intersects(getArea())) {
          // Calcular distancia a cada lado del mazo
          double distArriba = Math.abs(y + height - m.getY());
          double distAbajo = Math.abs(y - (m.getY() + m.getHeight()));
          double distIzquierda = Math.abs(x + width - m.getX());
          double distDerecha = Math.abs(x - (m.getX() + m.getWidth()));
          
          // Encontrar el lado más cercano
          double minDist = Math.min(Math.min(distArriba, distAbajo), Math.min(distIzquierda, distDerecha));
          
          // Rebotar según el lado del impacto
          if (minDist == distArriba || minDist == distAbajo) {
            // Impacto superior o inferior
            vy *= -1;
            if (m.isJugadorUno()) {
              y = m.getY() - height - 2;
            } else {
              y = m.getY() + m.getHeight() + 2;
            }
          } else {
            // Impacto lateral
            vx *= -1;
            if (distIzquierda < distDerecha) {
              x = m.getX() - width - 2;
            } else {
              x = m.getX() + m.getWidth() + 2;
            }
          }
        }
      }
    }
  }

  @Override
  public void reset() {
    x = (double) (GamePanel.ANCHO_MESA / 2 - Disco.LADO_DISCO / 2);
    y = (double) (GamePanel.ALTO_MESA / 2 - Disco.LADO_DISCO / 2);
    vx = VELOCIDAD_DISCO;
    vy = VELOCIDAD_DISCO;

  }

}
