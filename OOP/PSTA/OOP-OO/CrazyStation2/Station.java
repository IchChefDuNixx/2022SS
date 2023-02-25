package CrazyStation2;

import java.util.LinkedList;
import java.util.ArrayList;

public class Station {

    private LinkedList<Train> trains = new LinkedList<Train>();
    private String name;
    private LinkedList<Train> rentals = new LinkedList<Train>();
    private ArrayList<Car> storage = new ArrayList<Car>();

    public Station (String name){
        this.name = name;
        //storage = new ArrayList<>();
        //trains  = new LinkedList<Train>();
    }

    public Station (String name, Train train){
        this.name = name;
        //storage = new ArrayList<>();
        //trains  = new LinkedList<Train>();
        this.trains.add(train);
    }

    public Station (String name, LinkedList<Train> trains){
        this.name = name;
        //storage = new ArrayList<>();
        //trains = new LinkedList<Train>();
        this.trains = trains;
    }

    public void addTrain (Train c) {
        this.trains.add(c);
    }

    // for adding multiple trains at once
    public void addTrains (Train... c){
        for (Train train : c){
            addTrain(train);
        }
    }

    /*public boolean addCar (Car c){
        if (storage[0] == null){
            storage [0] = c;
            return true;
        } else {
            Car[] newArray = new Car[storage.length+1];
            for (int i = 0; i < storage.length; i++ ){
                newArray[i] = storage[i];
            }
            newArray [storage.length] = c;
            storage = newArray;
            return true;
        }
    }*/

    public void addCar (Car c){
        storage.add(c);
    }

    // for adding multiple cars at once
    public void addCars (Car... c){
        for (Car car : c){
            addCar(car);
        }
    }

    /*public Car removeCar (){
        if (storage.length == 0){
            return null;
        }
        Car car = storage[storage.length-1];
        Car[] newArray = new Car[storage.length-1];
        for (int i = 0; i < storage.length-1; i++ ){
            newArray[i] = storage[i];
        }
        storage = newArray;
        return car;
    }*/

    public Car removeCar (){
        if(storage.size() == 0){
            return null;
        }
        Car car = storage.remove(storage.size()-1);
        return car;
    }

    public void loadTrains (){
        Car c = removeCar();
        while (c != null){
            for (Train t: trains) {
                while (c != null) {
                    if (t.addCar(c)) {
                        c = removeCar();
                    } else {
                        break;
                    }
                }
            }
            c = removeCar();
        }
        storage = new ArrayList<>();
    }

    public void unloadTrains () {

        for (Train t: trains){
            //System.out.println(t);
            //System.out.println(t.getCar_amount());
            while (t.getCar_amount() > 0){
                //System.out.println(t);
                Car c = t.removeCar();
                addCar(c);
                //c = t.removeCar();
            }
        }
    }

    public String toString () {
        String s;
        s = name + ":\n";
        if (storage.isEmpty()){
            s += "---";
        } else {
            for (Car c : storage) {
                if(c != null){
                    s += c.toString() + "\n";
                }

            }
        }
        return s;
    }

    public ArrayList<Car> getStorage (){return storage; }

    public void setStorage (ArrayList<Car> sorted){
        storage = sorted;
    }

    public LinkedList<Train> getTrains ()  { return trains; }

    public String getName() { return name; }

    public void setTrains (LinkedList<Train> trains) {this.trains = trains;}

    public void setRentals (LinkedList<Train> rentals) {this.rentals = rentals; }

    public LinkedList<Train> getRentals () {return rentals;}

    public void unloadRentals () {
        if(rentals == null){
            System.out.println("There were no rentals");
            return;
        }
        for (Train t: rentals){
            if(t == null){
                break;
            }
            while (t.getCar_amount() > 0){
                Car c = t.removeCar();
                addCar(c);
            }
        }
    }

    public void prettyprintstation() {

        String steam_emoji = "\ud83d\ude82";
        String electric_emoji = "\ud83d\ude84";
        String freight_emoji = "\ud83d\ude85";
        String food_emoji = "\ud83d\ude83";
        String material_emoji = "\ud83d\ude8b";
        String product_emoji = "\ud83d\ude9d";
        String rental_emoji = "\ud83d\ude87";


        System.out.println("===="+this.name+"====");
        System.out.println("Trains: ");
        for (Train t : trains){
            System.out.println(t);

        }
        if(!storage.isEmpty()){
            System.out.println("Cars in storage");
            for (Car c : storage) {
            /*
            if(c.getClass() == FoodCar.class){
                System.out.println(food_emoji);
            }
            if(c.getClass() == MaterialCar.class){
                System.out.println(material_emoji);
            }
            if(c.getClass() == ProductCar.class){
                System.out.println(product_emoji);
            }
            */
                if(c!=null){
                    System.out.println(c.emoji);
                }

            }
        }

    }
}
