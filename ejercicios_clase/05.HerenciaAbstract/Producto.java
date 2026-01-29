public class Producto {
  String tipo;
  double precio;

  Producto(String _tipo){
    tipo = _tipo;
  }

  String getInfo(){
    return tipo + " - precio: " + precio;
  }

  public boolean equals(Object o){
    if(o instanceof Producto p)
      if(p.tipo.equals(tipo))
        return true;
    return false;
  }

}
