package TheGoldenBucket;

public class Customer {

    private String name;
    private int age;

    //Constructors
    public Customer() {
      this("defaultCustomer");
    }

    public Customer(String name) {
      this(name, 0);
    }

    public Customer(String name, int age) {
      this.name = name;
      this.age = age;
    }

    //Methods
    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return this.name;
    }

    public int getAge() {
      return this.age;
    }

    public boolean isAdult() {
      if(this.getAge() >= 18) {
        return true;
      } else {
        return false;
      }
    }
}
