package fornite;

import java.util.Queue;

import fornite.armas.*;
import fornite.items.*;

public class Personaje {
  private Objeto[] objetos;
  private int vida;
  private int escudo;
  private Skin skin;
  private int x,y,z;
  private int posLibre;

  public Personaje(Skin skin) {
    objetos = new Objeto[5];
    this.skin = skin;
    vida = 100;
    escudo = 0;
    x = 0;
    y = 0;
    z = 0;
  }

  boolean addObjeto(Objeto o){
    if (posLibre < objetos.length){
      objetos[posLibre] = o;
      posLibre += 1;
      return true;
    }
    else return false;
  }

  int atacar(int posItem, int distancia){
    Objeto o = objetos[posItem];
    if (o instanceof Atacable){
      //return ((Atacable)o).atacar(distancia);
      Atacable a = (Atacable)o;
      return a.atacar(distancia);
    }
    else return 0;
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public int getEscudo() {
    return escudo;
  }

  public void setEscudo(int escudo) {
    this.escudo = escudo;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }
  
  



}
