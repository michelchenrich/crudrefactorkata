package accounttracker;

public class Debit {
    private double value;
    private String description;

    public Debit(double value, String description) {
        this.value = value;
        this.description = description;
    }

    public double value() {
        return value;
    }

    public String description() {
        return description;
    }
}
