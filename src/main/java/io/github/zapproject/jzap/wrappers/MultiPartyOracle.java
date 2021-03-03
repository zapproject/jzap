package zapprotocol.jzap.wrappers;

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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
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
 * <p>Generated with web3j version 1.4.0.
 */
@SuppressWarnings("rawtypes")
public class MultiPartyOracle extends Contract {
    public static final String BINARY = "0x60806040527f4e6f6e70726f7669646572730000000000000000000000000000000000000000600b556040518060600160405280600163ffffffff168152602001600163ffffffff168152602001633b9aca0063ffffffff16815250600c9060036200006d9291906200069f565b506000600d556000600e5560006010553480156200008a57600080fd5b5060405162002def38038062002def83398181016040526040811015620000b057600080fd5b8101908080519060200190929190805190602001909291905050508173ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200014e57600080fd5b505afa15801562000163573d6000803e3d6000fd5b505050506040513d60208110156200017a57600080fd5b8101908080519060200190929190505050600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260088152602001807f444953504154434800000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015620002b157600080fd5b505afa158015620002c6573d6000803e3d6000fd5b505050506040513d6020811015620002dd57600080fd5b8101908080519060200190929190505050600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200041357600080fd5b505afa15801562000428573d6000803e3d6000fd5b505050506040513d60208110156200043f57600080fd5b8101908080519060200190929190505050600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff1660e01b81526004018080602001828103825260098152602001807f5a41505f544f4b454e000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200057657600080fd5b505afa1580156200058b573d6000803e3d6000fd5b505050506040513d6020811015620005a257600080fd5b8101908080519060200190929190505050600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505062000721565b828054828255906000526020600020908101928215620006e6579160200282015b82811115620006e5578251829063ffffffff16905591602001919060010190620006c0565b5b509050620006f59190620006f9565b5090565b6200071e91905b808211156200071a57600081600090555060010162000700565b5090565b90565b6126be80620007316000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80637ff94b621161005b5780637ff94b621461021857806385aa92a714610236578063bd5b853b14610280578063de261583146103385761007d565b80632ac9f6a3146100825780635fd8c7101461020457806363bd1d4a1461020e575b600080fd5b610202600480360360a081101561009857600080fd5b8101908080359060200190929190803590602001906401000000008111156100bf57600080fd5b8201836020820111156100d157600080fd5b803590602001918460208302840111640100000000831117156100f357600080fd5b90919293919293908035906020019064010000000081111561011457600080fd5b82018360208201111561012657600080fd5b8035906020019184602083028401116401000000008311171561014857600080fd5b90919293919293908035906020019064010000000081111561016957600080fd5b82018360208201111561017b57600080fd5b8035906020019184602083028401116401000000008311171561019d57600080fd5b9091929391929390803590602001906401000000008111156101be57600080fd5b8201836020820111156101d057600080fd5b803590602001918460208302840111640100000000831117156101f257600080fd5b9091929391929390505050610426565b005b61020c610d7a565b005b610216611122565b005b6102206119e6565b6040518082815260200191505060405180910390f35b61023e6119ec565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6103366004803603602081101561029657600080fd5b81019080803590602001906401000000008111156102b357600080fd5b8201836020820111156102c557600080fd5b803590602001918460208302840111640100000000831117156102e757600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f820116905080830192505050505050509192919290505050611a12565b005b610424600480360360a081101561034e57600080fd5b81019080803590602001909291908035906020019064010000000081111561037557600080fd5b82018360208201111561038757600080fd5b803590602001918460018302840111640100000000831117156103a957600080fd5b909192939192939080359060200190929190803590602001906401000000008111156103d457600080fd5b8201836020820111156103e657600080fd5b8035906020019184602083028401116401000000008311171561040857600080fd5b9091929391929390803515159060200190929190505050611cf3565b005b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636cc9354f8b6040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561049b57600080fd5b505afa1580156104af573d6000803e3d6000fd5b505050506040513d60208110156104c557600080fd5b81019080805190602001909291905050509050600080600090505b888890508110156108855760018989838181106104f957fe5b9050602002013588888481811061050c57fe5b9050602002013560ff1687878560020281811061052557fe5b9050602002013588886001876002020181811061053e57fe5b9050602002013560405160008152602001604052604051808581526020018460ff1660ff1681526020018381526020018281526020019450505050506020604051602081039080840390855afa15801561059c573d6000803e3d6000fd5b505050602060405103519150600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e226a1b6836040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b15801561064757600080fd5b505afa15801561065b573d6000803e3d6000fd5b505050506040513d602081101561067157600080fd5b8101908080519060200190929190505050801561076d5750600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fe151a9684846040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060206040518083038186803b15801561073057600080fd5b505afa158015610744573d6000803e3d6000fd5b505050506040513d602081101561075a57600080fd5b8101908080519060200190929190505050155b156108785760008b8b8381811061078057fe5b90506020020135146107a357600d600081548092919060010191905055506107b6565b600e600081548092919060010191905055505b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663287d3d3684846040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561085f57600080fd5b505af1158015610873573d6000803e3d6000fd5b505050505b80806001019150506104e0565b506001600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636f07abcc846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156108fb57600080fd5b505afa15801561090f573d6000803e3d6000fd5b505050506040513d602081101561092557600080fd5b81019080805190602001909291905050501415610d6c576060600160405190808252806020026020018201604052801561096e5781602001602082028038833980820191505090505b509050600e54600d54118015610a335750600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634615d5e9846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156109f257600080fd5b505afa158015610a06573d6000803e3d6000fd5b505050506040513d6020811015610a1c57600080fd5b8101908080519060200190929190505050600d5410155b15610af157600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166381f668448460026040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b158015610ab657600080fd5b505af1158015610aca573d6000803e3d6000fd5b50505050600181600081518110610add57fe5b602002602001018181525050505050610d6f565b600d54600e54118015610bb35750600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634615d5e9846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b158015610b7257600080fd5b505afa158015610b86573d6000803e3d6000fd5b505050506040513d6020811015610b9c57600080fd5b8101908080519060200190929190505050600e5410155b15610d6a57600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166381f668448460026040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b158015610c3657600080fd5b505af1158015610c4a573d6000803e3d6000fd5b50505050600081600081518110610c5d57fe5b6020026020010181815250506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ef05ab0b84836040518363ffffffff1660e01b81526004018083815260200180602001828103825283818151815260200191508051906020019060200280838360005b83811015610d00578082015181840152602081019050610ce5565b505050509050019350505050602060405180830381600087803b158015610d2657600080fd5b505af1158015610d3a573d6000803e3d6000fd5b505050506040513d6020811015610d5057600080fd5b810190808051906020019092919050505050505050610d6f565b505b50505b505050505050505050565b6000600f60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205490506000811415610e35576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260138152602001807f4e6f207061796f757420617661696c61626c650000000000000000000000000081525060200191505060405180910390fd5b80600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b158015610ed557600080fd5b505afa158015610ee9573d6000803e3d6000fd5b505050506040513d6020811015610eff57600080fd5b81019080805190602001909291905050501015610f84576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4e6f7420656e6f7567682066756e647320696e20636f6e74726163740000000081525060200191505060405180910390fd5b6000600f60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb33836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561107257600080fd5b505af1158015611086573d6000803e3d6000fd5b505050506040513d602081101561109c57600080fd5b810190808051906020019092919050505061111f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f4661696c656420746f205472616e66657220546f6b656e00000000000000000081525060200191505060405180910390fd5b50565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e226a1b6336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156111c157600080fd5b505afa1580156111d5573d6000803e3d6000fd5b505050506040513d60208110156111eb57600080fd5b810190808051906020019092919050505061126e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600d8152602001807f496e76616c696420566f7465720000000000000000000000000000000000000081525060200191505060405180910390fd5b6010600081548092919060010191905055506002600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663602bb04f6040518163ffffffff1660e01b815260040160206040518083038186803b1580156112ea57600080fd5b505afa1580156112fe573d6000803e3d6000fd5b505050506040513d602081101561131457600080fd5b81019080805190602001909291905050508161132c57fe5b0460105411156119e4576000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bbee369430306040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001807f4e6f6e70726f76696465727300000000000000000000000000000000000000008152506020019250505060206040518083038186803b15801561143357600080fd5b505afa158015611447573d6000803e3d6000fd5b505050506040513d602081101561145d57600080fd5b81019080805190602001909291905050509050600081116114e6576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600d8152602001807f4e6f20646f747320626f756e640000000000000000000000000000000000000081525060200191505060405180910390fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a06fe77530836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001807f4e6f6e70726f766964657273000000000000000000000000000000000000000081525060200182815260200192505050602060405180830381600087803b1580156115b757600080fd5b505af11580156115cb573d6000803e3d6000fd5b505050506040513d60208110156115e157600080fd5b810190808051906020019092919050505050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663602bb04f6040518163ffffffff1660e01b815260040160206040518083038186803b15801561165b57600080fd5b505afa15801561166f573d6000803e3d6000fd5b505050506040513d602081101561168557600080fd5b8101908080519060200190929190505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b15801561173557600080fd5b505afa158015611749573d6000803e3d6000fd5b505050506040513d602081101561175f57600080fd5b81019080805190602001909291905050508161177757fe5b0490506060600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166312faae936040518163ffffffff1660e01b815260040160006040518083038186803b1580156117e457600080fd5b505afa1580156117f8573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561182257600080fd5b810190808051604051939291908464010000000082111561184257600080fd5b8382019150602082018581111561185857600080fd5b825186602082028301116401000000008211171561187557600080fd5b8083526020830192505050908051906020019060200280838360005b838110156118ac578082015181840152602081019050611891565b50505050905001604052505050905060008090505b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663602bb04f6040518163ffffffff1660e01b815260040160206040518083038186803b15801561192957600080fd5b505afa15801561193d573d6000803e3d6000fd5b505050506040513d602081101561195357600080fd5b81019080805190602001909291905050508110156119d85782600f600084848151811061197c57fe5b602002602001015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254019250508190555080806001019150506118c1565b50600060108190555050505b565b600b5481565b600960009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663664c0bf9826040518263ffffffff1660e01b81526004018080602001828103825283818151815260200191508051906020019060200280838360005b83811015611aa3578082015181840152602081019050611a88565b5050505090500192505050600060405180830381600087803b158015611ac857600080fd5b505af1158015611adc573d6000803e3d6000fd5b5050505060007f4d756c746950617274794f7261636c65000000000000000000000000000000009050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663af87c833613039836040518363ffffffff1660e01b81526004018083815260200182815260200192505050602060405180830381600087803b158015611b8457600080fd5b505af1158015611b98573d6000803e3d6000fd5b505050506040513d6020811015611bae57600080fd5b810190808051906020019092919050505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663238b3aed600b54600c60006040518463ffffffff1660e01b815260040180848152602001806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281038252848181548152602001915080548015611c9157602002820191906000526020600020905b815481526020019060010190808311611c7d575b5050945050505050602060405180830381600087803b158015611cb357600080fd5b505af1158015611cc7573d6000803e3d6000fd5b505050506040513d6020811015611cdd57600080fd5b8101908080519060200190929190505050505050565b7f3029607cc6a3c9da1151808d70477d5629884ae9cf28dace18a0043d89460cf88686868686336040518080602001868152602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381038352898982818152602001925080828437600081840152601f19601f8201169050808301925050508381038252868682818152602001925060200280828437600081840152601f19601f8201169050808301925050509850505050505050505060405180910390a1600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148015611ed357506000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636f07abcc896040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b158015611e9657600080fd5b505afa158015611eaa573d6000803e3d6000fd5b505050506040513d6020811015611ec057600080fd5b8101908080519060200190929190505050145b611f45576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600d8152602001807f4469737061746368206f6e6c790000000000000000000000000000000000000081525060200191505060405180910390fd5b60008460405160200180828152602001915050604051602081830303815290604052805190602001209050600084846002818110611f7f57fe5b9050602002013560001c905060008111801561203d5750600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663602bb04f6040518163ffffffff1660e01b815260040160206040518083038186803b158015611ffe57600080fd5b505afa158015612012573d6000803e3d6000fd5b505050506040513d602081101561202857600080fd5b81019080805190602001909291905050508111155b6120af576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f496e76616c6964205468726573686f6c64204c656e677468000000000000000081525060200191505060405180910390fd5b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9c362098a836040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b15801561212c57600080fd5b505af1158015612140573d6000803e3d6000fd5b50505050600b54604051602001808281526020019150506040516020818303038152906040528051906020012082141561267e57600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166381f668448a60016040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b1580156121f257600080fd5b505af1158015612206573d6000803e3d6000fd5b50505050600080600090505b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663602bb04f6040518163ffffffff1660e01b815260040160206040518083038186803b15801561227a57600080fd5b505afa15801561228e573d6000803e3d6000fd5b505050506040513d60208110156122a457600080fd5b810190808051906020019092919050505081101561267b5743428b8b8e600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634155b850876040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561233457600080fd5b505afa158015612348573d6000803e3d6000fd5b505050506040513d602081101561235e57600080fd5b810190808051906020019092919050505060405160200180878152602001868152602001858580828437808301925050508381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b815260140196505050505050506040516020818303038152906040528051906020012060001c9150600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638be8f272838d6040518363ffffffff1660e01b81526004018083815260200182815260200192505050600060405180830381600087803b15801561246a57600080fd5b505af115801561247e573d6000803e3d6000fd5b505050507f69741cc3ec0270f258feb6b53b42ef1e7d2251a3c8eea4f6ba1f72bd4b7beba782600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634155b850846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561251757600080fd5b505afa15801561252b573d6000803e3d6000fd5b505050506040513d602081101561254157600080fd5b8101908080519060200190929190505050308d8d8c8c6001604051808981526020018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001807f48656c6c6f3f000000000000000000000000000000000000000000000000000081525060200180602001841515151581526020018381038352888882818152602001925080828437600081840152601f19601f8201169050808301925050508381038252868682818152602001925060200280828437600081840152601f19601f8201169050808301925050509a505050505050505050505060405180910390a18080600101915050612212565b50505b50505050505050505056fea265627a7a723158201971c8cda8dbf9b80ea8bb5c6d609632d5c8aaaa8b80959f5222e65aca7c5f4b64736f6c63430005100032";

    public static final String FUNC_SPEC3 = "spec3";

    public static final String FUNC_STORAGEADDRESS = "storageAddress";

    public static final String FUNC_SETUP = "setup";

    public static final String FUNC_RECEIVE = "receive";

    public static final String FUNC_CALLBACK = "callback";

    public static final String FUNC_PAYOUT = "payout";

    public static final String FUNC_WITHDRAWBALANCE = "withdrawBalance";

    public static final Event INCOMING_EVENT = new Event("Incoming", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event RECEIVEDRESPONSE_EVENT = new Event("ReceivedResponse", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event RECIEVEDQUERY_EVENT = new Event("RecievedQuery", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event RESULT1_EVENT = new Event("Result1", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MultiPartyOracle(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiPartyOracle(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MultiPartyOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MultiPartyOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<IncomingEventResponse> getIncomingEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INCOMING_EVENT, transactionReceipt);
        ArrayList<IncomingEventResponse> responses = new ArrayList<IncomingEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IncomingEventResponse typedResponse = new IncomingEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.provider = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.subscriber = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.query = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.endpointParams = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.onchainSubscriber = (Boolean) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<IncomingEventResponse> incomingEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, IncomingEventResponse>() {
            @Override
            public IncomingEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INCOMING_EVENT, log);
                IncomingEventResponse typedResponse = new IncomingEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.provider = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.subscriber = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.query = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.endpointParams = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.onchainSubscriber = (Boolean) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<IncomingEventResponse> incomingEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INCOMING_EVENT));
        return incomingEventFlowable(filter);
    }

    public List<ReceivedResponseEventResponse> getReceivedResponseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDRESPONSE_EVENT, transactionReceipt);
        ArrayList<ReceivedResponseEventResponse> responses = new ArrayList<ReceivedResponseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedResponseEventResponse typedResponse = new ReceivedResponseEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.queryId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.responder = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.response = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedResponseEventResponse> receivedResponseEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReceivedResponseEventResponse>() {
            @Override
            public ReceivedResponseEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDRESPONSE_EVENT, log);
                ReceivedResponseEventResponse typedResponse = new ReceivedResponseEventResponse();
                typedResponse.log = log;
                typedResponse.queryId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.responder = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.response = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedResponseEventResponse> receivedResponseEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDRESPONSE_EVENT));
        return receivedResponseEventFlowable(filter);
    }

    public List<RecievedQueryEventResponse> getRecievedQueryEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECIEVEDQUERY_EVENT, transactionReceipt);
        ArrayList<RecievedQueryEventResponse> responses = new ArrayList<RecievedQueryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RecievedQueryEventResponse typedResponse = new RecievedQueryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.query = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.params = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RecievedQueryEventResponse> recievedQueryEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RecievedQueryEventResponse>() {
            @Override
            public RecievedQueryEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECIEVEDQUERY_EVENT, log);
                RecievedQueryEventResponse typedResponse = new RecievedQueryEventResponse();
                typedResponse.log = log;
                typedResponse.query = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.endpoint = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.params = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RecievedQueryEventResponse> recievedQueryEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECIEVEDQUERY_EVENT));
        return recievedQueryEventFlowable(filter);
    }

    public List<Result1EventResponse> getResult1Events(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESULT1_EVENT, transactionReceipt);
        ArrayList<Result1EventResponse> responses = new ArrayList<Result1EventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            Result1EventResponse typedResponse = new Result1EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.response1 = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<Result1EventResponse> result1EventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, Result1EventResponse>() {
            @Override
            public Result1EventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESULT1_EVENT, log);
                Result1EventResponse typedResponse = new Result1EventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.response1 = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<Result1EventResponse> result1EventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESULT1_EVENT));
        return result1EventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> spec3() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SPEC3, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> storageAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STORAGEADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setup(List<String> _responders) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETUP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_responders, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> receive(BigInteger id, String userQuery, byte[] endpoint, List<byte[]> endpointParams, Boolean onchainSubscriber) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECEIVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(userQuery), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpoint), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(endpointParams, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Bool(onchainSubscriber)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callback(BigInteger mpoId, List<BigInteger> responses, List<byte[]> msgHash, List<BigInteger> sigv, List<byte[]> sigrs) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(mpoId), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(responses, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(msgHash, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.datatypes.generated.Uint8.class,
                        org.web3j.abi.Utils.typeMap(sigv, org.web3j.abi.datatypes.generated.Uint8.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(sigrs, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> payout() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAYOUT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAWBALANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MultiPartyOracle load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiPartyOracle(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MultiPartyOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiPartyOracle(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MultiPartyOracle load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MultiPartyOracle(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MultiPartyOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MultiPartyOracle(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MultiPartyOracle> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _zapCoord, String mpoStorageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_zapCoord), 
                new org.web3j.abi.datatypes.Address(mpoStorageAddress)));
        return deployRemoteCall(MultiPartyOracle.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiPartyOracle> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _zapCoord, String mpoStorageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_zapCoord), 
                new org.web3j.abi.datatypes.Address(mpoStorageAddress)));
        return deployRemoteCall(MultiPartyOracle.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiPartyOracle> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _zapCoord, String mpoStorageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_zapCoord), 
                new org.web3j.abi.datatypes.Address(mpoStorageAddress)));
        return deployRemoteCall(MultiPartyOracle.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiPartyOracle> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _zapCoord, String mpoStorageAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_zapCoord), 
                new org.web3j.abi.datatypes.Address(mpoStorageAddress)));
        return deployRemoteCall(MultiPartyOracle.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class IncomingEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String provider;

        public String subscriber;

        public String query;

        public byte[] endpoint;

        public List<byte[]> endpointParams;

        public Boolean onchainSubscriber;
    }

    public static class ReceivedResponseEventResponse extends BaseEventResponse {
        public BigInteger queryId;

        public String responder;

        public String response;
    }

    public static class RecievedQueryEventResponse extends BaseEventResponse {
        public String query;

        public byte[] endpoint;

        public List<byte[]> params;

        public String sender;
    }

    public static class Result1EventResponse extends BaseEventResponse {
        public BigInteger id;

        public String response1;
    }
}
