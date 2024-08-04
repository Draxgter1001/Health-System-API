/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.config;

/**
 *
 * @author uthsh
 */

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class AppConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(com.mycompany.healthsystemapi.resources.PatientResource.class);
        classes.add(com.mycompany.healthsystemapi.resources.DoctorResource.class);
        classes.add(com.mycompany.healthsystemapi.resources.AppointmentResource.class);
        classes.add(com.mycompany.healthsystemapi.resources.BillingResource.class);
        classes.add(com.mycompany.healthsystemapi.resources.MedicalRecordResource.class);
        classes.add(com.mycompany.healthsystemapi.resources.PrescriptionResource.class);
        return classes;
    }
}
