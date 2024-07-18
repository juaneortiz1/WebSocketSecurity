package org.apache.maven.archetypes.maven_archetype_quickstart;

import static org.mockito.Mockito.*;

import jakarta.websocket.RemoteEndpoint;
import jakarta.websocket.Session;
import org.apache.maven.archetypes.maven_archetype_quickstart.endpoints.BBEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class BBEndpointTest {

    @Mock
    private Session mockSession;

    @Mock
    private RemoteEndpoint.Basic mockRemoteEndpoint;

    private BBEndpoint bbEndpoint;

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(mockSession.getBasicRemote()).thenReturn(mockRemoteEndpoint);
        bbEndpoint = new BBEndpoint();
        bbEndpoint.openConnection(mockSession);
    }



    @Test
    public void testOnOpen() throws IOException {
        verify(mockRemoteEndpoint).sendText("Connection established.");
    }

    @Test
    public void testOnClose() {
        bbEndpoint.closedConnection(mockSession);
    }

    @Test
    public void testOnError() {
        Throwable mockThrowable = mock(Throwable.class);
        bbEndpoint.error(mockSession, mockThrowable);
    }
}
