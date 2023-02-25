package NeedForSpeed;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Race {
    private String name;
    private int racetype; // 1 = DragRace, 2 = Race with flying start, 3 = Race with normal start
    private int distance;
    private double time;
    private List<Vehicle> all_vehicles;


    public Race(String name, int racetype, int distance) {
        this.name = name;
        this.racetype = racetype;
        this.distance = distance;
        this.time = 0;
        all_vehicles = new LinkedList<Vehicle>();
    }

    public Race(String name, int racetype, double time) {
        this.name = name;
        this.racetype = racetype;
        this.distance = 0;
        this.time = time;
        all_vehicles = new LinkedList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public void addParticipant(Vehicle participant) {
        all_vehicles.add(participant);
    }


    public void addtoParticipants(Vehicle v){
        all_vehicles.add(v);
    }

    public void showparticipants(){
        for(Vehicle v : all_vehicles){
            System.out.println(v.getName());
        }
    }


    public void start() {
        switch (racetype) {
            case 1: // Drag Race
                if (this.distance == 0) {
                    for (Vehicle v : all_vehicles){
                        if(v.dragDistance(this.time) == 0){
                            System.out.println("Time to short for this car.");
                        }
                    }

                } else {

                    for (Vehicle v : all_vehicles){
                        if(v.dragTime(this.distance) == 0){
                            System.out.println("Distance to short for this car.");
                        }
                    }

                }
                break;


            case 2: // Race with flying start
                if (this.distance == 0) {

                    for (Vehicle v : all_vehicles){
                        v.driveTime(this.time, v.getRestTime2());
                    }

                } else {

                    for (Vehicle v : all_vehicles){
                        v.driveDistance(this.distance, v.getRestTime2());
                    }
                }
                break;


            case 3: // Race with normal start
                if (this.distance == 0) {

                    for (Vehicle v : all_vehicles){
                        v.distance(this.time, v.getRestTime2());
                    }

                } else {

                    for (Vehicle v : all_vehicles){
                        v.time(this.distance, v.getRestTime2());
                    }
                }
                break;
            default:
                System.out.println("Error, incorrect racetype");
                break;
        }
    }

    // implement the method placement
    public void placement() {

        List<Vehicle> sortResults = new LinkedList<>(all_vehicles);
        all_vehicles = sortResults.stream()
                .sorted(Comparator.comparingDouble(o -> o.getTime()))
                .toList();

        System.out.println("Placement of the Race: ");
        for (int i = 0; i < all_vehicles.size(); i++) {
            if (i < 3)
                System.out.println(i + 1 + ". " +all_vehicles.get(i).getName() + ": \"" + all_vehicles.get(i).celebration() + "\"");
            else
                System.out.println(i + 1 + ". " + all_vehicles.get(i).getName() + ": " + all_vehicles.get(i).disappointment());
        }

        double first_time = 0;
        double last_time = 0;
        for (int i = 0; i < all_vehicles.size(); i++){
            if(i == 0){
                //System.out.println(all_vehicles.get(i).getTime());
                first_time = all_vehicles.get(i).getTime();
            }
            if(i == all_vehicles.size()-1){
                //System.out.println(all_vehicles.get(i).getTime());
                last_time = all_vehicles.get(i).getTime();
            }
        }
        System.out.println();
        if (first_time != last_time){
            showtimerace(first_time, last_time);
        }else{
            showdistancerace();
        }
        System.out.println();
    }


    public void showtimerace(double first_time, double last_time){
        double time_dif = last_time - first_time;
        double separator = time_dif / 20;
        double range = last_time;
        String racetrack = "";

        for(int i = 0; i < 21; i++){
            racetrack += " ";
            for(Vehicle v : all_vehicles){

                if (v.getTime() <= range && v.getTime() >= (range - separator)){
                    racetrack += v.getEmoji();
                }
            }
            range -= separator;
        }
        StringBuilder sb = new StringBuilder(racetrack); //victory
        sb.append(" " + "\ud83c\udff3" + "\ud83c\udff3" + "\ud83c\udff3" + "YROTCIV");
        sb.reverse();
        sb.append("\ud83c\udff4");
        System.out.println(sb.toString());
    }


    public void showdistancerace(){
        double first_dist = 0;
        double last_dist = 0;
        for (int i = 0; i < all_vehicles.size(); i++){
            if(i == 0){
                first_dist = all_vehicles.get(i).getDistance();
            }
            if(i == all_vehicles.size()-1){
                last_dist = all_vehicles.get(i).getDistance();
            }
        }
        double dist;
        double normalized;
        double range = 1;
        String racetrack = "VICTORY"+ "\ud83c\udff3" + "\ud83c\udff3" + "\ud83c\udff3";
        while(range > 0){
            for (int i = 0; i < all_vehicles.size(); i++){
                dist = all_vehicles.get(i).getDistance();
                normalized = dist/first_dist;
                if (normalized <= range && normalized >= range-0.05){
                    racetrack += all_vehicles.get(i).getEmoji();
                }
            }
            racetrack += " ";
            range -= 0.05;
        }
        racetrack += "\ud83c\udff4";
        System.out.println(racetrack);
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        String string;
        if (this.distance == 0) {
            string = " Race for the time: " + time + " s\n";
        } else
            string = " distance of the Race: " + distance + " m\n";

        s.append("Racename: " + name + "\t" + string);

        for(Vehicle v : all_vehicles){
            s.append(v.toString());
        }
        return s.toString();
    }


    public void reset() {

        for(Vehicle v : all_vehicles){
            if(v instanceof ManualDrive){
                ((ManualDrive)v).reset();
            }
            if(v instanceof MotorizedDrive){
                ((MotorizedDrive)v).reset();
            }
        }

    }
}
