package no.iterate.ic2017se

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/kotlin")
@Produces(MediaType.APPLICATION_JSON)
class KotlinMessageResource @Inject constructor(val messageService: MessageService) {

    @GET
    @Path("/messages")
    fun getMessages(@QueryParam("name") name: String): List<Message> {
        return messageService.messages
                .filter { it.to == name }
                .map { Message(it.subject, it.body) }
    }

    data class Message(val subject: String, val body: String)
}