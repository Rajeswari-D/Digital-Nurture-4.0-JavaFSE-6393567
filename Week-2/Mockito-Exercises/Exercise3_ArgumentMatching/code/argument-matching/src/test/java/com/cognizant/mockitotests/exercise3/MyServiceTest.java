package com.cognizant.mockitotests.exercise3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData(ArgumentMatchers.anyString())).thenReturn("Mocked Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchUserData("user123");

        assertEquals("Mocked Data", result);

        verify(mockApi).getData("user123");
    }
}
