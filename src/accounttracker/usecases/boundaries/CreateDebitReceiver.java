package accounttracker.usecases.boundaries;

public interface CreateDebitReceiver extends DebitMessageReceiver {
    void createdWithId(String id);
}
