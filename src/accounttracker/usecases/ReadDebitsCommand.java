package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IterativeDebitReceiver;
import accounttracker.usecases.entities.Debit;

public class ReadDebitsCommand implements Command {
    private DebitStore store;
    private IterativeDebitReceiver receiver;

    public ReadDebitsCommand(IterativeDebitReceiver receiver, DebitStore store) {
        this.receiver = receiver;
        this.store = store;
    }

    public void execute() {
        for (Debit debit : store.read()) sendDebitData(debit);
    }

    public void sendDebitData(Debit debit) {
        receiver.debitStart(debit.id());
        debit.sendData(receiver);
        receiver.endDebit();
    }
}
