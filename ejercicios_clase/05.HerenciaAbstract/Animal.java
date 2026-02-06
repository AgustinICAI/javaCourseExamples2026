import java.util.Calendar;
import java.util.Date;

abstract class Animal{
  //ATRIBUTOS
  double hambre; //0 lleno, 100 muy hambriento
  long inicioProduccion;
  boolean listo;
  double x;
  double y;
  boolean vivo;


  //CONSTRUCTORES
  Animal(double x,double y){
    setX(x);
    setY(y);
    this.hambre = 100; //Empieza con hambre al 100%
    this.listo = false;
    this.vivo = true;
    inicioProduccion = Calendar.getInstance().getTimeInMillis();
  }
  Animal(){
    //REUTILIZACIÓN DE CONSTRUCTOR, PRINCIPIO DRY
    this(Math.random()*1000, Math.random()*1000);
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

  double getX(){
    return x;
  }

  double getY(){
    return y;
  }

  void comer(int cantidad){
    hambre = hambre - cantidad;
    if(hambre < 0)
      hambre = 0;
    if(hambre > 100)
      hambre = 100;
  }

  //COMER POR DEFECTO 5, REUTILIZANDO MÉTODOS
  void comer(){
    this.comer(5);
  }

  void mover(){
    x = x + Math.random()*10;
    y = y + Math.random()*10; 
  }

  abstract long getTiempoProduccion();
  abstract Producto getProducto();
  abstract String getTipoAlimentacion();


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
  @Override
  public String toString() {
    Date d = new Date(inicioProduccion);
    return "hambre=" + hambre + ", inicioProduccion=" + d + ", listo=" + listo + ", x=" + x
        + ", y=" + y + ", vivo=" + vivo + "]";
  }
  

  boolean isVivo() {
    return vivo;
  }

}

