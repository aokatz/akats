package emailnotification;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void close() {
        pool.shutdown();
    }

    public void emailTo(User user) {
        pool.submit(() -> send("Notification " + user.getUsername() + " to email " + user.getEmail() + ".", "Add a new event to " + user.getUsername(), user.getEmail()));
    }

    public void send(String subject, String body, String email) {

    }

}
