package com.cognizant.mockitotests.exercise5;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String[] fetchMultiple() {
        return new String[] {
            api.getData(),
            api.getData(),
            api.getData()
        };
    }
}
