abstract class Animal {
    private String nombre;
    
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    
    abstract public void hacerSonido();
    
    public void moverse() {
        System.out.println("El animal se está moviendo");
    }

    public String getNombre(){
      return nombre;
    }
    public void setNombre(String nombre){
      this.nombre = nombre;
    }
}