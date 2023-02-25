import java.util.ArrayList;

public class CTree<T> {
  public class CTreeElement<T> {
    ArrayList<CTreeElement<T>> next;
    T value;
    String s;

    public String toString() {
      String s = "";
      return helperToString(s);
    }

    public String helperToString(String s) {
      if (next.size() == 0) {
        s += value.toString();
      }
      for (CTreeElement<T> element : next) {
        element.helperToString();
      }
      return s;
    }
  }

}
