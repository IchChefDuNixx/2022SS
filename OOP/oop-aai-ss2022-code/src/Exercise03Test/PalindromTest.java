package Exercise03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromTest {
	@Test
	void testPalindrom() {
		String[] xs = {
				"a",
				"aa",
				"Ana",
				"Anna",
				"Regallager",
				"Ein Neger mit Gazelle zagt im Regen nie",
				"Eine güldne gute Tugend Lüge nie"
		};

		for (String s : xs) {
			System.err.println(s);
			assertTrue(Palindrom.istPalindrom(s));
		}

		String[] zs = {
				"hansdampf",
				"peter pan",
				"quatsch mit sosse",
				"ab"
		};

		for (String s : zs) {
			System.err.println(s);
			assertFalse(Palindrom.istPalindrom(s));
		}
	}
}