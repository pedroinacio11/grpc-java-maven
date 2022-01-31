import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.UserService;

import java.io.IOException;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String args[]) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8080).addService(new UserService()).build();

        server.start();

        Runtime.getRuntime().addShutdownHook( new Thread(
                () -> {
                    System.out.println("Received Shutdown Request");
                    server.shutdown();
                    System.out.println("Successfully stopped the Calculator Server");
                }
        ));

        logger.info("Serve started on " + server.getPort());

        server.awaitTermination();

    }
}
