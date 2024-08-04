/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.resources;

import com.mycompany.healthsystemapi.dao.AppointmentDAO;
import com.mycompany.healthsystemapi.entity.Appointment;
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
@Path("/appointment")
public class AppointmentResource {
    
    AppointmentDAO appointmentdao = new AppointmentDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Appointment> getAllAppointments(){
        return appointmentdao.getAllAppointments();
    }
    
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId){
        return appointmentdao.getAppointmentById(appointmentId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment appointment) {
        appointmentdao.addAppointment(appointment);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{appointmentId}")
    public void updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updateAppointment) {
        Appointment existingAppointment = appointmentdao.getAppointmentById(appointmentId);
        
        if(existingAppointment !=null) {
            updateAppointment.setId(appointmentId);
            appointmentdao.updateAppointment(updateAppointment);
        }
    }
    
    @DELETE
    @Path("/{appointmentId}")
    public void deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        appointmentdao.deleteAppointment(appointmentId);
    }
}
