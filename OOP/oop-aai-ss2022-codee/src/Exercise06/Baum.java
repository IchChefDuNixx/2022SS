import java.util.Stack;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Baum<T extends Comparable<T>> {
	private class Element {
		T value;
		Element left, right;

		Element(T value) {
			this.value = value;
		}

		String elementToString() {
			return value.toString();
		}
	}

	private Element root;
	private Element tempRoot;
	private int compared = 0;
	private boolean isContained = false;
	private List<T> stringList = new LinkedList<>();

	/**
	 * Fügt ein Element in den Baum ein.
	 */
	void add(T value) {
		if (root == null) {
			root = new Element(value);
			return;
		}

		Element it = root;
		while (it != null) {
			int c = value.compareTo(it.value);

			if (c == 0)
				return;
			else if (c < 0) {
				if (it.left == null) {
					it.left = new Element(value);
					return;
				} else {
					it = it.left;
				}
			} else {
				if (it.right == null) {
					it.right = new Element(value);
					return;
				} else {
					it = it.right;
				}
			}
		}
	}

	/**
	 * Wie `add`, aber rekursiv zu implementieren.
	 */
	void addRek(T value) {
		if (root == null) {
			root = new Element(value);
			tempRoot = root;
			return;
		}

		compared = value.compareTo(tempRoot.value);
		if (compared == 0) {
			return;
		} else if (compared < 0) { // value smaller -> left
			if (tempRoot.left == null) { // left slot available
				tempRoot.left = new Element(value);
				tempRoot = root;
			} else {
				tempRoot = tempRoot.left;
				addRek(value);
			}
		} else { // value greater -> right
			if (tempRoot.right == null) { // right slot available
				tempRoot.right = new Element(value);
				tempRoot = root;
			} else {
				tempRoot = tempRoot.right;
				addRek(value);
			}
		}
	}

	/**
	 * Gibt `true` zurück, wenn der Wert `value` im Baum enthalten ist.
	 */
	boolean contains(T value) {
		if (root == null)
			return false;

		Element it = root;
		while (it != null) {
			int c = value.compareTo(it.value);
			if (c == 0)
				return true;
			else if (c < 0)
				it = it.left;
			else
				it = it.right;
		}

		return false;
	}

	/**
	 * Wie `contains`, aber rekursiv zu implementieren.
	 */
	boolean containsRek(T value) {
		// System.out.println("the way of " + value);
		helperContainsRek(value);
		tempRoot = root;
		boolean output = isContained;
		isContained = false;
		return output;
	}

	void helperContainsRek(T value) {
		// System.out.println("current isContained: " + isContained);
		if (root == null) {
			isContained = false;
			return;
		}

		compared = value.compareTo(tempRoot.value);
		// System.out.println("compared is " + compared);

		if (tempRoot.left == null && tempRoot.right == null) {
			if (compared == 0) {
				// System.out.println("expected");
				isContained = true;
				return;
			} else {
				// System.out.println("not expected");
				isContained = false;
				return;
			}
		}

		if (compared == 0) {
			tempRoot = root;
			isContained = true;
			// System.out.println("expected");
			return;
		} else if (compared < 0 && tempRoot.left != null) { // value smaller -> left
			tempRoot = tempRoot.left;
			helperContainsRek(value);
		} else if (compared > 0 && tempRoot.right != null) { // value greater -> right
			tempRoot = tempRoot.right;
			helperContainsRek(value);
		} else {
			return;
		}
	}

	/**
	 * Gibt eine Stringrepraesentation des Baums zurück, wobei das Format
	 * eine aufsteigende sortierte Liste darstellt, z.B. [] oder [2, 3, 4].
	 * Abstrakt betrachtet ist dies die sog. Infixschreibweise, bei der fuer
	 * ein Element zuerst der linke Teilbaum, dann der Wert, dann der rechte
	 * Tb. ausgegeben wird.
	 */
	public String toString() {
		Stack<Element> agenda = new Stack<>();

		// Tiefenabstieg nach links
		Element it = root;
		while (it != null) {
			agenda.push(it);
			it = it.left;
		}

		StringBuilder sb = new StringBuilder();

		while (!agenda.empty()) {
			Element e = agenda.pop();
			sb.append(e.value);

			// Tiefenabstieg nach links
			it = e.right;
			while (it != null) {
				agenda.push(it);
				it = it.left;
			}

			if (agenda.size() > 0)
				sb.append(", ");
		}

		return "[" + sb.toString() + "]";
	}

	/**
	 * Zusatzaufgabe: Wie `toString`, nur rekursiv zu implementieren.
	 */
	String toStringRek() {
		if (root == null) {
			return "[]";
		} else {
			helperToString(root);
		}
		List<T> outList = new LinkedList<>(stringList);
		stringList.clear();
		Collections.sort(outList);
		return outList.toString();
	}

	void helperToString(Element current) {
		if (current.left != null && current.right != null) {
			stringList.add(current.value);
			helperToString(current.left);
			helperToString(current.right);
		} else if (current.left == null && current.right != null) {
			stringList.add(current.value);
			helperToString(current.right);
		} else if (current.left != null && current.right == null) {
			stringList.add(current.value);
			helperToString(current.left);
		} else { // both == null
			stringList.add(current.value);
		}
	}
}
