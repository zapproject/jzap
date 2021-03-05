package io.github.zapproject.jzap;

import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;

public abstract class BaseContract extends Contract {
    public String provider;
    public String name;
    public String address;
    public Web3j web3j;
    public int networkId;
    public ZapCoordinator coordinator;
    public Artifacts artifact = new Artifacts();

    BaseContract(BaseContractType type) throws Exception {
        super(
            // new Artifacts().getMap(type.artifactDir.isEmpty() ? 
            //     type.artifactName.toUpperCase() : 
            //     type.artifactDir
            //     ).get("bytecode"),
            type.bytecode,
            type.address,
            type.web3j,
            type.credentials,
            new DefaultGasProvider()
        ); 
        
        // Below this is unecessary if class instances do not have to be accessed.
        // HashMap zapArtifact = new Artifacts().getMap("ZAPCOORDINATOR");
        
        // // this.name = type.artifactName;
        // this.provider = type.networkProvider;
        // this.networkId = type.networkId;
        // this.address = type.address;

        // Credentials creds = Credentials.create(type.accountKey);
        // ContractGasProvider gasPro = new DefaultGasProvider();

        // if (type.web3j != null) {
        //     this.web3j = type.web3j;   
        // } else {
        //     this.web3j = Web3j.build(new HttpService());
        // }

        // if (!type.coordinator.isEmpty()){
            // this.coordinator = ZapCoordinator.load(type);
        // } else {
        //     this.coordinator = ZapCoordinator.load(ZapCoordinator.BINARY, web3j, creds, gasPro);
        // }
    }

}