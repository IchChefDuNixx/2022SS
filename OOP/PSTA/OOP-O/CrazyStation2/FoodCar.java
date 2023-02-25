package CrazyStation2;

public class FoodCar extends Car{

    FoodCar (int carID, Station station, Station target){
        super (carID, station, target, 1);
        this.emoji = "\ud83d\ude83";
    }

}
