package examenMayo.dominio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IOFichero {

  public static int[][] leerCombinaciones(String filePath) throws IOException {

    List<String> lineas = Files.readAllLines(Path.of(filePath));

    int[][] resultado = new int[lineas.size()][];

    for (int i = 0; i < lineas.size(); i++) {
      String linea = lineas.get(i).trim();
      if (linea.isEmpty())
        continue;

      String[] numeros = linea.split(",");
      resultado[i] = new int[numeros.length];

      for (int j = 0; j < numeros.length; j++) {
        resultado[i][j] = Integer.parseInt(numeros[j].trim());
      }
    }

    return resultado;
  }
}