/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.dao;

import com.mycompany.healthsystemapi.entity.Appointment;
import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.MedicalRecord;
import com.mycompany.healthsystemapi.entity.Patient;
import com.mycompany.healthsystemapi.entity.Prescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author uthsh
 */
public class PatientDAO {

    private DoctorDAO doctordao = new DoctorDAO();
    private AppointmentDAO appointmentdao = new AppointmentDAO();
    private MedicalRecordDAO medicalrecorddao = new MedicalRecordDAO();
    private PrescriptionDAO prescriptiondao = new PrescriptionDAO();
    
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Doctor>> patientDoctortMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<Appointment>> patientAppointmentMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<MedicalRecord>> patientMedicalMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<Prescription>> patientPrescriptionMap = new HashMap<>();

    public ArrayList<Patient> getAllPatients(){
        return patients;
    }
    
    public Patient getPatientById(int id){
        for(Patient patient : patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }
    
    public void addPatient(Patient patient){
        int newUserId = getNextPatientId();
        patient.setId(newUserId);
        patients.add(patient);
    }
    
    public int getNextPatientId(){
        int maxUserId = 0;
        for(Patient patient : patients){
            if (patient.getId() > maxUserId) { 
                maxUserId = patient.getId();
            }
        }

        return maxUserId + 1; 
    }
    
    public void updatePatient(Patient patient){
        for(int i = 0; i < patients.size(); i++){
            Patient existingPatient = patients.get(i);
            if(existingPatient.getId() == patient.getId()){
                patients.set(i, patient);
                System.out.println("Patient updated: " + patient);
            }
        }
    }
    
    public void deletePatient(int id){
        patients.removeIf(patient -> patient.getId() == id);
    }
    
    public ArrayList<Doctor> getDoctors(int patientId) {
        return patientDoctortMap.getOrDefault(patientId, new ArrayList<>());
    }
    
    public void addDoctor(int patientId, Doctor doctor) {
        ArrayList<Doctor> doctorsAdd = new ArrayList<>();
        int doctorId = doctordao.getNextDoctortId() + 1;
        doctor.setId(doctorId);
        doctorsAdd.add(doctor);
        if(patientDoctortMap.containsKey(patientId)){
            patientDoctortMap.get(patientId).add(doctor);
        } else{
            patientDoctortMap.put(patientId, doctorsAdd);
        }
        doctordao.addDoctor(doctor);
    }
    
    public void removeDoctor(int patientId, int doctorId) {
        if (patientDoctortMap.containsKey(patientId)) {
            ArrayList<Doctor> doctors = patientDoctortMap.get(patientId);
            Iterator<Doctor> iterator = doctors.iterator();
            while (iterator.hasNext()) {
                Doctor doctor = iterator.next();

                if (doctor.getId() == doctorId) {
                    iterator.remove();
                    Patient patient = getPatientById(patientId);
                    patient.setDoctors(doctors); 
                    doctordao.deleteDoctor(doctorId);
                    return; 
                }
            }

            System.out.println("Doctor with ID " + doctorId + " does not exist for patient with ID " + patientId);
        } else {
            System.out.println("Patient with ID " + patientId + " does not exist");
        }
    }
    
    public ArrayList<Appointment> getAppointments(int patientId){
        return patientAppointmentMap.getOrDefault(patientId, new ArrayList<>());
    }
    
    public void addAppointment(int patientId, Appointment appointment){
        ArrayList<Appointment> appointmentsAdd = new ArrayList<>();
        int appointmentId = appointmentdao.getNextAppointmentId() + 1;
        appointment.setId(appointmentId);
        appointmentsAdd.add(appointment);
        if(patientAppointmentMap.containsKey(patientId)){
            patientAppointmentMap.get(patientId).add(appointment);
        } else{
            patientAppointmentMap.put(patientId, appointmentsAdd);
        }
        appointmentdao.addAppointment(appointment);
    }
    
    public void removeAppointment(int patientId, int appointmentId){
        if (patientAppointmentMap.containsKey(patientId)) {
            ArrayList<Appointment> appointments = patientAppointmentMap.get(patientId);
            Iterator<Appointment> iterator = appointments.iterator();
            while (iterator.hasNext()) {
                Appointment appointment = iterator.next();

                if (appointment.getId() == appointmentId) {
                    iterator.remove();
                    Patient patient = getPatientById(patientId);
                    patient.setAppointments(appointments); 
                    appointmentdao.deleteAppointment(appointmentId);
                    return; 
                }
            }

            System.out.println("Doctor with ID " + appointmentId + " does not exist for patient with ID " + patientId);
        } else {
            System.out.println("Patient with ID " + patientId + " does not exist");
        }
    }
    
    public ArrayList<MedicalRecord> getMedicalRecords(int patientId){
        return patientMedicalMap.getOrDefault(patientId, null);
    }
    
    public void addMedicalRecords(int patientId, MedicalRecord medicalRecord){
        ArrayList<MedicalRecord> medicalRcAdds = new ArrayList<>();
        int medicalRecordId = medicalrecorddao.getNextMedicalRecordId() + 1;
        medicalRecord.setId(medicalRecordId);
        medicalRcAdds.add(medicalRecord);
        if(patientMedicalMap.containsKey(patientId)){
            patientMedicalMap.get(patientId).add(medicalRecord);
        } else{
            patientMedicalMap.put(patientId, medicalRcAdds);
        }
        medicalrecorddao.addMedicalRecord(medicalRecord);
    }
    
    public ArrayList<Prescription> getPrescription(int patientId){
        return patientPrescriptionMap.getOrDefault(patientId, null);
    }
    
    public void addPrescription(int patientId, Prescription prescription){
        ArrayList<Prescription> prescriptionsAdd = new ArrayList<>();
        int prescriptionId = prescriptiondao.getNextPrescriptionId() + 1;
        prescription.setId(prescriptionId);
        prescriptionsAdd.add(prescription);
        if(patientPrescriptionMap.containsKey(patientId)){
            patientPrescriptionMap.get(patientId).add(prescription);
        } else{
            patientPrescriptionMap.put(patientId, prescriptionsAdd);
        }
        prescriptiondao.addPrescription(prescription);
    }    
}