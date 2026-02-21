package fornite.items;

import fornite.Atacable;

public class Pico extends Item implements Atacable{
  static final int DANO_PICO = 20;
  
  int fuerzaPico;

  public boolean equals(Object o){
    /*if (o instanceof Pico){
      return fuerzaPico == ((Pico)o).getFuerzaPico();
    }*/
    if (o instanceof Pico p)
      return fuerzaPico == p.getFuerzaPico();
    else return false;
  }

  public int getFuerzaPico() {
    return fuerzaPico;
  }



  public Pico(){
    fuerzaPico = 2;
  }

  @Override
  public int atacar(int distancia){
    if(distancia > 5)
      return 0;
    else
      return DANO_PICO;
  }


  @Override
  public String toString() {
    return "Pico [fuerzaPico=" + fuerzaPico + "]";
  }
  
}