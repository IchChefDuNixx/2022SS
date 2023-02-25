import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
	@Test
	void testAdd() {
		Liste<Integer> li = new Liste<>();

		assertEquals("[]", li.toString());

		li.addRek(1);
		li.addRek(2);
		li.addRek(3);

		assertEquals("[1, 2, 3]", li.toString());
	}

	@Test
	void testContains() {
		Liste<Integer> li = new Liste<>();

		assertFalse(li.contains(0));

		li.add(1);
		li.add(2);
		li.add(3);

		assertFalse(li.containsRek(0));
		assertTrue(li.containsRek(1));
		assertTrue(li.containsRek(2));
		assertTrue(li.containsRek(3));
	}

	@Test
	void testToString() {
		Liste<Integer> li = new Liste<>();

		assertEquals("[]", li.toStringRek());

		li.addRek(1);
		li.addRek(2);
		li.addRek(3);

		assertEquals("[1, 2, 3]", li.toStringRek());
	}
}
