package io.github.zapproject.jzap;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;


public class BaseContractType {
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
