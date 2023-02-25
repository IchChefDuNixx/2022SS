public class StackMain {
  public static void main(String[] args) {
    StackImpl<Integer> intStack = new StackImpl<Integer>();
    System.out.println(intStack.size());
    intStack.push(1);
    intStack.push(1);
    intStack.push(1);
    System.out.println(intStack.findDuplicates());
    intStack.pop();
    System.out.println(intStack.findDuplicates());
  }
}
