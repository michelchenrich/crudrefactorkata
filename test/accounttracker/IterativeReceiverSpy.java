package accounttracker;

import accounttracker.usecases.boundaries.IterativeDebitReceiver;

import java.util.ArrayList;
import java.util.List;

class IterativeReceiverSpy implements IterativeDebitReceiver {
    public List<String> debits = new ArrayList<String>();
    private String debit = "";

    public void debitStart(String id) {
        debit += String.format("[%s", id);
    }

    public void valueIs(double value) {
        debit += String.format(", %.1f", value);
    }

    public void descriptionIs(String description) {
        debit += String.format(", %s]", description);
    }

    public void endDebit() {
        debits.add(debit);
        debit = "";
    }
}
