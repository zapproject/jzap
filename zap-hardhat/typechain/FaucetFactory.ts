/* Autogenerated file. Do not edit manually. */
/* tslint:disable */
/* eslint-disable */

import { Signer } from "ethers";
import { Provider, TransactionRequest } from "@ethersproject/providers";
import { Contract, ContractFactory, Overrides } from "@ethersproject/contracts";

import type { Faucet } from "./Faucet";

export class FaucetFactory extends ContractFactory {
  constructor(signer?: Signer) {
    super(_abi, _bytecode, signer);
  }

  deploy(_token: string, overrides?: Overrides): Promise<Faucet> {
    return super.deploy(_token, overrides || {}) as Promise<Faucet>;
  }
  getDeployTransaction(
    _token: string,
    overrides?: Overrides
  ): TransactionRequest {
    return super.getDeployTransaction(_token, overrides || {});
  }
  attach(address: string): Faucet {
    return super.attach(address) as Faucet;
  }
  connect(signer: Signer): FaucetFactory {
    return super.connect(signer) as FaucetFactory;
  }
  static connect(address: string, signerOrProvider: Signer | Provider): Faucet {
    return new Contract(address, _abi, signerOrProvider) as Faucet;
  }
}

const _abi = [
  {
    constant: false,
    inputs: [],
    name: "withdrawTok",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: true,
    inputs: [],
    name: "rate",
    outputs: [
      {
        name: "",
        type: "uint256",
      },
    ],
    payable: false,
    stateMutability: "view",
    type: "function",
  },
  {
    constant: false,
    inputs: [],
    name: "withdrawEther",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: true,
    inputs: [],
    name: "owner",
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
    constant: false,
    inputs: [
      {
        name: "to",
        type: "address",
      },
      {
        name: "amt",
        type: "uint256",
      },
    ],
    name: "buyZap",
    outputs: [],
    payable: true,
    stateMutability: "payable",
    type: "function",
  },
  {
    inputs: [
      {
        name: "_token",
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
        indexed: true,
        name: "_buyer",
        type: "address",
      },
      {
        indexed: true,
        name: "_amount",
        type: "uint256",
      },
      {
        indexed: true,
        name: "_rate",
        type: "uint256",
      },
    ],
    name: "BUYZAP",
    type: "event",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: false,
        name: "n1",
        type: "uint256",
      },
      {
        indexed: false,
        name: "n2",
        type: "uint256",
      },
    ],
    name: "Log",
    type: "event",
  },
];

const _bytecode =
  "0x60806040526103e860025534801561001657600080fd5b506040516020806108508339810180604052602081101561003657600080fd5b810190808051906020019092919050505033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610778806100d86000396000f3fe608060405260043610610067576000357c0100000000000000000000000000000000000000000000000000000000900480630f33a2a91461006c5780632c4e722e146100835780637362377b146100ae5780638da5cb5b146100c55780638fe200d81461011c575b600080fd5b34801561007857600080fd5b5061008161016a565b005b34801561008f57600080fd5b506100986103de565b6040518082815260200191505060405180910390f35b3480156100ba57600080fd5b506100c36103e4565b005b3480156100d157600080fd5b506100da6104c2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101686004803603604081101561013257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506104e8565b005b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156101c657600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156102e057600080fd5b505afa1580156102f4573d6000803e3d6000fd5b505050506040513d602081101561030a57600080fd5b81019080805190602001909291905050506040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156103a057600080fd5b505af11580156103b4573d6000803e3d6000fd5b505050506040513d60208110156103ca57600080fd5b810190808051906020019092919050505050565b60025481565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561044057600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc3073ffffffffffffffffffffffffffffffffffffffff16319081150290604051600060405180830381858888f193505050501580156104bf573d6000803e3d6000fd5b50565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000811115156104f757600080fd5b600254810290506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156105b857600080fd5b505afa1580156105cc573d6000803e3d6000fd5b505050506040513d60208110156105e257600080fd5b8101908080519060200190929190505050811115151561060157600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb83836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156106c557600080fd5b505af11580156106d9573d6000803e3d6000fd5b505050506040513d60208110156106ef57600080fd5b810190808051906020019092919050505050600254813373ffffffffffffffffffffffffffffffffffffffff167f46a678f82b3e0eafe7564f8c981cd0f62c33d33d29ecac048008ca14ecd0997a60405160405180910390a4505056fea165627a7a72305820139379c89e385a36a5621b2b636f70fcc7afbdf842805fe7d0b511cb05314a8b0029";
