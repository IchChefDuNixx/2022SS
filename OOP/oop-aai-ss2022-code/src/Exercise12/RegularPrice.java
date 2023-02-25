public class RegularPrice extends Price {

    @Override
    int getPriceCode() {
        return 0;
    }

    @Override
    double getCharge(int _daysRented) {
        double result = 0;
        result += 2;
        if (_daysRented >= 3) {
            result += (_daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int _daysRented) {
        return 1;
    }

}