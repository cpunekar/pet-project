package api.impl;

import model.*;

import java.util.Map;
import java.util.Random;
import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import api.services.ApiResponseMessage;
import api.services.NotFoundException;
import api.services.PetsApiService;
import common.PetServiceHandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-03-18T02:10:00.755Z[GMT]")

public class PetsApiServiceImpl extends PetsApiService {
	PetServiceHandler petServiceHandler = PetServiceHandler.getInstance();

	@Override
	public Response addPet(Pet body, SecurityContext securityContext) throws NotFoundException {
		Response result = null;
		try {
			String name = body.getName();
			String tag = body.getTag();

			Pet response = petServiceHandler.addPet(name, tag);
			result = Response.status(Response.Status.OK).entity(response).build();
		} catch (Exception e) {
			System.out.printf("Failed to call addPet", e);
		}
		return result;
	}

	@Override
	public Response deletePet(Long id, SecurityContext securityContext) throws NotFoundException {
		// do some magic!
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
	}

	@Override
	public Response findPetById(Long id, SecurityContext securityContext) throws NotFoundException {
		Response result = null;
		try {
			List<Pet> response = petServiceHandler.getPetById(id);
			result = Response.status(Response.Status.OK).entity(response).build();
		} catch (Exception e) {
			System.out.printf("Failed to get pet by id", e);
		}
		return result;
	}

	@Override
	public Response findPets(SecurityContext securityContext) throws NotFoundException {
		Response result = null;
		try {
			List<Pet> response = petServiceHandler.getPet();
			result = Response.status(Response.Status.OK).entity(response).build();
		} catch (Exception e) {
			System.out.printf("Failed to get", e);
		}
		return result;
	}
}
