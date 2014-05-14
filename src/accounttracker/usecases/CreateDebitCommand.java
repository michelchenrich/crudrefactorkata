package accounttracker.usecases;

import accounttracker.usecases.boundaries.CreateDebitReceiver;
import accounttracker.usecases.boundaries.DebitRequest;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.entities.Debit;

public class CreateDebitCommand extends ChangeDebitCommand {
    private CreateDebitReceiver createReceiver;

    public CreateDebitCommand(DebitRequest request, CreateDebitReceiver receiver, DebitStore store) {
        super(request, receiver, store);
        createReceiver = receiver;
    }

    protected Debit getTarget() {
        return store.create();
    }

    protected void saveDebit(Debit debit) {
        super.saveDebit(debit);
        createReceiver.createdWithId(debit.id());
    }
}
