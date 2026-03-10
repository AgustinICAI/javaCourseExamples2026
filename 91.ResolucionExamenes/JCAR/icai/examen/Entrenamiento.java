package icai.examen;

public class Entrenamiento {
    String tipoSesion;
    int duracionMinutos;
    int intensidad;    
    public Entrenamiento(String tipoSesion, int duracionMinutos, int intensidad) {
        this.tipoSesion = tipoSesion;
        this.duracionMinutos = duracionMinutos;
        this.setIntensidad(intensidad);
    }
    
    public String getTipoSesion() {
        return tipoSesion;
    }
    
    public void setTipoSesion(String tipoSesion) {
        this.tipoSesion = tipoSesion;
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    
    public int getIntensidad() {
        return intensidad;
    }
    
    public void setIntensidad(int intensidad) {
        if (intensidad >= 1 && intensidad <= 5) {
            this.intensidad = intensidad;
        }
    }
    
    public  double calcularCaloriasQuemadas(double peso) {
      return duracionMinutos * intensidad * peso * 0.08;
    }

    @Override
    public String toString() {
      //carrera larga 90 min (4)
        return tipoSesion + " " + duracionMinutos + " min (" + intensidad + ")";
    }
}
