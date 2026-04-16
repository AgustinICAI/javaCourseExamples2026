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

  public Juego(JVentana ventana){
    
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

  public String getGanador() {
    int[] combinacionGanadora = null;
    for(int combinacion = 0; combinacion < combinaciones.length; combinacion ++){
      boolean ganador = true;
      for(int i = 0; i < combinaciones[i].length; i ++){
        Letra letra = casillas.get(i).getLetra();
        if(letra==null || (letra instanceof LetraO && turnoX) || (letra instanceof LetraX && !turnoX) )
          ganador = false;
      }
      if(ganador)
        combinacionGanadora = combinaciones[combinacion];
    }
    if(combinacionGanadora != null)
      return "Ganador " + (turnoX?"X":"O");
    else return null;
  }
  


}
