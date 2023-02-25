public class tempShootingRange {

  /*public class Customer {

    private String name;

    public Customer() {
      this("defaultName");
    }

    public Customer (String name){
        this.name = name;
    }
  }*/

  public static void main(String[] args) {
    Customer c1 = new Customer();
    System.out.println(c1.getName());
    Customer c2 = new Customer("ey");
    System.out.println(c2.getName());
    Customer c3 = new Customer(25);
  }
}
