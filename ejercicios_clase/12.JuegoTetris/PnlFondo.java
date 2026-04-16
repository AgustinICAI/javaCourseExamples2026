import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PnlFondo extends JPanel{

  BufferedImage bi;
  static int WIDTH = 1408;
  static int HEIGHT = 768;
  JuegoDisparos juegoDisparos;


  PnlFondo(JuegoDisparos jd){
    this.juegoDisparos = jd;
    try {
      bi = ImageIO.read(new File("fondo.jpg"));
      this.setPreferredSize(new Dimension(PnlFondo.WIDTH,PnlFondo.HEIGHT));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e){
        juegoDisparos.addDisparos(e.getX(), e.getY());
        PnlFondo.this.repaint();
      }
    });

  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(bi, 0, 0, null);
    juegoDisparos.getDisparos().forEach(d -> g.fillOval(d.x-JuegoDisparos.TAM_DISPARO/2, d.y-JuegoDisparos.TAM_DISPARO/2, JuegoDisparos.TAM_DISPARO,JuegoDisparos.TAM_DISPARO));
  }
  
}
