
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
	@Test
	void testPalindrome() {
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
			assertTrue(Palindrome.isPalindrome(s));
		}

		String[] zs = {
				"hansdampf",
				"peter pan",
				"quatsch mit sosse",
				"ab"
		};

		for (String s : zs) {
			System.err.println(s);
			assertFalse(Palindrome.isPalindrome(s));
		}
	}
}
