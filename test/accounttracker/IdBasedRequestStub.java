package accounttracker;

import accounttracker.usecases.boundaries.IdBasedRequest;

public class IdBasedRequestStub implements IdBasedRequest {
    private String id;

    public IdBasedRequestStub(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
