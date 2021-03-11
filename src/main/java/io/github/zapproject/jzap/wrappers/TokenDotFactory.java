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
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class TokenDotFactory extends BaseContract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b5060405162002e5738038062002e57833981810160405260808110156200003757600080fd5b8101908080519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260098152602001807f5a41505f544f4b454e000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200018c57600080fd5b505afa158015620001a1573d6000803e3d6000fd5b505050506040513d6020811015620001b857600080fd5b8101908080519060200190929190505050600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663095ea7b3600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015620002ec57600080fd5b505afa15801562000301573d6000803e3d6000fd5b505050506040513d60208110156200031857600080fd5b81019080805190602001909291905050506000196040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156200039657600080fd5b505af1158015620003ab573d6000803e3d6000fd5b505050506040513d6020811015620003c257600080fd5b81019080805190602001909291905050505082600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015620004bc57600080fd5b505afa158015620004d1573d6000803e3d6000fd5b505050506040513d6020811015620004e857600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663af87c83384846040518363ffffffff1660e01b81526004018083815260200182815260200192505050602060405180830381600087803b1580156200055757600080fd5b505af11580156200056c573d6000803e3d6000fd5b505050506040513d60208110156200058357600080fd5b81019080805190602001909291905050505050505050506128ad80620005aa6000396000f3fe608060405234801561001057600080fd5b50600436106100f55760003560e01c80638da5cb5b11610097578063e77772fe11610066578063e77772fe1461073b578063f2fde38b14610785578063f3457c01146107c9578063f4325d671461080b576100f5565b80638da5cb5b146105925780639201de55146105dc5780639495c25a14610683578063b12e4410146106cd576100f5565b806351f93215116100d357806351f93215146103d0578063593b79fe146104085780635d7c83f1146104c557806366903e8014610524576100f5565b806306af0650146100fa5780634629ffea146102065780634d8de4fc14610398575b600080fd5b6101c46004803603606081101561011057600080fd5b8101908080359060200190929190803590602001909291908035906020019064010000000081111561014157600080fd5b82018360208201111561015357600080fd5b8035906020019184602083028401116401000000008311171561017557600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f820116905080830192505050505050509192919290505050610855565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6103566004803603604081101561021c57600080fd5b810190808035906020019064010000000081111561023957600080fd5b82018360208201111561024b57600080fd5b8035906020019184600183028401116401000000008311171561026d57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156102d057600080fd5b8201836020820111156102e257600080fd5b8035906020019184600183028401116401000000008311171561030457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610f1c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6103ce600480360360408110156103ae57600080fd5b81019080803590602001909291908035906020019092919050505061110a565b005b610406600480360360408110156103e657600080fd5b810190808035906020019092919080359060200190929190505050611892565b005b61044a6004803603602081101561041e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506120f7565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561048a57808201518184015260208101905061046f565b50505050905090810190601f1680156104b75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6104cd6121b9565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156105105780820151818401526020810190506104f5565b505050509050019250505060405180910390f35b6105506004803603602081101561053a57600080fd5b8101908080359060200190929190505050612211565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61059a612244565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610608600480360360208110156105f257600080fd5b8101908080359060200190929190505050612269565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561064857808201518184015260208101905061062d565b50505050905090810190601f1680156106755780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61068b6122ce565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6106f9600480360360208110156106e357600080fd5b81019080803590602001909291905050506122f4565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610743612568565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6107c76004803603602081101561079b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061258e565b005b6107f5600480360360208110156107df57600080fd5b81019080803590602001909291905050506126df565b6040518082815260200191505060405180910390f35b610813612700565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146108b057600080fd5b600073ffffffffffffffffffffffffffffffffffffffff166006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610985576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f43757276652073706563696669657220616c726561647920657869737473000081525060200191505060405180910390fd5b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015610a2b57600080fd5b505afa158015610a3f573d6000803e3d6000fd5b505050506040513d6020811015610a5557600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663186b79c9306040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b158015610ae557600080fd5b505afa158015610af9573d6000803e3d6000fd5b505050506040513d6020811015610b0f57600080fd5b8101908080519060200190929190505050610b92576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f50726f7669646572206e6f7420696e746969616c697a6564000000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1663238b3aed8685306040518463ffffffff1660e01b815260040180848152602001806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019060200280838360005b83811015610c3b578082015181840152602081019050610c20565b50505050905001945050505050602060405180830381600087803b158015610c6257600080fd5b505af1158015610c76573d6000803e3d6000fd5b505050506040513d6020811015610c8c57600080fd5b810190808051906020019092919050505050610cb8610caa86612269565b610cb386612269565b610f1c565b6006600087815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060078590806001815401808255809150509060018203906000526020600020016000909192909190915055508073ffffffffffffffffffffffffffffffffffffffff16635750644a86610d8e600660008a815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166120f7565b6040518363ffffffff1660e01b81526004018083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610de3578082015181840152602081019050610dc8565b50505050905090810190601f168015610e105780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610e3057600080fd5b505af1158015610e44573d6000803e3d6000fd5b505050507f6c98c7e1fb155d4c2c1f008682fd94fb74d1c9667207aaaa9ab65cee2b38ea7a6006600087815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a16006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169150509392505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610f7757600080fd5b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663198e2b8a85856040518363ffffffff1660e01b8152600401808060200180602001838103835285818151815260200191508051906020019080838360005b8381101561100c578082015181840152602081019050610ff1565b50505050905090810190601f1680156110395780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015611072578082015181840152602081019050611057565b50505050905090810190601f16801561109f5780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b1580156110c057600080fd5b505af11580156110d4573d6000803e3d6000fd5b505050506040513d60208110156110ea57600080fd5b810190808051906020019092919050505090508091508191505092915050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156111ae57600080fd5b505afa1580156111c2573d6000803e3d6000fd5b505050506040513d60208110156111d857600080fd5b8101908080519060200190929190505050600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631d7b5e2230856040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b1580156112d257600080fd5b505afa1580156112e6573d6000803e3d6000fd5b505050506040513d60208110156112fc57600080fd5b81019080805190602001909291905050509050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b815260040180806020018281038252600c8152602001807f43555252454e545f434f5354000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156113b357600080fd5b505afa1580156113c7573d6000803e3d6000fd5b505050506040513d60208110156113dd57600080fd5b8101908080519060200190929190505050600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663197d66d53086866001870103600188036040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060206040518083038186803b1580156114ef57600080fd5b505afa158015611503573d6000803e3d6000fd5b505050506040513d602081101561151957600080fd5b81019080805190602001909291905050509050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a06fe7753086866040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018281526020019350505050602060405180830381600087803b1580156115dd57600080fd5b505af11580156115f1573d6000803e3d6000fd5b505050506040513d602081101561160757600080fd5b81019080805190602001909291905050505060006006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff166379cc679033866040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b1580156116d857600080fd5b505af11580156116ec573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb33846040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561179957600080fd5b505af11580156117ad573d6000803e3d6000fd5b505050506040513d60208110156117c357600080fd5b8101908080519060200190929190505050611846576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260168152602001807f4572726f723a205472616e73666572206661696c65640000000000000000000081525060200191505060405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff1684867f11a44cb23d594705c95aa35553bec5a6572ef7d08fbd468f29c5392ee1d214e360405160405180910390a45050505050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b15801561193657600080fd5b505afa15801561194a573d6000803e3d6000fd5b505050506040513d602081101561196057600080fd5b8101908080519060200190929190505050600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631d7b5e2230856040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b158015611a5a57600080fd5b505afa158015611a6e573d6000803e3d6000fd5b505050506040513d6020811015611a8457600080fd5b810190808051906020019092919050505090506000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b815260040180806020018281038252600c8152602001807f43555252454e545f434f5354000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015611b3d57600080fd5b505afa158015611b51573d6000803e3d6000fd5b505050506040513d6020811015611b6757600080fd5b8101908080519060200190929190505050905060008173ffffffffffffffffffffffffffffffffffffffff1663197d66d5308760018701600189036040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060206040518083038186803b158015611c1757600080fd5b505afa158015611c2b573d6000803e3d6000fd5b505050506040513d6020811015611c4157600080fd5b81019080805190602001909291905050509050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611d3157600080fd5b505af1158015611d45573d6000803e3d6000fd5b505050506040513d6020811015611d5b57600080fd5b8101908080519060200190929190505050611dc1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260398152602001806128406039913960400191505060405180910390fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663095ea7b3600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015611e8c57600080fd5b505af1158015611ea0573d6000803e3d6000fd5b505050506040513d6020811015611eb657600080fd5b810190808051906020019092919050505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166399275cc73087876040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018281526020019350505050602060405180830381600087803b158015611f7957600080fd5b505af1158015611f8d573d6000803e3d6000fd5b505050506040513d6020811015611fa357600080fd5b8101908080519060200190929190505050506006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166340c10f1933866040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561206f57600080fd5b505af1158015612083573d6000803e3d6000fd5b505050506040513d602081101561209957600080fd5b8101908080519060200190929190505050503373ffffffffffffffffffffffffffffffffffffffff1684867f9738427d867a8b08540015120042d5a5ab1244297c70f40cb29fa7ba3458715360405160405180910390a45050505050565b606060146040519080825280601f01601f19166020018201604052801561212d5781602001600182028038833980820191505090505b50905060008090505b60148110156121b3578060130360080260020a8373ffffffffffffffffffffffffffffffffffffffff168161216757fe5b0460f81b82828151811061217757fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508080600101915050612136565b50919050565b6060600780548060200260200160405190810160405280929190818152602001828054801561220757602002820191906000526020600020905b8154815260200190600101908083116121f3575b5050505050905090565b60066020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60608060206040519080825280601f01601f1916602001820160405280156122a05781602001600182028038833980820191505090505b5090508260405160200180828152602001915050604051602081830303815290604052905080915050919050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b15801561239b57600080fd5b505afa1580156123af573d6000803e3d6000fd5b505050506040513d60208110156123c557600080fd5b810190808051906020019092919050505090506125608173ffffffffffffffffffffffffffffffffffffffff16634d9bcac430866040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060006040518083038186803b15801561246057600080fd5b505afa158015612474573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561249e57600080fd5b81019080805160405193929190846401000000008211156124be57600080fd5b838201915060208201858111156124d457600080fd5b82518660018202830111640100000000821117156124f157600080fd5b8083526020830192505050908051906020019080838360005b8381101561252557808201518184015260208101905061250a565b50505050905090810190601f1680156125525780820380516001836020036101000a031916815260200191505b506040525050506000612726565b915050919050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146125e757600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561262157600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600781815481106126ec57fe5b906000526020600020016000915090505481565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000816014830110156127a1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f746f416464726573735f6f766572666c6f77000000000000000000000000000081525060200191505060405180910390fd5b601482018351101561281b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f746f416464726573735f6f75744f66426f756e6473000000000000000000000081525060200191505060405180910390fd5b60006c0100000000000000000000000083602086010151049050809150509291505056fe696e73756666696369656e7420616363657074656420746f6b656e206e756d446f747320617070726f76656420666f72207472616e73666572a265627a7a72315820697e5180c678c34131c87be59e64935f750fb8b17db3a5d88169bc6b0d274a0c64736f6c63430005100032";

    public static final String FUNC_COORD = "coord";

    public static final String FUNC_CURVES = "curves";

    public static final String FUNC_CURVES_LIST = "curves_list";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RESERVETOKEN = "reserveToken";

    public static final String FUNC_TOKENFACTORY = "tokenFactory";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_INITIALIZECURVE = "initializeCurve";

    public static final String FUNC_BOND = "bond";

    public static final String FUNC_UNBOND = "unbond";

    public static final String FUNC_NEWTOKEN = "newToken";

    public static final String FUNC_GETTOKENADDRESS = "getTokenAddress";

    public static final String FUNC_GETENDPOINTS = "getEndpoints";

    public static final String FUNC_TOBYTES = "toBytes";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final Event BONDED_EVENT = new Event("Bonded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event DOTTOKENCREATED_EVENT = new Event("DotTokenCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event UNBONDED_EVENT = new Event("Unbonded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected TokenDotFactory(NetworkProviderOptions type) throws Exception {
        super(BINARY, type, "TOKENDOTFACTORY");
    }

    protected TokenDotFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(new BaseContractType(BINARY, contractAddress, web3j, credentials, contractGasProvider));
    }

    public List<BondedEventResponse> getBondedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BONDED_EVENT, transactionReceipt);
        ArrayList<BondedEventResponse> responses = new ArrayList<BondedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BondedEventResponse typedResponse = new BondedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.specifier = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.numDots = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BondedEventResponse> bondedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BondedEventResponse>() {
            @Override
            public BondedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BONDED_EVENT, log);
                BondedEventResponse typedResponse = new BondedEventResponse();
                typedResponse.log = log;
                typedResponse.specifier = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.numDots = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BondedEventResponse> bondedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BONDED_EVENT));
        return bondedEventFlowable(filter);
    }

    public List<DotTokenCreatedEventResponse> getDotTokenCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOTTOKENCREATED_EVENT, transactionReceipt);
        ArrayList<DotTokenCreatedEventResponse> responses = new ArrayList<DotTokenCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DotTokenCreatedEventResponse typedResponse = new DotTokenCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DotTokenCreatedEventResponse> dotTokenCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DotTokenCreatedEventResponse>() {
            @Override
            public DotTokenCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOTTOKENCREATED_EVENT, log);
                DotTokenCreatedEventResponse typedResponse = new DotTokenCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.tokenAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DotTokenCreatedEventResponse> dotTokenCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOTTOKENCREATED_EVENT));
        return dotTokenCreatedEventFlowable(filter);
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

    public List<UnbondedEventResponse> getUnbondedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UNBONDED_EVENT, transactionReceipt);
        ArrayList<UnbondedEventResponse> responses = new ArrayList<UnbondedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnbondedEventResponse typedResponse = new UnbondedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.specifier = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.numDots = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UnbondedEventResponse> unbondedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UnbondedEventResponse>() {
            @Override
            public UnbondedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNBONDED_EVENT, log);
                UnbondedEventResponse typedResponse = new UnbondedEventResponse();
                typedResponse.log = log;
                typedResponse.specifier = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.numDots = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UnbondedEventResponse> unbondedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNBONDED_EVENT));
        return unbondedEventFlowable(filter);
    }

    public RemoteFunctionCall<String> coord() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> curves(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CURVES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> curves_list(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CURVES_LIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> reserveToken() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RESERVETOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenFactory() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENFACTORY, 
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

    public RemoteFunctionCall<TransactionReceipt> initializeCurve(byte[] specifier, byte[] symbol, List<BigInteger> curve) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZECURVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(specifier), 
                new org.web3j.abi.datatypes.generated.Bytes32(symbol), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Int256>(
                        org.web3j.abi.datatypes.generated.Int256.class,
                        org.web3j.abi.Utils.typeMap(curve, org.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> bond(byte[] specifier, BigInteger numDots) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BOND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(specifier), 
                new org.web3j.abi.datatypes.generated.Uint256(numDots)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unbond(byte[] specifier, BigInteger numDots) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNBOND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(specifier), 
                new org.web3j.abi.datatypes.generated.Uint256(numDots)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newToken(String name, String symbol) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_NEWTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getTokenAddress(byte[] endpoint) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTOKENADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(endpoint)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getEndpoints() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETENDPOINTS, 
                Arrays.<Type>asList(), 
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

    public RemoteFunctionCall<byte[]> toBytes(String x) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(x)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> bytes32ToString(byte[] x) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BYTES32TOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(x)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static TokenDotFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) throws Exception {
        return new TokenDotFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TokenDotFactory load(NetworkProviderOptions type) throws Exception {
        return new TokenDotFactory(type);
    }

    public static RemoteCall<TokenDotFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String coordinator, String factory, BigInteger providerPubKey, byte[] providerTitle) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(coordinator), 
                new org.web3j.abi.datatypes.Address(factory), 
                new org.web3j.abi.datatypes.generated.Uint256(providerPubKey), 
                new org.web3j.abi.datatypes.generated.Bytes32(providerTitle)));
        return deployRemoteCall(TokenDotFactory.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TokenDotFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String coordinator, String factory, BigInteger providerPubKey, byte[] providerTitle) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(coordinator), 
                new org.web3j.abi.datatypes.Address(factory), 
                new org.web3j.abi.datatypes.generated.Uint256(providerPubKey), 
                new org.web3j.abi.datatypes.generated.Bytes32(providerTitle)));
        return deployRemoteCall(TokenDotFactory.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Override
    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class BondedEventResponse extends BaseEventResponse {
        public byte[] specifier;

        public BigInteger numDots;

        public String sender;
    }

    public static class DotTokenCreatedEventResponse extends BaseEventResponse {
        public String tokenAddress;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class UnbondedEventResponse extends BaseEventResponse {
        public byte[] specifier;

        public BigInteger numDots;

        public String sender;
    }
}
