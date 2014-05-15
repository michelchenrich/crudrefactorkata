package accounttracker.usecases.entities;

import accounttracker.usecases.boundaries.DebitMessageReceiver;
import accounttracker.usecases.boundaries.DebitReceiver;
import accounttracker.usecases.boundaries.DebitRequest;

public abstract class Debit {
    public abstract String id();
    protected abstract double value();
    protected abstract String description();
    public abstract Debit updateWith(DebitRequest request);

    public void sendData(DebitReceiver receiver) {
        receiver.valueIs(value());
        receiver.descriptionIs(description());
    }

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
