
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class MiVentana extends JFrame {
  public static void main(String[] args) {
      new MiVentana();
    }
  
  JTextArea txtArea;
  int countHilos = 0;
  public MiVentana() {
    init();
  }
  private void init() {
    setTitle("Mi Ventana");
    setSize(400, 300);
    
    this.txtArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(txtArea);
    add(scrollPane);

    JButton btnHilo = new JButton("Iniciar Hilo");
    btnHilo.addActionListener(e -> {
      MiHilo hilo = new MiHilo(countHilos, this);
      hilo.start();
      countHilos++;

    });
    add(btnHilo, BorderLayout.SOUTH);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // Centra la ventana en la pantalla
    setVisible(true);
  }
  public JTextArea getTxtArea() {
    return txtArea;
  }
  public synchronized void appendText(String text) {
    txtArea.append(text);
  }

}
