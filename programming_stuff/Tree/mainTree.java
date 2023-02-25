public class mainTree {

  public static void main(String[] args) {
    System.out.println("--- start ---");

    TreeImplementation binaryTree = new TreeImplementation();
    binaryTree.add('f');
    binaryTree.add('g');
    binaryTree.add('b');
    binaryTree.add('a');
    binaryTree.add('d');
    binaryTree.add('z');
    binaryTree.add('c');
    binaryTree.add('h');
    binaryTree.add('t');
    binaryTree.add('a');
    binaryTree.add('a');
    System.out.println("size: " + binaryTree.size());
    System.out.println(binaryTree.toString());
    binaryTree.remove('g');
    System.out.println(binaryTree.toString());
    System.out.println("--- end ---");
  }
}
