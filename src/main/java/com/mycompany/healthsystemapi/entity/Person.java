/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

/**
 *
 * @author uthsh
 */
public abstract class Person {

    private int id;
    private String name;
    private String contactInfo;
    private String address;
    
    public Person() {
        
    }
    
    public Person(int id, String name, String contactInfo, String address){
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getContactInfo(){
        return contactInfo;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}