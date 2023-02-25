package CrazyStation;

import java.util.ArrayList;
import java.util.Scanner;


public class CrazyStation {

    public static void hitenter(Scanner sc){
        System.out.println("Please hit 'Enter' to continue~");
        String input = sc.nextLine();
        if(input.isEmpty())
        {
            return;
        }
    }

    public static void main (String[] args){

        Scanner sc=new Scanner(System.in);

        // Setup for new normal Stations
        Station hamburg = new Station ("Hamburg");
        Station berlin = new Station ("Berlin");
        Station cologne = new Station ("Cologne");
        Station munich = new Station ("Munich");
        Station frankfurt = new Station ("Frankfurt");

        ArrayList<Station> stations = new ArrayList<Station>();
        stations.add(hamburg);
        stations.add(berlin);
        stations.add(cologne);
        stations.add(munich);
        stations.add(frankfurt);

        // Setup for new central Stations
        CentralStation frankfurt_central = new CentralStation("Frankfurt");

        // Setup for new Trains
        // name: startStation_centralStation
        Train frankfurt_frankfurt_central = new Train(frankfurt, frankfurt_central);
        Train munich_frankfurt_central = new Train(munich, frankfurt_central);
        Train hamburg_frankfurt_central = new Train(hamburg, frankfurt_central);
        Train berlin_frankfurt_central = new Train(berlin, frankfurt_central);
        Train cologne_frankfurt_central = new Train(cologne, frankfurt_central);

        // Adding Trains to Stations
        hamburg.addTrain(hamburg_frankfurt_central);
        munich.addTrain(munich_frankfurt_central);
        cologne.addTrain(cologne_frankfurt_central);
        berlin.addTrain(berlin_frankfurt_central);
        frankfurt.addTrain(frankfurt_frankfurt_central);
        frankfurt_central.addTrains(hamburg_frankfurt_central,
                            munich_frankfurt_central,
                            cologne_frankfurt_central,
                            berlin_frankfurt_central,
                            frankfurt_frankfurt_central);

        // Adding Cars to Stations
        hamburg.addCars(new Car(1, hamburg, cologne),
                        new Car(2, hamburg, cologne),
                        new Car(3, hamburg, munich),
                        new Car(4, hamburg, munich));
        munich.addCars(new Car(5, munich, cologne),
                       new Car(9, munich, cologne),
                       new Car(10, munich, berlin),
                       new Car(17, munich, frankfurt));
        berlin.addCars(new Car(6, berlin, munich),
                       new Car(7, berlin, hamburg),
                       new Car(12, berlin, munich),
                       new Car(13, berlin, hamburg),
                       new Car(14, berlin, munich));
        cologne.addCars(new Car(8, cologne, munich),
                        new Car(11, cologne, berlin));
        frankfurt.addCars(new Car(15, frankfurt, munich),
                          new Car(16, frankfurt, cologne));

        // Console Output
        System.out.println("__________________Situation at the beginning of the day__________________");
        for(Station s : stations){
            System.out.println("\uD83D\uDE82 " + s);
        }
        // uD83D uDE82 is the Unicode for the train emoji 🚂

        // Cars get attached to the available trains on those routes
        for(Station s : stations){
            s.loadTrains();
        }

        hitenter(sc);

        // Cars get transported from Stations to CentralStation Frankfurt, uD83D uDE89 is the Unicode for the station 🚉
        frankfurt_central.unloadTrains();
        System.out.println("________________Cars transported to the Central Station \uD83D\uDE89 ________________");
        System.out.println("\uD83D\uDE82 " + frankfurt_central);
        frankfurt_central.distributeCars();

        // Trains drive with the new attached cars back to the stations
        for(Station s : stations){
            s.unloadTrains();
        }

        hitenter(sc);
        // Lets check if all possible cars are at the right station
        System.out.println("___________________Transported Cars___________________");
        for(Station s : stations){
            System.out.println("\uD83D\uDE82 " + s);
        }
    }
}
