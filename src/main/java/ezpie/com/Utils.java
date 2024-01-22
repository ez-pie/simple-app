package ezpie.com;

import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.stream.Collectors;

public class Utils {
    public static RestResponse<String> getStringRestResponse(UriInfo uriInfo, StringBuilder builder) {
        builder.append("getBaseUri:\n" + uriInfo.getBaseUri() + "\n\n");
        builder.append("getRequestUri:\n" + uriInfo.getRequestUri() + "\n\n");
        builder.append("getAbsolutePath:\n" + uriInfo.getAbsolutePath() + "\n\n");
        builder.append("getPath:\n" + uriInfo.getPath() + "\n\n");
        builder.append("path segments:\n"
                + uriInfo.getPathSegments().stream().map(Object::toString).collect(Collectors.joining(","))
                + "\n\n");

        String str = builder.toString();

        return RestResponse
                .ResponseBuilder
                .ok(str)
                .build();
    }
}
