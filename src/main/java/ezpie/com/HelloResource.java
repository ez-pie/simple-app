package ezpie.com;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.stream.Collectors;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/sayHello")
    public RestResponse<String> sayHello() {
        return RestResponse
                .ResponseBuilder
                .ok("Hello World!")
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/baseUri")
    public RestResponse<String> baseUri(@Context UriInfo uriInfo) {
        return RestResponse
                .ResponseBuilder
                .ok(uriInfo.getBaseUri().toString())
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/requestUri")
    public RestResponse<String> requestUri(@Context UriInfo uriInfo) {
        return RestResponse
                .ResponseBuilder
                .ok(uriInfo.getRequestUri().toString())
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/absolutePath")
    public RestResponse<String> absolutePath(@Context UriInfo uriInfo) {
        return RestResponse
                .ResponseBuilder
                .ok(uriInfo.getAbsolutePath().toString())
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/path")
    public RestResponse<String> path(@Context UriInfo uriInfo) {
        return RestResponse
                .ResponseBuilder
                .ok(uriInfo.getPath())
                .build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/pathSegments")
    public RestResponse<String> pathSegments(@Context UriInfo uriInfo) {
        return RestResponse
                .ResponseBuilder
                .ok(
                        uriInfo.getPathSegments()
                                .stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(","))
                )
                .build();
    }
}
