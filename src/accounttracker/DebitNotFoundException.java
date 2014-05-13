package accounttracker;

public class DebitNotFoundException extends RuntimeException {
    private String debitId;

    public DebitNotFoundException(String debitId) {
        this.debitId = debitId;
    }

    public String debitId() {
        return debitId;
    }
}
