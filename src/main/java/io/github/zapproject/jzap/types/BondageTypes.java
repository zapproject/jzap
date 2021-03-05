package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


interface SubscriberHandler {
    public void handlleResponse();
    public void handleUnsubscription();
    public void handleSubscription();
}

class TokenBondType extends DefaultTx {
    public byte[] endpoint;
    public BigInteger dots;
}

class BondType extends DefaultTx {
    public String subscriber;
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class DelegateBondType extends BondType {
    public String subscriber;
}

class UnbondType extends DefaultTx {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class SubscribeType extends DefaultTx {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
    public List<byte[]> endpointParams;
}

class ApproveType extends DefaultTx {
    public String provider;
    public BigInteger zapNum;
}

class BondArgs extends DefaultTx {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class UnbondArgs extends DefaultTx {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
}

class DelegateBondArgs extends DefaultTx {
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

class BondFilter extends Filter {
    public BigInteger numDots;
    public BigInteger numZap;
}
