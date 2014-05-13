package accounttracker.usecases.boundaries;

public interface DebitReceiver {
    void valueIs(double value);
    void descriptionIs(String description);
}
