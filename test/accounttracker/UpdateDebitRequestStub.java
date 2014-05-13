package accounttracker;

import accounttracker.usecases.boundaries.UpdateDebitRequest;

public class UpdateDebitRequestStub extends IdBasedRequestStub implements UpdateDebitRequest {
    private double value;
    private String description;

    public UpdateDebitRequestStub(String id, double value, String description) {
        super(id);
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
