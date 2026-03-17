import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class JVentana extends JFrame{
  public static void main(String argv[]){
    new JVentana();
  }
  
  public JVentana(){
    super("Mi Ventana");
    init();    
  }
  public void init(){
    JPanel pnlNorth = new JPanel(); 
    pnlNorth.setBackground(Color.RED);
    this.add(pnlNorth,BorderLayout.NORTH);

    JPanel pnlSouth = new JPanel(); 
    pnlSouth.setBackground(Color.YELLOW);

    JButton btnAceptar = new JButton("Aceptar");
    pnlSouth.add(btnAceptar);
    JButton btnCancelar = new JButton("Cancelar");
    pnlSouth.add(btnCancelar);
    this.add(pnlSouth,BorderLayout.SOUTH);

    JPanel pnlEast = new JPanel(); 
    pnlEast.setBackground(Color.BLACK);
    this.add(pnlEast,BorderLayout.EAST);
    JPanel pnlWest = new JPanel(); 
    pnlWest.setBackground(Color.BLUE);
    this.add(pnlWest,BorderLayout.WEST);
    JPanel pnlCenter = new JPanel(); 
    pnlCenter.setBackground(Color.GREEN);
    pnlCenter.add(new JButton("centro"));
    this.add(pnlCenter,BorderLayout.CENTER);



    this.setSize(400, 400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }



}
