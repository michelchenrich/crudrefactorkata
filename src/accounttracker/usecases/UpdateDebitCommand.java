package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitMessageReceiver;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IdBasedRequest;
import accounttracker.usecases.boundaries.UpdateDebitRequest;
import accounttracker.usecases.entities.Debit;

public class UpdateDebitCommand extends ChangeDebitCommand {
    private IdBasedRequest idRequest;

    public UpdateDebitCommand(UpdateDebitRequest request, DebitMessageReceiver receiver, DebitStore store) {
        super(request, receiver, store);
        idRequest = request;
    }

    protected Debit getTarget() {
        return store.read(idRequest.id());
    }
}
