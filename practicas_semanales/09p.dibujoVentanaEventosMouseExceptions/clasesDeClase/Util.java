class Util{
  public static Color rgbToColor(int r, int g, int b) throws RGBConversionException
  {
    if(r < 0 || r > 255 )
      throw new RGBConversionException("Rojo", r);
    if(g < 0 || g > 255 )
      throw new RGBConversionException("Verde", g);
    if(b < 0 || b > 255 )
      throw new RGBConversionException("Azul", b);   
    
    return new Color(r, g, b);
  }
}