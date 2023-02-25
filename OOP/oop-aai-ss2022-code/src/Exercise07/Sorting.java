import java.util.Comparator;

public class Sorting<T> {

  public static <T> void swap(T[] inputArray, int n, int m) {
    T temp = inputArray[n];
    inputArray[n] = inputArray[m];
    inputArray[m] = temp;
  }

  public static <T extends Comparable<T>> void bubbleSort(T[] inputArray) {
    int n = 0;
    int counter = 0;
    while (counter < inputArray.length - 1) {
      if (n == inputArray.length - 1) {
        n = 0;
        counter = 0;
      }
      // System.out.println(inputArray[n] + " vs " + inputArray[n+1] + " (" +
      // inputArray[n].compareTo(inputArray[n+1]) + ")");
      if (inputArray[n].compareTo(inputArray[n + 1]) > 0) {
        swap(inputArray, n, n + 1);
      } else {
        counter++;
      }
      n++;
      // System.out.println("n: " + n + "\ncounter: " + counter);

    }
  }

  public static <T> void bubbleSort(T[] inputArray, Comparator<T> compType) {
    int n = 0;
    int counter = 0;
    while (counter < inputArray.length - 1) {
      if (n == inputArray.length - 1) {
        n = 0;
        counter = 0;
      }
      if (compType.compare(inputArray[n], inputArray[n + 1]) > 0) {
        swap(inputArray, n, n + 1);
      } else {
        counter++;
      }
      n++;
    }
  }
}
