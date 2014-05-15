package accounttracker;

import accounttracker.usecases.boundaries.IterativeDebitReceiver;

import java.util.ArrayList;
import java.util.List;

class IterativeReceiverSpy implements IterativeDebitReceiver {
    public List<Object[]> debits = new ArrayList<Object[]>();
    private Object[] debitData;

    public void debitStart(String id) {
        debitData = new Object[3];
        debitData[0] = id;
    }

    public void valueIs(double value) {
        debitData[1] = value;
    }

    public void descriptionIs(String description) {
        debitData[2] = description;
    }

    public void endDebit() {
        debits.add(debitData);
    }
}
