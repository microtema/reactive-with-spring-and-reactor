package de.microtema.reactivespringreactor.config;

import de.microtema.reactivespringreactor.consumer.EventConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

import java.util.Set;

import static reactor.bus.selector.Selectors.$;

@Configuration
public class Config {

    private final Set<EventConsumer<?>> consumers;

    public Config(Set<EventConsumer<?>> consumers) {
        this.consumers = consumers;
    }

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty().assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env) {

        EventBus eventBus = EventBus.create(env, Environment.THREAD_POOL);

        // Note: Register all consumers on bus
        consumers.forEach(it -> eventBus.on($(it.getConsumerName()), it));

        return eventBus;
    }

}
