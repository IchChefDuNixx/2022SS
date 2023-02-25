package Exercise03;

import org.junit.jupiter.api.Test;

import static Exercise03.Duplikate.findeDuplikate;
import static org.junit.jupiter.api.Assertions.*;

class DuplikateTest {
	@Test
	void testFindeDuplikate() {
		String t1 = "In Ulm! und um Ulm! und um Ulm herum!";

		StringSet s1 = findeDuplikate(t1);
		System.out.println(s1);

		assertEquals(3, s1.size());  // Ulm und um
		assertTrue(s1.contains("Ulm"));
		assertTrue(s1.contains("und"));
		assertTrue(s1.contains("um"));
		assertFalse(s1.contains("In"));
		assertFalse(s1.contains("herum"));
		assertFalse(s1.contains("Ulm!"));  // keine Satzzeichen!

		String t2 = "Ein armer Affe";
		StringSet s2 = findeDuplikate(t2);

		assertEquals(0, s2.size());

		String t3 = "Wenn Fliegen hinter Fliegen fliegen?";
		StringSet s3 = findeDuplikate(t3);

		assertEquals(1, s3.size());
		assertTrue(s3.contains("Fliegen"));
		assertFalse(s3.contains("fliegen"));
	}

}