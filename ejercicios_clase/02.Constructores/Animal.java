  /*
  Esta es la implementación
  de la clase Animal basado en el juego
  HayDay
  */

class Animal{
  //ATRIBUTOS
  String tipo; //Esto es el tipo de animal
  double hambre; //0 lleno, 100 muy hambriento
  long inicioProduccion;
  boolean listo;
  double x;
  double y;
  //CONSTRUCTORES
  Animal(String _tipo, double _x,double _y){
    tipo = _tipo;
    setX(_x);
    setY(_y);
    hambre = 100; //Empieza con hambre al 100%
    listo = false;
  }
    Animal(String _tipo){
    tipo = _tipo;
    x = Math.random()*1000;
    y = Math.random()*1000; 
    hambre = 100; //Empieza con hambre al 100%
    listo = false;
  }

  //MÉTODOS
  void setX(double _x){
    if(x<0)
      x = 0;
    else if (x>1000)
      x = 1000;
    else
      x = _x;
  }
  void setY(double _y){
    if(y<0)
      y = 0;
    else if (y>1000)
      y = 1000;
    else
      y = _y;
  }

  String getTipoAlimentacion(){
    if(tipo.equals("pollo"))
      return "pienso pollo";
    else if(tipo.equals("vaca"))
      return "pienso vaca";
    else
      return "ERROR";
  }
  long getTiempoProduccion(){
    if(tipo.equals("pollo"))
      return 15*60*1000;
    else if(tipo.equals("vaca"))
      return 30*60*1000;
    else
      return -99999;
  }


  double getX(){
    return x;
  }

  double getY(){
    return y;
  }

  void comer(){
    hambre = hambre - 5;
    if(hambre < 0)
      hambre = 0;
    if(hambre > 100)
      hambre = 100;
  }

  void mover(){
    x = x + Math.random()*10;
    y = y + Math.random()*10; 
  }

  Producto getProducto(){
    if(tipo.equals("pollo"))
      return new Producto("huevo");
    else if(tipo.equals("vaca"))
      return new Producto("leche");
    else
      return null;
  }

  Producto recogerProducto(){
    if(listo == true){ 
      listo = false;
      inicioProduccion = System.currentTimeMillis();
      //PTE EXPLICAR QUE ES ESTO
      return getProducto();
    }
    else{
      return null;
    }
  }

  void producir(){
    long horaActual = System.currentTimeMillis();
    if (horaActual - inicioProduccion > getTiempoProduccion())
      //SI EL CONDICIONAL SOLO TIENE UNA LINEA, NO HACEN FALTA CORCHETES
      listo = true;
  }

  String getInfo(){
    return "tipo: " + tipo + ", x="+ x +", y="+ y;
  }
  
}

