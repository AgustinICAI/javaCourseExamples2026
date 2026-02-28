public class TarjetaDebito extends Tarjeta{

  public TarjetaDebito(Cuenta cuenta) {
    super(cuenta);
  }

  @Override
  public Movimiento pagarConTarjeta(double d){
    Movimiento m = new Movimiento(d);
    getCuenta().retirar(d);
    return m;
  }
}
