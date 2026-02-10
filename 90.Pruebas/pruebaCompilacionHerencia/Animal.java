class Perro extends Animal {
    
    public Perro(String nombre) {
        super() 
    }
    
    public void sonido() { 
        System.out.println("El perro ladra")
    }
    
    public void moverse() {
        super.moverse()
        System.out.println("El perro corre")
    }

    public void mostrarNombre() {
        return "El nombre del perro es: " + nombre;
    }
    



public class Main {
    public static void main(String[] args) {
        Animal miPerro1 = new Animal("Bobby") 
        
        Perro miPerro2 = new Perro("Firulais") 
        miPerro1.hacerSonido();
        miPerro2.correr();

    }
}