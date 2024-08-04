/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

import java.util.ArrayList;

/**
 *
 * @author uthsh
 */
public class Patient extends Person {
    
    private String medicalHistory;
    private String healthStatus;
    
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<Prescription> prescriptions;
    
    public Patient() {
        super();
    }
    
    public Patient(int id, String name, String contactInfo, String address, String medicalHistory, String healthStatus){
        super(id, name, contactInfo, address);
        this.healthStatus = healthStatus;
        this.medicalHistory = medicalHistory;
    }
    
    public String getMedicalHistory(){
        return medicalHistory;
    }
    
    public String getHealthStatus(){
        return healthStatus;
    }
    
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
        
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    
    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }
    
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

   
    public void setMedicalHistory(String medicalHistory){
        this.medicalHistory = medicalHistory;
    }
    
    public void setHealthStatus(String healthStatus){
        this.healthStatus = healthStatus;
    }
    
    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
    
    @Override
    public int hashCode() {
        return super.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Patient other = (Patient) obj;
        return super.getId() == other.getId();
    }
}