package accounttracker.inmemory;

import accounttracker.usecases.boundaries.DebitNotFoundException;
import accounttracker.usecases.boundaries.DebitStore;
import accounttracker.usecases.entities.Debit;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDebitStore implements DebitStore {
    private Map<String, Debit> debits = new HashMap<String, Debit>();
    private int incrementalId;

    public Debit create() {
        return new InMemoryDebit(String.valueOf(++incrementalId));
    }

    public Debit read(String id) {
        if (debits.containsKey(id)) return debits.get(id);
        else throw new DebitNotFoundException(id);
    }

    public void delete(String id) {
        debits.remove(id);
    }

    public Debit save(Debit debit) {
        return debits.put(debit.id(), debit);
    }
}
