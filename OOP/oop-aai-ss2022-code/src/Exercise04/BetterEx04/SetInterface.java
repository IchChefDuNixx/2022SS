package BetterEx04;

public interface SetInterface<T extends Comparable<T>> extends Iterable<T> {
  boolean add(T element);

  boolean remove(T element);

  boolean contains(T element);

  int size();
}
