public class TreeImplementation implements TreeInterface {

  private TreeElement root;
  private TreeElement tempRoot = root;

  public TreeImplementation() {
      root = null;
  }

  public void add(char c) {
    if(contains(c) == true) {
      System.out.println("character already contained in storage.");
      return;
    }
    if(root == null) {
      System.out.println("root is null. creating new root with value '" + c + "'.");
      root = new TreeElement(c);
      tempRoot = root;
    } else {
      if(c < tempRoot.getChar()) {
        if(tempRoot.getLeft() == null) {
          tempRoot.setLeft(new TreeElement(c));
          System.out.println("created new leaf with value '" + c + "'.");
          return;
        } else {
          tempRoot = tempRoot.getLeft();
          System.out.println("recursive loop");
          add(c);
          return;
        }
      } else {
        if(tempRoot.getRight() == null) {
          tempRoot.setRight(new TreeElement(c));
          System.out.println("created new leaf with value '" + c + "'.");
        } else {
          tempRoot = tempRoot.getRight();
          System.out.println("recursive loop");
          add(c);
          return;
        }
      }
    }
  }

  public void remove(char c) {
    if(root == null) {
      return;
    }
    if(root.getChar() == c) {
      if(root.getLeft() != null && root.getRight() != null) {         //YES YES
        tempRoot = root.getRight();
        root = root.getLeft();
        String tempString = tempRoot.toString();
        tempString.replaceAll(" ","");
        char[] charArray = new char[tempString.length()];
        for(int i = 0; i < tempString.length(); i++) {
          this.add(charArray[i]);
        }
        return;
      } else if(root.getLeft() != null && root.getRight() == null) {  //YES NO
        root = root.getLeft();
        return;
      } else if(root.getLeft() == null && root.getRight() != null) {  //NO YES
        root = root.getRight();
        return;
      } else if(root.getLeft() == null && root.getRight() == null) {  //NO NO
        root = null;
        return;
      }
      System.out.println("unexpected result!");
      return;
    }
    if(c < root.getChar() && tempRoot.getLeft() != null) {
      tempRoot = tempRoot.getLeft();
      System.out.println("switched to left branch");
      if(tempRoot.getChar() == c) {
        return;
      } else {
        remove(c);
      }
    }
    if(c > root.getChar() && tempRoot.getRight() != null) {
      tempRoot = tempRoot.getRight();
      System.out.println("switched to right branch");
      if(tempRoot.getChar() == c) {
        return;
      } else {
        remove(c);
      }
    }
    return;
  }

  public boolean contains(char c) {
    if(root == null) {
      return false;
    }
    if(root.getChar() == c) {
      return true;
    }
    if(c < root.getChar() && tempRoot.getLeft() != null) {
      tempRoot = tempRoot.getLeft();
      System.out.println("switched to left branch");
      if(tempRoot.getChar() == c) {
        return true;
      } else {
        contains(c);
      }
    }
    if(c > root.getChar() && tempRoot.getRight() != null) {
      tempRoot = tempRoot.getRight();
      System.out.println("switched to right branch");
      if(tempRoot.getChar() == c) {
        return true;
      } else {
        contains(c);
      }
    }
    return false;
  }

  public int size() {
    return 42;
  }

  public String toString() {
    return toString(root);
  }

  private static String toString(TreeElement e) {
    if(e == null) {
      return "";
    } else {
      return e.getChar() + " " + toString(e.getLeft()) + " " + toString(e.getRight());
    }
  }
}
