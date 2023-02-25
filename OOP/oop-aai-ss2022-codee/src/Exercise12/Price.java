public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int _daysRented);

    abstract int getFrequentRenterPoints(int _daysRented);
}