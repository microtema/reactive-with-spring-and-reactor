package de.microtema.reactivespringreactor.consumer;

import de.microtema.reactivespringreactor.model.NotificationData;
import de.microtema.reactivespringreactor.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer implements EventConsumer<NotificationData> {

    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void consume(NotificationData data) {

        notificationService.initiateNotification(data);
    }
}
