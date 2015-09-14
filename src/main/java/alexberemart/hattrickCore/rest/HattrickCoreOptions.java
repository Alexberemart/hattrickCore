package alexberemart.hattrickCore.rest;

import Alexberemart.core.rest.AbstractRestService;
import alexberemart.hattrickCore.model.enums.MatchStatus;
import alexberemart.hattrickCore.model.enums.MatchType;
import com.google.inject.servlet.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@Path("hattrick-options")
public class HattrickCoreOptions extends AbstractRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptions() throws IOException {
        HashMap<String, Map> result = new HashMap<>();
        result.put("matchStatus", MatchStatus.asMap());
        result.put("matchType", MatchType.asMap());

        return ok(result);
    }
}
