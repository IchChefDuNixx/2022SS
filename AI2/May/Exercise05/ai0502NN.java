/*
2*1 - 0 + 0 = 2 > 0 -> 1
2*0 - 1 + 1 = 0 <= 0 -> 0
2*1 - 0 + 1 = 3 > 0 -> 1
2*1 - 1 + 1 = 2 > 0 -> 1
*/

public class ai0502NN {
	public static class Neuron {
		private int weight1;
		private int weight2;
		private int weight3;

		public Neuron() {
			this(0);
		}

		public Neuron(int weight1) {
			this(weight1, 0);
		}

		public Neuron(int weight1, int weight2) {
			this(weight1, weight2, 0);
		}

		public Neuron(int weight1, int weight2, int weight3) {
			this.weight1 = weight1;
			this.weight2 = weight2;
			this.weight3 = weight3;
		}

		public int compute(int x, int y, int z) {
			int result = x*weight1 + y*weight2 + z*weight3;
			if(result > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		/*
		ai0502NN.Neuron nure = new ai0502NN.Neuron(1, 2, 3);
		nure.compute(5, 5, 5);
		*/
		Neuron n1 = new Neuron(2, -1, 1);
		System.out.println(n1.compute(1, 0, 0) + "\n" +
						   n1.compute(0, 1, 1) + "\n" +
						   n1.compute(1, 0, 1) + "\n" +
						   n1.compute(1, 1, 1)
						   );
	}
}
