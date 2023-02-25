import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
	@Test
	void testToString() {
		Integer[] a1 = { 1, 2, 3 };
		Integer[] a2 = new Integer[0];

		assertEquals("[1, 2, 3]", Arrays.toString(a1));
		assertEquals("[]", Arrays.toString(a2));
	}

	@Test
	void testContains() {
		Integer[] a1 = { 1, 2, 3 };

		assertTrue(Arrays.contains(a1, 1));
		assertTrue(Arrays.contains(a1, 3));
		assertTrue(Arrays.contains(a1, 2));

		assertFalse(Arrays.contains(a1, 0));
	}
}
