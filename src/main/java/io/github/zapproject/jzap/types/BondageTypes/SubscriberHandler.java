package io.github.zapproject.jzap;


public interface SubscriberHandler {
    public void handlleResponse();
    public void handleUnsubscription();
    public void handleSubscription();
}