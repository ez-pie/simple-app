package ezpie.com;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/special")
public class PathResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/abc")
    public RestResponse<String> func1(@Context UriInfo uriInfo) {
        StringBuilder builder = new StringBuilder();

        builder.append("from abc:\n\n\n\n");
        return Utils.getStringRestResponse(uriInfo, builder);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/xyz")
    public RestResponse<String> func2(@Context UriInfo uriInfo) {
        StringBuilder builder = new StringBuilder();

        builder.append("from xyz:\n\n\n\n");
        return Utils.getStringRestResponse(uriInfo, builder);
    }
}
