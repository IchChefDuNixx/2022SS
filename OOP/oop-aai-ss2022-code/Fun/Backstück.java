import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public abstract class Backstück {
  Map<Zutat, Integer> ZutatenListe = new TreeMap<>();
  String typ;
  String name;

  public Backstück(String name, String typ) {
    this.typ = typ;
    this.name = name;
  }

  public void addZutat(Zutat zutat, int menge) {
    ZutatenListe.put(zutat, menge);
  }

  public double getPrice() {
    double price = 0;
    if (typ == "Kuchen") {
      for (Entry<Zutat, Integer> entry : ZutatenListe.entrySet()) {
        price += entry.getKey().preisProKilo * entry.getValue() * 1.25;
      }
    } else if (typ == "Brot") {
      for (Entry<Zutat, Integer> entry : ZutatenListe.entrySet()) {
        price += entry.getKey().preisProKilo * entry.getValue() * 1.22;
      }
    }
    return price * 1.19;
  }

  public class Zutat {
    String name;
    double preisProKilo;

    public Zutat(String name, double price) {
      this.name = name;
      this.preisProKilo = price;
    }
  }
}
