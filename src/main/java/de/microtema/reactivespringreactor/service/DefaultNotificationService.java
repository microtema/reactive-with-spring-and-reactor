package de.microtema.reactivespringreactor.service;

import de.microtema.reactivespringreactor.model.NotificationData;
import de.microtema.reactivespringreactor.observer.ObservableList;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
@Service
public class DefaultNotificationService implements NotificationService, DisposableBean {

    private final ObservableList<NotificationData> observableList;
    private final Disposable disposable;

    public DefaultNotificationService() {

        observableList = new ObservableList<>();

        disposable = observableList.getObservable().subscribe(this::subscriber);
    }

    @Override
    public void initiateNotification(NotificationData notificationData) {

        log.info(() -> "Notification service started for ID: " + notificationData.getId());

        try {
            int randomSleep = ThreadLocalRandom.current().nextInt(250, 3000);
            Thread.sleep(randomSleep);
        } catch (InterruptedException e) {
            log.error(e);
            Thread.currentThread().interrupt();
        }

        observableList.add(notificationData);

        log.info(() -> "Notification service ended for: " + notificationData);
    }

    private void subscriber(List<NotificationData> notifications) {

        log.info(() -> "Notifications size: " + notifications.size());
    }

    @Override
    public void destroy() {
        disposable.dispose();
    }
}
