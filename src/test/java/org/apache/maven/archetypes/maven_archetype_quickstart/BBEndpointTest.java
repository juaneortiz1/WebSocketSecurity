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

  /*  @Test
    public void testSend() throws IOException {
        Session anotherMockSession = mock(Session.class);
        RemoteEndpoint.Basic anotherMockRemoteEndpoint = mock(RemoteEndpoint.Basic.class);
        when(anotherMockSession.getBasicRemote()).thenReturn(anotherMockRemoteEndpoint);
        bbEndpoint.openConnection(anotherMockSession);

        // Clear previous interactions
        clearInvocations(mockRemoteEndpoint, anotherMockRemoteEndpoint);

        String message = "Test message";
        bbEndpoint.send(message);

        // Verify that the message is sent to the other session
        verify(anotherMockRemoteEndpoint).sendText(message);
        // Verify that the message is not sent to the own session
        verify(mockRemoteEndpoint, never()).sendText(message);
    }*/

    @Test
    public void testProcessPoint() throws IOException {
        String message = "Test point";

        BBEndpoint spyEndpoint = spy(bbEndpoint);
        doNothing().when(spyEndpoint).send(anyString());


        spyEndpoint.processPoint(message, mockSession);


        verify(spyEndpoint).send(message);
    }

    @Test
    public void testOpenConnection() throws IOException {
        Session newMockSession = mock(Session.class);
        RemoteEndpoint.Basic newMockRemoteEndpoint = mock(RemoteEndpoint.Basic.class);
        when(newMockSession.getBasicRemote()).thenReturn(newMockRemoteEndpoint);

        bbEndpoint.openConnection(newMockSession);

        verify(newMockRemoteEndpoint).sendText("Connection established.");
    }
    
}
