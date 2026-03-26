import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaEventos extends JFrame{
  JButton btnNorte, btnSur;
  
  public static void main (String argv[]){
    new VentanaEventos();
  }

  VentanaEventos(){
    super("Ventana con muchos eventos");
    init();
  }

  private void init() {
    this.setSize(300,300);
    btnNorte = new JButton("Botón Norte");
    btnNorte.addActionListener( new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("botón norte pulsado");
      }
    });

    btnSur = new JButton("Botón Sur");
    btnSur.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("botón sur pulsado");
      }
    });

    this.add(btnNorte, BorderLayout.NORTH);
    this.add(btnSur, BorderLayout.SOUTH);

    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1)
          System.out.println("Disparando");
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

}