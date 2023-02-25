
public class MainCharStack {
  public static void main(String[] args) {
    CharStackImpl charStack = new CharStackImpl();
    charStack.push('a');
    System.out.println(charStack.size());
    charStack.push('f');
    System.out.println(charStack.size());
    charStack.push('g');
    System.out.println(charStack.size());
    charStack.pop();
    System.out.println(charStack.size());
    charStack.pop();
    System.out.println(charStack.size());
    System.out.println(charStack.root.getChar());
  }
}
