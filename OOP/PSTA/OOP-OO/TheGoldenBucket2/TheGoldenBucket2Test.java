package TheGoldenBucket2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TheGoldenBucket2Test {
  @Test
  public void customerTest() {
    Customer c1 = new Customer();
    assertEquals("defaultName", c1.getName());
    Customer c2 = new Customer("thisIsMeName");
    assertEquals("thisIsMeName", c2.getName());
    c2.setName("newName");
    assertEquals("newName", c2.getName());
  }

  @Test
  public void drinkTest() {
    Drink d1 = new Drink();
    assertEquals("defaultDrink", d1.getName());
    Drink d2 = new Drink("drinkME");
    assertEquals(0, d2.getPrice(), 0);
    Drink d3 = new Drink("coke", 0.20);
    assertEquals("coke", d3.getName());
    d1.setPrice(1);
    assertEquals(1, d1.compareTo(d3));
  }

  @Test
  public void employeeTest() {
    Employee e1 = new Employee();
    assertEquals("defaultTitle", e1.getTitle());
    Employee e2 = new Employee("henry");
    assertEquals("henry", e2.getName());
    Employee e3 = new Employee("sam", "chef");
    assertEquals("chef", e3.getTitle());
    e2.setTitle("cashier");
    assertEquals("cashier", e2.getTitle());
  }

  @Test
  public void foodTest() {
    Food f1 = new Food();
    assertEquals("defaultFood", f1.getName());
    Food f2 = new Food("baguette");
    assertEquals(0, f2.getPrice(), 0);
    Food f3 = new Food("pizza funghi", 5.50);
    assertEquals(5.50, f3.getPrice(), 0);
    f2.setPrice(2.79);
    assertEquals(-1, f2.compareTo(f3));
  }

  @Test
  public void listForAllTest() {
    ListForAllImpl<Drink> impl = new ListForAllImpl<>();
    Drink a = new Drink("a", 1);
    Drink b = new Drink("b", 2);
    Drink c = new Drink("c", 3);
    Drink d = new Drink("d", 4);
    Drink e = new Drink("e", 5);

    assertEquals(0, impl.size());

    impl.add(a);
    impl.add(b);
    impl.add(c);
    impl.add(d);

    assertEquals(4, impl.size());

    //test cases for the get_at_index function
    assertEquals(c, impl.get_at_index(3));
    assertNotEquals(b , impl.get_at_index(3));

    assertTrue(impl.contains(a));
    assertTrue(impl.contains(b));
    assertTrue(impl.contains(c));
    assertTrue(impl.contains(d));
    assertFalse(impl.contains(e));

    impl.remove(a);
    impl.remove(b);
    assertEquals(2, impl.size());

    assertFalse(impl.contains(a));
    assertFalse(impl.contains(b));
    assertTrue(impl.contains(c));
    assertTrue(impl.contains(d));

    ListForAll<Food> foodList = new ListForAllImpl<>();
    Food x = new Food("foodX", 5);
    Food y = new Food("foodY");
    Food z = new Food("foodZ", 20.20);

    assertEquals(0, foodList.size());

    foodList.add(x);
    foodList.add(y);

    assertEquals(2, foodList.size());

    assertTrue(foodList.contains(x));
    assertTrue(foodList.contains(y));
    assertFalse(foodList.contains(z));

    foodList.add(z);
    foodList.remove(x);
    foodList.remove(z);

    assertEquals(1, foodList.size());
    assertTrue(foodList.contains(y));
  }

  @Test
  public void orderTest() {
    Customer c1 = new Customer("hans");
    Order o1 = new Order(c1);
    assertEquals("hans", o1.getCustomer());
    ListForAllImpl<Drink> testDrinks = new ListForAllImpl<>();
    Order o2 = new Order(c1, testDrinks);
    assertEquals(0, o2.getDrinkNumber());
    ListForAllImpl<Food> testFoods = new ListForAllImpl<>();
    Order o3 = new Order(c1, testDrinks, testFoods);
    assertEquals(2, o3.getOrderId());
    Food f1 = new Food();
    Food f2 = new Food("ei", 0.5);
    o1.addFood(f1);
    o1.addFood(f2);
    assertEquals(2, o1.getFoodNumber());
    Drink d1 = new Drink("orange juice", 2.69);
    Drink d2 = new Drink("milk", 1);
    o1.addDrink(d1);
    o1.addDrink(d2);
    assertEquals(2, o1.getDrinkNumber());
    assertEquals(4.19, o1.getTotalPrice(), 0.001);
  }

  @Test
  public void reservationTest() {
    Reservation r1 = new Reservation();
    assertEquals("defaultCustomer", r1.getCustomer().getName());
    assertEquals("waiter", r1.getEmployee().getTitle());
    assertEquals(0, r1.getOrders().size());
    assertEquals(0, r1.getReservationId());

    Customer c1 = new Customer("fred");
    r1.setTime("18:00");
    r1.setDate("30.04.22");
    r1.setCustomer(c1);

    assertEquals("18:00", r1.getTime());
    assertEquals("30.04.22", r1.getDate());
    assertEquals("fred", r1.getCustomer().getName());

    Reservation r2 = new Reservation();
    Employee e1 = new Employee("chris");
    Reservation r3 = new Reservation(c1, "now", "today", e1);
    Order o1 = new Order();
    r3.addOrder(o1);

    assertEquals("now", r3.getTime());
    assertEquals("defaultTitle", r3.getEmployee().getTitle());
    assertEquals(1, r3.getOrders().size());
    assertEquals(2, r3.getReservationId());
  }
}
