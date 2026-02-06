package fornite.items;

import fornite.Atacable;

public class Pico extends Item implements Atacable{
  static final int DANO_PICO = 20;
  
  int fuerzaPico;

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
}