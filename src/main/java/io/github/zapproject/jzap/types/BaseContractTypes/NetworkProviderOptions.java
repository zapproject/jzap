package io.github.zapproject.jzap;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;


public class NetworkProviderOptions {
    public int networkId;
    public Web3j web3j;
    public Credentials credentials;
    public ContractGasProvider contractGasProvider;

    NetworkProviderOptions(int networkId, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        this.networkId = networkId;
        this.web3j = web3j;
        this.credentials = credentials;
        this.contractGasProvider = contractGasProvider;
    }
}