
public class Motorrad extends MotorizedVehicle {
	Scheibenbremse10 vorderbremse;
	Trommelbremse10 hinterbremse;

	public Motorrad(String hersteller, String modell, int ps, int tankvolumen) {
		super(hersteller, modell, ps, tankvolumen);
		this.vorderbremse = new Scheibenbremse10();
		this.hinterbremse = new Trommelbremse10();
	}

	public void anlassen() {
		System.out.println("Starte Motor...");
	}

	public String toString() {
		return "Ich bin ein " + hersteller + " " + modell + " mit "
				+ ps + " PS, "
				+ tankvolumen + " Litern Tankvolumen" +
				" sowie einer " + vorderbremse + " und " + hinterbremse;
	}
}
