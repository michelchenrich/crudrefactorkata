package accounttracker.usecases.boundaries;

import accounttracker.usecases.entities.Debit;

public interface DebitStore {
    Debit create();
    Debit read(String id) throws DebitNotFoundException;
    void delete(String id);
    Debit save(Debit debit);
}
