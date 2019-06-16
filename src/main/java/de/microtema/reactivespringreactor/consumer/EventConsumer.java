package de.microtema.reactivespringreactor.consumer;

import reactor.bus.Event;
import reactor.fn.Consumer;

/**
 * Create Adapter API from reactor Consumer and decorate with name and high level consumer.
 *
 * @param <T> generic type of event data
 */
public interface EventConsumer<T> extends Consumer<Event<T>> {

    default String getConsumerName() {

        return getClass().getSimpleName();
    }

    /**
     * Provide default handling of event and consume only data.
     * This my be override by sub types for more low level handling.
     *
     * @param event may not be null
     */
    default void accept(Event<T> event) {

        T data = event.getData();

        consume(data);
    }

    /**
     * Consume the event data without context.
     *
     * @param data may not be null
     */
    void consume(T data);
}
