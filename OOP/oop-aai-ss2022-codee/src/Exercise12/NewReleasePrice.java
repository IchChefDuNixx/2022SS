
public class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return 1;
    }

    @Override
    double getCharge(int _daysRented) {
        return _daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int _daysRented) {
        if (_daysRented >= 2) {
            return 2;
        } else {
            return 1;
        }
    }

}