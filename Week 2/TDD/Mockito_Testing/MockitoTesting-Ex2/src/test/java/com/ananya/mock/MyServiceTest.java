package com.ananya.mock;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData(); 

        verify(mockApi).getData(); 

        System.out.println("Verified: getData() was called on mockApi.");
    }
}
