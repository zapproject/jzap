package io.github.zapproject.jzap;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

class BaseContractType {
    // public String artifactDir;
    // public String artifactName;
    // public Contract contract;
    public String bytecode;
    // public int networkId;
    // public String networkProvider;
    // public String coordinator;
    public String address;
    public Web3j web3j;
    public Credentials credentials;
    public ContractGasProvider contractGasProvider;

    BaseContractType(
        // String dir, String name, Contract contract, 
        String bytecode,
        // int netId, 
        // String provider, 
        // String coord, 
        String add, 
        Web3j web, Credentials credentials,
        ContractGasProvider contractGasProvider){
            // this.artifactDir = dir;
            // this.artifactName = name;
            // this.contract = contract;
            this.bytecode = bytecode;
            // this.networkId = netId;
            // this.networkProvider = provider;
            // this.coordinator = coord;
            this.address = add;
            this.web3j = web;
            this.credentials = credentials;
            this.contractGasProvider = contractGasProvider;
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
