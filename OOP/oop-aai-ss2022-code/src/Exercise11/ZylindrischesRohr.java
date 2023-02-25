public class ZylindrischesRohr extends Volumen {
	private double r1, r2;
	public ZylindrischesRohr(double r1, double r2, double h) {
		super(h);
		this.r1 = r1;
		this.r2 = r2;
	}

	public double grundflaeche() {
		return Math.PI*r1*r1 - Math.PI*r2*r2;
	}
}
