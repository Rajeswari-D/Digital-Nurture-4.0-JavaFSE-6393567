package com.cognizant.mockitotests.exercise7;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testDisconnectThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Disconnect failed")).when(mockApi).disconnect();

        MyService service = new MyService(mockApi);

        // Ensure it doesn't crash the test (because it's handled in service)
        assertDoesNotThrow(service::safeDisconnect);

        // Verify it was called
        verify(mockApi).disconnect();
    }
}
