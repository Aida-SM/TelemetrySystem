package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest

{
    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
        TelemetryClient telemetryClient = mock(TelemetryClient.class);

        when(telemetryClient.receive()).thenReturn("It's a diagnostic message result");
        telemetryClient.send("It's a diagnostic message");


        verify(telemetryClient,times(1)).send("It's a diagnostic message");
        Assert.assertEquals("It's a diagnostic message result",telemetryClient.receive());
    }

}
