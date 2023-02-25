package TheGoldenBucket;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
  /*
  Idea: split the whole process into smaller methods (e.g. just printing the menu, scanner, exit)
  and then combine these internal methods into 1 method that can be called from main:
  startMenu() {
    method1() {}
    method2() {}
    method3() {}
  }
  */

  //Declaring all variables
  //private int a,b,c;
  private int choice;
  private Scanner scanner = new Scanner(System.in);

  public void startMenu(Employee[] employee_list, Customer[] customer_list, Reservation[] reservation_list, Order o1, Order o2) {
  //Creating infinite while loop
  while(true) {

      //Creating menu
      System.out.println("\n" +
      "Press 1 to display all Employees" + "\n" +
      "Press 2 to display all Customers" + "\n" +
      "Press 3 to display all Reservations" + "\n" +
      "Press 4 dismiss customer" + "\n" +
      "Press 5 to Quit\n \n "
      );

      //Asking user to make choice
      System.out.print("Make your choice:");
      choice = scanner.nextInt();

      //Creating switch case branch
      switch (choice) {

          //First case for finding the addition
          case 1:
              for(Employee e1 : employee_list){
                  System.out.println(e1.getName());
              }
              break;

          //Second case for finding the difference
          case 2:
              for(Customer c1 : customer_list){
                  System.out.println(c1.getName());
              }
              break;

          //Third case for finding the product
          case 3:
              for(Reservation r1 : reservation_list){
                  System.out.println(r1);
              }
              break;

          //Fourth case for finding the quotient
          case 4:
              for (int i = 0; i < customer_list.length; i++) {
                  System.out.println("Press "+(1+i)+" to dismiss customer "+ customer_list[i].getName());}
              System.out.println();

              Scanner scanner2 = new Scanner(System.in);
              System.out.print("Make your choice:");
              int choice2 = scanner2.nextInt();

              System.out.println("Choose order [1] or [2]: ");

              int choice3 = scanner.nextInt();
              Order o3 = new Order();
              if(choice3 == 2){

                  o3 = o2;
              }else{
                  o3 = o1;
              }

              double price = (double) o3.getTotalPrice() / 100;
              String priceStr = String.format("%.2f Euro", price);



              System.out.println( "Dear Guest "+
                      customer_list[choice2-1].getName()+
                      " We thank you so much for your Business. Tonight you had "+
                      o3.getNumberOfDrinks() +
                      " Drinks and you ordered "+
                      o3.getNumberOfFoods() +
                      " different variations of our food " +
                      "in total your bill is: " +
                      priceStr+".");
              break;


              /*switch (choice2){
                  case 1:
                      //to get the price in 00,00 Euro format and not in cents
                      double price = (double) o1.getTotalPrice() / 100;
                      String priceStr = String.format("%.2f Euro", price);
                      //printReceipt
                      System.out.println( "Dear Guest "+
                              customer_list[choice2].getName()+
                              " We thank you so much for your Business. Tonight you had "+
                              o1.getNumberOfDrinks() +
                              " Drinks and you ordered "+
                              o1.getNumberOfFoods() +
                              " different variations of our food " +
                              "in total your bill is: " +
                              priceStr+".");
                      break;

                  case 2:
                      //to get the price in 00,00 Euro format and not in cents
                      price = (double) o2.getTotalPrice() / 100;
                      priceStr = String.format("%.2f Euro", price);
                      //printReceipt
                      System.out.println( "Dear Guest "+
                              customer_list[choice2].getName()+
                              " We thank you so much for your Business. Tonight you had "+
                              o2.getNumberOfDrinks() +
                              " Drinks and you ordered "+
                              o2.getNumberOfFoods() +
                              " different variations of our food " +
                              "in total your bill is: " +
                              priceStr+".");
                      break;

                  default:
                      System.out.println("There are no orders form the customer yet.");
              }

              break;
*/
          //Fifth case to quit the program
          case 5:
              System.exit(0);

              //default case to display the message invalid choice made by the user
          default:
              System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
            }
      }
  }
}
