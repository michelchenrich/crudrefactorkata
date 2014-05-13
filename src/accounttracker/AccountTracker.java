package accounttracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountTracker {
    private static Map<String, Debit> debits = new HashMap<String, Debit>();
    private static int incrementalId;

    public static String createDebit(double value, String description, List<String> messages) {
        if (validate(value, description, messages)) return "";

        String id = String.valueOf(++incrementalId);
        debits.put(id, new Debit(value, description));
        return id;
    }

    public static void updateDebit(String id, double value, String description, List<String> messages) {
        if (validate(value, description, messages)) return;

        debits.put(id, new Debit(value, description));
    }

    private static boolean validate(double value, String description, List<String> messages) {
        if (value <= 0d) messages.add("valueMustBeGreaterThanZero");
        if (description == null || description.isEmpty()) messages.add("descriptionMustNotBeEmpty");
        return !messages.isEmpty();
    }

    public static Debit readDebit(String id) {
        if (debits.containsKey(id)) return debits.get(id);
        else throw new DebitNotFoundException(id);
    }

    public static void deleteDebit(String id) {
        debits.remove(id);
    }
}
