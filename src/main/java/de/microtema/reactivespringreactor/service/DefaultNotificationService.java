package de.microtema.reactivespringreactor.service;

import de.microtema.reactivespringreactor.model.NotificationData;
import org.springframework.stereotype.Service;

@Service
public class DefaultNotificationService implements NotificationService {

    @Override
    public void initiateNotification(NotificationData notificationData) {

        System.out.println("Notification service started for " + "Notification ID: " + notificationData.getId());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //ignore me
        }

        System.out.println("Notification service ended for " + "Notification ID: " + notificationData.getId());
    }
}
