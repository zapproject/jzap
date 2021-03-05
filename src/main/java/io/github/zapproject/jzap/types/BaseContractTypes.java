package io.github.zapproject.jzap;

import java.math.BigInteger;
import org.web3j.protocol.Web3j;

class BaseContractType {
    public String artifactDir;
    public String artifactName;
    // public Contract contract;
    public int networkId;
    public String networkProvider;
    public String coordinator;
    public String address;
    public Web3j web3j;
    public String accountKey;

    BaseContractType(String dir, String name, 
    // Contract contract, 
        int netId, String provider, String coord, String add, 
        Web3j web, String key){
            this.artifactDir = dir;
            this.artifactName = name;
            // this.contract = contract;
            this.networkId = netId;
            this.networkProvider = provider;
            this.coordinator = coord;
            this.address = add;
            this.web3j = web;
            this.accountKey = key;
    }
}

class NetworkProviderOptions {
    // public String artifactDir;
    public int networkId;
    public String networkProvider;
    public String coordinator;
    public String address;
    public Web3j web3j;
}

class TransferType extends DefaultTx {
    public String to;
    public BigInteger amount;
}
