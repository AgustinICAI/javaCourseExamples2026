public class App {
  public static void main(String[] args) {
    //int a = 65 → Integer → float →char → String → devolver el primer carácter en
    //mayúsculas como char → int → byte
    int a = 65;
    //DEPRECADO Integer i1 = new Integer(a);
    Integer i1 = a;
    float f = i1;
    char c1 = (char) f;
    //OPCION 1
    Character c2 = c1;
    String s1 = c2.toString();
    //OPCION 2
    char[] cs = new char[1];
    cs[0] = c1;
    String s2 = new String(cs);

    char c3 = s1.toUpperCase().charAt(0);    

    int i2 = c3;

    byte b1 = (byte) i2;


    
    
  }
}
