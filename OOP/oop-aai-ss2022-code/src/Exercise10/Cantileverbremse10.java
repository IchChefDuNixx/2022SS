
public class Cantileverbremse10 implements Brakes {
	private static final int MAX_BELAG = 5;
	private static final int MIN_BELAG = 1;

	private int belagLinks;
	private int belagRechts;

	public Cantileverbremse10() {
		this.belagLinks = this.belagRechts = MAX_BELAG;
	}

	public void brake() {
		System.out.println("Cantileverbremse bremst!");
	}

	public boolean needsService() {
		return belagLinks > MIN_BELAG && belagRechts > MIN_BELAG;
	}

	public String toString() {
		return "Cantileverbremse";
	}
}
