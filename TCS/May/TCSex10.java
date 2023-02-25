import java.util.Stack;

public class TCSex10 {
  public static int pred(int m) {
    if(m == 0) {
      return 0;
    } else {
      return m - 1;
    }
  }
  public static int sub(int m, int n) {
    if(n == 0) {
      return m;
    } else if(m == 0) {
      return 0;
    } else {
      return sub(m-1, n-1);
    }
  }
  public static int mult(int m, int n) {
    if(n == 0) {
      return 0;
    } else {
      return mult(m, n-1) + m;
    }
  }
  public static int exp(int m, int n) {
    if(n == 0) {
      return 1;
    } else {
      return mult(exp(m, n-1), m);
    }
  }
  public static int fac(int n) {
    if(n == 0) {
      return 1;
    } else {
      return mult(fac(n-1),n);
    }
  }
  public static int ack(int x, int y) {
    if(x == 0) {
      return y + 1;
    } else if(y == 0) {
      return ack(x - 1, 1);
    } else {
      return ack(x - 1, ack(x, y- 1));
    }
  }
  public static int ackIter(int x, int y) {
    Stack<Integer> ackStack = new Stack<>();
    ackStack.push(x);
    ackStack.push(y);
    while(ackStack.size() > 1) {
      System.out.println(ackStack);
      y = ackStack.pop();
      x = ackStack.pop();

      if(x == 0) {
        ackStack.push(y + 1);

      } else if(x == 1 && y == 0) {
        ackStack.push(2);

      } else if(y == 0) {
        ackStack.push(x - 1);
        ackStack.push(1);

      } else if(x == 1 && y == 1) {
        ackStack.push(3);

      } else {
        ackStack.push(x - 1);
        ackStack.push(x);
        ackStack.push(y - 1);
      }
    }
    return ackStack.pop();
  }
  public static void main(String[] args) {
    System.out.println("pred: " + pred(10));
    System.out.println("sub: " + sub(8, 27));
    System.out.println("mult: " + mult(3, 3));
    System.out.println("exp: " + exp(2, 4));
    System.out.println("fac: " + fac(5));
    System.out.println("ack: " + ack(2, 3));
    System.out.println("ackiter: " + ackIter(1,1));
  }
}
