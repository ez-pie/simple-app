package ezpie.com;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.stream.Collectors;

@Path("/{path:.*}")
public class EchoResource {
    private static final Logger log = Logger.getLogger(EchoResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> echo(@Context UriInfo uriInfo) {
        log.info("*** enter method...");

        StringBuilder builder = new StringBuilder();

        builder.append("getBaseUri:\n" + uriInfo.getBaseUri() + "\n\n");
        builder.append("getRequestUri:\n" + uriInfo.getRequestUri() + "\n\n");
        builder.append("getAbsolutePath:\n" + uriInfo.getAbsolutePath() + "\n\n");
        builder.append("getPath:\n" + uriInfo.getPath() + "\n\n");
        builder.append("path segments:\n"
                + uriInfo.getPathSegments().stream().map(Object::toString).collect(Collectors.joining(","))
                + "\n\n");

        String str = builder.toString();

        log.info("*** builder result:\n" + str);

        return RestResponse
                .ResponseBuilder
                .ok(str)
                .build();
    }
}
