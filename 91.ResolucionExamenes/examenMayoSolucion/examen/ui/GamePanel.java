package examen.ui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

import examen.domain.Disco;
import examen.domain.Elemento;
import examen.domain.Sprite;
import examen.domain.Marcador;
import examen.domain.Mazo;
import examen.domain.Porteria;

public class GamePanel extends JPanel {

  public static final int ANCHO_MESA = 400;
  public static final int ALTO_MESA = 600;

  public static final int FPS = 60;
  public static final int GOLES_PARA_GANAR = 5;

  // Animacion
  public static final int FRAMES_ANIMACION = 120; // 2 segundos a 60fps

  /*
   * Variables a rellenar por el alumno según el enunciado. Se pueden añadir más
   * variables si se considera necesario.
   */
  private ArrayList<Elemento> elementos;
  private HashSet<Integer> teclasPulsadas;
  private Thread gameThread;
  private boolean running;
  private int winner = 0;
  private Marcador marcador1, marcador2;

  public GamePanel() {
    super();
    initElementos();
    init();
    teclasPulsadas = new HashSet<>();
    running = true;
    setPreferredSize(new Dimension(ANCHO_MESA, ALTO_MESA));
    setBackground(new Color(20, 100, 20));
    setFocusable(true);
    gameThread = new Thread(() -> {
      int animacionGanadoraCounter = 0;
      while (running) {
        wait(getDelay());
        if (winner == 0) {
          updatePosicionesDeElementos();
          checkColisiones();

          winner = getWinner();

          if (checkWinCondition()) {
            winner = getWinner();
          }
        } else {
          animacionGanadoraCounter++;
          updatePosicionMarcadores();
          if (animacionGanadoraCounter >= FRAMES_ANIMACION) {
            wait(1000);
            animacionGanadoraCounter = 0;
            reset();
          }
        }
        repaint();
      }
    });
  }

  private void wait(int amount) {
    try {
      Thread.sleep(amount);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private int getDelay() {
    return (int) 1000.0 / FPS;
  }

  public void arrancarGameThread() {
    gameThread.start();
  }

  private boolean checkWinCondition() {
    return (marcador1.getScore() >= 5 || marcador2.getScore() >= 5);
  }

  private int getWinner() {
    if (marcador2.getScore() >= 5) {
      marcador2.setWinner(true);
      return 2;
    } else if (marcador1.getScore() >= 5) {
      marcador1.setWinner(true);
      return 1;
    }
    return 0;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Linea central (se considera decoración ya que no se interactúa con ella)
    g.setColor(Color.WHITE);
    g.drawLine(0, ALTO_MESA / 2, ANCHO_MESA, ALTO_MESA / 2);

    // ElementosGráficos

    elementos.forEach(elem -> elem.pintar(g));
  }

  private void updatePosicionesDeElementos() {
    elementos.forEach(e -> {
      if (e instanceof Sprite em) {
        em.updatePosicion(teclasPulsadas);
      }
    });
  }

  private void updatePosicionMarcadores() {
    for (Elemento e : elementos) {
      if (e instanceof Marcador m) {
        m.updatePosicion();
      }
    }
  }

  private void checkColisiones() {
    Disco d;
    if ((d = getDisco()) != null) {
      d.checkColisionConBordes();
      d.checkColisionesConMazos(elementos);
      checkColisionesDiscoYPorteria(d);
    }
  }

  private void checkColisionesDiscoYPorteria(Disco d) {
    for (Elemento elemento : elementos) {
      if (elemento instanceof Porteria p) {
        if (d.getY() > ALTO_MESA / 2 && p.getArea().intersects(d.getArea())) {
          marcador2.setScore(marcador2.getScore() + 1);
          d.reset();
        } else if (d.getY() < ALTO_MESA / 2 && p.getArea().intersects(d.getArea())) {
          marcador1.setScore(marcador1.getScore() + 1);
          d.reset();
        }
      }
    }
  }

  private Disco getDisco() {
    for (Elemento elemento : elementos) {
      if (elemento instanceof Disco d) {
        return d;
      }
    }
    return null;
  }

  private void initElementos() {
    elementos = new ArrayList<>();
    elementos.add(new Mazo(true)); // j1
    elementos.add(new Mazo(false)); // j2
    elementos.add(new Porteria(0));
    elementos.add(new Porteria(ALTO_MESA - 4));
    elementos.add(new Disco());
    marcador1 = new Marcador((double) 10, (double) ALTO_MESA - 10, 1);
    marcador2 = new Marcador((double) 10, 35, 2);
    elementos.add(marcador1);
    elementos.add(marcador2);
  }

  public void init() {
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        teclasPulsadas.add(e.getKeyCode());
      }

      @Override
      public void keyReleased(KeyEvent e) {
        teclasPulsadas.remove(e.getKeyCode());
      }
    });
  }

  private void reset() {
    winner = 0;
    marcador1.reset();
    marcador2.reset();
    for (Elemento elemento : elementos) {
      if (elemento instanceof Sprite em) {
        em.reset();
      }
    }
  }
}
