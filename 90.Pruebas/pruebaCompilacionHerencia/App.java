// Clase base (superclase)
abstract class Animal {
    private String nombre  // Falta punto y coma
    
    // Constructor faltante
    public Animal(String nombre) {
        this.nombre = nombre
    }
    
    // Método mal definido (debe ser abstract)
    public void hacerSonido() 
    
    public void moverse() {
        System.out.println("El animal se está moviendo")
    }
}

// Subclase
class Perro extends Animal {
    
    public Perro(String nombre) {
        super() // Error: Falta pasar el parámetro nombre
    }
    
    @Override // Error: No está sobrescribiendo nada válido
    public void sonido() { 
        System.out.println("El perro ladra")
    }
    
    public void moverse() {
        super.moverse()
        System.out.println("El perro corre")
    }

    public void mostrarNombre() {
        System.out.println("El nombre del perro es: " + nombre) // Error: nombre es privado en la superclase
    }
    
// Falta cerrar la llave de la clase

// Clase principal con errores
public class Main {
    public static void main(String[] args) {
        Animal miAnimal = new Animal("Bobby") // Error: No se puede instanciar una clase abstracta
        
        Perro miPerro = new Perro("Firulais") 
        miPerro.hacerSonido()
        miPerro.correr() // Error: No existe método "correr"

        Scanner scanner = new Scanner(System.in) // Falta import java.util.Scanner;
        System.out.println("Introduce un nombre para el perro")
        String nuevoNombre = scanner.nextLine()
        Perro.mostrarNombre() // Error: método no es estático, no se llama con la clase
    }
}