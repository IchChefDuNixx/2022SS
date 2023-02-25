package CrazyStation2;

import java.util.LinkedList;

public class TrainRental {
    private String name;
    private String emoji = "\ud83d\ude87";

    public TrainRental (String name){
        this.name = name;
    }

    public LinkedList<Train> lendTrain (int necessaryCap, Station station, CentralStation central){
        LinkedList<Train> rental = new LinkedList<Train>();
        int numberTrains = 0;
        if (necessaryCap % 3 != 0){
            numberTrains++;
        }
        numberTrains += (int)(necessaryCap/3);
        while (numberTrains>0){
            if (rental.size() == 1 && rental.getFirst() == null){
                rental.add(0, new SteamLocomotive(station,central));
            } else {
                LinkedList<Train> newArray = new LinkedList<Train>();
                for (int i = 0; i < rental.size(); i++) {
                    newArray.add(rental.get(i));
                }
                newArray.add(new SteamLocomotive(station, central));
                rental = newArray;
            }
            numberTrains--;
        }
        return rental;
    }

    public LinkedList<Train> optimized_lend_train (int car_number, Station station, CentralStation central){
        LinkedList<Train> rentals = new LinkedList<Train>();
        //Optimize the renting process so that A) the amount of rental trains is minimized and B) the used capacity is maximized
        //We have 3 different types of trains
        //Freight capacity 10
        //Electric locomotive capacity 5
        //Steam locomotive capacity 3
        //Example of a good destribution:
        //If we have 38 cars we take 3 freight trains, 1 electric, 1 steam; min amount of trains used and capacity is maxed

        int freights = 0;
        int electrics = 0;
        int steams = 0;

        while(car_number != 0){
            //System.out.println(car_number);
            if(car_number >= 10){
                car_number -= 10;
                freights ++;
                continue;
            }
            if(car_number >= 5){
                car_number -= 5;
                electrics ++;
                continue;
            }
            if(car_number >= 3){
                car_number -= 3;
                steams ++;
                continue;
            }
            if(car_number < 3){
                steams ++;
                break;
            }
        }
        //Add new trains to linked list
        for(int i = 0; i < freights; i++){
            rentals.add(new FreightTrain(station,central));
        }
        for(int i = 0; i < electrics; i++){
            rentals.add(new ElectricLocomotive(station,central));
        }
        for(int i = 0; i < steams; i++){
            rentals.add(new SteamLocomotive(station,central));
        }
        //System.out.println(rentals);
        System.out.println("Trains rented: " + freights + " Freight Trains, " + electrics + " Electric Locomotives, " + steams + " Steam Locomotives");

        return rentals;
    }
}
