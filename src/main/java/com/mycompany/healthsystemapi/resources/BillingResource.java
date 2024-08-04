/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import com.mycompany.healthsystemapi.dao.BillingDAO;
import com.mycompany.healthsystemapi.entity.Billing;
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
@Path("/billing")
public class BillingResource {
    
    BillingDAO billingdao = new BillingDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Billing> getAllBillings(){
        return billingdao.getAllBillings();
    }
    
    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getAppointmentById(@PathParam("billingId") int billingId){
        return billingdao.getBillingById(billingId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBilling(Billing billing) {
        billingdao.addBilling(billing);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{billingId}")
    public void updateBilling(@PathParam("billingId") int billingId, Billing updateBilling) {
        Billing existingBilling = billingdao.getBillingById(billingId);
        
        if(existingBilling !=null) {
            updateBilling.setId(billingId);
            billingdao.updateBilling(updateBilling);
        }
    }
    
    @DELETE
    @Path("/{billingId}")
    public void deleteBilling(@PathParam("billingId") int billingId) {
        billingdao.deleteBilling(billingId);
    }
}
