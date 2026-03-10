package icai.examen;

import icai.internal.Competicion;

public class Tenista extends Deportista implements ParticipaCompeticiones {
  static double FACTOR_COMPETICION  = 0.11;
  
  public Tenista(String nombre, double peso, String patrocinador) {
    super(nombre, peso, patrocinador);
  }

  @Override
  public int getPartidosSemana() {
    return Competicion.getCompeticionesSemanales(nombre , Competicion.TENIS);
  }

  @Override
  public double getTiempoRecuperacion() {
    double minutosEntrenamientoPista = 0;
    double minutosEntrenamientoGimnasio = 0;
    for (Entrenamiento e : entrenamientos) {
      if (e.getTipoSesion().equals("pista")) {
        minutosEntrenamientoPista += e.getDuracionMinutos();
      } else if (e.getTipoSesion().equals("gimnasio")) {
        minutosEntrenamientoGimnasio += e.getDuracionMinutos();
      }
    }
    return (minutosEntrenamientoPista / 60) + (minutosEntrenamientoGimnasio / 120);
  }

  @Override
  public double gastoEnergeticoSemanal() {
    //Su gasto calórico de competición será igual al numero de competición
    //multiplicado por el peso y multiplicado por un factor de competición.
    return getPartidosSemana() * peso * FACTOR_COMPETICION; 
  }


}
