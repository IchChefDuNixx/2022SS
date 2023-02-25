import java.util.Scanner;
import java.util.Arrays;

public class books {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int book1, book2, book3;
    int[] bookshelf = new int[9];
    System.out.println("\n enter book amount: \n order: gold, silver, bronze");
    for(int i = 0; i < 9; i++) {
      book1 = scan.nextInt();
      book2 = scan.nextInt();
      book3 = scan.nextInt();
      bookshelf[i] = book1*9 + book2*3 + book3;
    }
    System.out.println(Arrays.toString(bookshelf));
  }
}
