package BetterEx04;

import java.util.Iterator;

public class SetImplementation<T extends Comparable<T>> implements SetInterface<T> {

  public Iterator<T> iterator() {
    Iterator<T> iter = new Iterator<>() {
      private SetElement iterElement = root;

      StackInterface<T> iterStack = new StackImplementation<>();

      public boolean hasNext() {
        if (iterElement.getRight() != null || iterElement.getLeft() != null) {
          return true;
        } else {
          return false;
        }
      }

      public T next() {
        return iterElement.getRight().getValue();
      }

      public void remove() {

      }
    };
    return iter;
  }

  public class SetElement {
    private T value;
    private SetElement right;
    private SetElement left;

    public SetElement(T inputValue) {
      this.value = inputValue;
      this.right = null;
      this.left = null;
    }

    public T getValue() {
      return value;
    }

    public SetElement getRight() {
      return right;
    }

    public SetElement getLeft() {
      return left;
    }

    public void setRight(T inputValue) {
      this.right = new SetElement(inputValue);
    }

    public void setRight(SetElement inputElement) {
      this.right = inputElement;
    }

    public void setLeft(T inputValue) {
      this.left = new SetElement(inputValue);
    }

    public void setLeft(SetElement inputElement) {
      this.left = inputElement;
    }

    public void removeRight() {
      this.right = null;
    }

    public void removeLeft() {
      this.left = null;
    }

    public int size() {
      return 1
          + (left == null ? 0 : left.size())
          + (right == null ? 0 : right.size());
    }

    public String toString() {
      return value.toString();
    }
  }

  SetElement root;
  SetElement tempRoot;

  public boolean add(T element) {
    int i = 0;
    tempRoot = root;
    if (root == null) {
      System.out.println(" 0 ");
      root = new SetElement(element);
      return true;
    } else {
      System.out.println(tempRoot.toString());
      while (i < 10) { // add null cases!
        i++;
        System.out.println(root);
        if (root.getRight() != null && root.getLeft() != null) {
          System.out.println(" ! ");
          if (tempRoot.getRight().getValue().equals(element) || tempRoot.getLeft().getValue().equals(element)) {
            return false;
          } else if (element.compareTo(tempRoot.getValue()) > 0) {
            tempRoot = tempRoot.getRight();
          } else {
            tempRoot = tempRoot.getLeft();
          }
        } else if (tempRoot.getRight() != null && tempRoot.getLeft() == null) {
          System.out.println(" ! ");
          if (tempRoot.getRight().getValue().compareTo(element) == 0) {
            return false;
          } else if (tempRoot.getRight().getValue().compareTo(element) > 0) {
            tempRoot = tempRoot.getLeft();
          }
        } else if (tempRoot.getRight() == null && tempRoot.getLeft() != null) {
          System.out.println(" ! ");
          if (tempRoot.getLeft().getValue().compareTo(element) == 0) {
            return false;
          } else if (tempRoot.getLeft().getValue().compareTo(element) < 0) {
            tempRoot = tempRoot.getRight();
          }
        }
      }
      System.out.println(" ? ");
      if (element.compareTo(tempRoot.getValue()) > 0) {
        System.out.println(" right ");
        System.out.println(tempRoot.getRight().toString());
        tempRoot.setRight(element);
        System.out.println(tempRoot.getRight().toString());
        return true;
      } else if (element.compareTo(tempRoot.getValue()) < 0) {
        System.out.println(" left ");
        System.out.println(tempRoot.getLeft() == null);
        tempRoot.setLeft(element);
        System.out.println(tempRoot.getLeft() == null);
        System.out.println(" ^ ");
        return true;
      } else {
        System.out.println(" wrong ");
        return false;
      }
    }
  }

  public boolean remove(T element) {
    tempRoot = root;
    T tempLeft = null;
    T tempRight = null;
    if (this.contains(element) == false) {
      return false;
    } else if (tempRoot.getValue().equals(element) == true) {
      return false;
      // remove root
    } else {
      while (tempRoot != null) {
        if (tempRoot.getValue().compareTo(element) > 0) {
          if (tempRoot.getLeft() != null && tempRoot.getLeft().getValue().equals(element)) {
            // return removeElement(it, it.left);
            tempLeft = tempRoot.getLeft().getLeft().getValue();
            tempRight = tempRoot.getLeft().getRight().getValue();
            tempRoot.removeLeft();
            add(tempLeft);
            add(tempRight);
            return true;
          }
          // tempRoot = tempRoot.getLeft();
        } else {
          if (tempRoot.getRight() != null && tempRoot.getRight().getValue().equals(element)) {
            // return removeElement(it, it.right);
            tempLeft = tempRoot.getRight().getLeft().getValue();
            tempRight = tempRoot.getRight().getRight().getValue();
            tempRoot.removeRight();
            add(tempLeft);
            add(tempRight);
            return true;
          }
          // tempRoot = tempRoot.getRight();
        }
      }
    }
    return false;
  }

  public boolean contains(T element) {
    tempRoot = root;
    if (tempRoot == null) {
      return false;
    } else {
      while (tempRoot != null) {
        int check = element.compareTo(tempRoot.getValue());
        if (check == 0) {
          return true;
        } else if (check < 0) {
          tempRoot = tempRoot.getLeft();
        } else {
          tempRoot = tempRoot.getRight();
        }
      }
    }
    return false;
  }

  public int size() {
    tempRoot = root;
    if (tempRoot == null) {
      return 0;
    } else {
      return tempRoot.size();
    }
  }

  public String toString() {
    if (root == null) {
      return "[]";
    } else {
      return "[" + root.toString() + "]";
    }
  }
}
