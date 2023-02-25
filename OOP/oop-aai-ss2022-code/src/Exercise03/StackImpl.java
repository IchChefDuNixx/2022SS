import java.util.NoSuchElementException;

public class StackImpl<T> implements Stack<T> {

	private StackElement<T> top;

	@Override
	public void push(T c) {
		top = new StackElement<T>(c, top);
	}

	@Override
	public T pop() {
		if (top == null)
			throw new NoSuchElementException();
		T v = top.value;
		top = top.next;
		return v;
	}

	@Override
	public int size() {
		int n = 0;
		StackElement<T> it = top;
		while (it != null) {
			n++;
			it = it.next;
		}
		return n;
	}

	@Override
	public boolean contains(T input) {
		StackElement<T> tempTop = top;
		for(int i = 0; i < size(); i++) {
			if(tempTop.value == input) {
				return true;
			} else {
				tempTop = tempTop.next;
			}
		}
		return false;
	}

	@Override
	public StackImpl<T> findDuplicates() {
		StackImpl<T> returnStack = new StackImpl<T>();
		for(int i = 0; i < size(); i++) {
			for(int j = i+1; j < size(); j++) {
				if(objectAtIndex(i).equals(objectAtIndex(j))) {
					returnStack.push(objectAtIndex(i));
				}
			}
		}
		return returnStack;
	}

	@Override
	public T objectAtIndex(int index) {
		StackElement<T> tempTop = top;
		for(int i = 0; i < index; i++) {
			tempTop = tempTop.next;
		}
		return tempTop.value;
	}

	@Override
	public String toString() {
		if (top == null) {
			return "[]";
		} else {
			return "[" + top.toString() + "]";
		}
	}
}
