
import java.util.Arrays;

public class Palindrome {
	public static boolean isPalindrome(String s) {
		boolean result = false;
		// Verwenden Sie die Klasse CharStackImpl um auf Palindrom zu testen!
		s = s.replaceAll("\s*", "");
		s = s.replaceAll("\\.", "");
		s = s.replaceAll(",", "");
		s = s.toLowerCase();
		char[] charArray = s.toCharArray();
		String tempS = "";
		for (int i = charArray.length; i > 0; i--) {
			tempS = tempS + charArray[i - 1];
		}
		char[] tempSArray = tempS.toCharArray();
		System.out.println(s + "\n" + tempS);
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != tempSArray[i]) {
				result = false;
			} else {
				result = true;
			}
		}
		return result;
	}
}
