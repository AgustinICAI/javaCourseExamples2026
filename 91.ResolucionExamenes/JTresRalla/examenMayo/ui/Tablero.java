package examenMayo.ui;

import examenMayo.dominio.Casilla;
import examenMayo.dominio.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Tablero extends JPanel {
  final static int ANCHO = 300;
  final static int ALTO = 200;
  final public static int INICIO_CUADRICULA_X = 63;
  final public static int INICIO_CUADRICULA_Y = 17;

  private Juego juego;

  private Image fondo;

  private boolean nuevaPartida = false;
  private String ganador = null; 
  public Tablero(Juego juego) {
    try {
      fondo = ImageIO.read(new File("./resources/fondo.png")).getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT);
    } catch (IOException exception) {
      exception.printStackTrace();
      System.exit(-1);
    }

    this.juego = juego;
    this.addMouseListener(
        // **BLOQUE DE CÓDIGO A IMPLEMENTAR POR EL ALUMNO**//
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX() + "," + e.getY());
            if (ganador == null) {
              juego.pulsado(e.getX(), e.getY());
              repaint();
              ganador = juego.getGanador();
              if (ganador != null) {
                int[] combinacionGanadora = juego.getCombinacionGanadora();
                System.out.println("Ganador: " + ganador);
                System.out.println("Combinación ganadora: " + java.util.Arrays.toString(combinacionGanadora));
              }
            }
            else
              nuevaPartida = true;
          }
        });

    this.setPreferredSize(new Dimension(ANCHO, ALTO));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // **BLOQUE DE CÓDIGO A IMPLEMENTAR POR EL ALUMNO**//
    g.drawImage(fondo, 0, 0, null);

    juego.getCasillas().forEach(c -> {
      if (c.getLetra() != null && c.isVisible())
        c.getLetra().pintar(g);
    });
  }

  public boolean isNuevaPartida() {
    if(nuevaPartida){
      nuevaPartida = false;
      juego.reset();
      return true;
    }
    return false;
  }



}
