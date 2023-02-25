import java.lang.Math;

public class ai0302irisDataset {
	public class classifierEvaluation {
		public static void evaluate(double a, double b, double c, double d) {
			/*
			Predicted/Actual
			Cat/Cat = TP
			Cat/notCat = FP
			notCat/Cat = FN
			notCat/notCat = TN
			*/
			
			double TP = a;
			double FP = b;
			double FN = c;
			double TN = d;
			double sum = TP+FP+FN+TN;
			
			System.out.println(
			"Predicted/Actual " + "(" + (int)sum + " total)" +
			"\nTP = " + TP + " (" + (int)((100*TP)/sum) + "%)" +
			"\tFP = " + FP + " (" + (int)((100*FP)/sum) + "%)" +
			"\nFN = " + FN + " (" + (int)((100*FN)/sum) + "%)" +
			"\tTN = " + TN + " (" + (int)((100*TN)/sum) + "%)"
			);
			
			double precision = TP/(TP + FP);
			double recall = TP/(TP + FN);
			double accuracy = (TP + TN)/(sum);
			double f1Score = (2*TP)/(2*TP + FP + FN);
			double mcc = Math.round(1000*((TP*TN + FP*FN)/(Math.sqrt((TP+FP)*(TP+FN)*(TN+FP)*(TN+FN)))));
			
			System.out.println(
			"Precision: " + 100*precision + "%" +
			"\nRecall: " + 100*recall + "%" +
			"\nAccuracy: " + 100*accuracy + "%" +
			"\nF1-Score: " + 100*f1Score + "%" +
			"\nMathews correlation coefficient: " + 0.1*mcc  + "%\n" 
			);
		}
	}
	public static void main(String[] args) {
		classifierEvaluation.evaluate(16,0,0,43);
		classifierEvaluation.evaluate(20,2,0,37);
	}
}