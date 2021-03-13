/* Autogenerated file. Do not edit manually. */
/* tslint:disable */
/* eslint-disable */

import { Signer } from "ethers";
import { Provider, TransactionRequest } from "@ethersproject/providers";
import { Contract, ContractFactory, Overrides } from "@ethersproject/contracts";

import type { DotFactoryFactory } from "./DotFactoryFactory";

export class DotFactoryFactoryFactory extends ContractFactory {
  constructor(signer?: Signer) {
    super(_abi, _bytecode, signer);
  }

  deploy(
    _coordinator: string,
    _factory: string,
    overrides?: Overrides
  ): Promise<DotFactoryFactory> {
    return super.deploy(
      _coordinator,
      _factory,
      overrides || {}
    ) as Promise<DotFactoryFactory>;
  }
  getDeployTransaction(
    _coordinator: string,
    _factory: string,
    overrides?: Overrides
  ): TransactionRequest {
    return super.getDeployTransaction(_coordinator, _factory, overrides || {});
  }
  attach(address: string): DotFactoryFactory {
    return super.attach(address) as DotFactoryFactory;
  }
  connect(signer: Signer): DotFactoryFactoryFactory {
    return super.connect(signer) as DotFactoryFactoryFactory;
  }
  static connect(
    address: string,
    signerOrProvider: Signer | Provider
  ): DotFactoryFactory {
    return new Contract(address, _abi, signerOrProvider) as DotFactoryFactory;
  }
}

const _abi = [
  {
    constant: true,
    inputs: [],
    name: "coordinator",
    outputs: [
      {
        name: "",
        type: "address",
      },
    ],
    payable: false,
    stateMutability: "view",
    type: "function",
  },
  {
    constant: true,
    inputs: [
      {
        name: "",
        type: "uint256",
      },
    ],
    name: "deployedFactories",
    outputs: [
      {
        name: "",
        type: "address",
      },
    ],
    payable: false,
    stateMutability: "view",
    type: "function",
  },
  {
    constant: true,
    inputs: [],
    name: "getFactories",
    outputs: [
      {
        name: "",
        type: "address[]",
      },
    ],
    payable: false,
    stateMutability: "view",
    type: "function",
  },
  {
    constant: false,
    inputs: [
      {
        name: "providerPubKey",
        type: "uint256",
      },
      {
        name: "providerTitle",
        type: "bytes32",
      },
    ],
    name: "deployFactory",
    outputs: [
      {
        name: "",
        type: "address",
      },
    ],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: true,
    inputs: [],
    name: "factory",
    outputs: [
      {
        name: "",
        type: "address",
      },
    ],
    payable: false,
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        name: "_coordinator",
        type: "address",
      },
      {
        name: "_factory",
        type: "address",
      },
    ],
    payable: false,
    stateMutability: "nonpayable",
    type: "constructor",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: false,
        name: "dotfactory",
        type: "address",
      },
      {
        indexed: false,
        name: "PubKey",
        type: "uint256",
      },
      {
        indexed: false,
        name: "Title",
        type: "bytes32",
      },
    ],
    name: "newDotFactory",
    type: "event",
  },
];

const _bytecode =
  "0x608060405234801561001057600080fd5b506040516040806138f58339810180604052604081101561003057600080fd5b81019080805190602001909291908051906020019092919050505081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050613817806100de6000396000f3fe608060405260043610610067576000357c0100000000000000000000000000000000000000000000000000000000900480630a0090971461006c5780632c956785146100c35780637e6cbb6a1461013e578063b5e6f987146101aa578063c45a01551461022f575b600080fd5b34801561007857600080fd5b50610081610286565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156100cf57600080fd5b506100fc600480360360208110156100e657600080fd5b81019080803590602001909291905050506102ac565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561014a57600080fd5b506101536102ea565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561019657808201518184015260208101905061017b565b505050509050019250505060405180910390f35b3480156101b657600080fd5b506101ed600480360360408110156101cd57600080fd5b810190808035906020019092919080359060200190929190505050610378565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561023b57600080fd5b506102446105f7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000818154811015156102bb57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060600080548060200260200160405190810160405280929190818152602001828054801561036e57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610324575b5050505050905090565b600080600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1685856103cb61061d565b808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001945050505050604051809103906000f08015801561045e573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff1663f2fde38b336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156104fc57600080fd5b505af1158015610510573d6000803e3d6000fd5b5050505060008190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507fb3d6aa9cf6c982df0dcc9abf9a51f24ea8414f74d9b28b5c351bf65417befa46818585604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390a18091505092915050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6040516131bd806200062f8339019056fe60806040523480156200001157600080fd5b50604051608080620031bd833981018060405260808110156200003357600080fd5b8101908080519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260098152602001807f5a41505f544f4b454e000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015620001a457600080fd5b505afa158015620001b9573d6000803e3d6000fd5b505050506040513d6020811015620001d057600080fd5b8101908080519060200190929190505050600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663095ea7b3600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200032057600080fd5b505afa15801562000335573d6000803e3d6000fd5b505050506040513d60208110156200034c57600080fd5b81019080805190602001909291905050506000196040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015620003e657600080fd5b505af1158015620003fb573d6000803e3d6000fd5b505050506040513d60208110156200041257600080fd5b81019080805190602001909291905050505082600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156200052857600080fd5b505afa1580156200053d573d6000803e3d6000fd5b505050506040513d60208110156200055457600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663af87c83384846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200182815260200192505050602060405180830381600087803b158015620005df57600080fd5b505af1158015620005f4573d6000803e3d6000fd5b505050506040513d60208110156200060b57600080fd5b8101908080519060200190929190505050505050505050612b8b80620006326000396000f3fe6080604052600436106100d5576000357c01000000000000000000000000000000000000000000000000000000009004806306af0650146100da5780634629ffea146101f35780634d8de4fc1461039257806351f93215146103d7578063593b79fe1461041c5780635d7c83f1146104e657806366903e80146105525780638da5cb5b146105cd5780639201de55146106245780639495c25a146106d8578063b12e44101461072f578063e77772fe146107aa578063f2fde38b14610801578063f3457c0114610852578063f4325d67146108a1575b600080fd5b3480156100e657600080fd5b506101b1600480360360608110156100fd57600080fd5b8101908080359060200190929190803590602001909291908035906020019064010000000081111561012e57600080fd5b82018360208201111561014057600080fd5b8035906020019184602083028401116401000000008311171561016257600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f8201169050808301925050505050505091929192905050506108f8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101ff57600080fd5b506103506004803603604081101561021657600080fd5b810190808035906020019064010000000081111561023357600080fd5b82018360208201111561024557600080fd5b8035906020019184600183028401116401000000008311171561026757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156102ca57600080fd5b8201836020820111156102dc57600080fd5b803590602001918460018302840111640100000000831117156102fe57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611035565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561039e57600080fd5b506103d5600480360360408110156103b557600080fd5b810190808035906020019092919080359060200190929190505050611241565b005b3480156103e357600080fd5b5061041a600480360360408110156103fa57600080fd5b810190808035906020019092919080359060200190929190505050611a8f565b005b34801561042857600080fd5b5061046b6004803603602081101561043f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612419565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104ab578082015181840152602081019050610490565b50505050905090810190601f1680156104d85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156104f257600080fd5b506104fb6124ff565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561053e578082015181840152602081019050610523565b505050509050019250505060405180910390f35b34801561055e57600080fd5b5061058b6004803603602081101561057557600080fd5b8101908080359060200190929190505050612557565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156105d957600080fd5b506105e261258a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561063057600080fd5b5061065d6004803603602081101561064757600080fd5b81019080803590602001909291905050506125af565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561069d578082015181840152602081019050610682565b50505050905090810190601f1680156106ca5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156106e457600080fd5b506106ed612614565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561073b57600080fd5b506107686004803603602081101561075257600080fd5b810190808035906020019092919050505061263a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156107b657600080fd5b506107bf61287e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561080d57600080fd5b506108506004803603602081101561082457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506128a4565b005b34801561085e57600080fd5b5061088b6004803603602081101561087557600080fd5b81019080803590602001909291905050506129f9565b6040518082815260200191505060405180910390f35b3480156108ad57600080fd5b506108b6612a1c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561095557600080fd5b600073ffffffffffffffffffffffffffffffffffffffff166006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610a2c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f43757276652073706563696669657220616c726561647920657869737473000081525060200191505060405180910390fd5b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015610aee57600080fd5b505afa158015610b02573d6000803e3d6000fd5b505050506040513d6020811015610b1857600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663186b79c9306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b158015610bc457600080fd5b505afa158015610bd8573d6000803e3d6000fd5b505050506040513d6020811015610bee57600080fd5b81019080805190602001909291905050501515610c73576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f50726f7669646572206e6f7420696e746969616c697a6564000000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1663238b3aed8685306040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180848152602001806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019060200280838360005b83811015610d38578082015181840152602081019050610d1d565b50505050905001945050505050602060405180830381600087803b158015610d5f57600080fd5b505af1158015610d73573d6000803e3d6000fd5b505050506040513d6020811015610d8957600080fd5b810190808051906020019092919050505050610db5610da7866125af565b610db0866125af565b611035565b6006600087815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060078590806001815401808255809150509060018203906000526020600020016000909192909190915055508073ffffffffffffffffffffffffffffffffffffffff16635750644a86610e8b600660008a815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16612419565b6040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610efc578082015181840152602081019050610ee1565b50505050905090810190601f168015610f295780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610f4957600080fd5b505af1158015610f5d573d6000803e3d6000fd5b505050507f6c98c7e1fb155d4c2c1f008682fd94fb74d1c9667207aaaa9ab65cee2b38ea7a6006600087815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a16006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169150509392505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561109257600080fd5b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663198e2b8a85856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835285818151815260200191508051906020019080838360005b83811015611143578082015181840152602081019050611128565b50505050905090810190601f1680156111705780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156111a957808201518184015260208101905061118e565b50505050905090810190601f1680156111d65780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b1580156111f757600080fd5b505af115801561120b573d6000803e3d6000fd5b505050506040513d602081101561122157600080fd5b810190808051906020019092919050505090508091508191505092915050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b15801561130157600080fd5b505afa158015611315573d6000803e3d6000fd5b505050506040513d602081101561132b57600080fd5b8101908080519060200190929190505050600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631d7b5e2230856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b15801561144157600080fd5b505afa158015611455573d6000803e3d6000fd5b505050506040513d602081101561146b57600080fd5b81019080805190602001909291905050509050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600c8152602001807f43555252454e545f434f5354000000000000000000000000000000000000000081525060200191505060206040518083038186803b15801561153e57600080fd5b505afa158015611552573d6000803e3d6000fd5b505050506040513d602081101561156857600080fd5b8101908080519060200190929190505050600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663197d66d53086866001870103600188036040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060206040518083038186803b15801561169657600080fd5b505afa1580156116aa573d6000803e3d6000fd5b505050506040513d60208110156116c057600080fd5b81019080805190602001909291905050509050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a06fe7753086866040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018281526020019350505050602060405180830381600087803b1580156117a057600080fd5b505af11580156117b4573d6000803e3d6000fd5b505050506040513d60208110156117ca57600080fd5b81019080805190602001909291905050505060006006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff166379cc679033866040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b1580156118b757600080fd5b505af11580156118cb573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb33846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561199457600080fd5b505af11580156119a8573d6000803e3d6000fd5b505050506040513d60208110156119be57600080fd5b81019080805190602001909291905050501515611a43576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260168152602001807f4572726f723a205472616e73666572206661696c65640000000000000000000081525060200191505060405180910390fd5b3373ffffffffffffffffffffffffffffffffffffffff1684867f11a44cb23d594705c95aa35553bec5a6572ef7d08fbd468f29c5392ee1d214e360405160405180910390a45050505050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f424f4e444147450000000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015611b4f57600080fd5b505afa158015611b63573d6000803e3d6000fd5b505050506040513d6020811015611b7957600080fd5b8101908080519060200190929190505050600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631d7b5e2230856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060206040518083038186803b158015611c8f57600080fd5b505afa158015611ca3573d6000803e3d6000fd5b505050506040513d6020811015611cb957600080fd5b810190808051906020019092919050505090506000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600c8152602001807f43555252454e545f434f5354000000000000000000000000000000000000000081525060200191505060206040518083038186803b158015611d8e57600080fd5b505afa158015611da2573d6000803e3d6000fd5b505050506040513d6020811015611db857600080fd5b8101908080519060200190929190505050905060008173ffffffffffffffffffffffffffffffffffffffff1663197d66d5308760018701600189036040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060206040518083038186803b158015611e8457600080fd5b505afa158015611e98573d6000803e3d6000fd5b505050506040513d6020811015611eae57600080fd5b81019080805190602001909291905050509050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611fba57600080fd5b505af1158015611fce573d6000803e3d6000fd5b505050506040513d6020811015611fe457600080fd5b8101908080519060200190929190505050151561208f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260398152602001807f696e73756666696369656e7420616363657074656420746f6b656e206e756d4481526020017f6f747320617070726f76656420666f72207472616e736665720000000000000081525060400191505060405180910390fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663095ea7b3600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561217657600080fd5b505af115801561218a573d6000803e3d6000fd5b505050506040513d60208110156121a057600080fd5b810190808051906020019092919050505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166399275cc73087876040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018281526020019350505050602060405180830381600087803b15801561227f57600080fd5b505af1158015612293573d6000803e3d6000fd5b505050506040513d60208110156122a957600080fd5b8101908080519060200190929190505050506006600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166340c10f1933866040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561239157600080fd5b505af11580156123a5573d6000803e3d6000fd5b505050506040513d60208110156123bb57600080fd5b8101908080519060200190929190505050503373ffffffffffffffffffffffffffffffffffffffff1684867f9738427d867a8b08540015120042d5a5ab1244297c70f40cb29fa7ba3458715360405160405180910390a45050505050565b606060146040519080825280601f01601f19166020018201604052801561244f5781602001600182028038833980820191505090505b50905060008090505b60148110156124f9578060130360080260020a8373ffffffffffffffffffffffffffffffffffffffff1681151561248b57fe5b047f01000000000000000000000000000000000000000000000000000000000000000282828151811015156124bc57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508080600101915050612458565b50919050565b6060600780548060200260200160405190810160405280929190818152602001828054801561254d57602002820191906000526020600020905b815481526020019060010190808311612539575b5050505050905090565b60066020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60608060206040519080825280601f01601f1916602001820160405280156125e65781602001600182028038833980820191505090505b5090508260405160200180828152602001915050604051602081830303815290604052905080915050919050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663358177736040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260088152602001807f524547495354525900000000000000000000000000000000000000000000000081525060200191505060206040518083038186803b1580156126fd57600080fd5b505afa158015612711573d6000803e3d6000fd5b505050506040513d602081101561272757600080fd5b810190808051906020019092919050505090506128768173ffffffffffffffffffffffffffffffffffffffff16634d9bcac430866040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060006040518083038186803b1580156127de57600080fd5b505afa1580156127f2573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f82011682018060405250602081101561281c57600080fd5b81019080805164010000000081111561283457600080fd5b8281019050602081018481111561284a57600080fd5b815185600182028301116401000000008211171561286757600080fd5b50509291905050506000612a42565b915050919050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156128ff57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415151561293b57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600781815481101515612a0857fe5b906000526020600020016000915090505481565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000816014830110151515612abf576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f746f416464726573735f6f766572666c6f77000000000000000000000000000081525060200191505060405180910390fd5b60148201835110151515612b3b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f746f416464726573735f6f75744f66426f756e6473000000000000000000000081525060200191505060405180910390fd5b60006c0100000000000000000000000083602086010151049050809150509291505056fea165627a7a72305820077556e8acda1bf64c70c3aa31f364395d86d1a1beb0ab7712b6b7d21ae8c3360029a165627a7a72305820eb9e37de7873341e26c81d2442be8b2cdf0f1ed9c762a551be7b05f7dbbc8f5d0029";
