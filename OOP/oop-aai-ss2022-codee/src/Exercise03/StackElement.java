public class StackElement<T> {
	T value;
	StackElement<T> next;
	StackElement(T c, StackElement<T> n) {
		value = c;
		next = n;
	}
}
