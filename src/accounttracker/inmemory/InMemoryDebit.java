package accounttracker.inmemory;

import accounttracker.usecases.boundaries.DebitRequest;
import accounttracker.usecases.entities.Debit;

public class InMemoryDebit extends Debit {
    private String id;
    private double value;
    private String description;

    public InMemoryDebit(String id) {
        this(id, 0d, "");
    }

    private InMemoryDebit(String id, double value, String description) {
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

    public Debit updateWith(DebitRequest request) {
        return new InMemoryDebit(id(), request.value(), request.description());
    }
}
