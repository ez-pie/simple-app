package ezpie.com;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/{path:.*}")
public class EchoResource {
    private static final Logger log = Logger.getLogger(EchoResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> echo(@Context UriInfo uriInfo) {
        log.info("*** enter method...");

        StringBuilder builder = new StringBuilder();

        return Utils.getStringRestResponse(uriInfo, builder);
    }
}
