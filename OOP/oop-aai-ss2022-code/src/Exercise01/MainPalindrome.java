
public class MainPalindrome {
	public static void main(String[] args) {
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
			System.out.println(Palindrome.isPalindrome(s));
		}

		String[] zs = {
				"hansdampf",
				"peter pan",
				"quatsch mit sosse",
				"ab"
		};

		for (String s : zs) {
			System.err.println(s);
			System.out.println(Palindrome.isPalindrome(s));
		}
	}
}
