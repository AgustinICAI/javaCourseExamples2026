package fornite;

import fornite.armas.Escopeta;
import fornite.armas.Sniper;
import fornite.items.Pico;

public class App {
  public static void main(String argv[]){
    Personaje p1 = new Personaje(new Skin("unicornio"));

    p1.addObjeto(new Escopeta());
    p1.addObjeto(new Sniper());
    p1.addObjeto(new Pico());

    System.out.println(p1.atacar(0, 10));
    System.out.println(p1.atacar(1, 10));
    System.out.println(p1.atacar(2, 10));


  }
}
