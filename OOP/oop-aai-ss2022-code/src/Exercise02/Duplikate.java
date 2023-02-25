import java.util.Arrays;

public class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	public static StringSet findeDuplikate(String text) {
		// TODO Implementieren Sie die Methode gemäß dem obigen Javadoc Kommentar.
		//System.out.println("input: " + text);
		text = text.replaceAll("ä|Ä", "ae");
		text = text.replaceAll("ö|Ö", "oe");
		text = text.replaceAll("ü|Ü", "ue");
		text = text.replaceAll("[^\\w\\s]", "");
		//System.out.println("modded: " + text);

		StringSet set = new StringSetImpl();

		int i = 0;
		for (String c : text.split(" ")) {
			i++;
		}

		String[] tempArray = new String[i];

		i = 0;
		for (String c : text.split(" ")) {
			tempArray[i] = c;
			i++;
		}

		/*
		if(i % 2 == 0) {
			String[] arrayOne = new String[i/2];
			String[] arrayTwo = new String[i/2];
			String[] returnArray = splitter(text, arrayOne, arrayTwo, true);
			return set;
		} else {
			String[] arrayOne = new String[i/2+1];
			String[] arrayTwo = new String[i/2];
			String[] returnArray = splitter(text, arrayOne, arrayTwo, false);
			return set;
		}
		*/

		for(int m = 0; m < i; m++) {
			for(int n = m+1; n < i; n++) {
				if(tempArray[m].equals(tempArray[n])) {
					set.add(tempArray[m]);
				}
			}
		}
		return set;
	}

	public static String[] splitter(String text, String[] arrayOne, String[] arrayTwo, boolean isEven) {
		String[] tempArray = new String[arrayOne.length + arrayTwo.length];
		int i = 0;
		for(String word : text.split(" ")) {
			tempArray[i] = word;
			//System.out.println(tempArray[i]);
			i++;
		}
		if(isEven){
			for(i = 0; i < arrayOne.length; i++) {
				arrayOne[i] = tempArray[i];
				arrayTwo[i] = tempArray[i+arrayOne.length];
			}
		} else {
			for(i = 0; i < arrayOne.length-1; i++) {
				arrayOne[i] = tempArray[i];
				arrayTwo[i] = tempArray[i+arrayOne.length];
			}
			arrayOne[i] = tempArray[i];
		}
		System.out.println(Arrays.toString(arrayOne) + "\n" + Arrays.toString(arrayTwo));
		return tempArray;
	}
}
