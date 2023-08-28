public class Cab {
    private String type;
    private double costPerKm;

    public Cab(String type, double costPerKm) {
        this.type = type;
        this.costPerKm = costPerKm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(double costPerKm) {
        this.costPerKm = costPerKm;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "type='" + type + '\'' +
                ", costPerKm=" + costPerKm +
                '}';
    }
}
