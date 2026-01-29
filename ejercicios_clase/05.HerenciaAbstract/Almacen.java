class Almacen {
  Producto[] productos;
  int capacidad; //tamaño del almacen
  int posLibre; //primera posición libre

  Almacen(int capacidad){
    this.capacidad = capacidad;
    this.posLibre = 0;
    productos = new Producto[capacidad]; 
  }

  boolean addProductoPocoEficiente(Producto producto){
    int i = 0;
    while (productos[i]!=null && i < capacidad)
      i=i+1;
    if (i >= capacidad)
      return false;
    else{
      productos[i] = producto;
      return true;
    }
  }

  boolean addProducto(Producto producto){
    if(posLibre>=capacidad)
      return false;
    else{
      productos[posLibre] = producto;
      posLibre+=1;
      return true;
    }
  }

  Producto[] getProductos(){
    return productos;
  }




  

}
