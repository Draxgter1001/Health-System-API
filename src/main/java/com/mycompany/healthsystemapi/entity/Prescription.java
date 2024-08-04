/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

/**
 *
 * @author uthsh
 */
public class Prescription {
 
    private int id;
    private String medicationName;
    private String dosage;
    private String instruction;
    private String duration;
    private Patient patient;
    
    public Prescription(){
        
    }
    
    public Prescription(int id, String medicationName, String dosage, String instruction, String duration){
        this.id = id;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.instruction = instruction;
        this.duration = duration;
    }
    
    public int getId(){
        return id;
    }
    
    public String getMedicationName() {
        return medicationName;
    }
   
    public String getDosage(){
       return dosage;
    }
   
    public String getInstruction(){
       return instruction;
    }
   
    public String getDuration(){
       return duration;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}