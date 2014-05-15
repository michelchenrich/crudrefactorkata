package accounttracker;

import accounttracker.inmemory.InMemoryDebitStore;
import accounttracker.usecases.CreateDebitCommand;
import accounttracker.usecases.boundaries.DebitStore;
import org.junit.Before;

public class DebitTest {
    protected ReceiverSpy receiver;
    protected DebitStore debitStore;

    protected String createDebit(double value, String description) {
        new CreateDebitCommand(new RequestStub(value, description), receiver, debitStore).execute();
        return receiver.id;
    }

    @Before
    public void setUp() {
        receiver = new ReceiverSpy();
        debitStore = new InMemoryDebitStore();
    }
}
