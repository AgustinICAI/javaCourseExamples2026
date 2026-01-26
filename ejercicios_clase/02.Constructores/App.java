class App {
  public static void main(String[] args) {
    System.out.println("Creando nuestra primera clase");
    Animal p1 = new Animal("pollo",40,30);
    System.out.println(p1.getInfo());
    p1.mover();
    System.out.println(p1.getInfo());
  }
}
