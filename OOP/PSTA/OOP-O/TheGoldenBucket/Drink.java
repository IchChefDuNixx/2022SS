package TheGoldenBucket;

public class Drink {

    private String name;
    private int price;
    //String[] Ingredient List?

    //added "isAlcoholic" since that might be relevant in some cases?
    private boolean isAlcoholic;

    //Constructors
    public Drink() {
        this("defaultDrink");
    }

    public Drink(String name){
        this(name, 0);
    }

    public Drink(String name, int price){
        this(name, price, false);
    }

    public Drink(String name, int price, boolean isAlcoholic){
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }

    //Methods
    public String getName() {
      return name;
    }

    public int getPrice() {
      return price;
    }

    public boolean getAlcoholic(){
        return isAlcoholic;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setPrice(int price) {
      this.price = price;
    }

    public void setAlcoholic(boolean isAlcoholic){
        this.isAlcoholic = isAlcoholic;
    }
}
