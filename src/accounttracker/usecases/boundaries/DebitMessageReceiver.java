package accounttracker.usecases.boundaries;

public interface DebitMessageReceiver {
    void valueMustBeGreaterThanZero();
    void descriptionMustNotBeEmpty();
}
