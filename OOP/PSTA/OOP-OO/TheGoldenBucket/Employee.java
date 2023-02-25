package TheGoldenBucket;

public class Employee {

    private String name;
    private String title;

    //Constructors
    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String title){
        this.name = name;
        this.title = title;
    }

    //Methods
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
}
