import java.util.NoSuchElementException;

public class CharStackImpl implements CharStack {

  CharStackElement root;
  CharStackElement tempRoot = root;

  public CharStackImpl() {

  }

  public void push(char c) {
    tempRoot = root;
    if (root == null) {
      root = new CharStackElement(c);
    } else {
      while (tempRoot.getNextElement() != null) {
        tempRoot = tempRoot.getNextElement();
      }
      tempRoot.setNextElement(new CharStackElement(c));
    }
  }

  public char pop() {
    tempRoot = root;
    if (root == null) {
      throw new NoSuchElementException();
    } else {
      while (tempRoot.getNextElement().getNextElement() != null) {
        tempRoot = tempRoot.getNextElement();
      }
      char tempChar = tempRoot.getNextElement().getChar();
      System.out.println("popped '" + tempChar + "'.");
      tempRoot.setNextElement(null);
      return tempChar;
    }
  }

  public int size() {
    tempRoot = root;
    int sizeCounter = 1;
    if (root == null) {
      return 0;
    } else {
      while (tempRoot.getNextElement() != null) {
        tempRoot = tempRoot.getNextElement();
        sizeCounter++;
      }
      return sizeCounter;
    }
  }
}
