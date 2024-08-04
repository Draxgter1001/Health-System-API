/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import com.mycompany.healthsystemapi.dao.MedicalRecordDAO;
import com.mycompany.healthsystemapi.entity.MedicalRecord;
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
@Path("/medicalrecords")
public class MedicalRecordResource {
    MedicalRecordDAO medicalRecordsdao = new MedicalRecordDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordsdao.getAllMedicalRecord();
    }
    
    @GET
    @Path("/{medicalrecordsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordsById(@PathParam("medicalrecordId") int medicalrecordId) {
        return medicalRecordsdao.getMedicalRecordById(medicalrecordId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordsdao.addMedicalRecord(medicalRecord);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{medicalrecordsId}")
    public void updateMedicalRecord(@PathParam("medicalrecordsId") int medicalrecordsId, MedicalRecord updateMedicalRecords) {
        MedicalRecord existingMedicalRecord = medicalRecordsdao.getMedicalRecordById(medicalrecordsId);
        
        if(existingMedicalRecord !=null) {
            updateMedicalRecords.setId(medicalrecordsId);
            medicalRecordsdao.updateMedicalRecord(updateMedicalRecords);
        }
    }
    
    @DELETE
    @Path("/{medicalrecordsId}")
    public void deleteMedicalRecordsId(@PathParam("medicalrecordsId") int medicalrecordsId) {
        medicalRecordsdao.deleteMedicalRecord(medicalrecordsId);
    }
}
