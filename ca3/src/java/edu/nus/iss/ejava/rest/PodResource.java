package edu.nus.iss.ejava.rest;

import edu.nus.iss.ejava.business.PackageService;
import edu.nus.iss.ejava.model.Delivery;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/pod")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PodResource {
    @EJB private PackageService pService;
    
    @GET
    @Path("/items")
    public Response getDeliveries(){
        Response.ResponseBuilder builder;
        List<Delivery> lstDelivery = pService.findAllDeliveries();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Delivery delivery: lstDelivery) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("teamId", "874f8a2d");
            objectBuilder.add("podId", delivery.getPod().getId());
            objectBuilder.add("name", delivery.getName());
            objectBuilder.add("address", delivery.getAddress());
            objectBuilder.add("phone", delivery.getPhone());
            arrayBuilder.add(objectBuilder.build());
        }
        builder = (Response.status(Response.Status.OK).entity(arrayBuilder.build()));
	return builder.build();
    }
//    
//    @POST
//    @Path("/appointment/add")
//    public Response addAppointment(final JsonObject apptForm) {
//	Response.ResponseBuilder builder;
//        if (!peopleBean.isPeopleExist(apptForm.getString("email"))) {
//            JsonObject json = Json.createObjectBuilder()
//                            .add("msg", "The user with email "+apptForm.getString("email")+" haven't registered.")
//                            .build();
//            builder = Response.status(Response.Status.NOT_FOUND).entity(json);
//        } else {
//            People people = peopleBean.getPeopleByEmail(apptForm.getString("email"));
//            Appointment app = new Appointment();
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date date = sdf.parse(apptForm.getString("appt-date"));
//                app.setApptDate(date);
//            } catch(Exception e){e.printStackTrace();}
//            app.setDescription(apptForm.getString("description"));
//            app.setPeople(people);
//            peopleBean.addAppointment(app);
//            builder = Response.status(Response.Status.CREATED);
//        }
//	return builder.build();
//    }
//    
//    @POST
//    @Path("/appointment")
//    public Response getAllAppointments(final JsonObject form) {
//	Response.ResponseBuilder builder;
//        if (!peopleBean.isPeopleExist(form.getString("email"))) {
//            JsonObject json = Json.createObjectBuilder()
//                            .add("msg", "The user with email "+form.getString("email")+" haven't registered.")
//                            .build();
//            builder = Response.status(Response.Status.NOT_FOUND).entity(json);
//        } else {
//            JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
//            List<Appointment> listAppt = peopleBean.findAppointmentByPeople(form.getString("email"));
//            listAppt.forEach((appt) -> {
//                arrBuilder.add(appt.toJSON());
//            });
//            builder = (Response.status(Response.Status.OK).entity(arrBuilder.build()));
//        }
//        return builder.build();
//    }
}
