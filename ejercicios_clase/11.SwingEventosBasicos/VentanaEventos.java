import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaEventos extends JFrame implements ActionListener, MouseListener, KeyListener{
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
    btnNorte.addActionListener(this);

    btnSur = new JButton("Botón Sur");
    btnSur.addActionListener(this);

    this.add(btnNorte, BorderLayout.NORTH);
    this.add(btnSur, BorderLayout.SOUTH);

    this.addMouseListener(this);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == btnNorte){
      System.out.println("Norte");
    }else if (e.getSource() == btnSur){
      System.out.println("Sur");
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Unimplemented method 'mouseClicked'");
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    if(e.getButton() == MouseEvent.BUTTON1)
      System.out.println("Botón izquierdo pulsado");
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Unimplemented method 'mouseReleased'");
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Unimplemented method 'mouseEntered'");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Unimplemented method 'mouseExited'");
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
  }

}