package TheGoldenBucket2;

public class Order implements Comparable<Order> {
  private static int orderCounter = 0;
  private int orderId;
  private Customer c;
  private ListForAll<Drink> drinks;
  private ListForAll<Food> foods;

  public Order() {
    this(new Customer("defaultCustomer"));
  }

  public Order(Customer c) {
    this(c, new ListForAllImpl<Drink>());
  }

  public Order(Customer c, ListForAll<Drink> drinks) {
    this(c, drinks, new ListForAllImpl<Food>());
  }

  public Order(Customer c, ListForAll<Drink> drinks, ListForAll<Food> foods) {
    this.orderId = orderCounter;
    this.c = c;
    this.drinks = drinks;
    this.foods = foods;
    orderCounter++;
  }

  public String getCustomer() {
    return c.toString();
  }

  public int getOrderId() {
    return orderId;
  }

  public int getDrinkNumber() {
    return drinks.size();
  }

  public int getFoodNumber() {
    return foods.size();
  }

  public ListForAll<Drink> getDrinkList() {
    return drinks;
  }

  public ListForAll<Food> getFoodList() {
    return foods;
  }

  public void addFood(Food f) {
    foods.add(f);
  }

  public void addDrink(Drink d) {
    drinks.add(d);
  }

  public String toString() {
    return c + " - " + getTotalPrice() + " - " + orderId;
  }

  public double getTotalPrice() {
    double total = 0;
    if (drinks.size() > 0) {
      ListForAllImpl<Drink>.ListElement tempFirst = drinks.getFirst();
      while (tempFirst.next != null) {
        total += tempFirst.value.getPrice();
        tempFirst = tempFirst.next;
      }
      total += tempFirst.value.getPrice();
      tempFirst = tempFirst.next;
    }
    if (foods.size() > 0) {
      ListForAllImpl<Food>.ListElement tempFirst = foods.getFirst();
      while (tempFirst.next != null) {
        total += tempFirst.value.getPrice();
        tempFirst = tempFirst.next;
      }
      total += tempFirst.value.getPrice();
      tempFirst = tempFirst.next;
    }
    return total;
  }

  // sort by additional attributes?
  @Override
  public int compareTo(Order o) {
    if(this.getTotalPrice() == o.getTotalPrice() ||
       this.getTotalPrice() + 0.01 > o.getTotalPrice() && // 0.01€ variation
       this.getTotalPrice() - 0.01 < o.getTotalPrice()) {
      return 0;
    } else if(this.getTotalPrice() < o.getTotalPrice()) {
      return -1;
    } else {
      return 1; // this.getTotalPrice() > o.getTotalPrice()
      }
  }
}
