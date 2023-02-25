
public class Programm {
	public static void main(String[] args) {
		Auto auto = new Auto("BMW", "318d", 145, 2000, 58, 5, 5, 2820);
		Lastwagen lkw = new Lastwagen("MAN", "TGX", 6, 360, 10500, 1380, 36000, 40000);
		Fahrrad rad = new Fahrrad("Cannondale", "Synapse", 21, false);
		Motorrad krad = new Motorrad("BMW", "1000", 150, 30);

		System.out.println(auto);
		System.out.println(lkw);
		System.out.println(rad);
		System.out.println(krad);
	}
}
