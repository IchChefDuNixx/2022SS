public interface Stack<T> {
	void push(T c);
	T pop();
	int size();
	boolean contains(T input);
	StackImpl<T> findDuplicates();
	T objectAtIndex(int index);
	String toString();
}
