package TheGoldenBucket2;

public class Reservation implements Comparable<Reservation> {
    private static int counter = 0;
    private int reservationId;
    private Customer c;
    private String time;
    private String date;
    private Employee waiter;
    private ListForAllImpl<Order> orders;

    Reservation() {
        this(new Customer("defaultCustomer"));
    }

    Reservation(Customer c) {
        this(c, " - ");
    }

    Reservation(Customer c, String time) {
        this(c, time, " - ");
    }

    Reservation(Customer c, String time, String date) {
        this(c, time, date, new Employee("defaultEmployee", "waiter"));
    }

    Reservation(Customer c, String time, String date, Employee waiter) {
        this(c, time, date, waiter, new ListForAllImpl<Order>());
    }

    Reservation(Customer c, String time, String date, Employee waiter, ListForAllImpl<Order> orders) {
        this.c = c;
        this.time = time;
        this.date = date;
        this.waiter = waiter;
        this.orders = orders;
        this.reservationId = counter;
        counter++;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return waiter;
    }

    public void setEmployee(Employee waiter) {
        this.waiter = waiter;
    }

    public boolean addOrder(Order o) {
        return orders.add(o);
    }

    public ListForAllImpl<Order> getOrders() {
        return orders;
    }

    public Customer getCustomer() {
        return c;
    }

    public void setCustomer(Customer c) {
        this.c = c;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String toString() {
        return c + " - " + time + " - " + waiter.getName();
    }

    @Override
    public int compareTo(Reservation o) {
        int compValue = this.reservationId - o.getReservationId();
        if (compValue < 0) {
            return -1;
        } else if (compValue == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
