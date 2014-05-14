package accounttracker.usecases;

import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.boundaries.IterativeDebitReceiver;
import accounttracker.usecases.entities.Debit;

public class ReadDebitsCommand extends ReadDebitCommand {
    private IterativeDebitReceiver iterativeReceiver;

    public ReadDebitsCommand(IterativeDebitReceiver receiver, DebitStore store) {
        super(receiver, store);
        iterativeReceiver = receiver;
    }

    public void execute() {
        for (Debit debit : store.read()) sendDebitInfo(debit);
    }

    public void sendDebitInfo(Debit debit) {
        iterativeReceiver.debitStart(debit.id());
        super.sendDebitInfo(debit);
        iterativeReceiver.endDebit();
    }
}
