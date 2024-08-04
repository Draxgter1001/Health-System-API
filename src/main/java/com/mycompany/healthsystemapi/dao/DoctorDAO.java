/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.dao;

import com.mycompany.healthsystemapi.entity.Appointment;
import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.Patient;
import com.mycompany.healthsystemapi.entity.Prescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author uthsh
 */
public class DoctorDAO {
 
    private PatientDAO  patientdao = new PatientDAO();
    
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Patient>> doctorPatientMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<Appointment>> doctorAppointmentMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<Prescription>> doctorPrescriptionMap = new HashMap<>();

    public ArrayList<Doctor> getAllDoctors(){
        return doctors;
    }
    
    public Doctor getDoctorById(int id){
        for(Doctor doctor : doctors){
            if(Objects.equals(doctor.getId(), id)){
                return doctor;
            }
        }
        return null;
    }
    
    public void addDoctor(Doctor doctor){
        int newUserId = getNextDoctortId();
        doctor.setId(newUserId + 1);
        doctors.add(doctor);
    }
    
    public int getNextDoctortId(){
        int maxUserId = 0;
        
        for(Doctor doctor : doctors) {
            maxUserId = Integer.max(maxUserId, doctor.getId());
        }
        return maxUserId;
    }
    
    public void updateDoctor(Doctor doctor){
        for(int i = 0; i < doctors.size(); i++){
            Doctor existingDoctor = doctors.get(i);
            if(existingDoctor.getId() == doctor.getId()){
                doctors.set(i, doctor);
                System.out.println("Doctor updated: " + doctor);
            }
        }
    }
    
    public void deleteDoctor(int id){
        doctors.removeIf(doctor -> doctor.getId() == id);
    }
    
    public ArrayList<Patient> getPatients(int doctorId) {
        return doctorPatientMap.getOrDefault(doctorId, null);
    }
    
    public void addPatient(int doctorId, Patient patient) {
        ArrayList<Patient> patientAdds = new ArrayList<>();
        int patientId = patientdao.getNextPatientId() + 1;
        patient.setId(patientId);
        patientAdds.add(patient);
        if(doctorPatientMap.containsKey(doctorId)){
            doctorPatientMap.get(doctorId).add(patient);
        } else{
            doctorPatientMap.put(doctorId, patientAdds);
        }
        patientdao.addPatient(patient);
    }
    
    public void removePatient(int doctorId, int patientId){
        if (doctorPatientMap.containsKey(doctorId)) {
            ArrayList<Patient> patients = doctorPatientMap.get(doctorId);
            Iterator<Patient> iterator = patients.iterator();
            while (iterator.hasNext()) {
                Patient patient = iterator.next();

                if (patient.getId() == patientId) {
                    iterator.remove();
                    Doctor doctor = getDoctorById(doctorId);
                    doctor.setPatients(patients); 
                    patientdao.deletePatient(patientId);
                    return; 
                }
            }

            System.out.println("Patient with ID " + patientId + " does not exist for doctor with ID " + doctorId);
        } else {
            System.out.println("Doctor with ID " + doctorId + " does not exist");
        }
    }
    
    public ArrayList<Appointment> getAppointments(int doctorId){
        return doctorAppointmentMap.getOrDefault(doctorId, null);
    }
    
    public void addAppointment(int doctorId, Appointment appointment){
        doctorAppointmentMap.getOrDefault(doctorId, new ArrayList<>());
        doctorAppointmentMap.get(doctorId).add(appointment);
    }
    
    public void removeAppointment(int doctorId, Appointment appointment){
        boolean idExist = false;
        for(Doctor doctor : doctors){
            if(doctor.getId() == doctorId){
                idExist = true;
            }
        }
        if(idExist){
            doctorAppointmentMap.get(doctorId).remove(appointment);
        }else{
            System.out.println("Appointment ID does not exist.");
        }
    }
    
    public ArrayList<Prescription> getPrescription(int doctorId){
        return doctorPrescriptionMap.getOrDefault(doctorId, null);
    }
    
    public void addPrescription(int doctorId, Prescription prescription){
        doctorPrescriptionMap.getOrDefault(doctorId, new ArrayList<>());
        doctorPrescriptionMap.get(doctorId).add(prescription);
    }
    
    public void removePrescriptiont(int doctorId, Prescription prescription){
        boolean idExist = false;
        for(Doctor doctor : doctors){
            if(doctor.getId() == doctorId){
                idExist = true;
            }
        }
        if(idExist){
            doctorPrescriptionMap.get(doctorId).remove(prescription);
        }else{
            System.out.println("Prescription ID does not exist.");
        }
    }
    
}