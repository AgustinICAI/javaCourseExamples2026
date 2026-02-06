package fornite.armas;

import fornite.Atacable;
import fornite.Objeto;

public abstract class Arma extends Objeto implements Atacable {
  
  int nivel;
  double alcance;
  double precision;
  int dano;
  

  public Arma(double alcance, double precision, int dano) {
    nivel = 1;
    this.alcance = alcance;
    this.precision = precision;
    this.dano = dano;
  }


  public int atacar(int distancia){
    //FUERZO LA CONVERSION A ENTERO DESDE DOUBLE
    return (int) (nivel*alcance*precision*dano / distancia);
  }
}
