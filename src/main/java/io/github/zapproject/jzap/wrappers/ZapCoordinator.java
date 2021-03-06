package io.github.zapproject.jzap;

// import io.github.zapproject.jzap.BaseContractType;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class ZapCoordinator extends BaseContract {
    public static final String BINARY = "0x6080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506111ef806100536000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c80634d655aff116100665780634d655aff146102dd578063697a60b3146103275780638da5cb5b146103c0578063ca8e2bdd1461040a578063f2fde38b146104b157610093565b806321d8ad4c146100985780632944363f1461013f57806329e63cd71461014957806335817773146101e2575b600080fd5b6100c4600480360360208110156100ae57600080fd5b81019080803590602001909291905050506104f5565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101045780820151818401526020810190506100e9565b50505050905090810190601f1680156101315780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101476105ae565b005b6101e06004803603604081101561015f57600080fd5b810190808035906020019064010000000081111561017c57600080fd5b82018360208201111561018e57600080fd5b803590602001918460018302840111640100000000831117156101b057600080fd5b9091929391929390803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610842565b005b61029b600480360360208110156101f857600080fd5b810190808035906020019064010000000081111561021557600080fd5b82018360208201111561022757600080fd5b8035906020019184600183028401116401000000008311171561024957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610a48565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6102e5610adb565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6103be6004803603604081101561033d57600080fd5b810190808035906020019064010000000081111561035a57600080fd5b82018360208201111561036c57600080fd5b8035906020019184600183028401116401000000008311171561038e57600080fd5b9091929391929390803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b01565b005b6103c8610ee6565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6104366004803603602081101561042057600080fd5b8101908080359060200190929190505050610f0b565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561047657808201518184015260208101905061045b565b50505050905090810190601f1680156104a35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6104f3600480360360208110156104c757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610fc4565b005b60606002828154811061050457fe5b906000526020600020018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105a25780601f10610577576101008083540402835291602001916105a2565b820191906000526020600020905b81548152906001019060200180831161058557829003601f168201915b50505050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461060757600080fd5b60008090505b60028054905081101561083f57600060016002838154811061062b57fe5b9060005260206000200160405180828054600181600116156101000203166002900480156106905780601f1061066e576101008083540402835291820191610690565b820191906000526020600020905b81548152906001019060200180831161067c575b5050915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff16636e5ecdff6040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561070e57600080fd5b505af1158015610722573d6000803e3d6000fd5b505050507ff16f69d181cb9b84ef2392d232ea0726dcf57689ccb091c7ff89e8b913148062426002848154811061075557fe5b906000526020600020018360405180848152602001806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281038252848181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156108215780601f106107f657610100808354040283529160200191610821565b820191906000526020600020905b81548152906001019060200180831161080457829003601f168201915b505094505050505060405180910390a150808060010191505061060d565b50565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461089b57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff1660018484604051808383808284378083019250505092505050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461091857fe5b8060018484604051808383808284378083019250505092505050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000838360405160200180838380828437808301925050509250505060405160208183030381529060405280519060200120905060405160200180807f4441544142415345000000000000000000000000000000000000000000000000815250600801905060405160208183030381529060405280519060200120811415610a425781600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50505050565b60006001826040518082805190602001908083835b60208310610a805780518252602082019150602081019050602083039250610a5d565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610b5a57600080fd5b600060018484604051808383808284378083019250505092505050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610c22576002848490918060018154018082558091505090600182039060005260206000200160009091929390919293909192909192509190610c1b929190611115565b5050610ce9565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a42b6bf18260006040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200192505050600060405180830381600087803b158015610cd057600080fd5b505af1158015610ce4573d6000803e3d6000fd5b505050505b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a42b6bf18360016040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200192505050600060405180830381600087803b158015610d9757600080fd5b505af1158015610dab573d6000803e3d6000fd5b505050507f1051b92bbfac380879e24c0529d529db8a2eec4e2f07c580112ebe1fd066c3c58484838560405180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281038252868682818152602001925080828437600081840152601f19601f8201169050808301925050509550505050505060405180910390a18160018585604051808383808284378083019250505092505050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60028181548110610f1857fe5b906000526020600020016000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fbc5780601f10610f9157610100808354040283529160200191610fbc565b820191906000526020600020905b815481529060010190602001808311610f9f57829003601f168201915b505050505081565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461101d57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561105757600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061115657803560ff1916838001178555611184565b82800160010185558215611184579182015b82811115611183578235825591602001919060010190611168565b5b5090506111919190611195565b5090565b6111b791905b808211156111b357600081600090555060010161119b565b5090565b9056fea265627a7a72315820ce4ee60f46db1a48ad291d817b6603f64beb75535661ffb01bf5bc1a93a1b1cf64736f6c63430005100032";

    public static final String FUNC_DB = "db";

    public static final String FUNC_LOADEDCONTRACTS = "loadedContracts";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_ADDIMMUTABLECONTRACT = "addImmutableContract";

    public static final String FUNC_UPDATECONTRACT = "updateContract";

    public static final String FUNC_GETCONTRACTNAME = "getContractName";

    public static final String FUNC_GETCONTRACT = "getContract";

    public static final String FUNC_UPDATEALLDEPENDENCIES = "updateAllDependencies";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event UPDATEDCONTRACT_EVENT = new Event("UpdatedContract", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event UPDATEDDEPENDENCIES_EVENT = new Event("UpdatedDependencies", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    // @Deprecated
    // protected ZapCoordinator(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
    //     super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    // }

    // protected ZapCoordinator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
    //     super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    // }

    // @Deprecated
    // protected ZapCoordinator(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
    //     super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    // }

    // protected ZapCoordinator(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
    //     super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    // }

    protected ZapCoordinator(BaseContractType type) throws Exception {
        super(type);
    }

    protected ZapCoordinator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) throws Exception {
        super(new BaseContractType(BINARY, contractAddress, web3j, credentials, contractGasProvider));
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

    public List<UpdatedContractEventResponse> getUpdatedContractEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEDCONTRACT_EVENT, transactionReceipt);
        ArrayList<UpdatedContractEventResponse> responses = new ArrayList<UpdatedContractEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdatedContractEventResponse typedResponse = new UpdatedContractEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.previousAddr = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newAddr = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdatedContractEventResponse> updatedContractEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpdatedContractEventResponse>() {
            @Override
            public UpdatedContractEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEDCONTRACT_EVENT, log);
                UpdatedContractEventResponse typedResponse = new UpdatedContractEventResponse();
                typedResponse.log = log;
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.previousAddr = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newAddr = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdatedContractEventResponse> updatedContractEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEDCONTRACT_EVENT));
        return updatedContractEventFlowable(filter);
    }

    public List<UpdatedDependenciesEventResponse> getUpdatedDependenciesEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEDDEPENDENCIES_EVENT, transactionReceipt);
        ArrayList<UpdatedDependenciesEventResponse> responses = new ArrayList<UpdatedDependenciesEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdatedDependenciesEventResponse typedResponse = new UpdatedDependenciesEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.contractName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.contractAddr = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdatedDependenciesEventResponse> updatedDependenciesEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpdatedDependenciesEventResponse>() {
            @Override
            public UpdatedDependenciesEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEDDEPENDENCIES_EVENT, log);
                UpdatedDependenciesEventResponse typedResponse = new UpdatedDependenciesEventResponse();
                typedResponse.log = log;
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.contractName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.contractAddr = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdatedDependenciesEventResponse> updatedDependenciesEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEDDEPENDENCIES_EVENT));
        return updatedDependenciesEventFlowable(filter);
    }

    public RemoteFunctionCall<String> db() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> loadedContracts(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LOADEDCONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    // Original wrapper function - fails
    public RemoteFunctionCall<TransactionReceipt> addImmutableContract(String contractName, String newAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDIMMUTABLECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(contractName), 
                new org.web3j.abi.datatypes.Address(newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    // public EthSendTransaction addImmutableContract(String contractName, String newAddress) throws IOException , InterruptedException , ExecutionException , Exception {
    //     org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
    //         FUNC_ADDIMMUTABLECONTRACT,
    //         Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(contractName),
    //         new org.web3j.abi.datatypes.Address(newAddress)), 
    //         Collections.<TypeReference<?>>emptyList());

    //     String owner = this.owner().send().toString();
    //     String encodedFunction = FunctionEncoder.encode(function);
    //     ContractGasProvider gasPro = new org.web3j.tx.gas.DefaultGasProvider();
    //     EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(owner, DefaultBlockParameterName.LATEST).send();
    //     BigInteger nonce = ethGetTransactionCount.getTransactionCount();
    //     Transaction transaction = Transaction.createFunctionCallTransaction(
    //                     owner, 
    //                     nonce, 
    //                     gasPro.getGasPrice(), 
    //                     gasPro.getGasLimit(), 
    //                     this.contractAddress, 
    //                     encodedFunction);
        
    //     org.web3j.protocol.core.methods.response.EthSendTransaction transactionResponse = web3j.ethSendTransaction(transaction).sendAsync().get();
        
    //     return transactionResponse;
    // }

    public RemoteFunctionCall<TransactionReceipt> updateContract(String contractName, String newAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(contractName), 
                new org.web3j.abi.datatypes.Address(newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getContractName(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCONTRACTNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getContract(String contractName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(contractName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    // public EthSendTransaction getContract(String contractName) throws IOException , InterruptedException , ExecutionException , Exception {
    //     org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
    //         FUNC_GETCONTRACT,
    //         Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(contractName)), 
    //         Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));

    //     String owner = this.owner().send().toString();
    //     String encodedFunction = FunctionEncoder.encode(function);
    //     ContractGasProvider gasPro = new org.web3j.tx.gas.DefaultGasProvider();
    //     EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
    //         owner, 
    //         DefaultBlockParameterName.LATEST).send();

    //     BigInteger nonce = ethGetTransactionCount.getTransactionCount();
    //      Transaction transaction = Transaction.createFunctionCallTransaction(
    //                     owner, 
    //                     nonce, gasPro.getGasPrice(), 
    //                     gasPro.getGasLimit(), 
    //                     this.contractAddress, 
    //                     encodedFunction);
        
    //     org.web3j.protocol.core.methods.response.EthSendTransaction transactionResponse = web3j.ethSendTransaction(
    //         transaction).sendAsync().get();

    //     return transactionResponse;
    // }

    // Original wrapper function - fails
    public RemoteFunctionCall<TransactionReceipt> updateAllDependencies() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEALLDEPENDENCIES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    // public EthSendTransaction updateAllDependencies() throws InterruptedException , ExecutionException , IOException , Exception {
    //     org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
    //         FUNC_UPDATEALLDEPENDENCIES,
    //         Arrays.<Type>asList(), 
    //         Collections.<TypeReference<?>>emptyList());

    //     String owner = this.owner().send().toString();
    //     String encodedFunction = FunctionEncoder.encode(function);
    //     ContractGasProvider gasPro = new org.web3j.tx.gas.DefaultGasProvider();
    //     EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(owner, DefaultBlockParameterName.LATEST).send();

    //     BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        
    //     Transaction transaction = Transaction.createFunctionCallTransaction(
    //                     owner, 
    //                     nonce, gasPro.getGasPrice(), 
    //                     gasPro.getGasLimit(), 
    //                     this.contractAddress, 
    //                     encodedFunction);
        
    //     org.web3j.protocol.core.methods.response.EthSendTransaction transactionResponse = web3j.ethSendTransaction(
    //         transaction).sendAsync().get();

    //     return transactionResponse;
    // }

    // @Deprecated
    // public static ZapCoordinator load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
    //     return new ZapCoordinator(contractAddress, web3j, credentials, gasPrice, gasLimit);
    // }

    // @Deprecated
    // public static ZapCoordinator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
    //     return new ZapCoordinator(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    // }

    public static ZapCoordinator load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) throws Exception {
        return new ZapCoordinator(contractAddress, web3j, credentials, contractGasProvider);
    }

    // public static ZapCoordinator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
    //     return new ZapCoordinator(contractAddress, web3j, transactionManager, contractGasProvider);
    // }

    public static ZapCoordinator load(BaseContractType type) throws Exception {
        return new ZapCoordinator(type);
    }

    public static RemoteCall<ZapCoordinator> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ZapCoordinator.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ZapCoordinator> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ZapCoordinator.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ZapCoordinator> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ZapCoordinator.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ZapCoordinator> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ZapCoordinator.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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

    public static class UpdatedContractEventResponse extends BaseEventResponse {
        public String name;

        public String previousAddr;

        public String newAddr;
    }

    public static class UpdatedDependenciesEventResponse extends BaseEventResponse {
        public BigInteger timestamp;

        public String contractName;

        public String contractAddr;
    }
}
