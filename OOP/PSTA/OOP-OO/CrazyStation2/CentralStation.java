package CrazyStation2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import javax.management.StringValueExp;
import java.util.*;

public class CentralStation extends Station {

    HashMap<String, ArrayList<Car>> destination_for_cars = new HashMap<String, ArrayList<Car>>();

    public CentralStation (String name){
        super (name);
    }

    public CentralStation (String name, Train train){
        super (name, train);
    }

    public CentralStation (String name, LinkedList<Train> trains){
        super (name, trains);
    }

    public void sortCars (){
        boolean run = true;


        ArrayList<Car> sorted = super.getStorage();
        for (int i = 0; i < sorted.size() && run; i++) {
            run = false;

            for (int y = 0; y < sorted.size()-1; y++) {
                Car c1 = (Car) sorted.get(y);
                Car c2 = (Car) sorted.get(y+1);
                if(c1.compareTo(c2) == 1) { //compareTo compares by the priority, if the priority is the same compares by the carID
                    //swaps the cars
                    Car bigger = (Car) sorted.get(y);
                    Car smaller = (Car) sorted.get(y + 1);
                    sorted.remove(y);
                    sorted.add(y,smaller);
                    sorted.remove(y+1);
                    sorted.add(y+1, bigger);

                    run = true;
                }
            }

        }
        super.setStorage(sorted);
    }

    public void distributeCars (){
        ArrayList<Car> notDistributable = new ArrayList<>();
        while (super.getStorage().size() != 0){
            Car c = super.removeCar();
            for (Train t: super.getTrains()){ //for each train in centralStation check if the target of the car is the same
                if (t.getStation().getName().equals(c.getTarget().getName())){ //if station an target name matches
                    if (t.getCar_amount() < t.getCarNumber() ){ // add the car
                        t.addCar(c);
                        break;
                    }
                    if (!checkdistribution(t.getStation())){
                        if (!notDistributable.contains(c))
                            notDistributable.add(c);
                        }
                    }
                }
            }
        super.setStorage(notDistributable);
    }

    public boolean checkdistribution (Station station){ //checks if any cars ar not distributed
        int count = 0;
        for (Car t: (ArrayList<Car>) super.getStorage()){ // for each car in centralStation Car[]storage
            if (t.getTarget() == station){
                count++; // how many cars have a target which matches to a station
            }
        }
        int distributable = 0;
        for (Train t: super.getTrains()){
            if (t.getStation()==station && !t.maxCarAttached()){
                distributable += t.getCarNumber(); // how many cars can be distributed if they have the same destination and the train still has space left
            }
        }
        boolean returnValue = false;
        returnValue = distributable >= count && distributable != 0 && count != 0; //true if distributable
        return returnValue;
    }

    public void rentTrains (TrainRental trainRental, Station station) {
        int required = 0;
        ArrayList<Car> cars = super.getStorage();
        if (cars.get(0) == null)
            return;
        for (Car c: cars){
            if (c.getTarget() == station) {
                required++;
            }
        }
        //LinkedList<Train> abc = trainRental.lendTrain(required,station,this);
        LinkedList<Train> abc = trainRental.optimized_lend_train(required,station,this);
        super.setRentals(abc);
        LinkedList<Train> trains = super.getTrains();
        super.setTrains(super.getRentals());
        distributeCars();
        station.setRentals(super.getRentals());
        super.setTrains(trains);
    }

    public void send_car_to_destiantion (String destination, Car car){
        ArrayList<Car> cars = new ArrayList<Car>();
        if (destination_for_cars.containsKey(destination)){
            cars = destination_for_cars.get(destination);
        }
        cars.add(car);
        destination_for_cars.put(destination, cars);
    }

    public void add_cars_to_hashmap (ArrayList<Car> cars){

        // a pretty bad and inflexible implementation
        ArrayList<Car> hamburg_list = new ArrayList<Car>();
        ArrayList<Car> berlin_list = new ArrayList<Car>();
        ArrayList<Car> cologne_list = new ArrayList<Car>();
        ArrayList<Car> munich_list = new ArrayList<Car>();
        //ArrayList<Car> frankfurt_list = new ArrayList<Car>();

        //assigns cars to the arraylist (arraylist are the values of the Hashmap)
        for (Car c : cars){
            Station target_station = c.getTarget();
            String destination = target_station.getName();
            //System.out.println(destination);
            switch (destination) {
                case "Hamburg" : hamburg_list.add(c);
                    break;
                case "Berlin" : berlin_list.add(c);
                    break;
                case "Cologne" : cologne_list.add(c);
                    break;
                case "Munich" : munich_list.add(c);
                    break;
                //case "Frankfurt" : frankfurt_list.add(c);
                    //break;
                default : System.out.println("Error while adding Cars to Hashmap");
                    break;
            }
        }

        //adds the list with their respective keys to the hashmap
        destination_for_cars.put("hamburg", hamburg_list);
        destination_for_cars.put("berlin", berlin_list);
        destination_for_cars.put("cologne", cologne_list);
        destination_for_cars.put("munich", munich_list);
        //destination_for_cars.put("frankfurt", frankfurt_list);
    }

    public String hashmap_to_string (){

        //for printing out the hashmap, so far it's only printing the keys
        StringBuilder returnStr = new StringBuilder();
        for (String i : destination_for_cars.keySet()) {
            returnStr.append("key: ");
            returnStr.append(i);
            returnStr.append("\n");

            //this part doesn't work as intended
            ArrayList<Car> destination = destination_for_cars.get(i);
            for (Car c : destination){
                returnStr.append(c.toString());
                returnStr.append("\n");
            }
            returnStr.append("\n");
        }
        return returnStr.toString();
    }

    public void hashmap_distributeCars(){
        ArrayList<Car> notDistributable = new ArrayList<>(); //for storing the not distributable cars
        for (String i : destination_for_cars.keySet()) {
            ArrayList<Car> destination = destination_for_cars.get(i); //gets the right Station Arraylist (destination)
            System.out.println("Distribution for " + destination.get(0).getTarget().getName() + ":");

            //distribution of cars to the available trains
            for (Car c : destination){
                for (Train t: super.getTrains()){ //for each train in centralStation check if the target of the car is the same
                    if (t.getStation().getName().equals(c.getTarget().getName())){
                        if (t.getCar_amount() < t.getCarNumber() ) { // add the car
                            t.addCar(c);
                            System.out.println("Car " + c.getCarID() + " has been added to train " + t.toString());
                            break;
                        }
                        if (!checkdistribution(t.getStation())){
                            if (!notDistributable.contains(c))
                                notDistributable.add(c);
                            }
                        }
                    }
                }

            //distribution of cars to the rental trains if needed
            Station station = destination.get(0).getTarget();
            int required = notDistributable.size();
            TrainRental trainRental = new TrainRental(i + " " + (destination.get(0).getTarget().getName()));
            LinkedList<Train> abc = trainRental.optimized_lend_train(required,station,this);
            super.setRentals(abc);
            LinkedList<Train> trains = super.getTrains();
            super.setTrains(super.getRentals());
            distributeCars();
            station.setRentals(super.getRentals());
            super.setTrains(trains);

            //removes elements of the arraylist in the hashmap
            destination.removeAll(destination);

            System.out.println("\n");
            }
        }
    }

