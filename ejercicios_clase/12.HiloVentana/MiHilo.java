public class MiHilo extends Thread {
  int id;
  MiVentana ventana;
  static final int ITERACIONES = 10000;
  MiHilo(int id, MiVentana ventana) {
    super();
    this.id= id;
    this.ventana = ventana;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < ITERACIONES; i++) {
      //System.out.println("Hilo: " + id + ", Iteración: " + i);
      ventana.getTxtArea().append("Hilo: " + id + ", Iteración: " + i + "\n");
      try {
        Thread.sleep(20); // Pausa el hilo
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
}
