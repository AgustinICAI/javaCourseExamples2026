package fornite.armas;

public class Sniper extends Arma {
  boolean mira;
  static final int DANO_DEFECTO=200;
  public Sniper(){
    this(DANO_DEFECTO,false);
  }

  public Sniper(int dano, boolean mira){
    super(200,1,dano);
    this.mira=mira;
  }

  


  @Override
  public String toString() {
    return "Sniper [mira=" + mira + ", dano=" + getDano() + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if(obj instanceof Sniper s)
    {
      return super.equals(obj) &&
             s.mira==this.mira;
    }
    else return false;
  }

  public int hashCode(){
    return super.hashCode() + Boolean.hashCode(mira);
  }



  public boolean isMira() {
    return mira;
  }  
  
}
