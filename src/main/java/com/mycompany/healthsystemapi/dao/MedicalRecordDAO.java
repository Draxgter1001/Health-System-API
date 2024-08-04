/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.dao;

import com.mycompany.healthsystemapi.entity.MedicalRecord;
import com.mycompany.healthsystemapi.entity.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author uthsh
 */
public class MedicalRecordDAO {
    
    private static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private static HashMap<Integer, Patient> medicalRecordPatientMap;
    
    public ArrayList<MedicalRecord> getAllMedicalRecord(){
        return medicalRecords;
    }
    
    public MedicalRecord getMedicalRecordById(int id){
        for(MedicalRecord medicalRecord : medicalRecords){
            if(Objects.equals(medicalRecord.getId(), id)){
                return medicalRecord;
            }
        }
        return null;
    }
    
    public void addMedicalRecord(MedicalRecord medicalRecord){
        int newUserId = getNextMedicalRecordId();
        medicalRecord.setId(newUserId + 1);
        medicalRecords.add(medicalRecord);
    }
    
    public int getNextMedicalRecordId(){
        int maxUserId = 0;
        
        for(MedicalRecord medicalRecord : medicalRecords) {
            maxUserId = Integer.max(maxUserId, medicalRecord.getId());
        }
        return maxUserId;
    }
    
    public void updateMedicalRecord(MedicalRecord medicalRecord){
        for(int i = 0; i < medicalRecords.size(); i++){
            MedicalRecord existingMedicalRecord = medicalRecords.get(i);
            if(existingMedicalRecord.getId() == medicalRecord.getId()){
                medicalRecords.set(i, medicalRecord);
                System.out.println("Patient updated: " + medicalRecord);
            }
        }
    }
    
    public void deleteMedicalRecord(int id){
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }
    
    public Patient getPatient(int patientId){
        return medicalRecordPatientMap.getOrDefault(patientId, null);
    }
    
    public void addPatient(int patientId, Patient patient){
        medicalRecordPatientMap.put(patientId, patient);
    }
}
