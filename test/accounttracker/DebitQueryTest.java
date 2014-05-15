package accounttracker;

import accounttracker.usecases.ReadDebitsCommand;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DebitQueryTest extends DebitTest {
    private IterativeReceiverSpy iterativeReceiver = new IterativeReceiverSpy();
    private int currentDebit = 0;

    private void readAllDebits() {
        new ReadDebitsCommand(iterativeReceiver, debitStore).execute();
    }

    private void assertDebitAttributes(String id, double value, String description) {
        assertArrayEquals(new Object[]{id, value, description}, iterativeReceiver.debits.get(currentDebit++));
    }

    private void assertDebitCount() {
        assertEquals(currentDebit, iterativeReceiver.debits.size());
    }

    @Test
    public void readMultipleDebits_fromFirstToLast() {
        String id1 = createDebit(10d, "Lunch");
        String id2 = createDebit(20d, "Dinner");

        readAllDebits();

        assertDebitAttributes(id1, 10d, "Lunch");
        assertDebitAttributes(id2, 20d, "Dinner");
        assertDebitCount();
    }
}
