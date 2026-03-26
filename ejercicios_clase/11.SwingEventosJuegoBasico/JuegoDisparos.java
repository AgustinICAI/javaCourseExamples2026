import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

public class JuegoDisparos{
  Collection<Point> disparos;
  static int TAM_DISPARO = 50;

  JuegoDisparos(){
    disparos = new ArrayList<>();
  }

  void addDisparos(int x,int y){
    disparos.add(new Point(x,y));
  }

  public Collection<Point> getDisparos() {
    return disparos;
  }  

}