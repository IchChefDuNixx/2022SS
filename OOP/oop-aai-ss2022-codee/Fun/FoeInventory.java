import org.simpleflatmapper.csv.CsvParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class FoeInventory {

    public class Item {
        private String name;
        private String description;
        private int amount;

        public Item() {
            this("", "", 0);
        }

        public Item(String name, String description, int amount) {
            this.name = name;
            this.description = description;
            this.amount = amount;
        }

        public String toString() {
            return name + " - " + description + " (" + amount + ")";
        }

        public int compareTo(Item o) {
            return this.amount - o.amount;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(loadData());
    }

    static public List<Item> loadData() throws IOException {
        ClassLoader classLoader = FoeInventory.class.getClassLoader();
        Reader reader = new InputStreamReader(classLoader.getResourceAsStream("./FoeInventory.csv"));
        return CsvParser
                .separator(';')
                .mapTo(Item.class)
                .stream(reader)
                .collect(Collectors.toList());
    }
}
