package no.iterate.ic2017se;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Path("/java")
public class MessageResource {

    private final MessageService messageService;

    @Inject
    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageDTO> getMessages(@QueryParam("name") String name) {

        return messageService.getMessages().stream()
                .filter(m -> m.to.equals(name))
                .map(m -> new MessageDTO(m.subject, m.body))
                .collect(Collectors.toList());
    }

    public static class MessageDTO {

        public final String subject;
        public final String body;

        public MessageDTO(String subject, String body) {
            this.subject = Objects.requireNonNull(subject);
            this.body = Objects.requireNonNull(body);
        }
    }
}