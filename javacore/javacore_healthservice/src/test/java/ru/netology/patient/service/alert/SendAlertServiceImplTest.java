package ru.netology.patient.service.alert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SendAlertServiceImplTest {

    @Mock
    SendAlertService sendAlertService;

    @Test
    void testSend() {
        sendAlertService.send(Mockito.anyString());
        Mockito.verify(sendAlertService).send(Mockito.anyString());
    }
}