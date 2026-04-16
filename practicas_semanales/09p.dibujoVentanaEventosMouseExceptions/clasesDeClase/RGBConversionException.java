public class RGBConversionException extends Exception {
  
  private String color;
  private int valor;

  public RGBConversionException(String color, int valor) {
    super();
    this.color = color;
    this.valor = valor;
  }
  public String getMessage() {
    return "El color " + color + " no puede tener el valor "+ valor + ". Valor válido: [0-255]");
  }
}
