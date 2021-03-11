package io.github.zapproject.jzap;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;


class BaseContractType {
    public String bytecode;
    public String address;
    public Web3j web3j;
    public Credentials credentials;
    public ContractGasProvider contractGasProvider;

    BaseContractType(
        String bytecode,
        String address, 
        Web3j web3j, 
        Credentials credentials,
        ContractGasProvider contractGasProvider){

        this.bytecode = bytecode;
        this.address = address;
        this.web3j = web3j;
        this.credentials = credentials;
        this.contractGasProvider = contractGasProvider;
    }
}

class NetworkProviderOptions {
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

class TransferType extends DefaultTx {
    public String to;
    public BigInteger amount;
}
