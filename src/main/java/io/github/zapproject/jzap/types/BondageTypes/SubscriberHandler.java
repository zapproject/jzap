package io.github.zapproject.jzap.types.BondageTypes;


public interface SubscriberHandler {
    public void handlleResponse();
    public void handleUnsubscription();
    public void handleSubscription();
}