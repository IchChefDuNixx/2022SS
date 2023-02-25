
public class Scheibenbremse10 implements Brakes {
	private static final int MAX_RIEFENTIEFE = 4;
	private static final int MIN_BELAG = 1;
	private static final int MAX_BELAG = 8;

	private int riefentiefe;
	private int belag;

	public Scheibenbremse10() {
		this.riefentiefe = 0;
		this.belag = MAX_BELAG;
	}

	public void brake() {
		System.out.println("Scheibembremse bremst!");
	}

	public boolean needsService() {
		return riefentiefe < MAX_RIEFENTIEFE && belag > MIN_BELAG;
	}

	public String toString() {
		return "Scheibenbremse";
	}
}
