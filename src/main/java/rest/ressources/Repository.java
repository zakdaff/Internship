package rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rest.entities.Internship;
@Path("/Internship")
@Api

public class Repository {
	static List<Internship> list = new ArrayList<Internship>();
	public Repository() {
		// TODO Auto-generated constructor stub
		this.list.add(new Internship("ref1", "backend developer", "Focus",6));
		this.list.add(new Internship("ref2", "Blockchain developer", "IBM",5));

	}
	
	@ApiOperation(value= "Get Internship")
	@GET
	@Path("/list")
	@Produces("application/json")

	public Response getAllInternship() {
		return Response.status(200).entity(list).build(); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value= "add Internship")

	public Response addInternship(Internship internship) {
		this.list.add(internship);
		return Response.status(201).entity("Added").build(); 
	}
	
	
	@ApiOperation(value= "update Internship")	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateInternship(Internship i) {
		int index = getIndexById(i.getId());

		if (index != -1) {
			list.set(index, i);
			return Response.status(Status.OK).entity("update successful").build();
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	}
	
	
	@ApiOperation(value= "delete Internship")
	@DELETE
	@Path("{id}")
	public Response deleteInternship(@PathParam(value="id") String id) {
		int index = getIndexById(id);
		if (index != -1) {
			this.list.remove(index);
			return Response.status(Status.OK).entity(true).build();
		} else
			return Response.status(Status.NOT_ACCEPTABLE).entity(false).build();
	}

	public int getIndexById(String id) {
		for (Internship i : this.list) {
			if (i.getId().equals(id))
				return this.list.indexOf(i);
		}
		return -1;
	}


}
