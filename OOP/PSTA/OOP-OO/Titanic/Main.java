package Titanic;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Ticket> tickets = TitanicStatistics.loadData();
        double pclass1 = tickets.stream()
                .filter(ticket -> ticket.getPclass().equals("1st") && ticket.getSurvived() == 0).count()
                / tickets.stream().filter(ticket -> ticket.getPclass().equals("1st")).count();

        double pclass2 = tickets.stream()
                .filter(ticket -> ticket.getPclass().equals("2nd") && ticket.getSurvived() == 0).count()
                / tickets.stream().filter(ticket -> ticket.getPclass().equals("2nd")).count();

        double pclass3 = tickets.stream()
                .filter(ticket -> ticket.getPclass().equals("3rd") && ticket.getSurvived() == 0).count()
                / tickets.stream().filter(ticket -> ticket.getPclass().equals("3rd")).count();

        System.out.println(tickets.stream()
                .filter(ticket -> ticket.getPclass().equals("1st") && ticket.getSurvived() == 0).count() / 10);
    }
}
