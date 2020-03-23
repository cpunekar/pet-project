package api.factories;

import api.impl.PetsApiServiceImpl;
import api.services.PetsApiService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-03-18T02:10:00.755Z[GMT]")public class PetsApiServiceFactory {
    private final static PetsApiService service = new PetsApiServiceImpl();

    public static PetsApiService getPetsApi() {
        return service;
    }
}
