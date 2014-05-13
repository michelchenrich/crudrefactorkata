package accounttracker;

import accounttracker.usecases.boundaries.DebitRequest;
import accounttracker.usecases.boundaries.IdBasedRequest;
import accounttracker.usecases.boundaries.UpdateDebitRequest;

public class RequestStub implements DebitRequest, IdBasedRequest, UpdateDebitRequest {
    private String id;
    private double value;
    private String description;

    public RequestStub(String id) {
        this(id, 0d, null);
    }

    public RequestStub(double value, String description) {
        this(null, value, description);
    }

    public RequestStub(String id, double value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public String id() {
        return id;
    }

    public double value() {
        return value;
    }

    public String description() {
        return description;
    }
}
