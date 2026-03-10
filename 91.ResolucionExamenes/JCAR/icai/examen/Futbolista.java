package icai.examen;

import icai.internal.Competicion;

public class Futbolista extends Deportista implements ParticipaCompeticiones {
  Futbolista(String nombre, double peso, String patrocinador) {
    super(nombre, peso, patrocinador);
  }

  @Override
  public int getPartidosSemana() {
    return Competicion.getCompeticionesSemanales(nombre , Competicion.FUTBOL);
  }

  public double getTiempoRecuperacion() {
    double minutosTotalesEntrenamientos = 0;
    for (Entrenamiento e : entrenamientos) {
      minutosTotalesEntrenamientos += e.getDuracionMinutos();
    }
    return getPartidosSemana() * 10 + (minutosTotalesEntrenamientos / 100);
  }
  @Override
  public double gastoEnergeticoSemanal() {
    //Por cada partido jugado esa semana, +900 Kcal
    return super.gastoEnergeticoSemanal() + getPartidosSemana() * 900;
  }
  
}
