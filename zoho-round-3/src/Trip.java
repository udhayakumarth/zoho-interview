import java.util.Date;

public class Trip {
    private String tripId;
    private Employee employee;
    private double cost;
    private Cab cab;
    private Date dateTime;

    public Trip(String tripId, Employee employee, double cost, Cab cab, Date dateTime) {
        this.tripId = tripId;
        this.employee = employee;
        this.cost = cost;
        this.cab = cab;
        this.dateTime = dateTime;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId='" + tripId + '\'' +
                ", employee=" + employee +
                ", cost=" + cost +
                ", cab=" + cab +
                ", dateTime=" + dateTime +
                '}';
    }
}
