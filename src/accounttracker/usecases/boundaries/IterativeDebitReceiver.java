package accounttracker.usecases.boundaries;

public interface IterativeDebitReceiver extends DebitReceiver {
    void debitStart(String id);
    void endDebit();
}
