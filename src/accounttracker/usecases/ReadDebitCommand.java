package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitReceiver;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.entities.Debit;

public class ReadDebitCommand {
    protected DebitReceiver receiver;
    protected DebitStore store;

    public ReadDebitCommand(DebitReceiver receiver, DebitStore store) {
        this.receiver = receiver;
        this.store = store;
    }

    protected void sendDebitInfo(Debit debit) {
        receiver.valueIs(debit.value());
        receiver.descriptionIs(debit.description());
    }
}
