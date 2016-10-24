/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.ejava.rest;

import edu.nus.iss.ejava.business.PeopleManagementBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/people")
public class ManagePeopleResource {
    @EJB private PeopleManagementBean peopleBean;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addPeople() {
	return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/appointment/add")
    public Response addAppointment() {
	return Response.ok().build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/appointment")
    public Response getAllAppointments() {
	return Response.ok().build();
    }
}
