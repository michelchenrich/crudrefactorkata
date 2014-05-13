package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IdBasedRequest;

public class DeleteDebitCommand {
    private IdBasedRequest request;
    private DebitStore store;

    public DeleteDebitCommand(IdBasedRequest request, DebitStore store) {
        this.request = request;
        this.store = store;
    }

    public void execute() {
        store.delete(request.id());
    }
}
