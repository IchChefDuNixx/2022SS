
public class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return 2;
    }

    @Override
    double getCharge(int _daysRented) {
        double result = 1.5;
        if (_daysRented >= 4) {
            result += (_daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int _daysRented) {
        return 1;
    }

}