package fornite;

import fornite.armas.Escopeta;
import fornite.armas.Sniper;
import fornite.items.Pico;
import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


public class App {
  public static void main(String argv[]){
    Personaje p1 = new Personaje(new Skin("unicornio"));

    Collection<Objeto> objetos = new ArrayList<>();
    objetos.add(new Sniper());
    objetos.add(new Sniper());
    objetos.add(new Sniper(300,true));
    objetos.add(new Sniper(500,true));
    objetos.add(new Sniper(600,true));
    objetos.add(new Sniper(700,true));

    for(Objeto o : objetos){
      System.out.println(o);
      //System.out.println(o.hashCode());
    }

    Set<Objeto> setObjetos = new HashSet<>();
    System.out.println("AHORA METEMOS EN UN SET");
    //for(Objeto o : objetos)
    //  setObjetos.add(o);
    setObjetos.addAll(objetos);

    for(Objeto o : setObjetos){
      System.out.println(o);
      //System.out.println(o.hashCode());
    }  

    TreeSet<Objeto> tsObjetos = new TreeSet<>();
    System.out.println("AHORA METEMOS EN UN TREESET");
    tsObjetos.addAll(objetos);

    for(Objeto o : tsObjetos){
      System.out.println(o);
      //System.out.println(o.hashCode());
    }  

    for(Objeto o : tsObjetos.descendingSet()){
      System.out.println(o);
      //System.out.println(o.hashCode());
    } 

    



  }
}
