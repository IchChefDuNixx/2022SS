import java.lang.Math;

public class ai0301validation {
	public static void main(String[] args) {
		/*
		Predicted/Actual
		Cat/Cat = 30
		Cat/notCat = 30
		notCat/Cat = 10
		notCat/notCat = 930
		*/
		
		double TP = 30;
		double FP = 30;
		double FN = 10;
		double TN = 930;
		double sum = TP+FP+FN+TN;
		
		System.out.println(
		"Predicted/Actual " + "(" + (int)sum + " total)" +
		"\nCat/Cat = " + TP + " (" + (int)((100*TP)/sum) + "%)" +
		"\nCat/notCat = " + FP + " (" + (int)((100*FP)/sum) + "%)" +
		"\nnotCat/Cat = " + FN + " (" + (int)((100*FN)/sum) + "%)" +
		"\nnotCat/notCat = " + TN + " (" + (int)((100*TN)/sum) + "%)"
		);
		
		double precision = TP/(TP + FP);
		double recall = TP/(FP + FN);
		double accuracy = (TP + TN)/(sum);
		double f1Score = (2*TP)/(2*TP + FP + FN);
		double mcc = Math.round(1000*((TP*TN + FP*FN)/(Math.sqrt((TP+FP)*(TP+FN)*(TN+FP)*(TN+FN)))));
		
		System.out.println(
		"Precision: " + 100*precision + "%" +
		"\nRecall: " + 100*recall + "%" +
		"\nAccuracy: " + 100*accuracy + "%" +
		"\nF1-Score: " + 100*f1Score + "%" +
		"\nMathews correlation coefficient: " + 0.1*mcc  + "%"
		);
	}
}