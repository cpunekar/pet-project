package api.services;

import model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import api.services.NotFoundException;

import java.util.Map;
import java.util.List;
import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-03-18T02:10:00.755Z[GMT]")public abstract class PetsApiService {
   
    public abstract Response deletePet(Long id,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response findPetById(Long id,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response findPets(SecurityContext securityContext) throws NotFoundException;

	public abstract Response addPet(Pet body, SecurityContext securityContext) throws NotFoundException;
}
