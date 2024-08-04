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
public class Doctor extends Person {
    
    private String specialization;

    private ArrayList<Patient> patients;
    
    public Doctor(){
        super();
    }
    
    public Doctor(int id, String name, String contactInfo, String address, String specialization){
        super(id, name, contactInfo, address);
        this.specialization = specialization;
    }
    
    public String getSpecialization(){
        return specialization;
    }
    
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    
    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
