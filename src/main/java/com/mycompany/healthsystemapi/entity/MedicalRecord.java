/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

/**
 *
 * @author uthsh
 */
public class MedicalRecord {

    private int id;
    private String diagnoses;
    private String treatment;
    
    public MedicalRecord(){
        
    }
    
    public MedicalRecord(int id, String diagnoses, String treatment){
        this.id = id;
        this.diagnoses = diagnoses;
        this.treatment = treatment;
    }
    
    public int getId(){
        return id;
    }
    
    public String getDiagnoses(){
        return diagnoses;
    }
    
    public String getTreatment(){
        return treatment;
    }
    
    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}