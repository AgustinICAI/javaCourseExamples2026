import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
  PnlFondo pnlFondo;

  public static void main (String argv[]){
    new VentanaJuego();

  }
  VentanaJuego(){
    super("dispara platos");
    JuegoDisparos juegoDisparos = new JuegoDisparos();
    pnlFondo = new PnlFondo(juegoDisparos);
    this.add(pnlFondo);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

}