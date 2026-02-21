package fornite.armas;

import fornite.Atacable;
import fornite.Objeto;


public abstract class Arma extends Objeto implements Atacable, Comparable {
  
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    if (obj instanceof Arma a)
      return a.getAlcance() == alcance &&
             a.getDano() == dano &&
             a.getPrecision() == precision;
    else return false;
  }

  public int hashCode(){
    return Double.hashCode(alcance)+
           Integer.hashCode(dano)+
           Double.hashCode(precision);
  }



  public double getAlcance() {
    return alcance;
  }


  public double getPrecision() {
    return precision;
  }


  public int getDano() {
    return dano;
  }

  public int compareTo(Object o){
    if(o instanceof Arma a)
    {
      return Integer.compare( dano,a.getDano());
    }
    return -1;
  }
  
  
}
