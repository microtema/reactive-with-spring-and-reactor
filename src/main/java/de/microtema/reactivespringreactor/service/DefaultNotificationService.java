package de.microtema.reactivespringreactor.service;

import de.microtema.reactivespringreactor.model.NotificationData;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DefaultNotificationService implements NotificationService {

    @Override
    public void initiateNotification(NotificationData notificationData) {

        log.info(() -> "Notification service started for " + "Notification ID: " + notificationData.getId());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //ignore me
        }

        log.info(() -> "Notification service ended for " + "Notification ID: " + notificationData.getId());
    }
}
