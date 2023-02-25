public class Element<T extends Comparable<?>> implements Comparable<Element<T>> {
  T val;
  Element<T> left, right;
  Element(T v, Element<T> l, Element<T> r) {
    val = v;
    left = l;
    right = r;
  }
  int size() {
    return 1
        + (left == null ? 0 : left.size())
        + (right == null ? 0 : right.size());
  }
  public String toString() {
    return val
      + (left == null ? "" : ", " + left)
      + (right == null ? "" : ", " + right);
  }
  @Override
  public int compareTo(Element<T> t) {
    return 1;
  }
}
