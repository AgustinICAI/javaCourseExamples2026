class App {
  public static void main(String argv[]){  
    Animal a1 = new Pollo();

    Animal[] animales = new Animal[5];
    animales[0] = new Pollo();
    animales[1] = new Vaca(30,20);
    animales[2] = new Vison();
    animales[3] = new Vaca(30,20);
/*
    for(int i = 0 ; i < animales.length; i=i+1){
      if(animales[i] != null &&
         animales[i] instanceof Vaca){
          Vaca v = (Vaca)animales[i];
          v.sacrificar();
         }
    }*/
    for(Animal a : animales){
      if(a != null && a instanceof Vaca){
          Vaca v = (Vaca)a;
          v.sacrificar();
      }
    }

    for(Animal a : animales)
      if(a!=null)
        System.out.println(a.isVivo());


    //quiero sacar las vacas muertas para sacarlas del array
    int muertos[] = new int[animales.length];
    int posMuertos = 0;
    for(int i = 0; i < animales.length; i++){
      if(animales[i] != null && animales[i].isVivo() == false){
        muertos[posMuertos] = i;
        posMuertos += 1;
      }
    }
    int i = 0;
    while(i < posMuertos){
      animales[muertos[i]] = null;
      i=i+1;
    }
    System.out.println("mostrando todo el array");
    for(Animal a : animales)
        //System.out.println(a.toString());
        System.out.println(a);




  }
}
