package io.github.zapproject.jzap;


interface TransactionCallback {
    public void transactionCallback(String error, String hash);
}

class NextEndpoint {
    public String provider;
    public byte[] endpoint;
}
