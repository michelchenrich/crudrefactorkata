package accounttracker.usecases.entities;

import accounttracker.usecases.boundaries.DebitMessageReceiver;
import accounttracker.usecases.boundaries.DebitRequest;

public abstract class Debit {
    public abstract String id();
    public abstract double value();
    public abstract String description();
    public abstract Debit updateWith(DebitRequest request);

    public void sendErrors(DebitMessageReceiver receiver) {
        if (valueLowerOrEqualToZero()) receiver.valueMustBeGreaterThanZero();
        if (descriptionIsEmpty()) receiver.descriptionMustNotBeEmpty();
    }

    public boolean isValid() {
        return !valueLowerOrEqualToZero() && !descriptionIsEmpty();
    }

    private boolean valueLowerOrEqualToZero() {
        return value() <= 0d;
    }

    private boolean descriptionIsEmpty() {
        return description() == null || description().isEmpty();
    }
}
