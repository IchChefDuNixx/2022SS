public class ai0401PerceptronLearning {

  public class VectorOperations {

    public static double[] addition(double[] weight, double x, double y) {
      weight[0] += x;
      weight[1] += y;
      return weight;
    }

    public static double[] subtraction(double[] weight, double x, double y) {
      weight[0] -= x;
      weight[1] -= y;
      return weight;
    }

    public static double dotProduct(double[] weight, double x, double y) {
      return (weight[0]*x + weight[1]*y);
    }

    public static boolean isPointAboveLine(double[] weight, double x, double y) {
      double m = weight[1]/weight[0];
      if(y > m*x) {
        return true;
      } else {
        return false;
      }
    }

    public static boolean isCorrectlyClassified(double[] weight, double[][] points, int setOne, int setTwo) {
      double m = weight[1]/weight[0];
      if(points[1][0] >= m*points[0][0]) {
        for(int i = 0; i < setOne; i++) {
          if(points[1][i] <= (-1/m)*points[0][i]) {
            return false;
          }
        }
        for(int j = setOne; j < setOne + setTwo; j++) {
          if(points[1][j] >= (-1/m)*points[0][j]) {
            return false;
          }
        }
        return true;

      } else {
        for(int i = 0; i < setOne; i++) {
          if(points[1][i] >= (-1/m)*points[0][i]) {
            return false;
          }
        }
        for(int j = setOne; j < setOne + setTwo; j++) {
          if(points[1][j] <= (-1/m)*points[0][j]) {
            return false;
          }
        }
        return true;
      }
    }
  }

  public static void main(String[] args) {
    double[][] points = new double[][]{{1.1, 1.2, 2, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 1.3},
                                       {1.2, 1.5, 2, 1.6, 1, 1.2, 0.8, 0.7, 0.5, 0.4}};
    double[] weight = new double[]{1,1};

    int setOne = 4;
    int setTwo = 6;
    double m = weight[1]/weight[0];
    int count = 0;
    while(VectorOperations.isCorrectlyClassified(weight, points, setOne, setTwo) == false && count < 10000) {
      if(points[1][0] >= m*points[0][0]) {
        for(int i = 0; i < setOne; i++) {
          if(VectorOperations.dotProduct(weight, points[0][i], points[1][i]) <= 0) {
            VectorOperations.addition(weight, points[0][i], points[1][i]);
          }
        }
        for(int j = setOne; j < setOne + setTwo; j++) {
          if(VectorOperations.dotProduct(weight, points[0][j], points[1][j]) >= 0) {
            VectorOperations.subtraction(weight, points[0][j], points[1][j]);
          }
        }
      } else {
        for(int i = 0; i < setOne; i++) {
          if(VectorOperations.dotProduct(weight, points[0][i], points[1][i]) >= 0) {
            VectorOperations.addition(weight, points[0][i], points[1][i]);
          }
        }
        for(int j = setOne; j < setOne + setTwo; j++) {
          if(VectorOperations.dotProduct(weight, points[0][j], points[1][j]) <= 0) {
            VectorOperations.subtraction(weight, points[0][j], points[1][j]);
          }
        }
      }
      count++;
    }
    System.out.println("y = " + (-1*weight[1]/weight[0]) + "*x");
  }
}
