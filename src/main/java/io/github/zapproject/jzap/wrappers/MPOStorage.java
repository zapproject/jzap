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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
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
public class MPOStorage extends Contract {
    public static final String BINARY = "0x60806040526005601155336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611bd9806100586000396000f3fe608060405234801561001057600080fd5b50600436106101e55760003560e01c80636f07abcc1161010f578063b9c36209116100a2578063e600505f11610071578063e600505f14610a85578063f2fde38b14610abd578063f43fd6f014610b01578063fe151a9614610b39576101e5565b8063b9c3620914610922578063bdbc01531461095a578063cdae1fba146109dd578063e226a1b614610a29576101e5565b806381f66844116100de57806381f668441461080657806387e028281461083e5780638be8f272146108a05780638da5cb5b146108d8576101e5565b80636f07abcc1461068657806371ee2ce1146106c8578063732d161c1461074b5780637d210c31146107ce576101e5565b80634c0f8073116101875780635ba4edb6116101565780635ba4edb614610575578063602bb04f146105ad578063664c0bf9146105cb5780636cc9354f14610644576101e5565b80634c0f80731461043d5780634c5738281461048b57806350d48de0146104cd5780635632258614610533576101e5565b8063287d3d36116101c3578063287d3d36146102f95780633b7bff7f146103475780634155b8501461038d5780634615d5e9146103fb576101e5565b8063090d4259146101ea57806312faae93146102385780631518ec5614610297575b600080fd5b6102366004803603604081101561020057600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b9f565b005b610240610c5c565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610283578082015181840152602081019050610268565b505050509050019250505060405180910390f35b6102e3600480360360408110156102ad57600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cea565b6040518082815260200191505060405180910390f35b6103456004803603604081101561030f57600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610d45565b005b6103736004803603602081101561035d57600080fd5b8101908080359060200190929190505050610e0b565b604051808215151515815260200191505060405180910390f35b6103b9600480360360208110156103a357600080fd5b8101908080359060200190929190505050610e35565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6104276004803603602081101561041157600080fd5b8101908080359060200190929190505050610e76565b6040518082815260200191505060405180910390f35b6104896004803603604081101561045357600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e93565b005b6104b7600480360360208110156104a157600080fd5b8101908080359060200190929190505050610f85565b6040518082815260200191505060405180910390f35b610519600480360360408110156104e357600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610fa2565b604051808215151515815260200191505060405180910390f35b61055f6004803603602081101561054957600080fd5b810190808035906020019092919050505061100a565b6040518082815260200191505060405180910390f35b6105ab6004803603604081101561058b57600080fd5b810190808035906020019092919080359060200190929190505050611027565b005b6105b5611043565b6040518082815260200191505060405180910390f35b610642600480360360208110156105e157600080fd5b81019080803590602001906401000000008111156105fe57600080fd5b82018360208201111561061057600080fd5b8035906020019184602083028401116401000000008311171561063257600080fd5b909192939192939050505061104d565b005b6106706004803603602081101561065a57600080fd5b8101908080359060200190929190505050611180565b6040518082815260200191505060405180910390f35b6106b26004803603602081101561069c57600080fd5b810190808035906020019092919050505061119d565b6040518082815260200191505060405180910390f35b6106f4600480360360208110156106de57600080fd5b81019080803590602001909291905050506111ba565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561073757808201518184015260208101905061071c565b505050509050019250505060405180910390f35b6107776004803603602081101561076157600080fd5b8101908080359060200190929190505050611225565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107ba57808201518184015260208101905061079f565b505050509050019250505060405180910390f35b610804600480360360408110156107e457600080fd5b8101908080359060200190929190803590602001909291905050506114f2565b005b61083c6004803603604081101561081c57600080fd5b810190808035906020019092919080359060200190929190505050611583565b005b61088a6004803603604081101561085457600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506115f8565b6040518082815260200191505060405180910390f35b6108d6600480360360408110156108b657600080fd5b810190808035906020019092919080359060200190929190505050611653565b005b6108e06116c8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6109586004803603604081101561093857600080fd5b8101908080359060200190929190803590602001909291905050506116ed565b005b6109866004803603602081101561097057600080fd5b8101908080359060200190929190505050611762565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156109c95780820151818401526020810190506109ae565b505050509050019250505060405180910390f35b610a13600480360360408110156109f357600080fd5b8101908080359060200190929190803590602001909291905050506117cd565b6040518082815260200191505060405180910390f35b610a6b60048036036020811015610a3f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506117fc565b604051808215151515815260200191505060405180910390f35b610abb60048036036040811015610a9b57600080fd5b810190808035906020019092919080359060200190929190505050611852565b005b610aff60048036036020811015610ad357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061186e565b005b610b3760048036036040811015610b1757600080fd5b8101908080359060200190929190803590602001909291905050506119bf565b005b610b8560048036036040811015610b4f57600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611a59565b604051808215151515815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610bf857600080fd5b6007600083815260200190815260200160002060008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055505050565b60606010805480602002602001604051908101604052809291908181526020018280548015610ce057602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610c96575b5050505050905090565b60006007600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610d9e57600080fd5b6001600b600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b60006003600083815260200190815260200160002060009054906101000a900460ff169050919050565b600060108281548110610e4457fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000600f6000838152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610eec57600080fd5b60016002600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555060016003600084815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b6000600d6000838152602001908152602001600020549050919050565b60006002600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b6000600e6000838152602001908152602001600020549050919050565b80600e6000848152602001908152602001600020819055505050565b6000601154905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146110a657600080fd5b8181601091906110b7929190611ac1565b508181905060115411156110d057818190506011819055505b60008090505b60115481101561117b576001806000601084815481106110f257fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555080806001019150506110d6565b505050565b6000600c6000838152602001908152602001600020549050919050565b600060046000838152602001908152602001600020549050919050565b60606008600083815260200190815260200160002080548060200260200160405190810160405280929190818152602001828054801561121957602002820191906000526020600020905b815481526020019060010190808311611205575b50505050509050919050565b6060600060108054905014156112a3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600e8152602001807f4469766973696f6e206572726f7200000000000000000000000000000000000081525060200191505060405180910390fd5b6000809050600080905060008090505b6011548110156113f957600260008681526020019081526020016000206000601083815481106112df57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16156113ec5781806001019250506006600086815260200190815260200160002060006010838154811061138157fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054830192505b80806001019150506112b3565b507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821061148f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601a8152602001807f4f766572666c6f77206572726f7228676574417665726167652900000000000081525060200191505060405180910390fd5b606060016040519080825280602002602001820160405280156114c15781602001602082028038833980820191505090505b5090508183816114cd57fe5b05816000815181106114db57fe5b602002602001018181525050809350505050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461154b57600080fd5b600560008381526020019081526020016000206000828152602001908152602001600020600081548092919060010191905055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146115dc57600080fd5b8060046000848152602001908152602001600020819055505050565b60006006600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146116ac57600080fd5b80600c6000848152602001908152602001600020819055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461174657600080fd5b80600f6000848152602001908152602001600020819055505050565b6060600960008381526020019081526020016000208054806020026020016040519081016040528092919081815260200182805480156117c157602002820191906000526020600020905b8154815260200190600101908083116117ad575b50505050509050919050565b600060056000848152602001908152602001600020600083815260200190815260200160002054905092915050565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b80600d6000848152602001908152602001600020819055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146118c757600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561190157600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614611a1857600080fd5b600960008381526020019081526020016000208190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b6000600b600084815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b828054828255906000526020600020908101928215611b50579160200282015b82811115611b4f57823573ffffffffffffffffffffffffffffffffffffffff168260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190611ae1565b5b509050611b5d9190611b61565b5090565b611ba191905b80821115611b9d57600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905550600101611b67565b5090565b9056fea265627a7a72315820763cb6bc964d000b49d9e3c00aeb71bf277dc7d9d54d056f7810e8605c15aa1464736f6c63430005100032";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETTHRESHOLD = "setThreshold";

    public static final String FUNC_SETCLIENTQUERYID = "setClientQueryId";

    public static final String FUNC_SETRESPONDERS = "setResponders";

    public static final String FUNC_REACHEDTHRESHOLD = "reachedThreshold";

    public static final String FUNC_SETQUERYSTATUS = "setQueryStatus";

    public static final String FUNC_TALLYRESPONSE = "tallyResponse";

    public static final String FUNC_TALLYADDRESS = "tallyAddress";

    public static final String FUNC_ADDRESPONSE = "addResponse";

    public static final String FUNC_ADDTHRESHOLDRESPONSE = "addThresholdResponse";

    public static final String FUNC_SETDELTA = "setDelta";

    public static final String FUNC_SETPRECISION = "setPrecision";

    public static final String FUNC_ONLYONERESPONSE = "onlyOneResponse";

    public static final String FUNC_GETTHRESHOLDSTATUS = "getThresholdStatus";

    public static final String FUNC_GETADDRESSSTATUS = "getAddressStatus";

    public static final String FUNC_GETTHRESHOLD = "getThreshold";

    public static final String FUNC_GETTALLY = "getTally";

    public static final String FUNC_GETADDRESSTALLY = "getAddressTally";

    public static final String FUNC_GETADDRESSRESPONSE = "getAddressResponse";

    public static final String FUNC_GETCLIENTQUERYID = "getClientQueryId";

    public static final String FUNC_GETQUERYSTATUS = "getQueryStatus";

    public static final String FUNC_GETTHRESHOLDRESPONSES = "getThresholdResponses";

    public static final String FUNC_GETNUMRESPONDERS = "getNumResponders";

    public static final String FUNC_GETRESPONDERADDRESS = "getResponderAddress";

    public static final String FUNC_GETRESPONDERS = "getResponders";

    public static final String FUNC_GETRESPONSES = "getResponses";

    public static final String FUNC_GETDELTA = "getDelta";

    public static final String FUNC_GETPRECISION = "getPrecision";

    public static final String FUNC_GETQUERYTHRESHOLD = "getQueryThreshold";

    public static final String FUNC_GETAVERAGE = "getAverage";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MPOStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MPOStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MPOStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MPOStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> setThreshold(BigInteger queryId, BigInteger _threshold) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETTHRESHOLD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(_threshold)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setClientQueryId(BigInteger mpoId, BigInteger _clientQueryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCLIENTQUERYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(mpoId), 
                new org.web3j.abi.datatypes.generated.Uint256(_clientQueryId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setResponders(List<String> parties) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETRESPONDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(parties, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> reachedThreshold(BigInteger queryId, String sender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REACHEDTHRESHOLD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(sender)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setQueryStatus(BigInteger queryId, BigInteger status) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETQUERYSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> tallyResponse(BigInteger queryId, BigInteger response) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TALLYRESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(response)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> tallyAddress(BigInteger queryId, String responder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TALLYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(responder)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addResponse(BigInteger queryId, String party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDRESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(party)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addThresholdResponse(BigInteger queryId, BigInteger response) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDTHRESHOLDRESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(response)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDelta(BigInteger queryId, BigInteger _delta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDELTA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(_delta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setPrecision(BigInteger queryId, BigInteger _precision) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPRECISION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(_precision)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> onlyOneResponse(BigInteger queryId, String party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ONLYONERESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(party)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> getThresholdStatus(BigInteger queryId, String party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTHRESHOLDSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(party)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> getAddressStatus(String party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(party)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> getThreshold(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTHRESHOLD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getTally(BigInteger queryId, BigInteger response) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTALLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.generated.Uint256(response)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getAddressTally(BigInteger queryId, String responder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSTALLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(responder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getAddressResponse(BigInteger queryId, String responder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSRESPONSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId), 
                new org.web3j.abi.datatypes.Address(responder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getClientQueryId(BigInteger mpoId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCLIENTQUERYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(mpoId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getQueryStatus(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETQUERYSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getThresholdResponses(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTHRESHOLDRESPONSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
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

    public RemoteFunctionCall<BigInteger> getNumResponders() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMRESPONDERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getResponderAddress(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESPONDERADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getResponders() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESPONDERS, 
                Arrays.<Type>asList(), 
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

    public RemoteFunctionCall<List> getResponses(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESPONSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
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

    public RemoteFunctionCall<BigInteger> getDelta(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETDELTA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPrecision(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRECISION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> getQueryThreshold(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETQUERYTHRESHOLD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<List> getAverage(BigInteger queryId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAVERAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(queryId)), 
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

    @Deprecated
    public static MPOStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MPOStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MPOStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MPOStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MPOStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MPOStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MPOStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MPOStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MPOStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MPOStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MPOStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MPOStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MPOStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MPOStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MPOStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MPOStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
}
