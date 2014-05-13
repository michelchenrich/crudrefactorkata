package accounttracker;

import accounttracker.usecases.boundaries.CreateDebitReceiver;
import accounttracker.usecases.boundaries.DebitMessageReceiver;
import accounttracker.usecases.boundaries.DebitReceiver;

import java.util.ArrayList;
import java.util.List;

public class ReceiverSpy implements DebitMessageReceiver, CreateDebitReceiver, DebitReceiver {
    public List<String> messages = new ArrayList<String>();
    public String id;
    public double value;
    public String description;

    public void valueMustBeGreaterThanZero() {
        messages.add("valueMustBeGreaterThanZero");
    }

    public void descriptionMustNotBeEmpty() {
        messages.add("descriptionMustNotBeEmpty");
    }

    public void createdWithId(String id) {
        this.id = id;
    }

    public void valueIs(double value) {
        this.value = value;
    }

    public void descriptionIs(String description) {
        this.description = description;
    }
}
