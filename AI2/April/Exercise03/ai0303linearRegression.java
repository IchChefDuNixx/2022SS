import java.lang.Math;

public class ai0303linearRegression {

	public class LinearRegression {

	  public static String linearRegression(double[] inputArray,
	                                        double lowerIntercept, double upperIntercept, double interceptStep,
	                                        double lowerSlope, double upperSlope, double SlopeStep) {
	    double sumOfResiduals = 0;
	    double intercept = 0;
	    double slope = 0;
	    double lowestSum = Double.MAX_VALUE;
	    double minIntercept = Double.MAX_VALUE;
	    double minSlope = Double.MAX_VALUE;
	    String result = "";

	    for(intercept = lowerIntercept; intercept < upperIntercept; intercept += interceptStep) {
	  		for(slope = lowerSlope; slope < upperSlope; slope += SlopeStep) {
	  			for(int i = 0; i < inputArray.length; i++) {
	  				sumOfResiduals += Math.pow((inputArray[i]-(slope*i + intercept)), 2);
	  			}
	  			//System.out.println("sum: " + sumOfResiduals + "\t\t\tslope: " + slope);
	  			if(sumOfResiduals <= lowestSum) {
	  				lowestSum = sumOfResiduals;
	  				minIntercept = intercept;
	  				minSlope = slope;
	  			}
	  			sumOfResiduals = 0;
	  		}
	  		//System.out.println("intercept: " + intercept);
	  		sumOfResiduals = 0;
	  	}
	  	result += "result: \n" +
	            	"error " + lowestSum + "\n" +
	            	"at intercept " + minIntercept + "\n" +
	            	"with slope " + minSlope;
	    System.out.println(result);
	    return result;
	  }

		public static String linearRegression(double[][] inputArray,
																					double lowerIntercept, double upperIntercept, double interceptStep,
																					double lowerSlope, double upperSlope, double SlopeStep) {
			double sumOfResiduals = 0;
			double intercept = 0;
			double slope = 0;
			double lowestSum = Double.MAX_VALUE;
			double minIntercept = Double.MAX_VALUE;
			double minSlope = Double.MAX_VALUE;
			String result = "";

			for(intercept = lowerIntercept; intercept < upperIntercept; intercept += interceptStep) {
				for(slope = lowerSlope; slope < upperSlope; slope += SlopeStep) {
					for(int i = 0; i < inputArray[0].length; i++) {
						sumOfResiduals += Math.pow((inputArray[1][i]-(slope*inputArray[0][i] + intercept)), 2);
						System.out.println("calc " + inputArray[1][i] + "-" + slope + "*" + inputArray[0][i] + "+" + intercept);
						System.out.println(sumOfResiduals);
					}
					//System.out.println("sum: " + sumOfResiduals + "\t\t\tslope: " + slope);
					if(sumOfResiduals < lowestSum) {
						lowestSum = sumOfResiduals;
						minIntercept = intercept;
						minSlope = slope;
					}
					sumOfResiduals = 0;
				}
				//System.out.println("intercept: " + intercept);
				sumOfResiduals = 0;
			}
			result += "result: \n" +
			"error " + lowestSum + "\n" +
			"at intercept " + minIntercept + "\n" +
			"with slope " + minSlope;
			System.out.println(result);
			return result;

		}
	}

	public static void main(String[] args) {
		/*
		    sepal_length  sepal_width  petal_length  petal_width species
0           5.1          3.5           1.4          0.2  setosa
1           4.9          3.0           1.4          0.2  setosa
2           4.7          3.2           1.3          0.2  setosa
3           4.6          3.1           1.5          0.2  setosa
4           5.0          3.6           1.4          0.2  setosa
5           5.4          3.9           1.7          0.4  setosa
6           4.6          3.4           1.4          0.3  setosa
7           5.0          3.4           1.5          0.2  setosa
8           4.4          2.9           1.4          0.2  setosa
9           4.9          3.1           1.5          0.1  setosa
		*/

		double[] sepal_length = new double[]{5.1, 4.9, 4.7, 4.6, 5.0, 5.4, 4.6, 5.0, 4.4, 4.9}; // x1
		double[] sepal_width = new double[]{3.5, 3.0, 3.2, 3.1, 3.6, 3.9, 3.4, 3.4, 2.9, 3.1};	// y1
		double[][] sepalArray = new double[2][10];
		for(int i = 0; i < 10; i++) {
			sepalArray[0][i] = sepal_length[i];
			sepalArray[1][i] = sepal_width[i];
		}
		double[] petal_length = new double[]{1.4, 1.4, 1.3, 1.5, 1.4, 1.7, 1.4, 1.5, 1.4, 1.5};	// x2
		double[] petal_width = new double[]{0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1};	// y2
		double[][] petalArray = new double[10][2];
		for(int i = 0; i < 10; i++) {
			petalArray[i][0] = petal_length[i];
			petalArray[i][1] = petal_width[i];
		}

		double[] fullData = new double[]{5.1, 4.9, 4.7, 4.6, 5.0, 5.4, 4.6, 5.0, 4.4, 4.9,
		                                 3.5, 3.0, 3.2, 3.1, 3.6, 3.9, 3.4, 3.4, 2.9, 3.1,
		                                 1.4, 1.4, 1.3, 1.5, 1.4, 1.7, 1.4, 1.5, 1.4, 1.5,
		                                 0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1};

		//LinearRegression.linearRegression(sepal_length, 0, 10, 1, -1, 1, 0.1);
		//LinearRegression.linearRegression(sepal_width, 0, 5, 0.2, 0, 3, 0.5);
		//LinearRegression.linearRegression(fullData, -10, 10, 0.01, -10, 10, 0.01);
		//LinearRegression.linearRegression(sepalArray, -5, 0, 0.5, 0, 2, 1);
		LinearRegression.linearRegression(petalArray, 0, 3, 0.2, 0, 2, 0.5);
		double[][] testArray = new double[][]{{2,3,3,3},{0,1,2,3.5}};
		//LinearRegression.linearRegression(testArray, -5, 5, 0.5, 0, 2, 0.5);
	}
}
