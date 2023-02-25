import java.util.Arrays;

public class ai0403kNN {
  public class Operations {
    public static double[][] distanceToK(double[][] inputArray, double x, double y, int k) {
      int length = inputArray.length;
      double[][] outputArray = new double[10][k];
      double[][] distanceArray = new double[length][2];
      double distance;
      for (int i = 0; i < length; i++) {
        distance = Math.pow(Math.pow(x - inputArray[i][0], 2) + Math.pow(y - inputArray[i][1], 2), 0.5);
        distanceArray[i][1] = inputArray[i][2];
        distanceArray[i][0] = distance;
        // System.out.println(distanceArray[i][0] + " | " + distanceArray[i][0]);
      }
      // System.out.println("---");
      Arrays.sort(distanceArray, (a, b) -> Double.compare(a[0], b[0]));
      for (int j = 0; j < k; j++) {
        outputArray[j][0] = distanceArray[j][0];
        outputArray[j][1] = distanceArray[j][1];
        // System.out.println(distanceArray[j][0] + " | " + distanceArray[j][1]);
      }
      return outputArray;
    }

    public static int classification(double[][] inputArray, double x, double y, int k) {
      double[][] result = Operations.distanceToK(inputArray, x, y, k);
      double sum = 0;
      for (int i = 0; i < result.length; i++) {
        sum += result[i][1];
      }
      System.out.println(Math.round(sum) + " / " + k);
      return (int) Math.round(sum / k);
    }

    public static double[][] transpose(double[][] inputArray) {
      double[][] transposed = new double[inputArray[0].length][3];
      for (int i = 0; i < inputArray[0].length; i++) {
        for (int j = 0; j < 3; j++) {
          transposed[i][j] = inputArray[j][i];
          // System.out.print(transposed[i][j] + " - ");
        }
        // System.out.println();
      }
      // System.out.println("L: " + transposed.length);
      return transposed;
    }
  }

  public static void main(String[] args) {
    double[][] inputArray = new double[][] {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, // x
        { 0, 2, 6, 9, 11, 12, 10, 5, 3, 1 }, // y
        { 0, 0, 1, 1, 1, 1, 0, 0, 0, 1 } }; // class

    inputArray = Operations.transpose(inputArray);
    double[][] testSet = new double[][] {
    {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
    for(int i = 0; i < testSet[0].length; i++) {
      System.out.println(Operations.classification(inputArray, testSet[0][i], testSet[1][i], 5));
    }
    System.out.println(" --- ");
    double[][] testSet2 = new double[][] {
    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
    {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}};
    for(int i = 0; i < testSet[0].length; i++) {
      System.out.println(Operations.classification(inputArray, testSet2[0][i], testSet2[1][i], 3));
    }
  }
}
