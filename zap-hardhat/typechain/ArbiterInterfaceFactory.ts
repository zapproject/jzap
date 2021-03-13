/* Autogenerated file. Do not edit manually. */
/* tslint:disable */
/* eslint-disable */

import { Contract, Signer } from "ethers";
import { Provider } from "@ethersproject/providers";

import type { ArbiterInterface } from "./ArbiterInterface";

export class ArbiterInterfaceFactory {
  static connect(
    address: string,
    signerOrProvider: Signer | Provider
  ): ArbiterInterface {
    return new Contract(address, _abi, signerOrProvider) as ArbiterInterface;
  }
}

const _abi = [
  {
    constant: false,
    inputs: [
      {
        name: "",
        type: "address",
      },
      {
        name: "",
        type: "bytes32",
      },
    ],
    name: "endSubscriptionSubscriber",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: true,
    inputs: [
      {
        name: "",
        type: "address",
      },
      {
        name: "",
        type: "address",
      },
      {
        name: "",
        type: "bytes32",
      },
    ],
    name: "getSubscription",
    outputs: [
      {
        name: "",
        type: "uint64",
      },
      {
        name: "",
        type: "uint96",
      },
      {
        name: "",
        type: "uint96",
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
        name: "receiver",
        type: "address",
      },
      {
        name: "endpoint",
        type: "bytes32",
      },
      {
        name: "params",
        type: "bytes32[]",
      },
    ],
    name: "passParams",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: false,
    inputs: [
      {
        name: "",
        type: "address",
      },
      {
        name: "",
        type: "bytes32",
      },
      {
        name: "",
        type: "bytes32[]",
      },
      {
        name: "",
        type: "uint256",
      },
      {
        name: "",
        type: "uint64",
      },
    ],
    name: "initiateSubscription",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    constant: false,
    inputs: [
      {
        name: "",
        type: "address",
      },
      {
        name: "",
        type: "bytes32",
      },
    ],
    name: "endSubscriptionProvider",
    outputs: [],
    payable: false,
    stateMutability: "nonpayable",
    type: "function",
  },
];
