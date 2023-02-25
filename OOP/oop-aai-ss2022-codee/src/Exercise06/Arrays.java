class Arrays {
	/**
	 * Gibt eine Stringrepraesentation des Arrays zurueck, z.B. [] oder [1, 2, 3]
	 */
	static String returner = "";
	static int n = 0;
	static boolean outputer = false;
	static <T> String toString(T[] array) {
		if(array.length == 0) {
			return "[]";
		} else {
		 	String output = stringWrapper(helperToString(array), '[', ']');
			returner = "";
			n = 0;
			return output;
		}
	}

	static String stringWrapper(String s, Character c1, Character c2) {
		return c1 + s + c2;
	}

	static <T> String helperToString(T[] array) {
		if(n < array.length - 1){
			n++;
			returner += array[n - 1] + ", " + helperToString(array);
		} else {
			returner += array[n];
		}
		return returner;
	}

	/**
	 * Gib zurück, ob ein Objekt in dem Array enthalten ist; verwendet `equals`
	 */
	static <T> boolean contains(T[] array, T object) {
		if(array.length == 0) {
			return false;
		} else {
			boolean output = helperContains(array, object);
			outputer = false;
			n = 0;
			return output;
		}
	}

	static <T> boolean helperContains(T[] array, T object) {
		if(n < array.length) {
			if((array[n].equals(object)) == true) {
				outputer = true;
			} else {
				n++;
				helperContains(array, object);
			}
			return outputer;
		}
		return outputer;
	}
}
