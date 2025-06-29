package com.cognizant.mockitotests.exercise3;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchUserData(String userId) {
        return api.getData(userId);
    }
}
