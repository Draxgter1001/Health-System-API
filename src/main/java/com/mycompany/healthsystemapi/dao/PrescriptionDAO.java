/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.dao;

import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.Patient;
import com.mycompany.healthsystemapi.entity.Prescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author uthsh
 */
public class PrescriptionDAO {
    
    private static ArrayList<Prescription> prescriptions = new ArrayList<>();
    private static HashMap<Integer, Patient> prescriptionPatientMap;
    private static HashMap<Integer, Doctor> prescriptionDoctorMap;
    
    public ArrayList<Prescription> getAllPrescription(){
        return prescriptions;
    }
    
    public Prescription getPrescriptionById(int id){
        for(Prescription prescription : prescriptions){
            if(Objects.equals(prescription.getId(), id)){
                return prescription;
            }
        }
        return null;
    }
    
    public void addPrescription(Prescription prescription){
        int newUserId = getNextPrescriptionId();
        prescription.setId(newUserId + 1);
        prescriptions.add(prescription);
    }
    
    public int getNextPrescriptionId(){
        int maxUserId = 0;
        for(Prescription prescription : prescriptions){
            maxUserId = Integer.max(maxUserId, prescription.getId());
        }
        return maxUserId;
    }
    
    public void updatePrescription(Prescription prescription){
        for(int i = 0; i < prescriptions.size(); i++){
            Prescription existingPrescription = prescriptions.get(i);
            if(existingPrescription.getId() == prescription.getId()){
                prescriptions.set(i, prescription);
                System.out.println("Patient updated: " + prescription);
            }
        }
    }
    
    public void deletePrescription(int id){
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }
    
    public Patient getPatient(int patientId){
        return prescriptionPatientMap.getOrDefault(patientId, null);
    }
    
    public void addPatient(int patientId, Patient patient){
        prescriptionPatientMap.put(patientId, patient);
    }
    
    public Doctor getDoctor(int doctorId){
        return prescriptionDoctorMap.getOrDefault(doctorId, null);
    }
    
    public void addDoctor(int doctorId, Doctor doctor){
        prescriptionDoctorMap.put(doctorId, doctor);
    }
    
}
