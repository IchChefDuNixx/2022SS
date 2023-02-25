import java.util.Arrays;
import java.util.Comparator;

public class SortingTests {
  public static void main(String[] args) {
    // Task 1
    Integer[] intArray = new Integer[] { 1, 4568, 3, 5, 0, 645, 2 };
    System.out.println(Arrays.toString(intArray));
    Sorting.swap(intArray, 1, 6);
    System.out.println(Arrays.toString(intArray) + "\n --- ");

    // Task 2
    Sorting.bubbleSort(intArray);
    System.out.println(Arrays.toString(intArray));

    Student s1 = new Student(123, "Felix");
    Student s2 = new Student(3684, "Hannah");
    Student s3 = new Student(355, "Gabe");
    Student s4 = new Student(985, "Sarah");
    Student s5 = new Student(652, "Felix");
    Student s6 = new Student(651, "Felixo");
    Student s7 = new Student(650, "Falix");

    Student[] AAI_Class = new Student[] { s1, s2, s3, s4, s5, s6, s7 };
    System.out.println(Arrays.toString(AAI_Class));
    Sorting.bubbleSort(AAI_Class);
    System.out.println(Arrays.toString(AAI_Class));

    // Task 3
    Sorting.bubbleSort(AAI_Class, new Comparator<Student>() {
      public int compare(Student a, Student b) {
        return -1 * a.compareTo(b);
      }
    });
    System.out.println(Arrays.toString(AAI_Class));
    Sorting.bubbleSort(AAI_Class, new Comparator<Student>() {
      public int compare(Student a, Student b) {
        int res = a.getName().compareTo(b.getName());
        if(res > 0) {
          return 1;
        } else if(res < 0) {
          return -1;
        } else {
          return a.compareTo(b);
        }
      }
    });
    System.out.println(Arrays.toString(AAI_Class));
  }
}
