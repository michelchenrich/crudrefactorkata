package accounttracker.entities;

import accounttracker.DebitAttributes;

public class Debit implements DebitAttributes {
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

    public void setValue(double value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
