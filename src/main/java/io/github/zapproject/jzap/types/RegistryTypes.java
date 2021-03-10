package io.github.zapproject.jzap;

import java.util.List;


class EndpointParams extends DefaultTx {
    public byte[] endpoint;
    public List<byte[]> endpointParams;
}

class Endpoint extends DefaultTx {
    public byte[] endpoint;
}