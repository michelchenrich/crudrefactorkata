package accounttracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static accounttracker.AccountTracker.*;
import static org.junit.Assert.*;

public class DebitCRUDTest {
    private final List<String> messages = new ArrayList<String>();

    private void assertReturnedError(String... messages) {
        assertEquals(messages.length, this.messages.size());
        assertArrayEquals(messages, this.messages.toArray());
        this.messages.clear();
    }

    private void assertDebitAttributes(String id, double value, String description) {
        assertEquals(value, readDebit(id).value(), 0.01);
        assertEquals(description, readDebit(id).description());
    }

    private void assertDebitNotFound(String id) {
        try {
            readDebit(id);
            fail();
        } catch (DebitNotFoundException exception) {
            assertEquals(id, exception.debitId());
        }
    }

    @Test
    public void whenCreatingWithInvalidValue_mustReturnMessage() {
        String id = createDebit(0d, "Free food", messages);
        assertTrue(id.isEmpty());
        assertReturnedError("valueMustBeGreaterThanZero");

        id = createDebit(-1d, "Free food", messages);
        assertTrue(id.isEmpty());
        assertReturnedError("valueMustBeGreaterThanZero");
    }

    @Test
    public void whenCreatingWithInvalidDescription_mustReturnMessage() {
        String id = createDebit(100d, "", messages);
        assertTrue(id.isEmpty());
        assertReturnedError("descriptionMustNotBeEmpty");

        id = createDebit(100d, null, messages);
        assertTrue(id.isEmpty());
        assertReturnedError("descriptionMustNotBeEmpty");
    }

    @Test
    public void whenReadingWithTheReturnedId_mustReturnAttributes() {
        String id = createDebit(10d, "Lunch", messages);
        assertDebitAttributes(id, 10d, "Lunch");
    }

    @Test
    public void whenCreatingMultiples_shouldBeAbleToReadThemOutOfOrder() {
        String id2 = createDebit(20d, "Dinner", messages);
        String id1 = createDebit(10d, "Lunch", messages);
        assertDebitAttributes(id1, 10d, "Lunch");
        assertDebitAttributes(id2, 20d, "Dinner");
    }

    @Test
    public void afterUpdatingDebit_mustReturnNewAttributes() {
        String id = createDebit(12d, "Snack", messages);
        updateDebit(id, 12.5, "Late Snack", messages);
        assertDebitAttributes(id, 12.5, "Late Snack");
    }

    @Test
    public void whenUpdatingWithInvalidValue_mustReturnMessage() {
        String id = createDebit(1d, "Cheap food", messages);
        updateDebit(id, 0d, "Free Food", messages);
        assertReturnedError("valueMustBeGreaterThanZero");

        updateDebit(id, -1d, "They Paid Me To Eat Their Food", messages);
        assertReturnedError("valueMustBeGreaterThanZero");
    }

    @Test
    public void whenUpdatingWithInvalidDescription_mustReturnMessage() {
        String id = createDebit(1d, "Cheap food", messages);
        updateDebit(id, 1d, "", messages);
        assertReturnedError("descriptionMustNotBeEmpty");

        updateDebit(id, 1d, null, messages);
        assertReturnedError("descriptionMustNotBeEmpty");
    }

    @Test
    public void whenUpdatingWithError_mustNotUpdate() {
        String id = createDebit(1d, "Cheap Food", messages);
        updateDebit(id, 1d, "", messages);
        assertDebitAttributes(id, 1d, "Cheap Food");

        updateDebit(id, 0, "Free Food", messages);
        assertDebitAttributes(id, 1d, "Cheap Food");
    }

    @Test
    public void afterDeletingDebit_itMayNotBeReadAnymore() {
        String id = createDebit(12d, "Snack", messages);
        deleteDebit(id);
        assertDebitNotFound(id);
    }
}
