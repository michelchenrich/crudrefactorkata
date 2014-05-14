package accounttracker.usecases.boundaries;

public interface IterativeDebitReceiver extends DebitReceiver {
    public void debitStart(String id);
    void endDebit();
}
