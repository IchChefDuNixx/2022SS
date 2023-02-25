import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Iteratatorr {
  public static class Customer {
    String name;
    public Customer(String name) {
      this.name = name;
    }
    public String getName() {
      return name;
    }
    public String toString() {
      return name;
    }
  }
  public static void main(String[] args) {
    List<Customer> customerList = new LinkedList<>();
    customerList.add(new Customer("hans"));
    customerList.add(new Customer("alfred"));
    customerList.add(new Customer("anna"));

    System.out.println("og size: " + customerList.size());

    Iterator<Customer> iter = customerList.iterator();
    while(iter.hasNext() == true) {
      if(iter.next().getName() == "hans") {
        iter.remove();
      }
    }
    for(Customer c : customerList) {
      System.out.println(c);
    }
  }
}
