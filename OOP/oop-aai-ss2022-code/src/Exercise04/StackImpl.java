
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl<T> implements Stack<T> {

	public class StackIterator<T> implements Iterator<T> {
		Element current;
		Element temp;
		int reverseCounter = 0;

		public StackIterator(int size) {
			current = top;
			reverseCounter = size;
		}

		public boolean hasNext() {
			if (current != null) {
				return true;
			} else {
				return false;
			}
		}

		public T next() {
			temp = current;
			for (int i = 1; i < reverseCounter; i++) {
				temp = temp.next;
			}
			if (reverseCounter >= 1) {
				reverseCounter--;
			} else {
				return null;
			}
			System.out.println(temp.value);
			return (T) temp.value;
		}

		public void remove() {
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator<>(size());
	}

	class Element {
		T value;
		Element next;

		Element(T value, Element next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	private Element top;
	private int s = 0;

	@Override
	public void push(T c) {
		top = new Element(c, top);
		s++;
	}

	@Override
	public T pop() {
		if (top == null)
			throw new NoSuchElementException();
		T v = top.value;
		top = top.next;
		s--;
		return v;
	}

	@Override
	public int size() {
		return s;
	}

}
