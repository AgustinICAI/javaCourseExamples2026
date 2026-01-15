  /*
  Esta es la implementación
  de la clase Animal basado en el juego
  HayDay
  */

import java.util.Calendar;

class Animal{
  String tipo; //Esto es el tipo de animal
  String tipoAlimentacion;
  String producto; //Producto que produce
  double hambre;
  long inicioProduccion;
  long tiempoProduccion=1*24*3600*1000;
  boolean listo;
  double x;
  double y;

  double getX(){
    return x;
  }

  double getY(){
    return y;
  }

  void setTiempoProduccion(long _tiempoProduccion){
    tiempoProduccion = _tiempoProduccion;
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

  Producto recogerProducto(){
    if(listo == true){ 
      listo = false;
      inicioProduccion = System.currentTimeMillis();
      //PTE EXPLICAR QUE ES ESTO
      return new Producto();
    }
    else{
      return null;
    }
  }

  void producir(){
    long horaActual = System.currentTimeMillis();
    if (horaActual - inicioProduccion > tiempoProduccion)
      //SI EL CONDICIONAL SOLO TIENE UNA LINEA, NO HACEN FALTA CORCHETES
      listo = true;
  }









  
}

