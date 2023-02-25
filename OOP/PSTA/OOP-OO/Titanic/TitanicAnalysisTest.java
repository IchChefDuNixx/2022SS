package Titanic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitanicAnalysisTest {

    static TitanicAnalysis testShip;

    @BeforeAll
    static void init() {
        testShip = new TitanicAnalysis();
    }

    @Test
    void sortByAgeAndAlphabet() {
        assertEquals("Andrew  Mr Frank 2nd -1 male 0", testShip.sortByAgeAndAlphabet(0));
        assertEquals("Hagland  Mr Ingvald Olsen 3rd -1 male 0", testShip.sortByAgeAndAlphabet(100));
        assertEquals("Makinen  Mr Kalle Edvard 3rd -1 male 0", testShip.sortByAgeAndAlphabet(200));
        assertEquals("Odahl  Mr Nils Martin 3rd -1 male 1", testShip.sortByAgeAndAlphabet(300));
        assertEquals("Ryan  Mr Patrick 3rd -1 male 0", testShip.sortByAgeAndAlphabet(400));
        assertEquals("Todoroff  Mr Lalio 3rd -1 male 0", testShip.sortByAgeAndAlphabet(500));
    }

    @Test
    void sortMenByAge() {
        assertEquals(851, testShip.tickets.stream().filter(ticket -> ticket.getSex().equals("male"))
                .sorted((t1, t2) -> t2.compareTo(t1)).count());
        assertEquals("Andrew  Mr Frank 2nd -1 male 0", testShip.sortMenByAge(0));
        assertEquals("Khalil  Mr Saad 3rd -1 male 0", testShip.sortMenByAge(100));
        assertEquals("Olsson  Mr Nils Johan 3rd -1 male 0", testShip.sortMenByAge(200));
        assertEquals("Sholt  Mr Peter Andreas Lauritz Andersen 3rd -1 male 0", testShip.sortMenByAge(300));
        assertEquals("Johnson  Master Harold Theodor 3rd 4 male 1", testShip.sortMenByAge(400));
        assertEquals("Johansson  Mr Erik 3rd 22 male 0", testShip.sortMenByAge(500));

    }

    @Test
    void sortChildrenByAgeAndAlphabet() {
        assertEquals(96, testShip.tickets.stream().filter(ticket -> ticket.getAge() >= 0 && ticket.getAge() < 18)
                .sorted((t1, t2) -> t2.compareTo(t1)).count());
        assertEquals("Aks  Master Philip 3rd 0 male 1", testShip.sortChildrenByAgeAndAlphabet(0));
        assertEquals("Klasen  Miss Gertrud Emilia 3rd 1 female 0", testShip.sortChildrenByAgeAndAlphabet(10));
        assertEquals("Aspland  Master Edvin Rojj Felix 3rd 3 male 1", testShip.sortChildrenByAgeAndAlphabet(20));
        assertEquals("Carr  Miss Helen 3rd 16 female 1", testShip.sortChildrenByAgeAndAlphabet(75));

    }

    @Test
    void averageAgePassengers() {
        assertEquals(30.3915, testShip.averageAgePassengers(), 0.001);
    }

    @Test
    void averageAgeDeceased() {
        // Bruh this assertion is checking for averageAgeAlive.
        // Just change ".getSurvived() ==" from 0 to 1 (twice)
        assertEquals(29.348, testShip.averageAgeDeceased(), 0.001);
    }

    @Test
    void numberOfPassengers() {
        assertEquals(1313, testShip.numberOfPassengers());
    }

    @Test
    void percentageDeceasedPeopleInTwenties() {
        assertEquals(0.666, testShip.percentageDeceasedPeopleInTwenties(), 0.001);
    }

    @Test
    void averageAgeMen() {
        assertEquals(31.00, testShip.averageAgeMen(), 0.01);
    }

    @Test
    void averageAgeWomen() {
        assertEquals(29.39, testShip.averageAgeWomen(), 0.01);
    }

    @Test
    void mostFrequentSurname() {
        assertEquals("Sage", testShip.mostFrequentSurname(0));
        assertEquals("Andersson", testShip.mostFrequentSurname(1));
        assertEquals("Goodwin", testShip.mostFrequentSurname(2));
        assertEquals("Asplund", testShip.mostFrequentSurname(3));
    }

    @Test
    void mostFrequentSurnames() {
        List<String> l = testShip.mostfrerquentsurnames();
        for (String a : l) {
            System.out.println(a);
        }
    }

    @Test
    void mostFrequentAge() {
        // 30 == 21
        assertEquals(22, testShip.mostFrequentAge(0));
        assertEquals(21, testShip.mostFrequentAge(1));
        assertEquals(30, testShip.mostFrequentAge(2));
        assertEquals(18, testShip.mostFrequentAge(3));
    }

    @Test
    void mostFrequentAges() {
        List<Integer> l = testShip.mostfrerquentAges();
        for (Integer a : l) {
            System.out.println(a);
        }
    }

    @Test
    void percentageDeceasedPclass() throws Exception {
        assertEquals(0.4006, testShip.percentageDeceasedPclass(1), 0.01);
        assertEquals(0.575, testShip.percentageDeceasedPclass(2), 0.01);
        assertEquals(0.806, testShip.percentageDeceasedPclass(3), 0.01);
    }

    @Test
    void percentageDeceasedPclassStreams() {
        assertEquals(0.4006, testShip.percentageDeceasedPclassStreams("1st"), 0.01);
        assertEquals(0.575, testShip.percentageDeceasedPclassStreams("2nd"), 0.01);
        assertEquals(0.806, testShip.percentageDeceasedPclassStreams("3rd"), 0.01);
    }

    @Test
    void genderDistributionbyclass() {
        testShip.genderdistributionbyclass();
    }

    @Test
    void agesbetween() {
        List ages = testShip.stream_agesinbetween(20, 30);
        Long num = testShip.stream_count(ages);
        System.out.println(num);
    }
}
