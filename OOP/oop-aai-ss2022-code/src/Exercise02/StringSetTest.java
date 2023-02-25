import java.util.NoSuchElementException;

class StringSetTest {
	public static void main(String[] args) {

		StringSetImpl impl = new StringSetImpl();
		String str = "In Ulm und um Ulm und um Ulm herum";

		int i = 1;
		for (String c : str.split(" ")) {
			System.out.println("attempt " + i + ": " + c);
			impl.add(c);
			i++;
		}

		System.out.println("test: " + impl.toString());

		// sollte sein: In Ulm und um herum
		System.out.println(impl.size());

		// Elemente testen
		System.out.println(impl.contains("In"));
		System.out.println(impl.contains("Ulm"));
		System.out.println(impl.contains(""));
		System.out.println(impl.contains("Hans"));
		System.out.println(impl.contains("herum"));

		System.out.println(impl);

		// zwei herausnehmen
		impl.remove("Ulm");
		impl.remove("um");
		impl.remove("Hams");

		System.out.println(impl.size());

		System.out.println(impl);

		// nochmal Elemente testen
		System.out.println(impl.contains("Ulm"));
		System.out.println(impl.contains("um"));
		System.out.println(impl.contains("Hans"));
	}
}
