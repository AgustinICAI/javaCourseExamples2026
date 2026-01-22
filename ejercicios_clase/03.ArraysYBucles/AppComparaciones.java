public class AppComparaciones {
  public static void main (String argv[]){
    Producto p1 = new Producto("leche");
    Producto p2 = new Producto("leche");
    if (p1==p2)
      System.out.println("variables iguales");
    else
      System.out.println("variables distintas");

    if (p1.equals(p2))
      System.out.println("objetos iguales");
    else
      System.out.println("objetos distintos");


    String s1 = "Hola que hases";
    String s2 = "Hola que hases";

    if(s1.equals(s2))
      System.out.println("STRINGS iguales");
    else
      System.out.println("STRINGS distintos");




  }
}
