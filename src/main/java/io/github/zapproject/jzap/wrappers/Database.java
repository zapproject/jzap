package io.github.zapproject.jzap;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.0.
 */
@SuppressWarnings("rawtypes")
public class Database extends Contract {
    public static final String BINARY = "0x6080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611fcd806100536000396000f3fe608060405234801561001057600080fd5b50600436106101cf5760003560e01c80638d152d7811610104578063a4f63ec8116100a2578063dd151d1e11610071578063dd151d1e14610aef578063e16e934014610b3d578063ec672cf614610bb5578063f2fde38b14610c38576101cf565b8063a4f63ec814610941578063a6ed563e14610983578063a9fcf76b146109c5578063c031a18014610a48576101cf565b8063986e791a116100de578063986e791a146107bc578063a21a65ae14610863578063a2987245146108a5578063a42b6bf1146108f1576101cf565b80638d152d78146106b75780638da5cb5b146106ef5780638db0e83b14610739576101cf565b80634e91db08116101715780635948f7331161014b5780635948f7331461050d5780635eca2aeb146105905780636e899550146105dc57806387ddf6cd1461065f576101cf565b80634e91db081461041a57806354c552db1461045257806356e5cf2e1461048a576101cf565b80632e28d084116101ad5780632e28d084146102d15780632ecb0d64146103545780632fc94ba61461039657806343cb0af7146103d8576101cf565b80630dd63ba3146101d45780631b929940146102165780632d2899b61461024e575b600080fd5b610214600480360360608110156101ea57600080fd5b81019080803590602001909291908035906020019092919080359060200190929190505050610c7c565b005b61024c6004803603604081101561022c57600080fd5b810190808035906020019092919080359060200190929190505050610d50565b005b61027a6004803603602081101561026457600080fd5b8101908080359060200190929190505050610d91565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156102bd5780820151818401526020810190506102a2565b505050509050019250505060405180910390f35b610352600480360360408110156102e757600080fd5b81019080803590602001909291908035906020019064010000000081111561030e57600080fd5b82018360208201111561032057600080fd5b8035906020019184600183028401116401000000008311171561034257600080fd5b9091929391929390505050610dfc565b005b6103806004803603602081101561036a57600080fd5b8101908080359060200190929190505050610ec6565b6040518082815260200191505060405180910390f35b6103c2600480360360208110156103ac57600080fd5b8101908080359060200190929190505050610ee6565b6040518082815260200191505060405180910390f35b610404600480360360208110156103ee57600080fd5b8101908080359060200190929190505050610f06565b6040518082815260200191505060405180910390f35b6104506004803603604081101561043057600080fd5b810190808035906020019092919080359060200190929190505050610f26565b005b6104886004803603604081101561046857600080fd5b810190808035906020019092919080359060200190929190505050610fe4565b005b61050b600480360360408110156104a057600080fd5b8101908080359060200190929190803590602001906401000000008111156104c757600080fd5b8201836020820111156104d957600080fd5b803590602001918460208302840111640100000000831117156104fb57600080fd5b90919293919293905050506110a5565b005b6105396004803603602081101561052357600080fd5b810190808035906020019092919050505061116f565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561057c578082015181840152602081019050610561565b505050509050019250505060405180910390f35b6105c6600480360360408110156105a657600080fd5b810190808035906020019092919080359060200190929190505050611210565b6040518082815260200191505060405180910390f35b61065d600480360360408110156105f257600080fd5b81019080803590602001909291908035906020019064010000000081111561061957600080fd5b82018360208201111561062b57600080fd5b8035906020019184600183028401116401000000008311171561064d57600080fd5b9091929391929390505050611243565b005b6106b56004803603606081101561067557600080fd5b810190808035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061130d565b005b6106ed600480360360408110156106cd57600080fd5b81019080803590602001909291908035906020019092919050505061141b565b005b6106f761145c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6107656004803603602081101561074f57600080fd5b8101908080359060200190929190505050611481565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107a857808201518184015260208101905061078d565b505050509050019250505060405180910390f35b6107e8600480360360208110156107d257600080fd5b81019080803590602001909291905050506114ec565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561082857808201518184015260208101905061080d565b50505050905090810190601f1680156108555780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61088f6004803603602081101561087957600080fd5b81019080803590602001909291905050506115a1565b6040518082815260200191505060405180910390f35b6108db600480360360408110156108bb57600080fd5b8101908080359060200190929190803590602001909291905050506115c1565b6040518082815260200191505060405180910390f35b61093f6004803603604081101561090757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035151590602001909291905050506115f4565b005b6109816004803603606081101561095757600080fd5b81019080803590602001909291908035906020019092919080359060200190929190505050611780565b005b6109af6004803603602081101561099957600080fd5b8101908080359060200190929190505050611854565b6040518082815260200191505060405180910390f35b610a46600480360360408110156109db57600080fd5b810190808035906020019092919080359060200190640100000000811115610a0257600080fd5b820183602082011115610a1457600080fd5b80359060200191846020830284011164010000000083111715610a3657600080fd5b9091929391929390505050611871565b005b610a7460048036036020811015610a5e57600080fd5b810190808035906020019092919050505061193b565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610ab4578082015181840152602081019050610a99565b50505050905090810190601f168015610ae15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610b3b60048036036040811015610b0557600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506119f0565b005b610b7360048036036040811015610b5357600080fd5b810190808035906020019092919080359060200190929190505050611a6b565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610c3660048036036040811015610bcb57600080fd5b810190808035906020019092919080359060200190640100000000811115610bf257600080fd5b820183602082011115610c0457600080fd5b80359060200191846020830284011164010000000083111715610c2657600080fd5b9091929391929390505050611abe565b005b610c7a60048036036020811015610c4e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611b88565b005b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16610d1e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b80600460008581526020019081526020016000208381548110610d3d57fe5b9060005260206000200181905550505050565b600460008381526020019081526020016000208190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b606060046000838152602001908152602001600020805480602002602001604051908101604052809291908181526020018280548015610df057602002820191906000526020600020905b815481526020019060010190808311610ddc575b50505050509050919050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16610e9e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8181600260008681526020019081526020016000209190610ec0929190611cd9565b50505050565b6000600160008381526020019081526020016000205460001c9050919050565b600060056000838152602001908152602001600020805490509050919050565b600060036000838152602001908152602001600020805490509050919050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16610fc8576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8060016000848152602001908152602001600020819055505050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16611086576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8060001b60016000848152602001908152602001600020819055505050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16611147576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8181600360008681526020019081526020016000209190611169929190611d59565b50505050565b60606005600083815260200190815260200160002080548060200260200160405190810160405280929190818152602001828054801561120457602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116111ba575b50505050509050919050565b600060036000848152602001908152602001600020828154811061123057fe5b9060005260206000200154905092915050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff166112e5576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8181600260008681526020019081526020016000209190611307929190611cd9565b50505050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff166113af576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b806005600085815260200190815260200160002083815481106113ce57fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b600360008381526020019081526020016000208190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060600360008381526020019081526020016000208054806020026020016040519081016040528092919081815260200182805480156114e057602002820191906000526020600020905b8154815260200190600101908083116114cc575b50505050509050919050565b6060600260008381526020019081526020016000208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115955780601f1061156a57610100808354040283529160200191611595565b820191906000526020600020905b81548152906001019060200180831161157857829003601f168201915b50505050509050919050565b600060046000838152602001908152602001600020805490509050919050565b60006004600084815260200190815260200160002082815481106115e157fe5b9060005260206000200154905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461164d57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156116d3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f815260200180611f6a602f913960400191505060405180910390fd5b80600660008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff167fc139d49f05d574c44ade2e84d6e5ddbab8d65a476d7244af01a64b247788c29782604051808215151515815260200191505060405180910390a25050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16611822576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8060036000858152602001908152602001600020838154811061184157fe5b9060005260206000200181905550505050565b600060016000838152602001908152602001600020549050919050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16611913576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8181600460008681526020019081526020016000209190611935929190611da6565b50505050565b6060600260008381526020019081526020016000208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156119e45780601f106119b9576101008083540402835291602001916119e4565b820191906000526020600020905b8154815290600101906020018083116119c757829003601f168201915b50505050509050919050565b600560008381526020019081526020016000208190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b6000600560008481526020019081526020016000208281548110611a8b57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905092915050565b600660003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16611b60576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180611f466024913960400191505060405180910390fd5b8181600560008681526020019081526020016000209190611b82929190611df3565b50505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614611be157600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415611c1b57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611d1a57803560ff1916838001178555611d48565b82800160010185558215611d48579182015b82811115611d47578235825591602001919060010190611d2c565b5b509050611d559190611e93565b5090565b828054828255906000526020600020908101928215611d95579160200282015b82811115611d94578235825591602001919060010190611d79565b5b509050611da29190611eb8565b5090565b828054828255906000526020600020908101928215611de2579160200282015b82811115611de1578235825591602001919060010190611dc6565b5b509050611def9190611edd565b5090565b828054828255906000526020600020908101928215611e82579160200282015b82811115611e8157823573ffffffffffffffffffffffffffffffffffffffff168260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190611e13565b5b509050611e8f9190611f02565b5090565b611eb591905b80821115611eb1576000816000905550600101611e99565b5090565b90565b611eda91905b80821115611ed6576000816000905550600101611ebe565b5090565b90565b611eff91905b80821115611efb576000816000905550600101611ee3565b5090565b90565b611f4291905b80821115611f3e57600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905550600101611f08565b5090565b9056fe4572726f723a20416363657373206e6f7420616c6c6f77656420746f2073746f726167654572726f723a2041646472657373207a65726f20697320696e76616c69642073746f7261676520636f6e7472616374a265627a7a72315820680c43a0c2efd54bad205ba9985926495cb3a370051e3ccd89744b8588d8fe4464736f6c63430005100032";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETSTORAGECONTRACT = "setStorageContract";

    public static final String FUNC_GETBYTES32 = "getBytes32";

    public static final String FUNC_SETBYTES32 = "setBytes32";

    public static final String FUNC_GETNUMBER = "getNumber";

    public static final String FUNC_SETNUMBER = "setNumber";

    public static final String FUNC_GETBYTES = "getBytes";

    public static final String FUNC_SETBYTES = "setBytes";

    public static final String FUNC_GETSTRING = "getString";

    public static final String FUNC_SETSTRING = "setString";

    public static final String FUNC_GETBYTESARRAY = "getBytesArray";

    public static final String FUNC_GETBYTESARRAYINDEX = "getBytesArrayIndex";

    public static final String FUNC_GETBYTESARRAYLENGTH = "getBytesArrayLength";

    public static final String FUNC_PUSHBYTESARRAY = "pushBytesArray";

    public static final String FUNC_SETBYTESARRAYINDEX = "setBytesArrayIndex";

    public static final String FUNC_SETBYTESARRAY = "setBytesArray";

    public static final String FUNC_GETINTARRAY = "getIntArray";

    public static final String FUNC_GETINTARRAYINDEX = "getIntArrayIndex";

    public static final String FUNC_GETINTARRAYLENGTH = "getIntArrayLength";

    public static final String FUNC_PUSHINTARRAY = "pushIntArray";

    public static final String FUNC_SETINTARRAYINDEX = "setIntArrayIndex";

    public static final String FUNC_SETINTARRAY = "setIntArray";

    public static final String FUNC_GETADDRESSARRAY = "getAddressArray";

    public static final String FUNC_GETADDRESSARRAYINDEX = "getAddressArrayIndex";

    public static final String FUNC_GETADDRESSARRAYLENGTH = "getAddressArrayLength";

    public static final String FUNC_PUSHADDRESSARRAY = "pushAddressArray";

    public static final String FUNC_SETADDRESSARRAYINDEX = "setAddressArrayIndex";

    public static final String FUNC_SETADDRESSARRAY = "setAddressArray";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event STORAGEMODIFIED_EVENT = new Event("StorageModified", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Database(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Database(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Database(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Database(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public List<StorageModifiedEventResponse> getStorageModifiedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STORAGEMODIFIED_EVENT, transactionReceipt);
        ArrayList<StorageModifiedEventResponse> responses = new ArrayList<StorageModifiedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StorageModifiedEventResponse typedResponse = new StorageModifiedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.contractAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.allowed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<StorageModifiedEventResponse> storageModifiedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, StorageModifiedEventResponse>() {
            @Override
            public StorageModifiedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STORAGEMODIFIED_EVENT, log);
                StorageModifiedEventResponse typedResponse = new StorageModifiedEventResponse();
                typedResponse.log = log;
                typedResponse.contractAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.allowed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<StorageModifiedEventResponse> storageModifiedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STORAGEMODIFIED_EVENT));
        return storageModifiedEventFlowable(filter);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setStorageContract(String _storageContract, Boolean _allowed) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTORAGECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storageContract), 
                new org.web3j.abi.datatypes.Bool(_allowed)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getBytes32(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytes32(byte[] key, byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getNumber(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setNumber(byte[] key, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETNUMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getBytes(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytes(byte[] key, byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.DynamicBytes(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getString(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setString(byte[] key, String value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.Utf8String(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getBytesArray(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTESARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<byte[]> getBytesArrayIndex(byte[] key, BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTESARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getBytesArrayLength(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBYTESARRAYLENGTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pushBytesArray(byte[] key, byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHBYTESARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytesArrayIndex(byte[] key, BigInteger index, byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTESARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytesArray(byte[] key, List<byte[]> value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBYTESARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(value, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getIntArray(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETINTARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Int256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getIntArrayIndex(byte[] key, BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETINTARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getIntArrayLength(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETINTARRAYLENGTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pushIntArray(byte[] key, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHINTARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Int256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setIntArrayIndex(byte[] key, BigInteger index, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETINTARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.generated.Int256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setIntArray(byte[] key, List<BigInteger> value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETINTARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Int256>(
                        org.web3j.abi.datatypes.generated.Int256.class,
                        org.web3j.abi.Utils.typeMap(value, org.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getAddressArray(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<String> getAddressArrayIndex(byte[] key, BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAddressArrayLength(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSARRAYLENGTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pushAddressArray(byte[] key, String value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHADDRESSARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.Address(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setAddressArrayIndex(byte[] key, BigInteger index, String value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETADDRESSARRAYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Address(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setAddressArray(byte[] key, List<String> value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETADDRESSARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(value, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Database load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Database(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Database load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Database(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Database load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Database(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Database load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Database(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Database> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Database.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Database> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Database.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Database> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Database.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Database> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Database.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Override
    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class StorageModifiedEventResponse extends BaseEventResponse {
        public String contractAddress;

        public Boolean allowed;
    }
}
