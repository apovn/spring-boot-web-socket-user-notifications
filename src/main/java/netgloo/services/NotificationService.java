package netgloo.services;

import netgloo.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class for sending notification messages.
 */
@Service
public class NotificationService {

    // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Send notification to users subscribed on channel "/user/queue/notify".
     * <p>
     * The message will be sent only to the user with the given username.
     * Ref: https://stackoverflow.com/questions/22367223/sending-message-to-specific-user-on-spring-websocket
     *
     * @param notification The notification message.
     * @param username     The username for the user to send notification.
     */
    public void notify(Notification notification, String username) {
        messagingTemplate.convertAndSendToUser(username, "/notify", notification); // Spring will automatically prepend "/user/" to destination => "/user/notify"
        return;
    }
    public void feedback(Notification notification, String username) {
        messagingTemplate.convertAndSendToUser(username, "/feedback", notification);
        return;
    }

} // class NotificationService
