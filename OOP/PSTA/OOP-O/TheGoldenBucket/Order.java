package TheGoldenBucket;

public class Order {

    private Customer c;
    private Reservation r;
    private Drink[] drinks;
    private Food[] foods;
    private int number_of_drinks;
    private int number_of_foods;


    //Constructors
    public Order() {
      this(new Customer());
    }

    public Order(Customer c) {
      this(c, new Reservation());
    }

    public Order(Customer c, Reservation r) {
      this(c, r, new Drink[0]);
    }

    public Order(Customer c, Reservation r, Drink[] drinks) {
      this(c, r, drinks, new Food[0]);
    }

    public Order(Customer c, Reservation r, Drink[] drinks, Food[] foods) {
      this(c, r, drinks, foods, 0);
    }

    public Order(Customer c, Reservation r, Drink[] drinks, Food[] foods, int number_of_drinks) {
      this(c, r, drinks, foods, number_of_drinks, 0);
    }

    public Order(Customer c, Reservation r, Drink[] drinks, Food[] foods, int number_of_drinks, int number_of_foods) {
      this.c = c;
      this.r = r;
      this.drinks = drinks;
      this.foods = foods;
      this.number_of_drinks = number_of_drinks;
      this.number_of_foods = number_of_foods;
    }

    //Methods
    void addDrink(Drink d){
        this.drinks = Utilities.enlargeDrinkArray(drinks);
        drinks[drinks.length - 1] = d;
        number_of_drinks++;
    }

    void addFood(Food f){
        this.foods = Utilities.enlargeFoodArray(foods);
        foods[foods.length - 1] = f;
        number_of_foods++;
    }

    public int getNumberOfDrinks(){
        return number_of_drinks;
    }

    public int getNumberOfFoods(){
        return number_of_foods;
    }

    public int getTotalPrice(){
        int sum = 0;
        for (Drink d : drinks) {
            sum += d.getPrice();
        }
        for (Food f:foods) {
            sum += f.getPrice();
        }
        return sum;
    }
}
