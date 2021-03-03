package io.github.zapproject.jzap.types;

import java.util.List;


interface TransactionCallback {
    public void transactionCallback(String error, String hash);
}

class InitProvider extends DefaultTx {
    public String publicKey;
    public byte[] title;
}

class InitTokenCurve extends DefaultTx {
    public String specifier;
    public String ticker;
    public CurveType term;
}

class InitCurve extends DefaultTx {
    byte[] endpoint;
    CurveType term;
    String broker;
}

class NextEndpoint {
    public String provider;
    public byte[] endpoint;
}

class EndpointParams extends DefaultTx {
    public byte[] endpoint;
    public List<byte[]> endpointParams;
}

class SetProviderParams extends DefaultTx {
    public byte[] key;
    public byte[] value;
}
