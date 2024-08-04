/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.dao;

import com.mycompany.healthsystemapi.entity.Appointment;
import com.mycompany.healthsystemapi.entity.Billing;
import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author uthsh
 */
public class BillingDAO {
    private static ArrayList<Billing> billings = new ArrayList<>();
    private static HashMap<Integer, Patient> billingPatientMap;
    private static HashMap<Integer, Doctor> billingDoctorMap;
    private static HashMap<Integer, Appointment> billingAppointmentMap;
    
    public ArrayList<Billing> getAllBillings(){
        return billings;
    }
    
    public Billing getBillingById(int id){
        for(Billing billing : billings){
            if(Objects.equals(billing.getId(), id)){
                return billing;
            }
        }
        return null;
    }
    
    public void addBilling(Billing billing){
        int newUserId = getNextBillingId();
        billing.setId(newUserId);
        billings.add(billing);
    }
    
    public int getNextBillingId(){
        int maxUserId = 0;
        for(Billing billing : billings){
            if (billing.getId() > maxUserId) { 
                maxUserId = billing.getId();
            }
        }

        return maxUserId + 1; 
    }
    
    public void updateBilling(Billing billing){
        for(int i = 0; i < billings.size(); i++){
            Billing existingBilling = billings.get(i);
            if(existingBilling.getId() == billing.getId()){
                billings.set(i, billing);
                System.out.println("Patient updated: " + billing);
            }
        }
    }
    
    public void deleteBilling(int id){
        billings.removeIf(billing -> billing.getId() == id);
    }
    
    public Patient getPatient(int patientId){
        return billingPatientMap.getOrDefault(patientId, null);
    }
    
    public void addPatient(int patientId, Patient patient){
        billingPatientMap.put(patientId, patient);
    }
    
    public Doctor getDoctor(int doctorId){
        return billingDoctorMap.getOrDefault(doctorId, null);
    }
    
    public void addDoctor(int doctorId, Doctor doctor){
        billingDoctorMap.put(doctorId, doctor);
    }
    
    public Appointment getAppointment(int appointmentId){
        return billingAppointmentMap.getOrDefault(appointmentId, null);
    }
    
    public void addAppointment(int appointmentId, Appointment appointment){
        billingAppointmentMap.put(appointmentId, appointment);
    }
    
}