public class TarjetaCredito extends Tarjeta{
  public TarjetaCredito(Cuenta cuenta, double saldo) {
    super(cuenta);
    this.saldo = saldo;
  }
  double saldo;
  
  public double getSaldo() {
    return saldo;
  }

  @Override
  public Movimiento pagarConTarjeta(double d){
    this.saldo -= d;
    Movimiento m = new Movimiento(d);
    return m;
  }
  

}
