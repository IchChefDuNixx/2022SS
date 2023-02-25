package TheGoldenBucket;
import java.util.Scanner;

public class TheGoldenBucketRestaurant {
    public static void main(String[] args) {

        //the following code creates an employee, customer, reservation list
        String[] initial_employee_names = {
                "Peter Griffin",
                "Lois Griffin",
                "Meg Griffin",
                "Chris Griffin",
                "Stewie Griffin",
                "Brian Griffin"
        };
        String[] initial_employee_roles = {
                "Waiter",
                "Cook",
                "Cook",
                "Waiter",
                "Waiter",
                "Front Desk"
        };

        Employee[] employee_list = new Employee[initial_employee_names.length];
        for(int i = 0; i<employee_list.length;i++){
            Employee e1 = new Employee(initial_employee_names[i], initial_employee_roles[i]);
            employee_list[i] = e1;
        }

        String[] initial_customer_names = {
                "Max",
                "Tommy",
                "Bob",
                "Amy",
                "Mari"
        };
        int[] initial_customer_ages = {
                23,
                34,
                15,
                19,
                25
        };

        Customer[] customer_list = new Customer[initial_customer_names.length];
        for(int i = 0; i<initial_customer_names.length;i++){
            Customer c1 = new Customer(initial_customer_names[i], initial_customer_ages[i]);
            customer_list[i] = c1;
        }

        //We can add complexity to the creation of reservations
        Reservation[] reservation_list = new Reservation[initial_customer_names.length];
        for(int i = 0; i<initial_customer_names.length;i++){
            //waiter list
            Employee[] waiters = {employee_list[0], employee_list[3], employee_list[4]};
            Reservation r1 = new Reservation(customer_list[i], "8pm", "31.03.2022", waiters[i%3]);
            reservation_list[i] = r1;
        }

        reservation_list[0].setWaiter(employee_list[0]);

        // Later that evening Maxwell Powers likes to order some food and drinks
        Order o1 = new Order();
        o1.addDrink(new Drink("Coke", 395));
        o1.addDrink(new Drink("Negroni Cocktail", 500));
        o1.addFood(new Food("Pizza Magherita", 1050));
        o1.addFood(new Food("Antipasti Selection", 970));

        //different order
        Order o2 = new Order();
        o2.addDrink(new Drink("Water", 200));
        o2.addFood(new Food("Kebap", 650));

        Menu menu = new Menu();
        menu.startMenu(employee_list, customer_list, reservation_list, o1, o2);
    }
}
