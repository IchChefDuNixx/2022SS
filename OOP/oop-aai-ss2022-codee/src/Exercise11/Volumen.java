public abstract class Volumen {

  private double height;

  public Volumen(double height) {
    this.height = height;
  }

  public abstract double grundflaeche();

  public double volumen() {
    return grundflaeche()*height;
  }
}
