// Clase principal con errores
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal miAnimal = new Perro("Bobby");
        
        Perro miPerro = new Perro("Firulais");

        miPerro.hacerSonido();
        miPerro.correr();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un nombre para el perro");
        String nuevoNombre = scanner.nextLine();
        miPerro.setNombre(nuevoNombre);
        System.out.println(miPerro.mostrarNombre());
    }
}