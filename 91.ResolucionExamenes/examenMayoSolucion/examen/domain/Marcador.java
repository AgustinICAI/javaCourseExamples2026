package examen.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import examen.ui.GamePanel;

public class Marcador extends Elemento {
  private final int tamanoFuenteFinal = 80;
  private final int tamanoFuenteInicial = 20;
  private final double xFinal = GamePanel.ANCHO_MESA / 2;
  private final double yFinal = GamePanel.ALTO_MESA / 2;
  private final double xInicial;
  private final double yInicial;
  private int score;
  private double tamanoFuente;
  private boolean winner;
  private int jugador;

  public Marcador(double x, double y, int jugador) {
    super(x, y, 0, 0);
    score = 0;
    tamanoFuente = 20;
    this.xInicial = x;
    this.yInicial = y;
    this.jugador = jugador;
    winner = false;
  }

  @Override
  public void pintar(Graphics g) {
    if (winner) {
      g.setColor(Color.YELLOW);
    } else {
      g.setColor(Color.WHITE);
    }
    g.setFont(new Font("Arial", Font.BOLD, (int) tamanoFuente));
    g.drawString("J" + jugador + ": " + score, (int) x, (int) y);
  }

  public void reset() {
    x = xInicial;
    y = yInicial;
    tamanoFuente = tamanoFuenteInicial;
    winner = false;
    score = 0;
  }

  public void updatePosicion() {
    if (winner) {
      double dx = (xFinal - xInicial) / (double) GamePanel.FRAMES_ANIMACION;
      double dy = (yFinal / 2 - yInicial) / (double) GamePanel.FRAMES_ANIMACION;

      x += dx;
      y += dy;
      tamanoFuente += (tamanoFuenteFinal - tamanoFuenteInicial) / (double) (GamePanel.FRAMES_ANIMACION * 2);
    }
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setWinner(boolean b) {
    winner = b;
  }

  public int getJugador() {
    return jugador;
  }

}
