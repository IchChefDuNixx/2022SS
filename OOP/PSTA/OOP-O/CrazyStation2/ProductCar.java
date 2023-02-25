package CrazyStation2;

public class ProductCar extends Car{

    ProductCar (int carID, Station station, Station target){
        super (carID, station, target, 2);
        this.emoji = "\ud83d\ude9d";
    }
}
