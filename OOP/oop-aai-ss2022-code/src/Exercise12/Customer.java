import java.util.LinkedList;
import java.util.List;

class Customer {

    private String _name;
    private List<Rental> _rentals = new LinkedList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        for (Rental rent : _rentals) {
            result += "\t" + rent.getMovie().getTitle() + "\t" + String.valueOf(rent.getCharge(rent.getDaysRented()))
                    + "\n"; // show
            // figures for
            // this rental
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rent : _rentals) {
            result += rent.getCharge(rent.getDaysRented());
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rent : _rentals) {
            result += rent.getFrequentRenterPoints();
        }
        return result;
    }
}
