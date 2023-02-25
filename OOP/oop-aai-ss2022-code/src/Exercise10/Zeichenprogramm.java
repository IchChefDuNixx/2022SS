public class Zeichenprogramm {
	public static void main(String[] args) {
		// 1. Datenstruktur erstellen, welche die geometrischen Formen speichern soll
		Shape[] storage = new Shape[3];

		// 2. Je ein/en Kreis, Viereck und Dreieck erstellen, und in obige Struktur
		// einfuegen
		storage[0] = new Circle(5, 10, 5);
		storage[1] = new Rectangle(0, 0, 3, 2);
		storage[2] = new Triangle(0, 0, 1, 0, 0, 1);

		// 3. Alle Formen mit `toString` auf der Konsole ausgeben.
		for (Shape shape : storage) {
			System.out.println(shape);
		}
	}
}
