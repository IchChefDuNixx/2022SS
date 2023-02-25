
public class Pair implements Comparable<Pair> {

    private String key;
    private Integer value;

    public Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.value < o.value) {
            return -1;
        } else if (this.value > o.value) {
            return 1;
        } else {
            return -1 * this.key.compareTo(o.key);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value) + " - " + key;
    }
}
