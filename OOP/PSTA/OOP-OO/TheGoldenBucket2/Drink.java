package TheGoldenBucket2;

public class Drink implements Comparable<Drink> {
  private String name;
  private double price;

  public Drink() {
    this("defaultDrink");
  }

  public Drink(String name) {
    this(name, 0);
  }

  public Drink(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Drink o) {
    if (this.price < o.getPrice()) {
      return -1;
    } else if (this.price == o.getPrice()) {
      return 0;
    } else {
      return 1; // this.price > o.price
    }
  }

  public String toString() {
    return name + " - " + price + "€";
  }
}
