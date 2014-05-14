package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitReceiver;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IdBasedRequest;

public class ReadSingleDebitCommand extends ReadDebitCommand {
    private IdBasedRequest request;

    public ReadSingleDebitCommand(IdBasedRequest request, DebitReceiver receiver, DebitStore store) {
        super(receiver, store);
        this.request = request;
    }

    public void execute() {
        sendDebitInfo(store.read(request.id()));
    }
}
