package com.zap.sdk;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
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
public class CurrentCost extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506040516112f43803806112f48339818101604052602081101561003357600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505061011661011c60201b60201c565b5061023d565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156101c057600080fd5b505afa1580156101d4573d6000803e3d6000fd5b505050506040513d60208110156101ea57600080fd5b8101908080519060200190929190505050600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6110a88061024c6000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80639cb8a26a1161005b5780639cb8a26a1461014c578063c1ca69c414610156578063ecca1fad146101b8578063f2fde38b146102245761007d565b8063197d66d5146100825780636e5ecdff146100f85780638da5cb5b14610102575b600080fd5b6100e26004803603608081101561009857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190505050610268565b6040518082815260200191505060405180910390f35b610100610578565b005b61010a610645565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61015461066a565b005b6101a26004803603604081101561016c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506106fd565b6040518082815260200191505060405180910390f35b61020e600480360360608110156101ce57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001909291905050506109b7565b6040518082815260200191505060405180910390f35b6102666004803603602081101561023a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506109cf565b005b600080600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166387cd29a487876040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b15801561031257600080fd5b505afa158015610326573d6000803e3d6000fd5b505050506040513d602081101561033c57600080fd5b810190808051906020019092919050505090506060816040519080825280602002602001820160405280156103805781602001602082028038833980820191505090505b509050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632316a9ff88886040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060006040518083038186803b15801561042a57600080fd5b505afa15801561043e573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561046857600080fd5b810190808051604051939291908464010000000082111561048857600080fd5b8382019150602082018581111561049e57600080fd5b82518660208202830111640100000000821117156104bb57600080fd5b8083526020830192505050908051906020019060200280838360005b838110156104f25780820151818401526020810190506104d7565b505050509050016040525050509050600061050e828787610b20565b9050600081121561056a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001806110296026913960400191505060405180910390fd5b809350505050949350505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461063b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4572726f723a20436f6f7264696e61746f72204f6e6c792046756e6374696f6e81525060200191505060405180910390fd5b610643610c71565b565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146106c357600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b600080600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166387cd29a485856040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b1580156107a757600080fd5b505afa1580156107bb573d6000803e3d6000fd5b505050506040513d60208110156107d157600080fd5b810190808051906020019092919050505090506060816040519080825280602002602001820160405280156108155781602001602082028038833980820191505090505b509050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632316a9ff86866040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060006040518083038186803b1580156108bf57600080fd5b505afa1580156108d3573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f8201168201806040525060208110156108fd57600080fd5b810190808051604051939291908464010000000082111561091d57600080fd5b8382019150602082018581111561093357600080fd5b825186602082028301116401000000008211171561095057600080fd5b8083526020830192505050908051906020019060200280838360005b8381101561098757808201518184015260208101905061096c565b5050505090500160405250505090508060018303815181106109a557fe5b60200260200101519250505092915050565b60006109c68484846000610268565b90509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610a2857600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610a6257600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008060009050600080905085600187510381518110610b3c57fe5b60200260200101518486011115610bbb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4572726f723a2046756e6374696f6e206e6f7420696e20646f74206c696d697481525060200191505060405180910390fd5b5b8551821015610c67576000868381518110610bd357fe5b6020026020010151905060008760018386010181518110610bf057fe5b602002602001015190506000600283860101905081881115610c1757809450505050610bbc565b610c3589868a858b8d0111610c2c578a610c30565b8b86035b610d92565b840193508187890111610c4f578395505050505050610c6a565b60018883030187039650819750809450505050610bbc565b50505b9392505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015610d1557600080fd5b505afa158015610d29573d6000803e3d6000fd5b505050506040513d6020811015610d3f57600080fd5b8101908080519060200190929190505050600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b600080600090506000868681518110610da757fe5b6020026020010151905060006001870190506000828201905060008290505b81811015610e1257610ddd60018903848303610e7c565b610deb888a01858403610e7c565b038a8281518110610df857fe5b602002602001015102850194508080600101915050610dc6565b506000841215610e6d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602581526020018061104f6025913960400191505060405180910390fd5b83945050505050949350505050565b600060068211158015610e90575060008210155b610f02576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f4572726f723a20496e76616c696420506965636577697365204c6f676963000081525060200191505060405180910390fd5b6000821415610f1357829050611022565b6001821415610f3357600260018401840281610f2b57fe5b049050611022565b6002821415610f5b576006600184600202016001850185020281610f5357fe5b049050611022565b6003821415610f7d5760028060018501850281610f7457fe5b040a9050611022565b6004821415610fb457601e600184600302858660030202010360018560020201600186018602020281610fac57fe5b049050611022565b6005821415610fdd576001836002026002850a600202010360026001850185020a029050611022565b600682141561101d57602a6001846003026003860a6006026004870a6003020103016001856002020160018601860202028161101557fe5b049050611022565b600090505b9291505056fe4572726f723a20436f7374206f6620646f74732063616e6e6f74206265206e656761746976654572726f723a20436f7374206d7573742062652067726561746572207468616e207a65726fa265627a7a723158207548ebf58a656add126e68536ad1072ecafb152380ba75b6648dcf47a1fbec8a64736f6c63430005100032";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SELFDESTRUCT = "selfDestruct";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPDATEDEPENDENCIES = "updateDependencies";

    public static final String FUNC__CURRENTCOSTOFDOT = "_currentCostOfDot";

    public static final String FUNC__COSTOFNDOTS = "_costOfNDots";

    public static final String FUNC__DOTLIMIT = "_dotLimit";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected CurrentCost(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CurrentCost(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CurrentCost(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CurrentCost(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> selfDestruct() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELFDESTRUCT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateDependencies() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEDEPENDENCIES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> _currentCostOfDot(String oracleAddress, byte[] endpoint, BigInteger start) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC__CURRENTCOSTOFDOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(oracleAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint), 
                new org.web3j.abi.datatypes.generated.Uint256(start)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> _costOfNDots(String oracleAddress, byte[] endpoint, BigInteger start, BigInteger nDots) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC__COSTOFNDOTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(oracleAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint), 
                new org.web3j.abi.datatypes.generated.Uint256(start), 
                new org.web3j.abi.datatypes.generated.Uint256(nDots)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> _dotLimit(String oracleAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC__DOTLIMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(oracleAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static CurrentCost load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CurrentCost(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CurrentCost load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CurrentCost(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CurrentCost load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CurrentCost(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CurrentCost load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CurrentCost(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CurrentCost> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(CurrentCost.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CurrentCost> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(CurrentCost.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CurrentCost> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(CurrentCost.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CurrentCost> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(CurrentCost.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

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
