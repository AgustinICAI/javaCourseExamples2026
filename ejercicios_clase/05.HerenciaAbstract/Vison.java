class Vison extends Animal{

  Vison(){
    super();
  }

  @Override //Anotaciones
  long getTiempoProduccion() {
    return 2*365*24*60*60*1000;
  }

  @Override
  Producto getProducto() {
    return new Producto("Piel");
  }

  @Override
  String getTipoAlimentacion() {
    return "Pienso proteico";
  }
  Producto recogerProducto(){
    if(listo == true){ 
      listo = false;
      vivo = false;
      return getProducto();
    }
    else{
      return null;
    }
  }

  

}
