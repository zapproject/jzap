package io.github.zapproject.jzap.types;

import java.util.List;


class InitProvider extends DefaultTx {
    public String publicKey;
    public String title;
}

class InitCurve extends DefaultTx {
    public byte[] endpoint;
    public CurveType term;
    public String broker;
}

class EndpointParams extends DefaultTx {
    public byte[] endpoint;
    public List<byte[]> endpointParams;
}

class SetProviderParams extends DefaultTx {
    public byte[] key;
    public byte[] value;
}

class SetProviderTitle extends DefaultTx {
    public String from;
    public byte[] title;
}

class Endpoint extends DefaultTx {
    public byte[] endpoint;
}