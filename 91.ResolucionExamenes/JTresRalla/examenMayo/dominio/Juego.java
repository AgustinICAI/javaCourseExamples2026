package examenMayo.dominio;

import examenMayo.ui.JVentana;
import examenMayo.ui.Tablero;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Juego {
  //**BLOQUE DE CÓDIGO A IMPLEMENTAR POR EL ALUMNO**//
  ArrayList<Casilla> casillas;
  int[][] combinaciones;
  private JVentana ventana;

  public Juego(JVentana ventana){
    this.ventana = ventana;
    try {
      combinaciones = IOFichero.leerCombinaciones("./resources/WinningCombination.txt");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    casillas = new ArrayList<>();
    for(int i = 0; i < 3; i ++)
      for(int j = 0; j < 3; j ++)
        casillas.add(new Casilla(new Rectangle(j*Casilla.ANCHO+Tablero.INICIO_CUADRICULA_X,
                                               i*Casilla.ANCHO+Tablero.INICIO_CUADRICULA_Y,
                                               Casilla.ANCHO,Casilla.ANCHO)));
                                               
  }

  public ArrayList<Casilla> getCasillas() {
    return casillas;
  }

  boolean turnoX = true;
  public void pulsado(int x, int y) {
    Casilla casillaPulsada = null;
    for(Casilla c : casillas)
      if(c.getArea().contains(new Point(x,y)))
        casillaPulsada = c;
    if(turnoX)
      casillaPulsada.setLetraX();
    else
      casillaPulsada.setLetraO();
    turnoX = !turnoX;
    //this.casillas.stream().filter(c -> c.getArea().contains(new Point(x,y))).collect(Collector<Casilla>);
    
  }

  int[] combinacionGanadora = null;

  public int[] getCombinacionGanadora() {
    return combinacionGanadora;
  }

  public String getGanador() {
    combinacionGanadora = null;
    for(int combinacion = 0; combinacion < combinaciones.length; combinacion ++){
      boolean ganador = true;
      for(int i = 0; i < combinaciones[combinacion].length; i ++){
        int indice = combinaciones[combinacion][i];
        Letra letra = casillas.get(indice).getLetra();
        if(letra==null || (letra instanceof LetraO && !turnoX) || (letra instanceof LetraX && turnoX) )
          ganador = false;
      }
      if(ganador){
        combinacionGanadora = combinaciones[combinacion];
        ventana.arrancarAnimacion(combinacionGanadora);
      }
    }
    if(combinacionGanadora != null)
      return "Ganador " + (turnoX?"O":"X");
    else return null;
  }

  public void reset() {
    casillas.forEach(c -> {c.resetLetra();});
    turnoX = true;
    combinacionGanadora = null;
  }
}
