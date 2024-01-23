package ezpie.com;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.PathSegment;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/redirect")
public class RedirectResource {
    @ConfigProperty(name = "quarkus.http.root-path")
    String rootPath;

    /**
     * 可被环境变量覆盖
     */
    @ConfigProperty(name = "my.root.path")
    String myRoot;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/old")
    public RestResponse<String> oldFunc(@Context UriInfo uriInfo) {
        var segmentList = uriInfo.getPathSegments();
        var subList = segmentList.subList(0, segmentList.size() - 1);
        var subListString = subList.stream().map(PathSegment::getPath).toList();
        var newUrl = uriInfo.getBaseUriBuilder()
                .path(myRoot)
                .segment(subListString.toArray(new String[0]))
                .path("new")
                .build();

        return RestResponse.seeOther(newUrl);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/new")
    public RestResponse<String> newFunc(@Context UriInfo uriInfo) {
        StringBuilder builder = new StringBuilder();

        builder.append("myRoot:\n" + myRoot + "\n\n\n\n");
        builder.append("rootPath:\n" + rootPath + "\n\n\n\n");
        builder.append("from new:\n\n\n\n");
        return Utils.getStringRestResponse(uriInfo, builder);
    }
}
