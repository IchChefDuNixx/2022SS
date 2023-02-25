package CrazyStation2;

public class MaterialCar extends Car{

    MaterialCar (int carID, Station station, Station target){
        super (carID, station, target, 3);
        this.emoji = "\ud83d\ude8b";
    }
}
