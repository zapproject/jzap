package io.github.zapproject.jzap;


public interface TransactionCallback {
    public void transactionCallback(String error, String hash);
}