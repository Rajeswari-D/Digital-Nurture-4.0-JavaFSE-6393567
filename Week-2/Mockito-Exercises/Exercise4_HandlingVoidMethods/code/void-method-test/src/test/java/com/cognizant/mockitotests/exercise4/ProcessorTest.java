package com.cognizant.mockitotests.exercise4;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProcessorTest {

    @Test
    public void testLogCalledForProcess() {
        Logger mockLogger = mock(Logger.class);

        Processor processor = new Processor(mockLogger);
        processor.process("Exercise4");

        verify(mockLogger).log("Processing: Exercise4");
    }
}
