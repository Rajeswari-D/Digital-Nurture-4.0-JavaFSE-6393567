package com.cognizant.mockitotests.exercise7;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void safeDisconnect() {
        try {
            api.disconnect();
        } catch (RuntimeException e) {
            System.out.println("Handled Exception: " + e.getMessage());
        }
    }
}
