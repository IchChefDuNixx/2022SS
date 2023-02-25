
class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text
	 * vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * 
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {

		// nur Zeichen und Leerzeichen zulassen
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isAlphabetic(c) || c == ' ')
				sb.append(c);
		}
		text = sb.toString();

		// Alternativ via reg. Ausdruck
		/*
		 * String[] satzz = {
		 * "\\?", "!", ",", "\\.", ":", "'", "\"", "-"
		 * };
		 * for (String z : satzz)
		 * text = text.replaceAll(z, "");
		 */

		StringSet s1 = new StringSetImpl();
		StringSet s2 = new StringSetImpl();

		for (String w : text.split(" ")) {
			// kennt das erste Set das Wort bereits, so tritt es zum 2. mal auf!
			if (s1.contains(w))
				s2.add(w);

			// jedes Wort in das erste Set einfuegen
			s1.add(w);
		}

		return s2;
	}
}
