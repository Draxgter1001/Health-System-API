/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import com.mycompany.healthsystemapi.dao.PrescriptionDAO;
import com.mycompany.healthsystemapi.entity.Prescription;
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
@Path("/prescription")
public class PrescriptionResource {
    
    PrescriptionDAO prescriptiondao = new PrescriptionDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Prescription> getAllPrescriptions() {
        return prescriptiondao.getAllPrescription();
    }
    
    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) {
        return prescriptiondao.getPrescriptionById(prescriptionId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescription(Prescription prescription) {
        prescriptiondao.addPrescription(prescription);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{prescriptionId}")
    public void updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatePrescription) {
        Prescription existingPrescription = prescriptiondao.getPrescriptionById(prescriptionId);
        
        if(existingPrescription !=null) {
            updatePrescription.setId(prescriptionId);
            prescriptiondao.updatePrescription(updatePrescription);
        }
    }
    
    @DELETE
    @Path("/{prescriptionId}")
    public void deletePrescriptionId(@PathParam("prescriptionId") int prescriptionId) {
        prescriptiondao.deletePrescription(prescriptionId);
    }
}
