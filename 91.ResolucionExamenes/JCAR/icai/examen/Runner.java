package icai.examen;

public class Runner extends Deportista {
  public Runner(String nombre, double peso, String patrocinador) {
    super(nombre, peso, patrocinador);
  }

  public double getTiempoRecuperacion() {
    //(kilometrosRecorridos / 10) + (intensidadMediaEntrenamientos)
    double kilometrosRecorridos = 0;
    double intensidadMediaEntrenamientos = 0;
    for (Entrenamiento e : entrenamientos) {
      if(e instanceof EntrenamientoCarrera ec) {
        kilometrosRecorridos += ec.getKmRecorridos();
      }
      intensidadMediaEntrenamientos += e.getIntensidad();
    }

    return (kilometrosRecorridos / 10) + (intensidadMediaEntrenamientos / entrenamientos.size());
  }
}
