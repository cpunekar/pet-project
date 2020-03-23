package api.services;

import model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import model.Error;
import model.Pet;

import java.util.Map;
import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import api.factories.PetsApiServiceFactory;
import api.services.NotFoundException;
import api.services.PetsApiService;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/pets")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-03-18T02:10:00.755Z[GMT]")public class PetsApi  {
   private final PetsApiService delegate;

   public PetsApi(@Context ServletConfig servletContext) {
      PetsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PetsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PetsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PetsApiServiceFactory.getPetsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Creates a new pet in the store. Duplicates are allowed", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "pet response", content = @Content(schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(schema = @Schema(implementation = Error.class))) })
    public Response addPet(@Parameter(in = ParameterIn.DEFAULT, description = "Pet to add to the store" ,required=true) Pet body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addPet(body,securityContext);
    }
    
    
    @DELETE
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "deletes a single pet based on the ID supplied", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "pet deleted"),
        
        @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(schema = @Schema(implementation = Error.class))) })
    public Response deletePet(@Parameter(in = ParameterIn.PATH, description = "ID of pet to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePet(id,securityContext);
    }
    
    
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Returns a user based on a single ID, if the user does not have access to the pet", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "pet response", content = @Content(schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(schema = @Schema(implementation = Error.class))) })
    public Response findPetById(@Parameter(in = ParameterIn.PATH, description = "ID of pet to fetch",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findPetById(id,securityContext);
    }
    
    
    @GET
    @Produces({ "application/json" })
    @Operation(summary = "", description = "Returns all pets from the system that the user has access to Nam sed condimentum est. Maecenas tempor sagittis sapien, nec rhoncus sem sagittis sit amet. Aenean at gravida augue, ac iaculis sem. Curabitur odio lorem, ornare eget elementum nec, cursus id lectus. Duis mi turpis, pulvinar ac eros ac, tincidunt varius justo. In hac habitasse platea dictumst. Integer at adipiscing ante, a sagittis ligula. Aenean pharetra tempor ante molestie imperdiet. Vivamus id aliquam diam. Cras quis velit non tortor eleifend sagittis. Praesent at enim pharetra urna volutpat venenatis eget eget mauris. In eleifend fermentum facilisis. Praesent enim enim, gravida ac sodales sed, placerat id erat. Suspendisse lacus dolor, consectetur non augue vel, vehicula interdum libero. Morbi euismod sagittis libero sed lacinia. Sed tempus felis lobortis leo pulvinar rutrum. Nam mattis velit nisl, eu condimentum ligula luctus nec. Phasellus semper velit eget aliquet faucibus. In a mattis elit. Phasellus vel urna viverra, condimentum lorem id, rhoncus nibh. Ut pellentesque posuere elementum. Sed a varius odio. Morbi rhoncus ligula libero, vel eleifend nunc tristique vitae. Fusce et sem dui. Aenean nec scelerisque tortor. Fusce malesuada accumsan magna vel tempus. Quisque mollis felis eu dolor tristique, sit amet auctor felis gravida. Sed libero lorem, molestie sed nisl in, accumsan tempor nisi. Fusce sollicitudin massa ut lacinia mattis. Sed vel eleifend lorem. Pellentesque vitae felis pretium, pulvinar elit eu, euismod sapien. ", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "pet response", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),
        
        @ApiResponse(responseCode = "200", description = "unexpected error", content = @Content(schema = @Schema(implementation = Error.class))) })
    public Response findPets(@Parameter(in = ParameterIn.QUERY, description = "tags to filter by") @QueryParam("tags") List<String> tags
,@Parameter(in = ParameterIn.QUERY, description = "maximum number of results to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findPets(securityContext);
    }
}
