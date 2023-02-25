class Liste<T> {
	private class Element {
		T value;
		Element next;

		Element(T value) {
			this.value = value;
		}
	}

	private Element first;
	private Element temp = first;
	private boolean isContained = false;
	private String concat = "";

	/**
	 * Hängt ein Element hinten an die Liste an.
	 */
	void add(T value) {
		if (first == null) {
			first = new Element(value);
			return;
		}

		Element it = first;
		while (it.next != null)
			it = it.next;

		it.next = new Element(value);
		temp = first;
	}

	/**
	 * Wie `add`, aber rekursiv zu implementieren.
	 */
	void addRek(T value) {
		if (value == null) {
			// return;
		} else if (first == null) {
			first = new Element(value);
			temp = first;
			// return;
		} else {
			// main part
			if (temp.next != null) {
				temp = temp.next;
				addRek(value);
			} else {
				temp.next = new Element(value);
				temp = first;
			}
		}
	}

	/**
	 * Gibt `true` zurück, wenn der Wert `value` in der Liste enthalten ist.
	 */
	boolean contains(T value) {
		if (first == null)
			return false;
		Element it = first;

		while (it != null) {
			if (it.value.equals(value))
				return true;
			it = it.next;
		}

		return false;
	}

	/**
	 * Wie `contains`, nur rekursiv zu implementieren.
	 */
	boolean containsRek(T value) {
		System.out.println(temp.value + " - " + value + " (" + temp.value.equals(value) + ")");
		if (value == null) {
			return false;
		} else if (first == null) {
			return false;
		} else if (temp.value.equals(value) == false && temp.next != null) {
			temp = temp.next;
			containsRek(value);
			return isContained;
			// true
		} else if (temp.value.equals(value) == true) {
			temp = first;
			isContained = true;
			return isContained;
			// false
		} else {
			temp = first;
			isContained = false;
			return isContained;
		}
	}

	/**
	 * Gibt eine Stringrepraesentation der Liste zurück, z.B. [] oder [1, 2, 3]
	 */
	public String toString() {
		if (first == null)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append("[").append(first.value);

		Element it = first.next;
		while (it != null) {
			sb.append(", ").append(it.value);
			it = it.next;
		}

		return sb.append("]").toString();
	}

	/**
	 * Zusatzaufgabe: Wie `toString`, nur rekursiv zu implementieren.
	 */
	String toStringRek() {
		if(first == null) {
			return "[]";
		} else {
			helperToStringRek();
			concat += temp.value;
			String output = "[" + concat + "]";
			concat = "";
			return output;
		}
	}

	void helperToStringRek() {
		if (temp.next != null){
			concat += temp.value + ", ";
			temp = temp.next;
			helperToStringRek();
			}
		}
	}
