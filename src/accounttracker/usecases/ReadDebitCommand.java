package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitReceiver;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IdBasedRequest;

public class ReadDebitCommand implements Command {
    private DebitReceiver receiver;
    private DebitStore store;
    private IdBasedRequest request;

    public ReadDebitCommand(IdBasedRequest request, DebitReceiver receiver, DebitStore store) {
        this.receiver = receiver;
        this.store = store;
        this.request = request;
    }

    public void execute() {
        store.read(request.id()).sendData(receiver);
    }
}
