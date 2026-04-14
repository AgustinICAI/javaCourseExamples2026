package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JPanel;

import domain.Pelota;
import domain.Slider;
import util.PropertiesLoader;

public class GamePanel extends JPanel {
  Slider slider;
  Pelota pelota;
  HashSet<Integer> teclasPulsadas;
  public static final int FPS = 30;
  boolean FIN_JUEGO = false;
  Thread hiloJuego;
  long timeRunning;
  TreeSet<Long> topPuntuaciones;

  public GamePanel(){
    super();
    topPuntuaciones = new TreeSet<>();
    this.teclasPulsadas = new HashSet<>();
    this.slider = new Slider();
    this.pelota = new Pelota();
    HashMap<String, String> propertiesPantalla = PropertiesLoader.loadProperties("properties.txt", "Pantalla");
    this.setPreferredSize(new Dimension(Integer.parseInt(propertiesPantalla.get("WIDTH")),
                 Integer.parseInt(propertiesPantalla.get("HEIGHT"))));
    this.setBackground(Color.BLACK);

    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_LEFT){
          teclasPulsadas.add(e.getKeyCode());
        }
        if(FIN_JUEGO){
          FIN_JUEGO = false;
          arrancaJuego();
        }
      }
      @Override
      public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_LEFT){
          teclasPulsadas.remove(e.getKeyCode());
        }
      }
    });
    arrancaJuego();
  }

  private void arrancaJuego() {
      hiloJuego = new Thread(() -> {
      long lastIncrement = System.currentTimeMillis();
      long startRunning = System.currentTimeMillis();
      while(!FIN_JUEGO){
        timeRunning = System.currentTimeMillis()-startRunning;
        //MOVER
        pelota.mover();
        slider.mover(teclasPulsadas);
        //COLISIONES
        pelota.checkcolision(slider);
        if(System.currentTimeMillis() - lastIncrement > 3000){
          //System.out.print("Aumentando Velocidad");
          pelota.incrementaVelocidad();
          slider.incrementaVelocidad();
          lastIncrement = System.currentTimeMillis();
        }
        if(pelota.isOut()){
          FIN_JUEGO = true;
          if(topPuntuaciones.size()==3 && topPuntuaciones.first() < timeRunning){
            topPuntuaciones.removeFirst();
            topPuntuaciones.add(timeRunning);
          }
          else
            topPuntuaciones.add(timeRunning);
        }
        //PINTAR
        this.repaint();
        //DORMIR
        try{
          Thread.sleep(1000 / FPS);
        }catch(InterruptedException e){

        }

      }
    });
    hiloJuego.start();}

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Pintar el Slider
    slider.paint(g);
    //Pintar la pelota
    pelota.paint(g);
    //Pintar top 3 puntuaciones
    int auxY=0;
    for(long p : topPuntuaciones.descendingSet()){
      g.setColor(Color.RED);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
      g.drawString(p/1000 + " s", 400, 30+auxY);
      auxY+=15;
    }

    //Pintar tiempo corriendo
    g.setColor(Color.RED);
    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    g.drawString(timeRunning/1000 + " s", 10, 30);

    //Pintar FIN PARTIDA
    if(FIN_JUEGO){
      g.setColor(Color.RED);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
      g.drawString("FIN PARTIDA", 100, 100);
      g.drawString("PULSA UNA TECLA", 100, 150);

    }

  }


}
