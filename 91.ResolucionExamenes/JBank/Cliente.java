/*METED LOS IMPORTS QUE SE CONSIDEREIS*/
import java.util.List;
import java.util.ArrayList;

class Cliente implements Comparable {
    private String nombre;
    private String apellido;
    private String dni;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentas = new ArrayList<>();
    }

    public Cliente( String dni){
        this.dni = dni;
    }

    public Cuenta abrirCuenta(double saldo) {
        Cuenta c = new Cuenta(saldo);
        cuentas.add(c);
        return c;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", saldo=" + String.format("%.2f EUR",calculaSaldo()) +
                ", saldoReal=" + String.format("%.2f EUR",calculaSaldoReal()) +
                '}';
    }



    public List<Cuenta> getCuentas() {
      return cuentas;
    }

    public int compareTo(Object o){
      if(o instanceof Cliente c){
        int res =  Double.compare(this.calculaSaldoReal(),c.calculaSaldoReal());
        if(res == 0)
          return dni.compareTo(c.getDni());
        else 
          return res;
      }
      else return -1;
    }

    public boolean equals(Object o){
      if (o instanceof Cliente c)
        return this.dni.equals(c.getDni());
      else return false;
    }


    // ES NECESARIO IMPLEMENTAR LOS MÉTODOS y OTROS MÉTODOS QUE SE CONSIDEREN NECESARIOS
    public double calculaSaldo() {
      double saldo = 0;
      for (Cuenta c : cuentas)
        saldo += c.getSaldo();
      return saldo;
    }
    double calculaSaldoReal(){
      double saldoReal = 0;
      for (Cuenta c : cuentas)
        saldoReal += c.getSaldo();
      return saldoReal;
    }


}
