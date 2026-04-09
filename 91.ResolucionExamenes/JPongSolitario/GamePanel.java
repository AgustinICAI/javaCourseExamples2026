import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;

import util.PropertiesLoader;

public class GamePanel extends JPanel {
  Slider slider;
  Pelota pelota;
  HashSet<Integer> teclasPulsadas;
  public static final int FPS = 30;

  public GamePanel(){
    super();
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
      }
      @Override
      public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_LEFT){
          teclasPulsadas.remove(e.getKeyCode());
        }
      }
    });

    Thread t = new Thread( () -> {
      while(true){
        //MOVER
        pelota.mover();
        slider.mover(teclasPulsadas);
        //COLISIONES
        
        //PINTAR
        this.repaint();
        //DORMIR
        try{
          Thread.sleep(1000 / FPS);
        }catch(InterruptedException e){

        }

      }
    });
    t.start();

  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //Pintar el Slider
    slider.paint(g);
    //Pintar la pelota
    pelota.paint(g);
    //Pintar top 3 puntuaciones

    //Pintar tiempo corriendo

  }


}
