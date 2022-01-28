package ru.netology.patient.service.medical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;
import ru.netology.patient.service.alert.SendAlertService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicalServiceImplTest {

    private final BloodPressure patientsNormalBP = new BloodPressure(120, 80);
    private final BigDecimal patientsNormalBT = new BigDecimal("36.6");
    private final HealthInfo healthInfo = new HealthInfo(patientsNormalBT, patientsNormalBP);
    private final LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
    private final String id = UUID.randomUUID().toString();
    private final PatientInfo patientInfo = new PatientInfo(id, "John", "Doe", dateOfBirth, healthInfo);

    @Mock
    PatientInfoFileRepository patientInfoFileRepository;

    @Mock
    SendAlertService sendAlertService;

    @InjectMocks
    MedicalServiceImpl medicalService;

    @Captor
    ArgumentCaptor<String> messageCaptor;

    @Test
    void testCheckBloodPressure_badBP_sendsMessage() {

        BloodPressure badBPDecrease = new BloodPressure(114, 74);
        BloodPressure badBPIncrease = new BloodPressure(126, 86);

        when(patientInfoFileRepository.getById(id)).thenReturn(patientInfo);
        medicalService.checkBloodPressure(id, badBPDecrease);
        medicalService.checkBloodPressure(id, badBPIncrease);

        verify(sendAlertService, times(2)).send(messageCaptor.capture());

        String expectedMessage = String.format("Warning, patient with id: %s, need help, cause: BP", id);
        List<String> actualMessages = messageCaptor.getAllValues();
        for (String actualMessage : actualMessages) {
            Assertions.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    void testCheckBloodPressure_normalBP_noMessage() {

        BloodPressure normalBPDecrease = new BloodPressure(115, 75);
        BloodPressure normalBPStable = new BloodPressure(120, 80);
        BloodPressure normalBPIncrease = new BloodPressure(125, 85);

        when(patientInfoFileRepository.getById(id)).thenReturn(patientInfo);
        medicalService.checkBloodPressure(id, normalBPDecrease);
        medicalService.checkBloodPressure(id, normalBPStable);
        medicalService.checkBloodPressure(id, normalBPIncrease);

        verify(sendAlertService, never()).send(anyString());
    }

    @ParameterizedTest
    @ValueSource(doubles = {36.0, 37.2})
    void testCheckTemperature_badBT_sendsMessage(double temperature) {

        BigDecimal badBTChange = BigDecimal.valueOf(temperature);
        when(patientInfoFileRepository.getById(id)).thenReturn(patientInfo);
        medicalService.checkTemperature(id, badBTChange);
        verify(sendAlertService).send(messageCaptor.capture());

        String expectedMessage = String.format("Warning, patient with id: %s, need help, cause: BT", id);
        String actualMessage = messageCaptor.getValue();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(doubles = {36.1, 36.6, 37.1})
    void testCheckTemperature_normalBT_noMessage(double temperature) {

        BigDecimal normalBTChange = BigDecimal.valueOf(temperature);
        when(patientInfoFileRepository.getById(id)).thenReturn(patientInfo);
        medicalService.checkTemperature(id, normalBTChange);

        verify(sendAlertService, never()).send(anyString());
    }
}