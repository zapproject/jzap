package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


interface SubscriberHandler {
    public void handlleResponse();
    public void handleUnsubscription();
    public void handleSubscription();
}

class TokenBondType {
    public byte[] endpoint;
    public BigInteger dots;
}

class BondType {
    public String subscriber;
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class DelegateBondType extends BondType {
    public String subscriber;
}

class UnbondType {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class SubscribeType {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
    public List<byte[]> endpointParams;
}

class ApproveType {
    public String provider;
    public BigInteger zapNum;
}

class BondArgs {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class UnbondArgs {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class DelegateBondArgs {
    public String provider;
    public String subscriber;
    public byte[] endpoint;
    public BigInteger dots;
}

class BondageArgs {
    public String subscriber;
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
    public BigInteger zapNum;
}

class CalcBondRateType {
    public String provider;
    public byte[] endpoint;
    public BigInteger zapNum;
}

class BondFilter {
    public BigInteger numDots;
    public BigInteger numZap;
}
