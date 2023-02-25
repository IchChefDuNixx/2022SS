package TheGoldenBucket;

public class Food {

    //variables
    private String name;
    private int price;

    //Constructors
    public Food() {
      this("defaultFood");
    }

    public Food(String name) {
      this(name, 0);
    }

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
