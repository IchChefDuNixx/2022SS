
public class Fahrrad extends ManualDrive {
	private Cantileverbremse10[] bremsen;

	public Fahrrad(String hersteller, String modell, int gaenge, boolean ruecktrittbremse) {
		super(hersteller, modell, gaenge, ruecktrittbremse);
		this.bremsen = new Cantileverbremse10[] { new Cantileverbremse10(), new Cantileverbremse10() };
	}

	public String toString() {
		return "Ich bin ein " + hersteller + " " + modell + " mit "
				+ gaenge + " Gängen"
				+ (ruecktrittbremse ? ", Rücktrittbremse" : "")
				+ " und " + bremsen.length + " " + bremsen[0].toString();
	}
}
