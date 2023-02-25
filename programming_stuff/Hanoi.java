public class Hanoi {
  class Operations {
    static void printMove(int start, int end) {
      if(start == 1 && end == 2) {
        System.out.println(start + "  -> \t" + end);
      } else if(start == 1 && end == 3) {
        System.out.println(start + " ->-> \t" + end);
      } else if(start == 2 && end == 3) {
        System.out.println(start + "  -> \t" + end);
      } else if(start == 3 && end == 2) {
        System.out.println(start + "  <- \t" + end);
      } else if(start == 3 && end == 1) {
        System.out.println(start + " <-<- \t" + end);
      } else if(start == 2 && end == 1) {
        System.out.println(start + "  <- \t" + end);
      }
    }

    static void runHanoi(int n, int start, int end) {
      int other = 0; // other / middle pole
      if(n == 1) {
        printMove(start, end);
      } else {
        other = 6 - start - end;
        runHanoi(n - 1, start, other);
        printMove(start, end);
        runHanoi(n - 1, other, end);
      }
    }
  }
  public static void main(String[] args) {
    Operations.runHanoi(2,1,3);
  }
}
