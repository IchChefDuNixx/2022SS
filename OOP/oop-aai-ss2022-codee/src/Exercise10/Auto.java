
public class Auto extends FourWheel {
	private int sitze;
	private int tueren;
	private Scheibenbremse10[] bremsen;

	public Auto(String hersteller, String modell, int ps, int hubraum, int tankvolumen, int sitze, int tueren,
			int zulGesamtGewicht) {
		super(hersteller, modell, ps, tankvolumen, hubraum, zulGesamtGewicht);
		this.sitze = sitze;

		this.tueren = tueren;

		this.bremsen = new Scheibenbremse10[] {
				new Scheibenbremse10(),
				new Scheibenbremse10(),
				new Scheibenbremse10(),
				new Scheibenbremse10()
		};
	}

	public String toString() {
		return "Ich bin ein " + hersteller + " " + modell + " mit "
				+ ps + " PS, "
				+ hubraum + " Hubraum, "
				+ tankvolumen + " Tankvolumen, "
				+ sitze + " Sitzen, "
				+ tueren + " Türen, "
				+ bremsen.length + " " + bremsen[0].toString()
				+ " und " + zulGesamtGewicht + " zul. Gesamtgewicht";
	}
}
