
public abstract class Movie {

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case 0:
                _price = new RegularPrice();
                break;
            case 1:
                _price = new NewReleasePrice();
                break;
            case 2:
                _price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int _daysRented) {
        return _price.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints(int _daysRented) {
        return _price.getFrequentRenterPoints(_daysRented);
    }
}
