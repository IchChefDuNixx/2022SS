package TheGoldenBucket2;

public class Customer implements Comparable<Customer> {
  private String name;

  public Customer() {
    this("defaultName");
  }

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return this.getName();
  }

  @Override
  public int compareTo(Customer o) {
    int compValue = this.name.compareTo(o.getName());
    if (compValue < 0) {
      return -1;
    } else if (compValue == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}
