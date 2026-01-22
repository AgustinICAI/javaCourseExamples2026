class App {
  public static void main(String[] args) {
    System.out.println("Creando nuestra primera clase");
    Animal p1 = new Animal("pollo",40,30);
    System.out.println(p1.getInfo());
    p1.mover();
    System.out.println(p1.getInfo());

    Almacen almacen = new Almacen(10);
    almacen.addProducto(p1.getProducto());    
    for(int i=0; i < 3; i=i+1)
      almacen.addProducto(new Producto("leche"));

    Producto[] productosAlmacen = almacen.getProductos();

    //System.out.println(productosAlmacen[0]);
    //System.out.println(productosAlmacen[4]);
    //System.out.println(productosAlmacen[5]);
    for(int i = 0; i < productosAlmacen.length;i=i+1){
      if(productosAlmacen[i]!=null)
        System.out.println("pos "+ i + " - "+productosAlmacen[i].getInfo());
    }

  }
}
