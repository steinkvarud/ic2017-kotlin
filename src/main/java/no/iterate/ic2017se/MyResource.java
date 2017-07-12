package no.iterate.ic2017se;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage() {

        return new Message("Iterate konferansen 2017", "Hurra");
    }
}
