package TheGoldenBucket2;

public class Food implements Comparable<Food> {
  private String name;
  private double price;

  public Food() {
    this("defaultFood");
  }

  public Food(String name) {
    this(name, 0);
  }

  public Food(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public int compareTo(Food o) {
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
