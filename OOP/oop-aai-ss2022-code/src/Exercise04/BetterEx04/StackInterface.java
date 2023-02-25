package BetterEx04;

public interface StackInterface<T extends Comparable<T>> extends Iterable<T> {
  boolean push(T element);

  boolean pop();

  boolean contains(T element);

  int size();
}
