/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import javax.ws.rs.Path;
import com.mycompany.healthsystemapi.dao.PatientDAO;
import com.mycompany.healthsystemapi.entity.Appointment;
import com.mycompany.healthsystemapi.entity.Doctor;
import com.mycompany.healthsystemapi.entity.MedicalRecord;
import com.mycompany.healthsystemapi.entity.Patient;
import com.mycompany.healthsystemapi.entity.Prescription;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author uthsh
 */

@Path("/patient")
public class PatientResource {
    
    PatientDAO patientdao = new PatientDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Patient> getAllPatients(){
        return patientdao.getAllPatients();
    }
    
    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("personId") int patientId){
        return patientdao.getPatientById(patientId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        patientdao.addPatient(patient);
    }
    
    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("personId") int patientId, Patient updatePatient) {
        Patient existingPatient = patientdao.getPatientById(patientId);
        
        if(existingPatient !=null) {
            updatePatient.setId(patientId);
            patientdao.updatePatient(updatePatient);
        }else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }
    
    @DELETE
    @Path("/{personId}")
    public void deletePatient(@PathParam("personId") int patientId) {
        patientdao.deletePatient(patientId);
    }
    
    @GET
    @Path("/{personId}/doctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getDoctors(@PathParam("personId") int patientId) {
    ArrayList<Doctor> listOfDoctor = patientdao.getDoctors(patientId);
    Patient patient = patientdao.getPatientById(patientId); 
    patient.setDoctors(listOfDoctor);
    return patient;
    }
    
    @POST
    @Path("/{personId}/doctor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(@PathParam("personId") int patientId, Doctor doctor) {
        patientdao.addDoctor(patientId, doctor);
    }

    @DELETE
    @Path("/{personId}/doctor/{doctorId}")
    public void deleteDoctor(@PathParam("personId") int patientId, @PathParam("doctorId") int doctorId) {
        patientdao.removeDoctor(patientId, doctorId);
    }
    
    @GET
    @Path("/{personId}/appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getAppointment(@PathParam("personId") int patientId) {
        ArrayList<Appointment> listOfAppointments = patientdao.getAppointments(patientId);
        Patient patient = patientdao.getPatientById(patientId); 
        patient.setAppointments(listOfAppointments);
        return patient;
    }
    
    @POST
    @Path("/{personId}/appointment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(@PathParam("personId") int patientId, Appointment appointment) {
        patientdao.addAppointment(patientId, appointment);
    }
    
    @DELETE
    @Path("/{personId}/appointment/{appointmentId}")
    public void deleteAppointment(@PathParam("personId") int patientId, @PathParam("appointmentId") int appointmentId) {
        patientdao.removeAppointment(patientId, appointmentId);
    }
    
    @GET
    @Path("/{personId}/medicalRecord")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient geMedicalRecord(@PathParam("personId") int patientId) {
        ArrayList<MedicalRecord> listOfMedicalRcs = patientdao.getMedicalRecords(patientId);
        Patient patient = patientdao.getPatientById(patientId); 
        patient.setMedicalRecords(listOfMedicalRcs);
        return patient;
    }
    
    @POST
    @Path("/{personId}/medicalRecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedicalRecord(@PathParam("personId") int patientId, MedicalRecord medicalRecord) {
        patientdao.addMedicalRecords(patientId, medicalRecord);
    }
    
    @GET
    @Path("/{personId}/prescription")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPrescription(@PathParam("personId") int patientId) {
        ArrayList<Prescription> listOfPrescriptions = patientdao.getPrescription(patientId);
        Patient patient = patientdao.getPatientById(patientId); 
        patient.setPrescriptions(listOfPrescriptions);
        return patient;
    } 
}
