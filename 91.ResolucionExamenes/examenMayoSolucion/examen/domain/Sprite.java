package examen.domain;

import java.util.HashSet;

public abstract class Sprite extends Elemento {

  protected double vx, vy;

  public Sprite(double x, double y, int width, int height, double vx, double vy) {
    super(x, y, width, height);
    this.vx = vx;
    this.vy = vy;
  }

  public abstract void updatePosicion(HashSet<Integer> teclasPulsadas);

  public abstract void reset();
}
