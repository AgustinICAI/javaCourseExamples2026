package icai.examen;
import java.util.TreeSet;

public class App {
  
  public static void main(String[] args) {

    TreeSet<Deportista> deportistas = new TreeSet<>();

    Futbolista futbolista = new Futbolista("Carlos Pérez", 75.0, "Nike");
    futbolista.addEntrenamiento(new Entrenamiento("partido", 90, 4));
    futbolista.addEntrenamiento(new Entrenamiento("gimnasio", 60, 3));
    futbolista.addEntrenamiento(new EntrenamientoCarrera("carrera", 40, 3, 5.0));
    Tenista tenista = new Tenista("Laura Gómez", 65.0, "Adidas");         
    tenista.addEntrenamiento(new Entrenamiento("pista", 120, 4));
    tenista.addEntrenamiento(new Entrenamiento("gimnasio", 60 , 3));
    tenista.addEntrenamiento(new EntrenamientoCarrera("carrera", 30, 2, 3.0));
    Runner runner = new Runner("Miguel Torres", 68.0, "Asics");
    runner.addEntrenamiento(new EntrenamientoCarrera("carrera larga", 90, 4, 15.0));
    runner.addEntrenamiento(new EntrenamientoCarrera("carrera suave", 60, 2, 8.0));
    runner.addEntrenamiento(new Entrenamiento("gimnasio", 45, 2));
    
    System.out.println(futbolista);
    System.out.println(tenista);
    System.out.println(runner); 

    deportistas.add(runner);
    deportistas.add(tenista);
    deportistas.add(futbolista);

    int partidosSemana = 0;
    for (Deportista d : deportistas) {
      if (d instanceof ParticipaCompeticiones dpc){
        partidosSemana += dpc.getPartidosSemana();
      }
    }

    System.out.println("Total de partidos en una semana: " + partidosSemana);
    
  }



}
