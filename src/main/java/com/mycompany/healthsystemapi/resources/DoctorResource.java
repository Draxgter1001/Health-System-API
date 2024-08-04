/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import com.mycompany.healthsystemapi.dao.DoctorDAO;
import com.mycompany.healthsystemapi.dao.PatientDAO;
import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.Patient;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author uthsh
 */
@Path("/doctor")
public class DoctorResource {
    
    DoctorDAO doctordao = new DoctorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Doctor> getAllDoctors(){
        return doctordao.getAllDoctors();
    }
    
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId){
        return doctordao.getDoctorById(doctorId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctor doctor) {
        doctordao.addDoctor(doctor);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{doctorId}")
    public void updateDoctor(@PathParam("doctorId") int doctorId, Doctor updateDoctor) {
        Doctor existingDoctor = doctordao.getDoctorById(doctorId);
        
        if(existingDoctor !=null) {
            updateDoctor.setId(doctorId);
            doctordao.updateDoctor(updateDoctor);
        }
    }
    
    @DELETE
    @Path("/{doctorId}")
    public void deleteDoctor(@PathParam("doctorId") int doctorId) {
        doctordao.deleteDoctor(doctorId);
    }
    
    @GET
    @Path("/{doctorId}/patient")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getPatient(@PathParam("doctorId") int doctorId) {
        ArrayList<Patient> listOfPatients = doctordao.getPatients(doctorId);
        Doctor doctor = doctordao.getDoctorById(doctorId); 
        doctor.setPatients(listOfPatients);
        return doctor;
    }
    
    @POST
    @Path("/{doctorId}/patient")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(@PathParam("doctorId") int doctorId, Patient patient) {
        doctordao.addPatient(doctorId, patient);
    }
    
    @DELETE
    @Path("/{doctorId}/patient/{patientId}")
    public void deletePatient(@PathParam("doctorId") int doctorId, @PathParam("patientId") int patientId) {
        doctordao.removePatient(doctorId, patientId);
    }
}