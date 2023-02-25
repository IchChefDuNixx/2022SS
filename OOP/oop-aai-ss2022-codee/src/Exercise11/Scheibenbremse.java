public class Scheibenbremse extends Bremse {
	private static final int MAX_RIEFENTIEFE = 4;
	private static final int MIN_BELAG = 1;
	private static final int MAX_BELAG = 8;

	private int riefentiefe;
	private int belag;

	public Scheibenbremse(String manufacturer, String serialNumber, int belag, int riefentiefe) {
		super(manufacturer, serialNumber);
		this.riefentiefe = 0;
		this.belag = MAX_BELAG;
	}

	public void bremsen() {
		System.out.println("Scheibembremse bremst!");
	}

	public boolean brauchtService() {
		return riefentiefe < MAX_RIEFENTIEFE && belag > MIN_BELAG;
	}

	public String toString() {
		return "Scheibenbremse";
	}
}
