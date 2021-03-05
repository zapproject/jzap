package io.github.zapproject.jzap;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

public abstract class BaseContract extends Contract {
    public String provider;
    public String name;
    public String address;
    public Web3j web3j;
    public int networkId;
    public ZapCoordinator coordinator;
    public Artifacts artifact;

    BaseContract(BaseContractType type) throws Exception {
        super(
            new Artifacts(type.artifactDir.isEmpty() ? 
                type.artifactName.toUpperCase() : 
                type.artifactDir
                ).map.get("bytecode"),
            type.address,
            type.web3j,
            Credentials.create(type.accountKey),
            new DefaultGasProvider()
        ); 
        
        // Below this is unecessary if class instances do not have to be accessed.
        Artifacts zapArtifact = new Artifacts("ZAPCOORDINATOR");
        
        this.name = type.artifactName;
        this.provider = type.networkProvider;
        this.networkId = type.networkId;
        this.address = type.address;

        Credentials creds = Credentials.create(type.accountKey);
        ContractGasProvider gasPro = new DefaultGasProvider();

        if (type.web3j != null) {
            this.web3j = type.web3j;   
        } else {
            this.web3j = Web3j.build(new HttpService());
        }

        // if (!type.coordinator.isEmpty()){
            // this.coordinator = ZapCoordinator.load(type);
        // } else {
            // this.coordinator = ZapCoordinator.load(zapArtifact.jsonNode.get("networks").get(networkId).get("address").asText(), web3j, creds, gasPro);
        // }
    }

}