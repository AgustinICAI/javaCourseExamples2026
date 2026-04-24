package examenMayo.ui;

import javax.swing.*;

import java.awt.*;

import examenMayo.dominio.Casilla;
import examenMayo.dominio.Juego;
/**
 * Clase que representa la ventana principal del juego. Se encarga de crear el tablero y de gestionar la animación de parpadeo de las casillas ganadoras cuando se detecta un ganador. También gestiona el inicio de una nueva partida cuando se hace clic en la ventana después de que se haya detectado un ganador.
 */
public class JVentana extends JFrame {
  private Juego juego;
  private Tablero tablero;
  static int VELOCIDAD_FLASH = 500; // ms

  public static void main(String[] args) {
    new JVentana();
  }

  public JVentana() {
    super("Tres En Ralla");
    this.juego = new Juego(this);
    tablero = new Tablero(juego);
    this.setLayout(new BorderLayout());
    init();
  }

  private void init() {
    this.add(tablero);
    this.pack();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }

  public Juego getJuego() {
    return juego;
  }

  public void arrancarAnimacion(int[] combinacionGanadora) {
    // **BLOQUE DE CÓDIGO A IMPLEMENTAR POR EL ALUMNO**//
    new Thread(() -> {
      boolean visible = true;
      while (!tablero.isNuevaPartida()) {
        visible = !visible;
        for (int i = 0; i < juego.getCasillas().size(); i++) {
          Casilla c = juego.getCasillas().get(i);
          if (i == combinacionGanadora[0] || i == combinacionGanadora[1] || i == combinacionGanadora[2]) {
            c.setVisible(visible);
          } else {
            c.setVisible(!visible);
          }
        }
        tablero.repaint();
        try {
          Thread.sleep(VELOCIDAD_FLASH);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

}
