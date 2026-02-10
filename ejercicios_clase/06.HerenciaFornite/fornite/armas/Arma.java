package fornite.armas;

import fornite.Atacable;
import fornite.Objeto;

public abstract class Arma extends Objeto implements Atacable {
  
  private double alcance;
  private double precision;
  private int dano;

  public Arma(double alcance, double precision, int dano) {
    //nivel = 1;
    //OPCION 1: POCO LIMPIA
    //super.setNivel(1);
    //OPCION 2: MAS LIMPIA
    //super(1);
    //OPCION 3, DEFINO EL NIVEL EN EL CONSTRUCTOR PADRE
    super();
    this.alcance = alcance;
    this.precision = precision;
    this.dano = dano;
  }


  public int atacar(int distancia){
    //FUERZO LA CONVERSION A ENTERO DESDE DOUBLE
    return (int) (getNivel()*alcance*precision*dano / distancia);
  }
}
