package io.github.zapproject.jzap;

import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;


public abstract class BaseContract extends Contract {
    public String provider;
    public String name;
    public String address;
    public Web3j web3j;
    public int networkId;
    public Artifacts artifact = new Artifacts();

    BaseContract(BaseContractType type) {
        super(
            type.bytecode,
            type.address,
            type.web3j,
            type.credentials,
            type.contractGasProvider
        ); 

        this.provider = type.credentials.getAddress();
        this.address = type.address;
        this.web3j = type.web3j;
    }

    BaseContract(String bytecode, NetworkProviderOptions type, String artifactName) throws Exception {
        super(
            bytecode,
            new Artifacts().getAddress(artifactName, type.networkId),
            type.web3j,
            type.credentials,
            type.contractGasProvider
        );

        this.provider = type.credentials.getAddress();
        this.name = artifactName;
        this.address = artifact.getAddress(artifactName, type.networkId);
        this.web3j = type.web3j;
        this.networkId = type.networkId;
    }
}