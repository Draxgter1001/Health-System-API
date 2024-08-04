/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

/**
 *
 * @author uthsh
 */
public class Appointment {

    private int id;
    private String date;
    private String time;
    
    public Appointment(){
        
    }
    
    public Appointment(int id, String date, String time){
        this.id = id;
        this.date = date;
        this.time = time;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
 
    public void setId(int id) {
        this.id = id;
    }
}
