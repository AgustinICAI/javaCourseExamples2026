package icai.examen;

public class EntrenamientoCarrera extends Entrenamiento {
  double kmRecorridos;

  public EntrenamientoCarrera(String tipoSesion, int duracionMinutos, int intensidad, double kmRecorridos) {
    super(tipoSesion, duracionMinutos, intensidad);
    this.kmRecorridos = kmRecorridos;
  }

  public double getKmRecorridos() {
    return kmRecorridos;
  }

  public void setKmRecorridos(double kmRecorridos) {
    this.kmRecorridos = kmRecorridos;
  }
}
