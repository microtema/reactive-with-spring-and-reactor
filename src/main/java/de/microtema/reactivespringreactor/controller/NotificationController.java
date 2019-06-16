package de.microtema.reactivespringreactor.controller;

import de.microtema.reactivespringreactor.consumer.NotificationConsumer;
import de.microtema.reactivespringreactor.model.NotificationData;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Log4j2
@Controller
public class NotificationController {

    private final EventBus eventBus;
    private final NotificationConsumer notificationConsumer;

    public NotificationController(EventBus eventBus, NotificationConsumer notificationConsumer) {
        this.eventBus = eventBus;
        this.notificationConsumer = notificationConsumer;
    }

    @GetMapping(value = "/notify/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> startNotification(@PathVariable Integer param) {

        for (int i = 0; i < param; i++) {

            NotificationData data = new NotificationData();
            data.setId(i);

            eventBus.notify(notificationConsumer.getConsumerName(), Event.wrap(data));

            log.info("Notification " + i + ": task submitted successfully");
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
