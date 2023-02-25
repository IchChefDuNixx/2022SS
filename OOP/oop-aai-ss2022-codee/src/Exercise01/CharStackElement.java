
public class CharStackElement {
  private char c;
  private CharStackElement nextElement;

  public CharStackElement(char c) {
    this.c = c;
    this.nextElement = null;
  }

  public char getChar() {
    return this.c;
  }

  public CharStackElement getNextElement() {
    return this.nextElement;
  }

  public void setNextElement(CharStackElement nextElement) {
    this.nextElement = nextElement;
  }
}
