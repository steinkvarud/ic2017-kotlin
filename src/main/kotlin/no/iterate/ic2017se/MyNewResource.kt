package no.iterate.ic2017se
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
class MyNewResource {

    data class User(val username: String, val age: Int)

    @GET
    fun getUser(): User? {
        return User("Stein", 40)
    }
}