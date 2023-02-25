import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaumTest {
	@Test
	void testAdd() {
		Baum<Integer> b = new Baum<>();

		assertEquals("[]", b.toString());

		b.addRek(3);
		b.addRek(2);
		b.addRek(1);
		b.addRek(4);

		assertEquals("[1, 2, 3, 4]", b.toString());
		assertTrue(b.contains(3));
		assertFalse(b.contains(0));
	}

	@Test
	void testContains() {
		Baum<Integer> b = new Baum<>();

		assertFalse(b.contains(0));

		b.addRek(3);
		b.addRek(2);
		b.addRek(1);
		b.addRek(4);

		assertTrue(b.containsRek(1));
		assertTrue(b.containsRek(2));
		assertTrue(b.containsRek(3));
		assertTrue(b.containsRek(4));

		assertFalse(b.containsRek(0));
	}

	@Test
	void testToString() {
		Baum<Integer> b = new Baum<>();

		assertEquals("[]", b.toStringRek());

		b.add(3);
		b.add(2);
		b.add(1);
		b.add(4);

		assertEquals("[1, 2, 3, 4]", b.toStringRek());
	}
}
