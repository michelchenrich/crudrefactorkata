package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitReceiver;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IdBasedRequest;
import accounttracker.usecases.entities.Debit;

public class ReadDebitCommand {
    private IdBasedRequest request;
    private DebitStore store;
    private DebitReceiver receiver;

    public ReadDebitCommand(IdBasedRequest request, DebitReceiver receiver, DebitStore store) {
        this.request = request;
        this.receiver = receiver;
        this.store = store;
    }

    public void execute() {
        Debit debit = store.read(request.id());
        receiver.valueIs(debit.value());
        receiver.descriptionIs(debit.description());
    }
}
