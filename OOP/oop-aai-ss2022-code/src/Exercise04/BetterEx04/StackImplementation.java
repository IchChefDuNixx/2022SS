package BetterEx04;

import java.util.Iterator;

public class StackImplementation<T extends Comparable<T>> implements StackInterface<T> {

  /*
   * public Iterator<T> iterator() {
   * Iterator<T> iter = new Iterator<>() {
   * private StackElement iterElement = root;
   * 
   * public boolean hasNext() {
   * if (iterElement.getNext() != null) {
   * return true;
   * } else {
   * return false;
   * }
   * }
   * 
   * public T next() {
   * if (iterElement.hasNext() == true) {
   * T returner = iterElement.getNext().getValue();
   * iterElement = iterElement.getNext();
   * return returner;
   * } else {
   * return null;
   * }
   * }
   * 
   * public void remove() {
   * if (iterElement.hasNext() == true) {
   * iterElement.removeNext();
   * }
   * }
   * };
   * return iter;
   * }
   */

  class CustomIterator<T extends Comparable<T>> implements Iterator<T> {
    StackElement previous;
    StackElement current;

    public CustomIterator() {
      previous = null;
      current = root;
    }

    public boolean hasNext() {
      if (current != null) {
        return true;
      } else {
        return false;
      }
    }

    public T next() {
      previous = current;
      T output = (T) current.getValue();
      current = current.getNext();
      return output;
    }

    public void remove() {
      previous.setNext(current.getNext());
      current = previous.getNext();
    }
  }

  public class StackElement {
    private T value;
    private StackElement next;

    public StackElement(T inputValue) {
      this.value = inputValue;
      this.next = null;
    }

    public boolean hasNext() {
      if (this.next != null) {
        return true;
      } else {
        return false;
      }
    }

    public T getValue() {
      return value;
    }

    public StackElement getNext() {
      return next;
    }

    public void setNext(T inputValue) {
      this.next = new StackElement(inputValue);
    }

    public void setNext(StackElement inputElement) {
      this.next = inputElement;
    }

    public void removeNext() {
      this.next = null;
    }

    public String toString() {
      return (value + " -> " + next.toString());
    }
  }

  private StackElement root;
  private StackElement tempRoot;

  public boolean push(T element) {
    tempRoot = root;
    if (tempRoot == null) {
      root = new StackElement(element);
      return true;
    } else {
      while (tempRoot.hasNext() == true) {
        tempRoot = tempRoot.getNext();
      }
      tempRoot.setNext(element);
      return true;
    }
  }

  public boolean pop() {
    tempRoot = root;
    if (tempRoot == null) {
      return false;
    } else {
      while (tempRoot.getNext().getNext() != null) {
        tempRoot = tempRoot.getNext();
      }
      tempRoot.removeNext();
      return true;
    }
  }

  public boolean contains(T element) {
    tempRoot = root;
    if (tempRoot == null) {
      return false;
    } else {
      while (tempRoot.getNext() != null) {
        if (tempRoot.getValue().equals(element)) {
          return true;
        }
        tempRoot = tempRoot.getNext();
      }
      if (tempRoot.getValue().equals(element)) {
        return true;
      } else {
        return false;
      }
    }
  }

  public int size() {
    tempRoot = root;
    int counter = 1;
    if (tempRoot == null) {
      return 0;
    }
    while (tempRoot.getNext() != null) {
      tempRoot = tempRoot.getNext();
      counter++;
    }
    return counter;
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator<>();
  }
}
