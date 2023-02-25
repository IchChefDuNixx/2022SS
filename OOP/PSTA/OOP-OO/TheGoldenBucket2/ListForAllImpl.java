package TheGoldenBucket2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListForAllImpl<T extends Comparable<T>> implements ListForAll<T> {

    private ListForAllImpl<T>.ListElement first;

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            ListForAllImpl<T>.ListElement current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T h = current.value;
                current = current.next;
                return h;
            }
        };
    }

    public class ListElement {
        T value;
        ListForAllImpl<T>.ListElement next;

        ListElement(T current, ListForAllImpl<T>.ListElement next) {
            this.next = next;
            this.value = current;
        }

        public String toString() {
            if (next != null) {
                return ">" + value.toString() + " | " + next.toString() + "<";
            } else {
                return ">" + value.toString() + " | " + "null" + "<";
            }
        }
    }

    public boolean add(T inputValue) {
        ListForAllImpl<T>.ListElement e = new ListElement(inputValue, null);

        if (first == null) {
            first = e;
            return true;
        }

        ListForAllImpl<T>.ListElement current = first;

        while (current.next != null) {
            if (current.value.equals(inputValue)) {
                return false;
            } else {
                current = current.next;
            }
        }
        current.next = e;
        return true;
    }

    public boolean contains(T checkedValue) {
        if (first == null) {
            return false;
        }

        ListForAllImpl<T>.ListElement current = first;

        while (current.next != null) {
            if (current.value.equals(checkedValue)) {
                return true;
            } else {
                current = current.next;
            }
        }
        if (current.value.equals(checkedValue)) {
            return true;
        }
        return false;
    }

    public boolean remove(T f) {

        if (first == null) {
            return false;
        }

        if (first.value.equals(f)) {
            first = first.next;
            return true;
        }

        ListForAllImpl<T>.ListElement current = first;

        while (current.next != null) {
            if (current.next.value.compareTo(f) == 0) {
                current.next = current.next.next;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public int size() {
        int i = 1;

        ListForAllImpl<T>.ListElement current = first;

        if (current == null) {
            return 0;
        }

        while (current.next != null) {
            i++;
            current = current.next;

        }
        return i++;
    }

    public ListForAllImpl<T>.ListElement getFirst() {
        return first;
    }

    public T get_at_index(int index){
        if (index > size()){
            return null;
        }
        int i = 1;

        ListForAllImpl<T>.ListElement current = first;

        while (i != index) {
            i++;
            current = current.next;
        }
        return current.value;
    }

}
