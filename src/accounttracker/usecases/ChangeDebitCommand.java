package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitMessageReceiver;
import accounttracker.usecases.boundaries.DebitRequest;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.entities.Debit;

public abstract class ChangeDebitCommand implements Command {
    protected DebitRequest request;
    protected DebitMessageReceiver receiver;
    protected DebitStore store;

    public ChangeDebitCommand(DebitRequest request, DebitMessageReceiver receiver, DebitStore store) {
        this.request = request;
        this.receiver = receiver;
        this.store = store;
    }

    public final void execute() {
        Debit debit = getTarget().updateWith(request);

        if (debit.isValid()) saveDebit(debit);
        else debit.sendErrors(receiver);
    }

    protected abstract Debit getTarget();

    protected void saveDebit(Debit debit) {
        store.save(debit);
    }
}
