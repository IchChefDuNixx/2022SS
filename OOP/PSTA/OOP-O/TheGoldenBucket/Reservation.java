package TheGoldenBucket;

public class Reservation {

    //Variables
    private Customer c;
    private String time;
    private String date;
    private Employee waiter;

    //Constructors
    public Reservation() {
        this(new Customer());
    }

    public Reservation(Customer c) {
        this(c, "defaultTime");
    }

    public Reservation(Customer c, String time) {
        this(c, time, "defaultDate");
    }

    public Reservation(Customer c, String time, String date) {
        this(c, time, date, new Employee());
    }

    public Reservation(Customer c, String time, String date, Employee waiter) {
        this.c = c;
        this.time = time;
        this.date = date;
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Customer: " + c.getName() + "Time: " + time + " Date: " + date + " Waiter: " + waiter.getName();
    }

    //Methods
    public Customer getCustomer() {
        return c;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getWaiter() {
        //System.out.println("hello im " + this.waiter.getName());
        return this.waiter.getName();
    }


    public void setCustomer(Customer c) {
        this.c = c;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    // ?
}
