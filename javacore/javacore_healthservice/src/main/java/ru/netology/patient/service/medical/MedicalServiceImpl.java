package ru.netology.patient.service.medical;

import java.math.BigDecimal;

import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoRepository;
import ru.netology.patient.service.alert.SendAlertService;

public class MedicalServiceImpl implements MedicalService {

    private final PatientInfoRepository patientInfoRepository;
    private final SendAlertService alertService;

    public MedicalServiceImpl(PatientInfoRepository patientInfoRepository, SendAlertService alertService) {
        this.patientInfoRepository = patientInfoRepository;
        this.alertService = alertService;
    }

    @Override
    public void checkBloodPressure(String patientId, BloodPressure patientsCurrentBP) {
        PatientInfo patientInfo = getPatientInfo(patientId);

        int patientsNormalSBP = patientInfo.getHealthInfo().getBloodPressure().getHigh();
        int patientsNormalDBP = patientInfo.getHealthInfo().getBloodPressure().getLow();
        int patientsCurrentSBP = patientsCurrentBP.getHigh();
        int patientsCurrentDBP = patientsCurrentBP.getLow();
        int actualSBPDifference = Math.abs(patientsNormalSBP - patientsCurrentSBP);
        int actualDBPDifference = Math.abs(patientsNormalDBP - patientsCurrentDBP);
        final int NORMAL_BP_DIFFERENCE = 5;

        if (actualSBPDifference > NORMAL_BP_DIFFERENCE || actualDBPDifference > NORMAL_BP_DIFFERENCE) {
            String message = String.format("Warning, patient with id: %s, need help, cause: BP", patientInfo.getId());
            alertService.send(message);
        }
    }

    @Override
    public void checkTemperature(String patientId, BigDecimal patientsCurrentBT) {

        PatientInfo patientInfo = getPatientInfo(patientId);
        BigDecimal patientsNormalBT = patientInfo.getHealthInfo().getNormalTemperature();
        BigDecimal actualBTDifference = patientsNormalBT.subtract(patientsCurrentBT);
        final BigDecimal NORMAL_BT_DIFFERENCE = new BigDecimal("0.5");

        if (actualBTDifference.abs().compareTo(NORMAL_BT_DIFFERENCE) > 0 ) {
            String message = String.format("Warning, patient with id: %s, need help, cause: BT", patientInfo.getId());
            alertService.send(message);
        }
    }

    private PatientInfo getPatientInfo(String patientId) {
        PatientInfo patientInfo = patientInfoRepository.getById(patientId);
        if (patientInfo == null) {
            throw new RuntimeException("Patient not found");
        }
        return patientInfo;
    }
}
