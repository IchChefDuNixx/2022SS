package TheGoldenBucket2;

public class Employee implements Comparable<Employee> {
  private String name;
  private String title;

  public Employee() {
    this("defaultEmployee");
  }

  public Employee(String name) {
    this(name, "defaultTitle");
  }

  public Employee(String name, String title) {
    this.name = name;
    this.title = title;
  }

  public String getName() {
    return name;
  }

  public String getTitle() {
    return title;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString() {
    return name + " - " + title;
  }

  @Override
  public int compareTo(Employee o) {
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
