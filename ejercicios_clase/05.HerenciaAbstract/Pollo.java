class Pollo extends Animal {
  
  Pollo(){
    super();
  }

  String getTipoAlimentacion(){
      return "pienso pollo";
  }

  long getTiempoProduccion(){
      return 15*60*1000;
  }

  Producto getProducto(){
    return new Producto("huevo");
  }

  public String toString(){
    return "TIPO POLLO ->" + super.toString();
  }
}
