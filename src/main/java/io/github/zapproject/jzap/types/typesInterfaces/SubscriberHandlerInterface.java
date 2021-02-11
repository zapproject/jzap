package io.github.zapproject.jzap.types.typesInterfaces;

public interface SubscriberHandlerInterface {
    void handleResponse();
    void handleUnsubscription();
    void handleSubscription();
}
