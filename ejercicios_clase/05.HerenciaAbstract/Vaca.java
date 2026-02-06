class Vaca extends Animal{

  Vaca(double x, double y){
    super(x,y);
  }

  String getTipoAlimentacion(){
      return "pienso vaca";
  }

  long getTiempoProduccion(){
    return 30*60*1000;
  }

  Producto getProducto(){
    return new Producto("leche");
  }

  Producto sacrificar(){
    vivo = false;
    return new Producto("carne vacuno");
  }

  public String toString(){
    return "TIPO VACA ->" + super.toString();
  }

  
}
