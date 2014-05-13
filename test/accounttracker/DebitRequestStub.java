package accounttracker;

import accounttracker.usecases.boundaries.DebitRequest;

public class DebitRequestStub implements DebitRequest {
    private final double value;
    private final String description;

    public DebitRequestStub(double value, String description) {
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
