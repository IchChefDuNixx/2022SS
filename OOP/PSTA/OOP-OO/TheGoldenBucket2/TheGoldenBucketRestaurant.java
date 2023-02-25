package TheGoldenBucket2;

import javax.lang.model.element.Element;
import java.util.Iterator;
import java.util.Scanner;

public class TheGoldenBucketRestaurant {
    //Set up the environment
    //Initialize lists for all employees, customers, food and drinks
    ListForAllImpl<Employee> employees = new ListForAllImpl<>();
    ListForAllImpl<Customer> customers = new ListForAllImpl<>();
    ListForAllImpl<Reservation> reservations = new ListForAllImpl<>();
    ListForAllImpl<Order> orders = new ListForAllImpl<>();
    ListForAllImpl<Food> food_available = new ListForAllImpl<>();
    ListForAllImpl<Drink> drinks_available = new ListForAllImpl<>();
    ListForAllImpl<Employee> waiters = new ListForAllImpl<>();

    TheGoldenBucketRestaurant() {

        employees.add( new Employee("Peter Griffin", "Waiter"));
        employees.add(new Employee("Lois Griffin","Cook"));
        employees.add(new Employee("Meg Griffin","Cook"));
        employees.add(new Employee("Chris Griffin","Waiter"));
        employees.add(new Employee("Stewie Griffin","Waiter"));
        employees.add(new Employee("Brian Griffin","Front Desk"));

        for(Employee e1 : employees){
            if (e1.getTitle() == "Waiter"){
                waiters.add(e1);
            }
        }

        customers.add( new Customer("Max"));
        customers.add( new Customer("Tommy"));
        customers.add( new Customer("Bob"));
        customers.add( new Customer("Amy"));
        customers.add( new Customer("Mari"));

        food_available.add(new Food("Pizza Magherita", 10.50));
        food_available.add(new Food("Antipasti Selection", 9.70));
        food_available.add(new Food("Pizza Salami", 11.30));
        food_available.add(new Food("Carbonara", 11.50));
        food_available.add(new Food("Gnocchi", 12.80));

        drinks_available.add(new Drink("Coke", 3.95));
        drinks_available.add(new Drink("Vino Rojo", 9.00));
        drinks_available.add(new Drink("Beer", 4.00));
        drinks_available.add(new Drink("Spezi", 3.50));
        drinks_available.add(new Drink("Vino Blanco", 10.00));

        //Initialize the reservations
        ListForAllImpl.ListElement C = customers.getFirst();
        ListForAllImpl.ListElement W = waiters.getFirst();
        for(int i = 0; i < customers.size(); i++){
            reservations.add(new Reservation((Customer)C.value, "22:00", "01.05.22", (Employee)W.value));
            C = C.next;
            W = W.next;
            if (W == null){W = waiters.getFirst();}
        }
        menu();
    }

    public static void main(String[] args) {

        new TheGoldenBucketRestaurant();
    }
    //should be called print_bill (verb)
    static void PrintBill(Reservation T) {
        ListForAllImpl<Order> Orders = T.getOrders();

        double price = 0;
        int TotalNumberOfFoods = 0;
        int TotalNumberOfDrinks = 0;

        for (Order o : Orders) {
            TotalNumberOfDrinks += o.getDrinkNumber();
            TotalNumberOfFoods += o.getFoodNumber();
            System.out.println("_____________________________");
            System.out.println("OrderId: " + o.getOrderId());
            System.out.println("\n" + "Drinks:");


            for (Drink d : o.getDrinkList()) {
                price += d.getPrice();
                System.out.format(" %-20s %5.2f $%n", d.getName(), d.getPrice());
            }

            System.out.println("\n" + "Foods:");
            for (Food d : o.getFoodList()) {
                price += d.getPrice();
                System.out.format(" %-20s %5.2f $%n", d.getName(), d.getPrice());
            }
        }
        System.out.println("_____________________________");
        System.out.format("%-20s %2d%n","Total Number of Drinks: ", TotalNumberOfDrinks);
        System.out.format("%-20s %3d%n","Total Number of Foods: ", TotalNumberOfFoods);
        System.out.format("%-20s % 5.2f $%n","Total Price: ", price);
        System.out.println("\n" +"Your waiter was " + T.getEmployee().getName());
    }

    static void printRecipient(Reservation T) {
        System.out.println("\u001B[1m"); //makes the text bold
        System.out.println("Dear Guest " +
                T.getCustomer().getName() +
                "\nWe thank you so much for your Business.\nTonight you had " +
                T.getOrders().size() +
                " Orders, which contain:\n");
    }

    void menu(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("\n" +
                    "Press 1 to display all Employees" + "\n" +
                    "Press 2 to display all Customers" + "\n" +
                    "Press 3 to Show Reservations" + "\n" +
                    "Press 4 to Dismiss a Customer" + "\n" +
                    "Press 5 to Take an Order" + "\n" +
                    "Press 6 to Show all Orders" + "\n" +
                    "Press 7 to add a new Food to the Menu" + "\n" +
                    "Press 8 to add a new Drink to the Menu" + "\n" +
                    "Press 9 to calculate the total revenue" + "\n" +
                    "Press 0 to Quit\n \n "
            );

            //Asking user to make choice
            System.out.print("Make your choice:");
            choice = scanner.nextInt();

            //Creating switch case branch
            switch (choice) {

                //First case for finding the addition
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    for(Employee e1 : employees){
                        System.out.println(e1);
                    }
                    break;

                //Second case for finding the difference
                case 2:
                    for(Customer c1 : customers){
                        System.out.println(c1);
                    }
                    break;

                //Third case for finding the product
                case 3:
                    for(Reservation r1 : reservations){
                        System.out.println(r1);
                    }
                    break;

                //Fourth case for finding the quotient
                case 4:
                    int i = 0;
                    for (Reservation t1 : reservations){
                        System.out.println(i + " " + t1);
                        i++;
                    }
                    System.out.print("\n"+"Who do you want to dismiss?: ");
                    choice = scanner.nextInt();

                    ListForAllImpl.ListElement iterator_reservation = reservations.getFirst();
                    for(int j = 0; j < choice; j++){
                        iterator_reservation = iterator_reservation.next;
                    }
                    Reservation dismiss = (Reservation) iterator_reservation.value;
                    //System.out.println(dismiss);
                    printRecipient(dismiss);
                    PrintBill(dismiss);
                    reservations.remove(dismiss);

                    customers.remove(dismiss.getCustomer());



                    break;

                //Fifth case to quit the program
                case 5:

                    i = 0;
                    for (Customer t1 : customers){
                        System.out.println(i + " " + t1);
                        i++;
                    }
                    System.out.print("\n"+"Which Customer?: ");
                    choice = scanner.nextInt();
                    ListForAllImpl.ListElement element = customers.getFirst();
                    for(int j = 0; j < choice; j++){
                        element = element.next;
                    }
                    Customer customer = (Customer) element.value;

                    ListForAllImpl<Food> food_ordered = new ListForAllImpl<>();
                    //choice = 1;
                    System.out.print("\n"+"\n");
                    while(true){
                        i = 1;
                        for (Food t1 : food_available){
                            System.out.println(i + " " + t1);
                            i++;
                        }
                        System.out.print("\n"+"What food? Press[0] to order Drinks: ");
                        choice = scanner.nextInt();
                        if(choice == 0){break;}
                        choice --;

                        Iterator<Food> iterator1 = food_ordered.iterator();
                        element = food_available.getFirst();

                        for(int j = 1; j < choice; j++){
                            element = element.next;
                        }
                        Food food = (Food) element.value;
                        //Food food1 =  element.value;
                        food_ordered.add(food);

                    }
                    //choice = 1;
                    System.out.print("\n"+"\n");
                    ListForAllImpl<Drink> drink_ordered = new ListForAllImpl<>();
                    while(true){
                        i = 1;
                        for (Drink t1 : drinks_available){
                            System.out.println(i + " " + t1);
                            i++;
                        }
                        System.out.print("\n"+"What Drinks? Press[0] to complete Order: ");
                        choice = scanner.nextInt();
                        if(choice == 0){break;}
                        choice --;

                        element = drinks_available.getFirst();
                        for(int j = 1; j < choice; j++){
                            element = element.next;
                        }
                        Drink drink = (Drink) element.value;
                        drink_ordered.add(drink);
                    }

                    //Adds order to a global list of orders
                    Order order = new Order(customer,drink_ordered,food_ordered);
                    orders.add(order);

                    for(Reservation res : reservations){
                        if (res.getCustomer() == customer){
                            res.addOrder(order);
                        }
                    }

                    break;

                case 6:
                    System.out.print("\n"+"\n");
                    System.out.println("Name - Price - Id");
                    for(Order e1 : orders){
                        System.out.println(e1);
                    }
                    break;

                //case 7 for adding new Foods
                case 7:
                    System.out.print("\n");
                    System.out.println("Enter the foods name: or Press[0] to cancel");
                    scanner.nextLine();
                    String food_name = scanner.nextLine();
                    if (food_name.equals("0")){break;}
                    System.out.println("Enter the price: or Press[0] to cancel");
                    double food_price = scanner.nextDouble();
                    if (food_price == 0){break;}
                    food_available.add(new Food(food_name, food_price));
                    System.out.println("added new food, name: " + food_name + ", price: " + food_price);
                    break;

                //case 8 for adding new Drinks
                case 8:
                    System.out.print("\n");
                    System.out.println("Enter the drinks name: or Press[0] to cancel");
                    scanner.nextLine();
                    String drink_name = scanner.nextLine();
                    if (drink_name.equals("0")){break;}
                    System.out.println("Enter the price: or Press[0] to cancel");
                    double drink_price = scanner.nextDouble();
                    if (drink_price == 0){break;}
                    drinks_available.add(new Drink(drink_name, drink_price));
                    System.out.println("added new Drink, name: " + drink_name + ", price: " + drink_price);
                    break;

                //case 9 for getting the total revenue
                case 9:
                    double revenue = 0;
                    for (Order o : orders) {
                        revenue = revenue + o.getTotalPrice();
                    }
                    System.out.println("\nthe total revenue is: " + revenue + "\n");
                    break;

                //default case to display the message invalid choice made by the user
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
            }
        }
    }
}
