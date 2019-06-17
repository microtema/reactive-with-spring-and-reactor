package de.microtema.reactivespringreactor.controller;

import de.microtema.reactivespringreactor.consumer.NotificationConsumer;
import de.microtema.reactivespringreactor.model.NotificationData;
import de.seven.fate.model.builder.ModelBuilder;
import de.seven.fate.model.builder.ModelBuilderFactory;
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
    private final ModelBuilder<NotificationData> modelBuilder;

    public NotificationController(EventBus eventBus, NotificationConsumer notificationConsumer) {
        this.eventBus = eventBus;
        this.notificationConsumer = notificationConsumer;
        this.modelBuilder = ModelBuilderFactory.createBuilder(NotificationData.class);
    }

    @GetMapping(value = "/notify/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> startNotification(@PathVariable Integer size) {

        modelBuilder.list(size).forEach(this::notify);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    private void notify(NotificationData notificationData) {

        eventBus.notify(notificationConsumer.getConsumerName(), Event.wrap(notificationData));

        log.info("Notification " + notificationData.getId() + ": task submitted successfully");
    }

}
