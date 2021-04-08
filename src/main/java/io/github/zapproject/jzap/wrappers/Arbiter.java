package io.github.zapproject.jzap.wrappers;

import io.github.zapproject.jzap.BaseContract;
import io.github.zapproject.jzap.types.BaseContractTypes.BaseContractType;
import io.github.zapproject.jzap.types.BaseContractTypes.NetworkProviderOptions;
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
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint64;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint96;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;


/**
 * Provides an interface to the Arbiter contract for managing temporal subscriptions to oracles.
 */
@SuppressWarnings("rawtypes")
public class Arbiter extends BaseContract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b506040516200289538038062002895833981810160405260208110156200003757600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506200011c6200012360201b60201c565b50620003d2565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015620001c857600080fd5b505afa158015620001dd573d6000803e3d6000fd5b505050506040513d6020811015620001f457600080fd5b8101908080519060200190929190505050600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f444154414241534500000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200034f57600080fd5b505afa15801562000364573d6000803e3d6000fd5b505050506040513d60208110156200037b57600080fd5b8101908080519060200190929190505050905080600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6124b380620003e26000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c80639c87920a1161008c578063e00dbb4111610066578063e00dbb41146105d7578063e87e69fe14610621578063f2fde38b146106bf578063fb88463014610703576100ea565b80639c87920a146104375780639cb8a26a14610537578063dbe7436414610541576100ea565b80636c526d85116100c85780636c526d85146102255780636dbe08df146103015780636e5ecdff146103e35780638da5cb5b146103ed576100ea565b80633e24a696146100ef5780634d655aff1461018d57806362800bd8146101d7575b600080fd5b61015b6004803603606081101561010557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610751565b60405180826bffffffffffffffffffffffff166bffffffffffffffffffffffff16815260200191505060405180910390f35b6101956108ee565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610223600480360360408110156101ed57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610914565b005b6102916004803603606081101561023b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061098f565b604051808467ffffffffffffffff1667ffffffffffffffff168152602001836bffffffffffffffffffffffff166bffffffffffffffffffffffff168152602001826bffffffffffffffffffffffff166bffffffffffffffffffffffff168152602001935050505060405180910390f35b6103e16004803603606081101561031757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019064010000000081111561035e57600080fd5b82018360208201111561037057600080fd5b8035906020019184602083028401116401000000008311171561039257600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f8201169050808301925050505050505091929192905050506109c4565b005b6103eb610a77565b005b6103f5610b44565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610535600480360360a081101561044d57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019064010000000081111561049457600080fd5b8201836020820111156104a657600080fd5b803590602001918460208302840111640100000000831117156104c857600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190803567ffffffffffffffff169060200190929190505050610b69565b005b61053f610e46565b005b6105ad6004803603606081101561055757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610ed9565b604051808267ffffffffffffffff1667ffffffffffffffff16815260200191505060405180910390f35b6105df611076565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61068d6004803603606081101561063757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061109c565b60405180826bffffffffffffffffffffffff166bffffffffffffffffffffffff16815260200191505060405180910390f35b610701600480360360208110156106d557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611239565b005b61074f6004803603604081101561071957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061138a565b005b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ecb0d6485858560405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f626c6f636b537461727400000000000000000000000000000000000000000000815250600a019350505050604051602081830303815290604052805190602001206040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156108aa57600080fd5b505afa1580156108be573d6000803e3d6000fd5b505050506040513d60208110156108d457600080fd5b810190808051906020019092919050505090509392505050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b61091f823383611406565b1561098b5760018081111561093057fe5b3373ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fe27dcf9b3b50e7d3af96f88c64ebd7307cdef3359182881bfe7210b42433a44960405160405180910390a45b5050565b600080600061099f868686610ed9565b6109aa878787610751565b6109b588888861109c565b92509250925093509350939050565b8273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fd31e849abbddf4d7669b530a73ab91262191fb280906f73316d4830f67f10d7d84846040518083815260200180602001828103825283818151815260200191508051906020019060200280838360005b83811015610a5e578082015181840152602081019050610a43565b50505050905001935050505060405180910390a3505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610b3a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4572726f723a20436f6f7264696e61746f72204f6e6c792046756e6374696f6e81525060200191505060405180910390fd5b610b42611847565b565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008167ffffffffffffffff1611610bcc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806123fd6021913960400191505060405180910390fd5b6000610bd9863387610ed9565b67ffffffffffffffff1614610c39576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260378152602001806124486037913960400191505060405180910390fd5b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166316614c98338787856040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018267ffffffffffffffff168152602001945050505050602060405180830381600087803b158015610d2857600080fd5b505af1158015610d3c573d6000803e3d6000fd5b505050506040513d6020811015610d5257600080fd5b810190808051906020019092919050505050610d7e85338684438667ffffffffffffffff164301611af0565b8067ffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff168673ffffffffffffffffffffffffffffffffffffffff167f10cd0837c48b7daca59ad3bbdbdc193ea84eea36bfde21b4c4b0960ab41b9f2f8587896040518084815260200180602001838152602001828103825284818151815260200191508051906020019060200280838360005b83811015610e2a578082015181840152602081019050610e0f565b5050505090500194505050505060405180910390a45050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610e9f57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ecb0d6485858560405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f646f7473000000000000000000000000000000000000000000000000000000008152506004019350505050604051602081830303815290604052805190602001206040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561103257600080fd5b505afa158015611046573d6000803e3d6000fd5b505050506040513d602081101561105c57600080fd5b810190808051906020019092919050505090509392505050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ecb0d6485858560405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f707265426c6f636b456e64000000000000000000000000000000000000000000815250600b019350505050604051602081830303815290604052805190602001206040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156111f557600080fd5b505afa158015611209573d6000803e3d6000fd5b505050506040513d602081101561121f57600080fd5b810190808051906020019092919050505090509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461129257600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156112cc57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b611395338383611406565b1561140257600060018111156113a757fe5b8273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fe27dcf9b3b50e7d3af96f88c64ebd7307cdef3359182881bfe7210b42433a44960405160405180910390a45b5050565b600080611414858585610ed9565b67ffffffffffffffff169050600061142d86868661109c565b6bffffffffffffffffffffffff16905060008211611496576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a81526020018061241e602a913960400191505060405180910390fd5b8043101561170d5760006114ab878787610751565b6bffffffffffffffffffffffff164303905060008184039050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633b058aa7888a89866040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001945050505050602060405180830381600087803b1580156115a957600080fd5b505af11580156115bd573d6000803e3d6000fd5b505050506040513d60208110156115d357600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f6dfac25888a89856040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001945050505050602060405180830381600087803b1580156116ca57600080fd5b505af11580156116de573d6000803e3d6000fd5b505050506040513d60208110156116f457600080fd5b810190808051906020019092919050505050505061182f565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633b058aa7868887866040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001945050505050602060405180830381600087803b1580156117f257600080fd5b505af1158015611806573d6000803e3d6000fd5b505050506040513d602081101561181c57600080fd5b8101908080519060200190929190505050505b61183a868686611f89565b6001925050509392505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156118eb57600080fd5b505afa1580156118ff573d6000803e3d6000fd5b505050506040513d602081101561191557600080fd5b8101908080519060200190929190505050600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f444154414241534500000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015611a6f57600080fd5b505afa158015611a83573d6000803e3d6000fd5b505050506040513d6020811015611a9957600080fd5b8101908080519060200190929190505050905080600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db87878760405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f646f747300000000000000000000000000000000000000000000000000000000815250600401935050505060405160208183030381529060405280519060200120856040518363ffffffff1660e01b8152600401808381526020018267ffffffffffffffff16815260200192505050600060405180830381600087803b158015611c5b57600080fd5b505af1158015611c6f573d6000803e3d6000fd5b50505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db87878760405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f626c6f636b537461727400000000000000000000000000000000000000000000815250600a01935050505060405160208183030381529060405280519060200120846bffffffffffffffffffffffff166040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b158015611de257600080fd5b505af1158015611df6573d6000803e3d6000fd5b50505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db87878760405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f707265426c6f636b456e64000000000000000000000000000000000000000000815250600b01935050505060405160208183030381529060405280519060200120836bffffffffffffffffffffffff166040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b158015611f6957600080fd5b505af1158015611f7d573d6000803e3d6000fd5b50505050505050505050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db84848460405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f646f74730000000000000000000000000000000000000000000000000000000081525060040193505050506040516020818303038152906040528051906020012060006040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b1580156120eb57600080fd5b505af11580156120ff573d6000803e3d6000fd5b50505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db84848460405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f626c6f636b537461727400000000000000000000000000000000000000000000815250600a0193505050506040516020818303038152906040528051906020012060006040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b15801561226557600080fd5b505af1158015612279573d6000803e3d6000fd5b50505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354c552db84848460405160200180807f737562736372697074696f6e7300000000000000000000000000000000000000815250600d018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401828152602001807f707265426c6f636b456e64000000000000000000000000000000000000000000815250600b0193505050506040516020818303038152906040528051906020012060006040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b1580156123df57600080fd5b505af11580156123f3573d6000803e3d6000fd5b5050505050505056fe4572726f723a204d757374206265206174206c65617374206f6e6520626c6f636b4572726f723a2053756273637269626572206d7573742068617665206120737562736372697074696f6e4572726f723a2043616e6e6f74207265696e7374616e746961746520612063757272656e746c792061637469766520636f6e7472616374a265627a7a72315820109070efff1eafb172fad43b0755aa2ab6ffb54245bd44d43f4b31ad939c6c5d64736f6c63430005100032";

    public static final String FUNC_BONDAGEADDRESS = "bondageAddress";

    public static final String FUNC_DB = "db";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SELFDESTRUCT = "selfDestruct";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPDATEDEPENDENCIES = "updateDependencies";

    public static final String FUNC_PASSPARAMS = "passParams";

    public static final String FUNC_INITIATESUBSCRIPTION = "initiateSubscription";

    public static final String FUNC_GETSUBSCRIPTION = "getSubscription";

    public static final String FUNC_ENDSUBSCRIPTIONPROVIDER = "endSubscriptionProvider";

    public static final String FUNC_ENDSUBSCRIPTIONSUBSCRIBER = "endSubscriptionSubscriber";

    public static final String FUNC_GETDOTS = "getDots";

    public static final String FUNC_GETBLOCKSTART = "getBlockStart";

    public static final String FUNC_GETPREBLOCKEND = "getPreBlockEnd";

    public static final Event DATAPURCHASE_EVENT = new Event("DataPurchase", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>(true) {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event DATASUBSCRIPTIONEND_EVENT = new Event("DataSubscriptionEnd", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint8>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PARAMSPASSED_EVENT = new Event("ParamsPassed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }
    
    /**
     * Initializes a subclass of BaseContract that can access the methods of the Arbiter contract.
     * @param type      wrapper class NetworkProviderOptions for {int networkID, org.web3j.protocol.Web3j web3j, org.web3j.crypto.Credentials credentials, org.web3j.tx.gas.ContractGasProvider contractGasProvider}
     */
    protected Arbiter(NetworkProviderOptions type) throws Exception {
        super(BINARY, type, "ARBITER");
    }

    /**
     * Initializes a subclass of BaseContract that can access the methods of the Arbiter contract.
     * @param contractAddress       Deployed Arbiter contract address
     * @param web3j                 Web3j instance to interact with contracts
     * @param credentials           Credentials acount 
     * @param contractGasProvider   Contract gas data
     */
    protected Arbiter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) throws Exception {
        super(new BaseContractType(BINARY, contractAddress, web3j, credentials, contractGasProvider));
    }

    /**
     * Listen for data purchase events
     * @param transactionReceipt Log of transactions done with contracts
     */
    @SuppressWarnings("unchecked")
    public List<DataPurchaseEventResponse> getDataPurchaseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DATAPURCHASE_EVENT, transactionReceipt);
        ArrayList<DataPurchaseEventResponse> responses = new ArrayList<DataPurchaseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DataPurchaseEventResponse typedResponse = new DataPurchaseEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.subscriber = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.publicKey = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.endpointParams = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    /**
     * Listens for a data purchase event
     * @param   filter  EthFilter which specifies which range of blocks to listen on a given contract address
     * @return  A DataPurchaseEventResponse as a Flowable
     */
    public Flowable<DataPurchaseEventResponse> dataPurchaseEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DataPurchaseEventResponse>() {
            @Override
            public DataPurchaseEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DATAPURCHASE_EVENT, log);
                DataPurchaseEventResponse typedResponse = new DataPurchaseEventResponse();
                typedResponse.log = log;
                typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.subscriber = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.publicKey = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.endpointParams = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    /**
     * Listens for a data purchase event
     * @param   startBlock  Starting block to begin listening on
     * @param   endBlock    Ending block to stop listening on
     * @return  A DataPurchaseEventResponse as a Flowable
     */
    public Flowable<DataPurchaseEventResponse> dataPurchaseEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DATAPURCHASE_EVENT));
        return dataPurchaseEventFlowable(filter);
    }

    /**
     * Listen for data subscription events
     * @param transactionReceipt Log of transactions done with contracts
     */
    public List<DataSubscriptionEndEventResponse> getDataSubscriptionEndEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DATASUBSCRIPTIONEND_EVENT, transactionReceipt);
        ArrayList<DataSubscriptionEndEventResponse> responses = new ArrayList<DataSubscriptionEndEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DataSubscriptionEndEventResponse typedResponse = new DataSubscriptionEndEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.subscriber = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.terminator = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    /**
     * Listens for a data subscription event
     * @param   filter  EthFilter which specifies which range of blocks to listen on a given contract address
     * @return  A DataSubscriptionEventResponse as a Flowable
     */
    public Flowable<DataSubscriptionEndEventResponse> dataSubscriptionEndEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DataSubscriptionEndEventResponse>() {
            @Override
            public DataSubscriptionEndEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DATASUBSCRIPTIONEND_EVENT, log);
                DataSubscriptionEndEventResponse typedResponse = new DataSubscriptionEndEventResponse();
                typedResponse.log = log;
                typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.subscriber = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.terminator = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    /**
     * Listens for a data subscription event
     * @param   startBlock  Starting block to begin listening on
     * @param   endBlock    Ending block to stop listening on
     * @return  A DataSubscriptionEventResponse as a Flowable
     */
    public Flowable<DataSubscriptionEndEventResponse> dataSubscriptionEndEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DATASUBSCRIPTIONEND_EVENT));
        return dataSubscriptionEndEventFlowable(filter);
    }

    /**
     * Listen for ownership transferred events
     * @param transactionReceipt Log of transactions done with contracts
     */
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

    /**
     * Listen for params passed events
     * @param transactionReceipt Log of transactions done with contracts
     */
    @SuppressWarnings("unchecked")
    public List<ParamsPassedEventResponse> getParamsPassedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PARAMSPASSED_EVENT, transactionReceipt);
        ArrayList<ParamsPassedEventResponse> responses = new ArrayList<ParamsPassedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ParamsPassedEventResponse typedResponse = new ParamsPassedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.receiver = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.params = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }
    
    public RemoteFunctionCall<String> bondageAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BONDAGEADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> db() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    /**
     * Broadcast parameters from sender to offchain receiver
     * @param   receiver    Address to receive parameters
     * @param   endpoint    Data endpoint of the provider
     * @param   params      Params passed to receiver
     * @return  A remote function call to Arbiter contract which returns a transaction receipt
     */
    public RemoteFunctionCall<TransactionReceipt> passParams(String receiver, byte[] endpoint, List<byte[]> params) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PASSPARAMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(receiver), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(params, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    /**
     * Initializes a subscription with a given provider, endpoint, and endpoint parameters.
     * @param   providerAddress   Address of the data provider
     * @param   endpoint          Data endpoint of the provider
     * @param   endpointParams    Params passed to endpoint
     * @param   publicKey         Public key of provider
     * @param   blocks            Number of blocks that the subscription will last for
     * @return  A remote function call to Arbiter contract which returns a transaction receipt
     */
    public RemoteFunctionCall<TransactionReceipt> initiateSubscription(String providerAddress, byte[] endpoint, List<byte[]> endpointParams, BigInteger publicKey, BigInteger blocks) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIATESUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(endpointParams, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(publicKey), 
                new org.web3j.abi.datatypes.generated.Uint64(blocks)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    /**
     * Gets the subscription status for a given provider, subscriber, and endpoint
     * @param   providerAddress     Address of the data provider
     * @param   subscriberAddress   Addres of the subscriber
     * @param   endpoint            Data endpoint of the provider
     * @return  A remote function call to Arbiter contract which returns a subscription tuple
     */
    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>> getSubscription(String providerAddress, String subscriberAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.Address(subscriberAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}, new TypeReference<Uint96>() {}, new TypeReference<Uint96>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    /**
     * Ends a currently active subscription for a given subscriber and endpoint from the provider.
     * @param   subscriberAddress    Address of the data subscriber
     * @param   endpoint             Data endpoint of the provider
     * @return  A remote function call to Arbiter contract which returns a transaction receipt
     */
    public RemoteFunctionCall<TransactionReceipt> endSubscriptionProvider(String subscriberAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ENDSUBSCRIPTIONPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(subscriberAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    /**
     * Ends a currently active subscription for a given subscriber and endpoint from the subscriber.
     * @param   providerAddress   Address of the data provider
     * @param   endpoint          Data endpoint of the provider
     * @return  A remote call function to Arbiter contract which returns a transaction receipt
     */
    public RemoteFunctionCall<TransactionReceipt> endSubscriptionSubscriber(String providerAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ENDSUBSCRIPTIONSUBSCRIBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    /**
     * Get subscriber dots remaining for specified provider endpoint
     * @param   providerAddress     Address of the data provider
     * @param   subscriberAddress   Address of the data subscriber
     * @param   endpoint            Data endpoint of the provider
     * @return  A remote call function to Arbiter contract which returns number of dots remaining
     */
    public RemoteFunctionCall<BigInteger> getDots(String providerAddress, String subscriberAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETDOTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.Address(subscriberAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    /**
     * Get first subscription block number
     * @param   providerAddress     Address of the data provider
     * @param   subscriberAddress   Address of the data subscriber
     * @param   endpoint            Data endpoint of the provider
     * @return  A remote call function to Arbiter contract which returns first subscribed block number
     */
    public RemoteFunctionCall<BigInteger> getBlockStart(String providerAddress, String subscriberAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBLOCKSTART, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.Address(subscriberAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    /**
     * Get subscription last block number
     * @param   providerAddress     Address of the data provider
     * @param   subscriberAddress   Address of the data subscriber
     * @param   endpoint            Data endpoint of the provider
     * @return  A remote call function to Arbiter contract which returns block number that subscription will end
     */
    public RemoteFunctionCall<BigInteger> getPreBlockEnd(String providerAddress, String subscriberAddress, byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPREBLOCKEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(providerAddress), 
                new org.web3j.abi.datatypes.Address(subscriberAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    /**
     * Wrapper to initializing a subclass of BaseContract that can access the methods of the Arbiter contract.
     * @param   contractAddress     Address of the deployed Arbiter contract
     * @param   web3j               Instance of Web3j to interact with contracts
     * @param   contractGasProvider Contract gas data
     * @return  Loaded Arbiter contract  
     */
    public static Arbiter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) throws Exception {
        return new Arbiter(contractAddress, web3j, credentials, contractGasProvider);
    }

    /**
     * Wrapper to initializing a subclass of BaseContract that can access the methods of the Arbiter contract.
     * @param   type wrapper class NetworkProviderOptions for {int networkID, org.web3j.protocol.Web3j web3j, org.web3j.crypto.Credentials credentials, org.web3j.tx.gas.ContractGasProvider contractGasProvider}
     * @return  Loaded Arbiter contract
     */
    public static Arbiter load(NetworkProviderOptions type) throws Exception {
        return new Arbiter(type);
    }

    /**
     * Deploys a new Arbiter contract for testing purposes
     * @param   web3j               Instance of Web3j to interact with contracts
     * @param   credentials         Credentials account data
     * @param   contractGasProvider Contract gas data
     * @param   c                   Address of ZapCoordinator contract
     * @return  A remote function call which returns a new Arbiter contract
     */
    public static RemoteCall<Arbiter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(Arbiter.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    /**
     * Deploys a new Arbiter contract for testing purposes
     */
    public static RemoteCall<Arbiter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String c) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c)));
        return deployRemoteCall(Arbiter.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    /**
     * Event object for data purchase events
     */
    public static class DataPurchaseEventResponse extends BaseEventResponse {
        public String provider;

        public String subscriber;

        public BigInteger amount;

        public BigInteger publicKey;

        public List<byte[]> endpointParams;

        public byte[] endpoint;
    }

    /**
     * Event object for data subscription events
     */
    public static class DataSubscriptionEndEventResponse extends BaseEventResponse {
        public String provider;

        public String subscriber;

        public BigInteger terminator;
    }

    /**
     * Event object for ownership transferred events
     */
    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    /**
     * Event object for params passed events
     */
    public static class ParamsPassedEventResponse extends BaseEventResponse {
        public String sender;

        public String receiver;

        public byte[] endpoint;

        public List<byte[]> params;
    }
}
