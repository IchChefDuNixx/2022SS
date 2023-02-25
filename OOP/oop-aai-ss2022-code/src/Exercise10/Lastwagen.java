
public class Lastwagen extends FourWheel {
	private int achsen;
	private int maxNutzlast;
	private Trommelbremse10[] bremsen;

	public Lastwagen(String hersteller, String modell, int achsen, int ps, int hubraum, int tankvolumen,
			int maxNutzlast, int zulGesamtGewicht) {
		super(hersteller, modell, ps, tankvolumen, hubraum, zulGesamtGewicht);
		this.achsen = achsen;

		this.maxNutzlast = maxNutzlast;

		bremsen = new Trommelbremse10[achsen * 2];
		for (int i = 0; i < bremsen.length; i++)
			bremsen[i] = new Trommelbremse10();

	}

	public String toString() {
		return "Ich bin ein " + hersteller + " " + modell + " mit "
				+ achsen + " Achsen, "
				+ ps + " PS, "
				+ hubraum + " Hubraum, "
				+ tankvolumen + " Tankvolumen, "
				+ maxNutzlast + " max. Nutzlast, "
				+ bremsen.length + " " + bremsen[0].toString()
				+ " und " + zulGesamtGewicht + " zul. Gesamtgewicht";
	}
}
