package no.iterate.ic2017se;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application extends ResourceConfig{

    public Application() {
        MessageService messageService = new MessageService();
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(messageService).to(MessageService.class);
            }
        });
    }

    public static void main(String[] args) {
        Server server = new Server(8080);

        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages","no.iterate.ic2017se");
        serHol.setInitParameter("javax.ws.rs.Application","no.iterate.ic2017se.Application" );

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            server.destroy();
        }
    }
}
