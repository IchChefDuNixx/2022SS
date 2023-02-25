package CrazyStation2;

import java.util.*;
import java.util.ArrayList;

public class CrazyStation2 {

    // ArrayList so that the output is a bit more flexible
    static ArrayList<Station> stations = new ArrayList<>();

    static TrainRental meyer = new TrainRental("Meyer's Trainrental");

    //Initiation of our Objects
    static Station hamburg = new Station ("Hamburg");
    static Station berlin = new Station ("Berlin");
    static Station cologne = new Station ("Cologne");
    static Station munich = new Station ("Munich");
    static CentralStation frankfurt = new CentralStation("Frankfurt");
    static Scanner scanner = new Scanner(System.in);

    FreightTrain munich_frankfurt = new FreightTrain(munich, frankfurt);
    ElectricLocomotive hamburg_frankfurt = new ElectricLocomotive(hamburg, frankfurt);
    ElectricLocomotive berlin_frankfurt = new ElectricLocomotive(berlin, frankfurt);
    SteamLocomotive cologne_frankfurt = new SteamLocomotive(cologne, frankfurt);
    SteamLocomotive cologne_frankfurt2 = new SteamLocomotive(cologne, frankfurt);

    // Setup constructor
    public CrazyStation2(){
        stations.add(hamburg);
        stations.add(berlin);
        stations.add(cologne);
        stations.add(munich);

        hamburg.addTrain(hamburg_frankfurt);
        munich.addTrain(munich_frankfurt);
        cologne.addTrains(cologne_frankfurt, cologne_frankfurt2);
        berlin.addTrain(berlin_frankfurt);

        frankfurt.addTrains(hamburg_frankfurt,
                munich_frankfurt,
                cologne_frankfurt,
                berlin_frankfurt,
                cologne_frankfurt2);

        hamburg.addCars(new FoodCar(1, hamburg, cologne),
                new FoodCar(2, hamburg, cologne),
                new FoodCar(3, hamburg, munich),
                new FoodCar(4, hamburg, munich));
        munich.addCars(new ProductCar(5, munich, cologne),
                new MaterialCar(9, munich, cologne),
                new MaterialCar(10, munich, berlin),
                new MaterialCar(17, munich, cologne));
        berlin.addCars(new ProductCar(6, berlin, munich),
                new ProductCar(7, berlin, hamburg),
                new MaterialCar(12, berlin, munich),
                new FoodCar(14, berlin, munich));
        cologne.addCars(new ProductCar(8, cologne, munich),
                new MaterialCar(11, cologne, berlin));
    }

    public static void pauseOutput(){
        System.out.println("\nplease hit enter\n");
        scanner.nextLine();
    }


    public static void main(String[] args){

        new CrazyStation2();


        //Used that part to test the hashmap implementation, might use JUnit test if there is still enough time left
        ArrayList<Car> test_storage = new ArrayList<Car>();
        test_storage.add(new ProductCar(17, frankfurt, hamburg));
        test_storage.add(new ProductCar(18, frankfurt, hamburg));
        test_storage.add(new ProductCar(19, frankfurt, berlin));
        test_storage.add(new ProductCar(20, frankfurt, berlin));
        test_storage.add(new ProductCar(21 ,frankfurt, cologne));
        test_storage.add(new ProductCar(22 ,frankfurt, munich));

        System.out.println("Testing Hashmap Implementation:\n ");
        frankfurt.add_cars_to_hashmap(test_storage);
        System.out.println(frankfurt.hashmap_to_string());

        System.out.println("Distributing the cars from the Hashmap:\n ");
        frankfurt.hashmap_distributeCars();

        System.out.println("Hashmap after the cars got distributed:\n ");
        System.out.println(frankfurt.hashmap_to_string());

        pauseOutput();

        System.out.println("Testing optimized lend trains: ");
        TrainRental tr = new TrainRental("test");
        tr.optimized_lend_train(39, berlin, frankfurt);




        System.out.println("Situation at the beginning of the day:");

        for (Station s : stations){
            s.prettyprintstation();
            System.out.println(s);
        }

        pauseOutput();
        // Cars get attached to the available trains on those routes
        System.out.println("The trains will be loaded: ");
        for (Station s : stations){
            s.loadTrains();
            s.prettyprintstation();
        }

        pauseOutput();
        // Cars left in Frankfurt the day before
        frankfurt.addCars(new FoodCar(15, berlin, cologne),
                new ProductCar(16, berlin, cologne));
        System.out.println("\n\nCars left the day before:");
        System.out.print(frankfurt.toString());

        pauseOutput();

        System.out.println("----------------------------------------------------\n");

        // Cars get transported from Stations to CentralStation Frankfurt
        System.out.println("The trains are unloaded: ");
        frankfurt.unloadTrains(); // all cars are removed from the trains and are added in the Car[] storage of frankfurt
        System.out.println(frankfurt);

        System.out.println("The trains are sorted: ");
        frankfurt.sortCars(); //the Car[] storage is sorted
        System.out.println("cars arrived in the CentralStation");
        System.out.println(frankfurt.toString());
        frankfurt.prettyprintstation();

        System.out.println("Adding cars to hashmap: ");
        frankfurt.add_cars_to_hashmap(frankfurt.getStorage());
        System.out.println(frankfurt.hashmap_to_string());

        pauseOutput();

        System.out.println("----------------------------------------------------\n");
        System.out.println("Trains are being distributed: ");
        boolean munich_distributable = frankfurt.checkdistribution(munich);
        boolean cologne_distributable = frankfurt.checkdistribution(cologne);
        boolean berlin_distributable = frankfurt.checkdistribution(berlin);
        boolean hamburg_distributable = frankfurt.checkdistribution(hamburg);
        frankfurt.distributeCars();
        frankfurt.prettyprintstation();

        // Trains drive with the new attached cars back to the stations
        System.out.println("Trains arrive at the new stations");
        for (Station s : stations){
            s.unloadTrains();
        }
        System.out.println("Situation with the cars attached to the their destination:");
        // Lets check if the cars are at the right station
        for (Station s : stations){
            System.out.println(s.toString()); // its not sorted
        }

        pauseOutput();

        // What?s left at the CentralStation?
        System.out.println("\n________________Left in Frankfurt________________");
        System.out.print(frankfurt.toString());

        // rental
        if (!munich_distributable){
            frankfurt.rentTrains(meyer, munich);
            munich.unloadRentals();
        }
        if (!hamburg_distributable){
            frankfurt.rentTrains(meyer, hamburg);
            hamburg.unloadRentals();
        }
        if (!berlin_distributable){
            frankfurt.rentTrains(meyer, berlin);
            berlin.unloadRentals();
        }
        if (!cologne_distributable){
            frankfurt.rentTrains(meyer, cologne);
            cologne.unloadRentals();
        }

        pauseOutput();

        System.out.println("-------------------------------------------------\n");

        // Lets check if the cars are at the right station
        for (Station s : stations){
            System.out.println(s.toString());
        }

        pauseOutput();

        // Is any car left at the Centralstation?
        System.out.println("\n\n________________Left in Frankfurt________________");
        System.out.print(frankfurt.toString());

    }
}
