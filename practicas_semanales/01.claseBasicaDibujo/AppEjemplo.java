class AppEjemplo{

  public static void main(String argv[]){
    
    Cuadrado c1 = new Cuadrado (100,100,20);
    Dibujo dibujo = new Dibujo();
    dibujo.pintar(c1);
    Util u1 = new Util();
    u1.wait(2);
    Cuadrado c2 = new Cuadrado (100,100,200);
    dibujo.pintar(c2);


  }



}
