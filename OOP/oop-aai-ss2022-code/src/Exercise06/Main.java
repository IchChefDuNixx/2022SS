public class Main {
  public static void main(String[] args) {
    Baum<Integer> b = new Baum<>();

		b.contains(0);

		b.addRek(3);
		b.addRek(2);
		b.addRek(1);
		b.addRek(4);


    b.containsRek(1);
		b.containsRek(2);
		b.containsRek(3);
		b.containsRek(4);

		b.containsRek(0);

    System.out.println("sanity check: " + b);
    System.out.println(b.toStringRek());
  }
}
