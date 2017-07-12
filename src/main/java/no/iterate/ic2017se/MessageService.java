package no.iterate.ic2017se;

import java.util.Arrays;
import java.util.List;

public class MessageService {

    public List<Message> getMessages() {
        return Arrays.asList(
                new Message("Stein", "Marie", "God sommer", "En kort sommerhilsen"),
                new Message("Annette", "Magnus", "Ha en fin dag", "Ha en super dag"),
                new Message("Stein", "Magnus", "Ut på tur aldri sur?", "Skal vi dra på sykkeltur?")
        );
    }

    public class Message {

        public String from;
        public String to;
        public String subject;
        public String body;

        public Message(String from, String to, String subject, String body) {
            this.from = from;
            this.to = to;
            this.subject = subject;
            this.body = body;
        }
    }
}
