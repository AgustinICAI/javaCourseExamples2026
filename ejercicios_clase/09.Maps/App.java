import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
  public static void main (String argv[]){

    String discurso = "ESTO ES UN DISCURSO PARA PROBAR LA PARTE DE CONTAR PALABRAS Y MUCHAS PALABRAS";

    String[] palabras = discurso.split("\s");

    HashMap<String, Integer> cuentaPalabras = new HashMap<>();

    for(String palabra : palabras)
      if(! cuentaPalabras.containsKey(palabra))
        cuentaPalabras.put(palabra,1);
      else
        cuentaPalabras.put(palabra, cuentaPalabras.get(palabra) +1 );
    /*
    for(Map.Entry<String, Integer> m : cuentaPalabras.entrySet())
      System.out.println(m.getKey() + " -> " + m.getValue());
    
    for(String palabra : cuentaPalabras.keySet()){
      System.out.print(palabra + " -> " + cuentaPalabras.get(palabra) );
    }

    cuentaPalabras.forEach((k,v) -> System.out.println(k + "-> " + v));
    */
    TreeMap<Integer, ArrayList<String>> palabrasOrd = new TreeMap<>();

    cuentaPalabras.forEach((palabra,count)->{
      if(!palabrasOrd.containsKey(count))
        palabrasOrd.put(count,new ArrayList<String>());
      palabrasOrd.get(count).add(palabra);
    });

    palabrasOrd.forEach((k,v)->{
      System.out.println(k +"->"+v);
    });





  }



}
