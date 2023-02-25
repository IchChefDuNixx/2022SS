package CrazyStation2;

import java.util.LinkedList;

public abstract class Train {
    private Station station;
    private CentralStation central;
    private int carNumber; // size of the attachable cars
    private LinkedList<Car> cars = new LinkedList<Car>();
    public String emoji;
    private int car_amount;


    public Train (){}

    public Train (Station station, CentralStation central, int carNumber){
        this.central = central;
        this.station = station;
        this.carNumber = carNumber;
        //this.cars = new Car[1];
    }

    public Station getStation (){
        return station;
    }

    public CentralStation getCentral () {
        return central;
    }

    public int getCarNumber () {return carNumber;}

    public int getCar_amount() {
        return cars.size();
    }

    public boolean addCar (Car c){
        cars.add(c);
        return true;
    }

    public Car removeCar (){
        Car car = this.cars.pop();
        return car;
    }

    public boolean maxCarAttached (){
        int len = cars.size();
        if (carNumber == len){
            return true;
        }
        return false;
    }

    public String toString(){
        String name = this.station.getName();
        String out = this.emoji + "(" + name + ")" + "[";
        int carsprinted = 0;
        for(Car c : cars){
            out += "-" + c.emoji;
            carsprinted++;
        }
        for(int i = carsprinted; i < carNumber; i++){
            out += "-_-";
        }
        return out + "]";

    }
}
