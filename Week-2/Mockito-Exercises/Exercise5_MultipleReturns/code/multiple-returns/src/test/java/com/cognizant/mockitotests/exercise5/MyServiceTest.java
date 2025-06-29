package com.cognizant.mockitotests.exercise5;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
            .thenReturn("First")
            .thenReturn("Second")
            .thenReturn("Third");

        MyService service = new MyService(mockApi);
        String[] result = service.fetchMultiple();

        assertArrayEquals(new String[]{"First", "Second", "Third"}, result);
    }
}
