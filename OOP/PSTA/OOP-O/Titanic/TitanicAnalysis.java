package Titanic;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TitanicAnalysis {
    List<Ticket> tickets;

    public TitanicAnalysis() {
        try {
            tickets = TitanicStatistics.loadData();
        } catch (IOException e) {
            System.out.println("IOException occured in constructor");
        }
    }

    public String sortByAgeAndAlphabet(int place) {
        Ticket[] ticketArray = tickets.stream()
                .sorted((t1, t2) -> t2.compareTo(t1))
                .toArray(Ticket[]::new);
        return ticketArray[place].toString();
    }

    public String sortMenByAge(int place) {
        Ticket[] ticketArray = tickets.stream().filter(ticket -> ticket.getSex().equals("male"))
                .sorted((t1, t2) -> t2.compareTo(t1)).toArray(Ticket[]::new);
        return ticketArray[place].toString();
    }

    public String sortChildrenByAgeAndAlphabet(int place) {
        Ticket[] ticketArray = tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getAge() < 18)
                .sorted((t1, t2) -> t2.compareTo(t1)).toArray(Ticket[]::new);
        return ticketArray[place].toString();
    }

    public double averageAgePassengers() {
        return (double) tickets.stream().filter(ticket -> ticket.getAge() >= 0).mapToDouble(ticket -> ticket.getAge())
                .reduce(0, Double::sum) / tickets.stream().filter(ticket -> ticket.getAge() >= 0).count();
    }

    public double averageAgeDeceased() {
        return (double) tickets.stream().filter(ticket -> ticket.getSurvived() == 1 && ticket.getAge() >= 0)
                .mapToDouble(ticket -> ticket.getAge()).reduce(0, Double::sum)
                / tickets.stream().filter(ticket -> ticket.getSurvived() == 1 && ticket.getAge() >= 0).count();
    }

    public int numberOfPassengers() {
        return (int) tickets.stream().count();
    }

    public double percentageDeceasedPeopleInTwenties() {
        return (double) tickets.stream()
                .filter(ticket -> ticket.getAge() >= 20 && ticket.getAge() < 30 && ticket.getSurvived() == 0).count()
                / tickets.stream().filter(ticket -> ticket.getAge() >= 20 && ticket.getAge() < 30).count();
    }

    public double averageAgeMen() {
        return (double) tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getSex().equals("male"))
                .mapToDouble(ticket -> ticket.getAge()).reduce(0, Double::sum)
                / tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getSex().equals("male")).count();
    }

    public double averageAgeWomen() {
        return (double) tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getSex().equals("female"))
                .mapToDouble(ticket -> ticket.getAge()).reduce(0, Double::sum)
                / tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getSex().equals("female")).count();
    }

    public String mostFrequentSurname(int place) {
        // still improvable
        List<Pair<String>> surnamePairList = new LinkedList<>();
        tickets.stream().collect(Collectors.groupingBy(Ticket::getSurname, Collectors.counting()))
                .forEach((String s, Long l) -> {
                    surnamePairList.add(new Pair<String>(s, Math.toIntExact(l)));
                });
        String[] result = surnamePairList.stream().sorted((Pair<String> p1, Pair<String> p2) -> p2.compareTo(p1))
                .map(pair -> pair.getKey()).toArray(String[]::new);
        return result[place];
    }

    public List<String> mostfrerquentsurnames() {
        // almost the same as mostfrequentages, turn things into
        // get rid of the filter to remove -1 ages
        Map<String, Long> result_map = tickets.stream()
                .collect(Collectors.groupingBy(t -> t.getSurname(), Collectors.counting()));

        List<String> result2 = result_map.keySet().stream()
                .sorted((String x, String y) -> result_map.get(y).compareTo(result_map.get(x)))
                .collect(Collectors.toList());
        return result2;
    }

    public int mostFrequentAge(int place) {
        // very similar to above

        List<Pair<Integer>> agePairList = new LinkedList<>();
        tickets.stream().filter(ticket -> ticket.getAge() >= 0)
                .collect(Collectors.groupingBy(Ticket::getAge, Collectors.counting()))
                .forEach((Integer a, Long l) -> {
                    agePairList.add(new Pair<Integer>(a, Math.toIntExact(l)));
                });
        Integer[] result = agePairList.stream().sorted((Pair<Integer> p1, Pair<Integer> p2) -> p2.compareTo(p1))
                .map(pair -> pair.getKey()).toArray(Integer[]::new);
        return result[place];
    }

    public List<Integer> mostfrerquentAges() {
        Map<Integer, Long> result_map = tickets.stream().filter(ticket -> ticket.getAge() >= 0)
                .collect(Collectors.groupingBy(t -> t.getAge(), Collectors.counting()));

        List<Integer> result2 = result_map.keySet().stream()
                .sorted((Integer x, Integer y) -> result_map.get(y).compareTo(result_map.get(x)))
                .collect(Collectors.toList());
        return result2;
    }

    public double percentageDeceasedPclass(int pclass) throws Exception {
        double totalPassengersPclass = 0;
        double PassengersPclassDeceased = 0;
        String pclassString = "";
        switch (pclass) {
            case 1:
                pclassString = "1st";
                break;
            case 2:
                pclassString = "2nd";
                break;
            case 3:
                pclassString = "3rd";
                break;
            default:
                throw new Exception("wrong class. enter 1-3");
        }
        for (Ticket ticket : tickets) {
            if (ticket.getPclass().equals(pclassString)) {
                totalPassengersPclass++;
                if (ticket.getSurvived() == 0) {
                    PassengersPclassDeceased++;
                }
            }
        }
        return PassengersPclassDeceased / totalPassengersPclass;
    }

    public double percentageDeceasedPclassStreams(String pclass) {
        // now with streams
        return (double) tickets.stream()
                .filter(ticket -> ticket.getPclass().equals(pclass) && ticket.getSurvived() == 0).count()
                / tickets.stream().filter(ticket -> ticket.getPclass().equals(pclass)).count();

    }

    public void genderdistributionbyclass() {
        String[] classes = { "1st", "2nd", "3rd" };
        for (String cls : classes) {
            double total_num = tickets.stream().filter(t -> t.getPclass().equals(cls)).count();
            double men_num = tickets.stream().filter(t -> t.getPclass().equals(cls) && t.getSex().equals("male"))
                    .count();

            double value = Math.floor(men_num / total_num * 100) / 100;

            System.out.print(cls + " class is ");
            System.out.print(value);
            System.out.println(" men");
        }

    }

    public List<Ticket> stream_agesinbetween(Integer min, Integer max) {
        List<Ticket> s = tickets.stream().filter(t -> t.getAge() >= min && t.getAge() < max)
                .collect(Collectors.toList());

        return s;
    }

    public Long stream_count(List<Ticket> s) {
        Long num = s.stream().count();
        return num;
    }

    public List<Ticket> stream_survived(Boolean alive) {
        Integer surv = 0;
        if (alive) {
            surv = 1;
        }
        List<Ticket> s = tickets.stream().filter(t -> t.getSurvived() == 1).collect(Collectors.toList());
        return s;
    }

}
