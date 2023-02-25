import java.util.Arrays;

public class Stack {

  public static int size(char[] charArray) {
    return charArray.length;
  }

  public static void push(char[] charArray, char c) {
    char[] tempCharArray = new char[size(charArray)+1];
    for(int i = 0; i < size(charArray); i++) {
      tempCharArray[i] = charArray[i];
    }
    tempCharArray[size(charArray)] = c;
    charArray = tempCharArray;
  }

  public static char pop(char[] charArray) {
    char returner = charArray[size(charArray)-1];
    char[] tempCharArray = new char[size(charArray)-1];
    for(int i = 0; i < size(charArray)-1; i++) {
      tempCharArray[i] = charArray[i];
    }
    charArray = tempCharArray;
    return returner;
  }

  public static void print(char[] charArray) {
    System.out.println(charArray);
  }

  public static void main(String[] args) {
    char[] charArray = new char[] {'a', 'b', 'x', 'y'};
    print(charArray);

    push(charArray, 'g');
    print(charArray);

    pop(charArray);
    print(charArray);

    size(charArray);
    print(charArray);
  }
}
