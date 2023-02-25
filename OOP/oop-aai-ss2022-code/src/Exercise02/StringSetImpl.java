public class StringSetImpl implements StringSet {

  private SetElement root;
  private SetElement tempRoot;

  public StringSetImpl() {

  }

  class SetElement {
    private String value;
    private SetElement next;

    SetElement(String value, SetElement next) {
      this.value = value;
      this.next = next;
    }

    public String getValue() {
      return value;
    }

    public SetElement getNextElement() {
      return next;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public void setNextElement(SetElement next) {
      this.next = next;
    }
  }

  public boolean add(String value) {
    if(root == null) {
      root = new SetElement(value, null);
      return true;
    } else if(contains(value) == true) {
      return false;
    } else {
      tempRoot = root;
      while(tempRoot.getNextElement() != null) {
          tempRoot = tempRoot.getNextElement();
      }
      tempRoot.setNextElement(new SetElement(value, null));
      return true;
    }
  }

  public boolean contains(String value) {
    tempRoot = root;
    if(root == null) {
      return false;
    } else if(tempRoot.getNextElement() == null) {
      if(tempRoot.getValue().equals(value)) {
        return true;
      } else {
        return false;
      }
    } else {
      while(tempRoot.getNextElement() != null) {
        if(tempRoot.getValue().equals(value)) {
          return true;
        } else {
          tempRoot = tempRoot.getNextElement();
        }
      }
      if(tempRoot.getValue().equals(value)) {
        return true;
      }
    }
    return false;
  }

  public String remove(String value) {
    if(contains(value) == false) {
      System.out.println("NoSuchElementException()");
      return "";
    } else {
      tempRoot = root;
      do {
        if(tempRoot.getNextElement().getValue().equals(value)) {
          String returner = tempRoot.getNextElement().getValue();
          if(tempRoot.getNextElement().getNextElement() != null) {
            tempRoot.setNextElement(tempRoot.getNextElement().getNextElement());
          } else {
            tempRoot.setNextElement(null);
          }
          return returner;
        } else {
          tempRoot = tempRoot.getNextElement();
        }
      } while(tempRoot.getNextElement() != null);
    }
    return "something's wrong";
  }

  public int size() {
    tempRoot = root;
    if(root == null) {
      return 0;
    } else if(tempRoot.getNextElement() == null) {
      return 1;
    } else {
      int i = 1;
      while(tempRoot.getNextElement() != null) {
        i++;
        tempRoot = tempRoot.getNextElement();
      }
      tempRoot = root;
      return i;
    }
  }

  public String toString() {
    String returner = "";
    tempRoot = root;
    if(size() == 0) {
      return "";
    } else if(size() == 1) {
      return tempRoot.getValue();
    } else {
      while(tempRoot.getNextElement() != null) {
        if(returner.equals("")) {
          returner = tempRoot.getValue();
          tempRoot = tempRoot.getNextElement();
        } else {
          returner = returner + " - " + tempRoot.getValue();
          tempRoot = tempRoot.getNextElement();
        }
      }
      return returner += " - " + tempRoot.getValue();
    }
  }
}
