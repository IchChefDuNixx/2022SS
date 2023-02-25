
public class Trommelbremse10 implements Brakes {
	private int belag;
	private static final int MIN_BELAG = 2;
	private static final int MAX_BELAG = 8;

	public Trommelbremse10() {
		this.belag = MAX_BELAG;
	}

	public void brake() {
		System.out.println("Trommelbremse bremst!");
	}

	public boolean needsService() {
		return belag < MIN_BELAG;
	}

	public String toString() {
		return "Trommelbremse";
	}
}
