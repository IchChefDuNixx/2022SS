
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    /*
     * StackInterface<Integer> stack1 = new StackImplementation<>();
     * 
     * System.out.println(stack1.size());
     * 
     * stack1.push(0);
     * stack1.push(1);
     * stack1.push(5);
     * stack1.push(3646);
     * stack1.push(3);
     * stack1.push(8);
     * 
     * System.out.println(stack1.size() + "\n" +
     * stack1.contains(1) + "\n" +
     * stack1.contains(2) + "\n" +
     * stack1.contains(3) + "\n" +
     * stack1.contains(4) + "\n" +
     * stack1.contains(5));
     * 
     * // stack1.pop();
     * // stack1.pop();
     * 
     * System.out.println(stack1.size() + "\n --- ");
     * 
     * Iterator<Integer> iter = stack1.iterator();
     * while (iter.hasNext() == true) {
     * System.out.println(iter.next());
     * }
     */

    /*
     * SetInterface<Integer> set1 = new SetImplementation<>();
     * 
     * System.out.println(set1.size());
     * 
     * System.out.println("to add: 68953");
     * System.out.println(set1.add(68953));
     * System.out.println("to add: 586");
     * System.out.println(set1.add(586));
     * System.out.println("to add: 8659");
     * System.out.println(set1.add(8659));
     * 
     * System.out.println(set1.add(6));
     * System.out.println(set1.add(6359));
     * System.out.println(set1.add(658));
     * 
     * 
     * System.out.println(set1.size() + "\n" +
     * set1.contains(857) + "\n" +
     * set1.contains(685) + "\n" +
     * set1.contains(6) + "\n" +
     * set1.contains(658));
     * 
     * set1.remove(6359);
     * set1.remove(10);
     * set1.remove(6);
     * 
     * System.out.println(set1.size() + "\n --- ");
     * 
     * Iterator<Integer> setIter = set1.iterator();
     */

    Set<String> impl = new SetImpl<>();
    String str = "In Ulm und um Ulm und um Ulm herum";

    for (String c : str.split(" ")) {
      impl.add(c);
    }

    System.out.println(impl);

    // sollte sein: In Ulm und um herum
    System.out.println(impl.size());

    // Elemente testen
    System.out.println(impl.contains("In"));
    System.out.println(impl.contains("Ulm"));
    System.out.println(impl.contains(""));
    System.out.println(impl.contains("Hans"));

    Iterator<String> iter = impl.iterator();

    while (iter.hasNext() == true) {
      iter.next();
    }

    // Elemente besuchen...
    /*
     * int count = 0;
     * for (String s : impl) {
     * // jedes muss drin sein, lol
     * System.out.println(s);
     * System.out.println(impl.contains(s));
     * count++;
     * }
     */

    // ...und es muessen genau 5 gewesen sein
    // System.out.println(count);
  }
}
