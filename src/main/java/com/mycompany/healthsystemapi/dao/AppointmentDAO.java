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
public class AppointmentDAO {
    
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static HashMap<Integer, Patient> appointmentPatientMap;
    private static HashMap<Integer, Doctor> appointmentDoctorMap;
    private static HashMap<Integer, Billing> appointmentBillingMap;

    public ArrayList<Appointment> getAllAppointments(){
        return appointments;
    }
    
    public Appointment getAppointmentById(int id){
        for(Appointment appointment : appointments){
            if(Objects.equals(appointment.getId(), id)){
                return appointment;
            }
        }
        return null;
    }
    
    public void addAppointment(Appointment appointment){
        int newUserId = getNextAppointmentId();
        appointment.setId(newUserId + 1);
        appointments.add(appointment);
    }
    
    public int getNextAppointmentId(){
        int maxUserId = 0;
        
        for(Appointment appointment : appointments) {
            maxUserId = Integer.max(maxUserId, appointment.getId());
        }
        return maxUserId;
    }
    
    public void updateAppointment(Appointment appointment){
        for(int i = 0; i < appointments.size(); i++){
            Appointment existingAppointment = appointments.get(i);
            if(existingAppointment.getId() == appointment.getId()){
                appointments.set(i, appointment);
                System.out.println("Patient updated: " + appointment);
            }
        }
    }
    
    public void deleteAppointment(int id){
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
    
    public Patient getPatient(int patientId){
        return appointmentPatientMap.getOrDefault(patientId, null);
    }
    
    public void addPatient(int patientId, Patient patient){
        appointmentPatientMap.put(patientId, patient);
    }
    
    public Doctor getDoctor(int doctorId){
        return appointmentDoctorMap.getOrDefault(doctorId, null);
    }
    
    public void addDoctor(int doctorId, Doctor doctor){
        appointmentDoctorMap.put(doctorId, doctor);
    }
    
    public Billing getBilling(int billingId){
        return appointmentBillingMap.getOrDefault(billingId, null);
    }
    
    public void addBilling(int billingId, Billing billing){
        appointmentBillingMap.put(billingId, billing);
    }
}