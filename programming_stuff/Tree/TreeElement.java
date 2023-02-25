public class TreeElement {

  private char c;
  private TreeElement left;
  private TreeElement right;

  public TreeElement(char c) {
    this.c = c;
    this.left = null;
    this.right = null;
  }

  public char getChar() {
    return this.c;
  }

  public char getLeftChar() {
    return left.getChar();
  }

  public char getRightChar() {
    return right.getChar();
  }

  public TreeElement getLeft() {
    return this.left;
  }

  public TreeElement getRight() {
    return this.right;
  }

  public void setChar(char c) {
    this.c = c;
  }

  public void setLeft(TreeElement left) {
    this.left = left;
  }

  public void setRight(TreeElement right) {
    this.right = right;
  }
}
