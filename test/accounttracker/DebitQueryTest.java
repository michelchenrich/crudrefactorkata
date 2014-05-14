package accounttracker;

import accounttracker.usecases.ReadDebitsCommand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DebitQueryTest extends DebitTest {
    private List<String> expectedDebits = new ArrayList<String>();
    private IterativeReceiverSpy iterativeReceiver = new IterativeReceiverSpy();

    private void readAllDebits() {
        new ReadDebitsCommand(iterativeReceiver, debitStore).execute();
    }

    private void expectDebit(String id, double value, String description) {
        expectedDebits.add(String.format("[%s, %.1f, %s]", id, value, description));
    }

    private void assertReturnedDebits() {
        assertEquals(expectedDebits.size(), iterativeReceiver.debits.size());
        assertTrue("Returned debits does not contain all expected debits", iterativeReceiver.debits.containsAll(expectedDebits));
    }

    @Test
    public void readMultipleDebits_fromFirstToLast() {
        createDebit(10d, "Lunch");
        String id1 = receiver.id;
        createDebit(20d, "Dinner");
        String id2 = receiver.id;

        readAllDebits();

        expectDebit(id1, 10d, "Lunch");
        expectDebit(id2, 20d, "Dinner");
        assertReturnedDebits();
    }

    @Test
    public void readMultipleDebits_fromLastToFirst() {
        createDebit(10d, "Lunch");
        String id1 = receiver.id;
        createDebit(20d, "Dinner");
        String id2 = receiver.id;

        readAllDebits();

        expectDebit(id2, 20d, "Dinner");
        expectDebit(id1, 10d, "Lunch");
        assertReturnedDebits();
    }
}
