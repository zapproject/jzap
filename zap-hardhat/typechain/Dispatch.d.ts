/* Autogenerated file. Do not edit manually. */
/* tslint:disable */
/* eslint-disable */

import {
  ethers,
  EventFilter,
  Signer,
  BigNumber,
  BigNumberish,
  PopulatedTransaction,
} from "ethers";
import {
  Contract,
  ContractTransaction,
  Overrides,
  CallOverrides,
} from "@ethersproject/contracts";
import { BytesLike } from "@ethersproject/bytes";
import { Listener, Provider } from "@ethersproject/providers";
import { FunctionFragment, EventFragment, Result } from "@ethersproject/abi";

interface DispatchInterface extends ethers.utils.Interface {
  functions: {
    "getCancel(uint256)": FunctionFragment;
    "respondBytes32Array(uint256,bytes32[])": FunctionFragment;
    "getSubscriber(uint256)": FunctionFragment;
    "respond4(uint256,string,string,string,string)": FunctionFragment;
    "getSubscriberOnchain(uint256)": FunctionFragment;
    "respond3(uint256,string,string,string)": FunctionFragment;
    "db()": FunctionFragment;
    "getProvider(uint256)": FunctionFragment;
    "getStatus(uint256)": FunctionFragment;
    "respond1(uint256,string)": FunctionFragment;
    "updateDependencies()": FunctionFragment;
    "cancelQuery(uint256)": FunctionFragment;
    "query(address,string,bytes32,bytes32[])": FunctionFragment;
    "owner()": FunctionFragment;
    "bondage()": FunctionFragment;
    "getEndpoint(uint256)": FunctionFragment;
    "selfDestruct()": FunctionFragment;
    "getUserQuery(uint256)": FunctionFragment;
    "bondageAddress()": FunctionFragment;
    "respondIntArray(uint256,int256[])": FunctionFragment;
    "transferOwnership(address)": FunctionFragment;
    "respond2(uint256,string,string)": FunctionFragment;
  };

  encodeFunctionData(
    functionFragment: "getCancel",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "respondBytes32Array",
    values: [BigNumberish, BytesLike[]]
  ): string;
  encodeFunctionData(
    functionFragment: "getSubscriber",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "respond4",
    values: [BigNumberish, string, string, string, string]
  ): string;
  encodeFunctionData(
    functionFragment: "getSubscriberOnchain",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "respond3",
    values: [BigNumberish, string, string, string]
  ): string;
  encodeFunctionData(functionFragment: "db", values?: undefined): string;
  encodeFunctionData(
    functionFragment: "getProvider",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "getStatus",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "respond1",
    values: [BigNumberish, string]
  ): string;
  encodeFunctionData(
    functionFragment: "updateDependencies",
    values?: undefined
  ): string;
  encodeFunctionData(
    functionFragment: "cancelQuery",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "query",
    values: [string, string, BytesLike, BytesLike[]]
  ): string;
  encodeFunctionData(functionFragment: "owner", values?: undefined): string;
  encodeFunctionData(functionFragment: "bondage", values?: undefined): string;
  encodeFunctionData(
    functionFragment: "getEndpoint",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "selfDestruct",
    values?: undefined
  ): string;
  encodeFunctionData(
    functionFragment: "getUserQuery",
    values: [BigNumberish]
  ): string;
  encodeFunctionData(
    functionFragment: "bondageAddress",
    values?: undefined
  ): string;
  encodeFunctionData(
    functionFragment: "respondIntArray",
    values: [BigNumberish, BigNumberish[]]
  ): string;
  encodeFunctionData(
    functionFragment: "transferOwnership",
    values: [string]
  ): string;
  encodeFunctionData(
    functionFragment: "respond2",
    values: [BigNumberish, string, string]
  ): string;

  decodeFunctionResult(functionFragment: "getCancel", data: BytesLike): Result;
  decodeFunctionResult(
    functionFragment: "respondBytes32Array",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "getSubscriber",
    data: BytesLike
  ): Result;
  decodeFunctionResult(functionFragment: "respond4", data: BytesLike): Result;
  decodeFunctionResult(
    functionFragment: "getSubscriberOnchain",
    data: BytesLike
  ): Result;
  decodeFunctionResult(functionFragment: "respond3", data: BytesLike): Result;
  decodeFunctionResult(functionFragment: "db", data: BytesLike): Result;
  decodeFunctionResult(
    functionFragment: "getProvider",
    data: BytesLike
  ): Result;
  decodeFunctionResult(functionFragment: "getStatus", data: BytesLike): Result;
  decodeFunctionResult(functionFragment: "respond1", data: BytesLike): Result;
  decodeFunctionResult(
    functionFragment: "updateDependencies",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "cancelQuery",
    data: BytesLike
  ): Result;
  decodeFunctionResult(functionFragment: "query", data: BytesLike): Result;
  decodeFunctionResult(functionFragment: "owner", data: BytesLike): Result;
  decodeFunctionResult(functionFragment: "bondage", data: BytesLike): Result;
  decodeFunctionResult(
    functionFragment: "getEndpoint",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "selfDestruct",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "getUserQuery",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "bondageAddress",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "respondIntArray",
    data: BytesLike
  ): Result;
  decodeFunctionResult(
    functionFragment: "transferOwnership",
    data: BytesLike
  ): Result;
  decodeFunctionResult(functionFragment: "respond2", data: BytesLike): Result;

  events: {
    "Incoming(uint256,address,address,string,bytes32,bytes32[],bool)": EventFragment;
    "FulfillQuery(address,address,bytes32)": EventFragment;
    "OffchainResponse(uint256,address,address,bytes32[])": EventFragment;
    "OffchainResponseInt(uint256,address,address,int256[])": EventFragment;
    "OffchainResult1(uint256,address,address,string)": EventFragment;
    "OffchainResult2(uint256,address,address,string,string)": EventFragment;
    "OffchainResult3(uint256,address,address,string,string,string)": EventFragment;
    "OffchainResult4(uint256,address,address,string,string,string,string)": EventFragment;
    "CanceledRequest(uint256,address,address)": EventFragment;
    "RevertCancelation(uint256,address,address)": EventFragment;
    "OwnershipTransferred(address,address)": EventFragment;
  };

  getEvent(nameOrSignatureOrTopic: "Incoming"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "FulfillQuery"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResponse"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResponseInt"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResult1"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResult2"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResult3"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OffchainResult4"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "CanceledRequest"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "RevertCancelation"): EventFragment;
  getEvent(nameOrSignatureOrTopic: "OwnershipTransferred"): EventFragment;
}

export class Dispatch extends Contract {
  connect(signerOrProvider: Signer | Provider | string): this;
  attach(addressOrName: string): this;
  deployed(): Promise<this>;

  on(event: EventFilter | string, listener: Listener): this;
  once(event: EventFilter | string, listener: Listener): this;
  addListener(eventName: EventFilter | string, listener: Listener): this;
  removeAllListeners(eventName: EventFilter | string): this;
  removeListener(eventName: any, listener: Listener): this;

  interface: DispatchInterface;

  functions: {
    getCancel(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: BigNumber;
    }>;

    "getCancel(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: BigNumber;
    }>;

    respondBytes32Array(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respondBytes32Array(uint256,bytes32[])"(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    getSubscriber(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "getSubscriber(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    respond4(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respond4(uint256,string,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    getSubscriberOnchain(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: boolean;
    }>;

    "getSubscriberOnchain(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: boolean;
    }>;

    respond3(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respond3(uint256,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    db(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "db()"(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    getProvider(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "getProvider(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    getStatus(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: BigNumber;
    }>;

    "getStatus(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: BigNumber;
    }>;

    respond1(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respond1(uint256,string)"(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    updateDependencies(overrides?: Overrides): Promise<ContractTransaction>;

    "updateDependencies()"(overrides?: Overrides): Promise<ContractTransaction>;

    cancelQuery(
      id: BigNumberish,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "cancelQuery(uint256)"(
      id: BigNumberish,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    query(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "query(address,string,bytes32,bytes32[])"(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    owner(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "owner()"(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    bondage(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "bondage()"(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    getEndpoint(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "getEndpoint(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    selfDestruct(overrides?: Overrides): Promise<ContractTransaction>;

    "selfDestruct()"(overrides?: Overrides): Promise<ContractTransaction>;

    getUserQuery(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "getUserQuery(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    bondageAddress(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    "bondageAddress()"(
      overrides?: CallOverrides
    ): Promise<{
      0: string;
    }>;

    respondIntArray(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respondIntArray(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    transferOwnership(
      newOwner: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "transferOwnership(address)"(
      newOwner: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    respond2(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "respond2(uint256,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<ContractTransaction>;
  };

  getCancel(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

  "getCancel(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<BigNumber>;

  respondBytes32Array(
    id: BigNumberish,
    response: BytesLike[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respondBytes32Array(uint256,bytes32[])"(
    id: BigNumberish,
    response: BytesLike[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  getSubscriber(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

  "getSubscriber(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<string>;

  respond4(
    id: BigNumberish,
    response1: string,
    response2: string,
    response3: string,
    response4: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respond4(uint256,string,string,string,string)"(
    id: BigNumberish,
    response1: string,
    response2: string,
    response3: string,
    response4: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  getSubscriberOnchain(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<boolean>;

  "getSubscriberOnchain(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<boolean>;

  respond3(
    id: BigNumberish,
    response1: string,
    response2: string,
    response3: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respond3(uint256,string,string,string)"(
    id: BigNumberish,
    response1: string,
    response2: string,
    response3: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  db(overrides?: CallOverrides): Promise<string>;

  "db()"(overrides?: CallOverrides): Promise<string>;

  getProvider(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

  "getProvider(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<string>;

  getStatus(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

  "getStatus(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<BigNumber>;

  respond1(
    id: BigNumberish,
    response: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respond1(uint256,string)"(
    id: BigNumberish,
    response: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  updateDependencies(overrides?: Overrides): Promise<ContractTransaction>;

  "updateDependencies()"(overrides?: Overrides): Promise<ContractTransaction>;

  cancelQuery(
    id: BigNumberish,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "cancelQuery(uint256)"(
    id: BigNumberish,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  query(
    provider: string,
    userQuery: string,
    endpoint: BytesLike,
    endpointParams: BytesLike[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "query(address,string,bytes32,bytes32[])"(
    provider: string,
    userQuery: string,
    endpoint: BytesLike,
    endpointParams: BytesLike[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  owner(overrides?: CallOverrides): Promise<string>;

  "owner()"(overrides?: CallOverrides): Promise<string>;

  bondage(overrides?: CallOverrides): Promise<string>;

  "bondage()"(overrides?: CallOverrides): Promise<string>;

  getEndpoint(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

  "getEndpoint(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<string>;

  selfDestruct(overrides?: Overrides): Promise<ContractTransaction>;

  "selfDestruct()"(overrides?: Overrides): Promise<ContractTransaction>;

  getUserQuery(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

  "getUserQuery(uint256)"(
    id: BigNumberish,
    overrides?: CallOverrides
  ): Promise<string>;

  bondageAddress(overrides?: CallOverrides): Promise<string>;

  "bondageAddress()"(overrides?: CallOverrides): Promise<string>;

  respondIntArray(
    id: BigNumberish,
    response: BigNumberish[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respondIntArray(uint256,int256[])"(
    id: BigNumberish,
    response: BigNumberish[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  transferOwnership(
    newOwner: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "transferOwnership(address)"(
    newOwner: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  respond2(
    id: BigNumberish,
    response1: string,
    response2: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "respond2(uint256,string,string)"(
    id: BigNumberish,
    response1: string,
    response2: string,
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  callStatic: {
    getCancel(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

    "getCancel(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respondBytes32Array(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respondBytes32Array(uint256,bytes32[])"(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: CallOverrides
    ): Promise<boolean>;

    getSubscriber(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

    "getSubscriber(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<string>;

    respond4(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respond4(uint256,string,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    getSubscriberOnchain(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<boolean>;

    "getSubscriberOnchain(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<boolean>;

    respond3(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respond3(uint256,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    db(overrides?: CallOverrides): Promise<string>;

    "db()"(overrides?: CallOverrides): Promise<string>;

    getProvider(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

    "getProvider(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<string>;

    getStatus(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

    "getStatus(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respond1(
      id: BigNumberish,
      response: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respond1(uint256,string)"(
      id: BigNumberish,
      response: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    updateDependencies(overrides?: CallOverrides): Promise<void>;

    "updateDependencies()"(overrides?: CallOverrides): Promise<void>;

    cancelQuery(id: BigNumberish, overrides?: CallOverrides): Promise<void>;

    "cancelQuery(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<void>;

    query(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "query(address,string,bytes32,bytes32[])"(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    owner(overrides?: CallOverrides): Promise<string>;

    "owner()"(overrides?: CallOverrides): Promise<string>;

    bondage(overrides?: CallOverrides): Promise<string>;

    "bondage()"(overrides?: CallOverrides): Promise<string>;

    getEndpoint(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

    "getEndpoint(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<string>;

    selfDestruct(overrides?: CallOverrides): Promise<void>;

    "selfDestruct()"(overrides?: CallOverrides): Promise<void>;

    getUserQuery(id: BigNumberish, overrides?: CallOverrides): Promise<string>;

    "getUserQuery(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<string>;

    bondageAddress(overrides?: CallOverrides): Promise<string>;

    "bondageAddress()"(overrides?: CallOverrides): Promise<string>;

    respondIntArray(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respondIntArray(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: CallOverrides
    ): Promise<boolean>;

    transferOwnership(
      newOwner: string,
      overrides?: CallOverrides
    ): Promise<void>;

    "transferOwnership(address)"(
      newOwner: string,
      overrides?: CallOverrides
    ): Promise<void>;

    respond2(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: CallOverrides
    ): Promise<boolean>;

    "respond2(uint256,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: CallOverrides
    ): Promise<boolean>;
  };

  filters: {
    Incoming(
      id: BigNumberish | null,
      provider: string | null,
      subscriber: string | null,
      query: null,
      endpoint: null,
      endpointParams: null,
      onchainSubscriber: null
    ): EventFilter;

    FulfillQuery(
      subscriber: string | null,
      provider: string | null,
      endpoint: BytesLike | null
    ): EventFilter;

    OffchainResponse(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response: null
    ): EventFilter;

    OffchainResponseInt(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response: null
    ): EventFilter;

    OffchainResult1(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response1: null
    ): EventFilter;

    OffchainResult2(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response1: null,
      response2: null
    ): EventFilter;

    OffchainResult3(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response1: null,
      response2: null,
      response3: null
    ): EventFilter;

    OffchainResult4(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null,
      response1: null,
      response2: null,
      response3: null,
      response4: null
    ): EventFilter;

    CanceledRequest(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null
    ): EventFilter;

    RevertCancelation(
      id: BigNumberish | null,
      subscriber: string | null,
      provider: string | null
    ): EventFilter;

    OwnershipTransferred(
      previousOwner: string | null,
      newOwner: string | null
    ): EventFilter;
  };

  estimateGas: {
    getCancel(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

    "getCancel(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respondBytes32Array(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respondBytes32Array(uint256,bytes32[])"(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    getSubscriber(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "getSubscriber(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respond4(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respond4(uint256,string,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    getSubscriberOnchain(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "getSubscriberOnchain(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respond3(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respond3(uint256,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    db(overrides?: CallOverrides): Promise<BigNumber>;

    "db()"(overrides?: CallOverrides): Promise<BigNumber>;

    getProvider(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "getProvider(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    getStatus(id: BigNumberish, overrides?: CallOverrides): Promise<BigNumber>;

    "getStatus(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    respond1(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respond1(uint256,string)"(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    updateDependencies(overrides?: Overrides): Promise<BigNumber>;

    "updateDependencies()"(overrides?: Overrides): Promise<BigNumber>;

    cancelQuery(id: BigNumberish, overrides?: Overrides): Promise<BigNumber>;

    "cancelQuery(uint256)"(
      id: BigNumberish,
      overrides?: Overrides
    ): Promise<BigNumber>;

    query(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    "query(address,string,bytes32,bytes32[])"(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    owner(overrides?: CallOverrides): Promise<BigNumber>;

    "owner()"(overrides?: CallOverrides): Promise<BigNumber>;

    bondage(overrides?: CallOverrides): Promise<BigNumber>;

    "bondage()"(overrides?: CallOverrides): Promise<BigNumber>;

    getEndpoint(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "getEndpoint(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    selfDestruct(overrides?: Overrides): Promise<BigNumber>;

    "selfDestruct()"(overrides?: Overrides): Promise<BigNumber>;

    getUserQuery(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    "getUserQuery(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<BigNumber>;

    bondageAddress(overrides?: CallOverrides): Promise<BigNumber>;

    "bondageAddress()"(overrides?: CallOverrides): Promise<BigNumber>;

    respondIntArray(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respondIntArray(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    transferOwnership(
      newOwner: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    "transferOwnership(address)"(
      newOwner: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    respond2(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<BigNumber>;

    "respond2(uint256,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<BigNumber>;
  };

  populateTransaction: {
    getCancel(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getCancel(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    respondBytes32Array(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respondBytes32Array(uint256,bytes32[])"(
      id: BigNumberish,
      response: BytesLike[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    getSubscriber(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getSubscriber(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    respond4(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respond4(uint256,string,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      response4: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    getSubscriberOnchain(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getSubscriberOnchain(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    respond3(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respond3(uint256,string,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      response3: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    db(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    "db()"(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    getProvider(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getProvider(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    getStatus(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getStatus(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    respond1(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respond1(uint256,string)"(
      id: BigNumberish,
      response: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    updateDependencies(overrides?: Overrides): Promise<PopulatedTransaction>;

    "updateDependencies()"(
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    cancelQuery(
      id: BigNumberish,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "cancelQuery(uint256)"(
      id: BigNumberish,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    query(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "query(address,string,bytes32,bytes32[])"(
      provider: string,
      userQuery: string,
      endpoint: BytesLike,
      endpointParams: BytesLike[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    owner(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    "owner()"(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    bondage(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    "bondage()"(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    getEndpoint(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getEndpoint(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    selfDestruct(overrides?: Overrides): Promise<PopulatedTransaction>;

    "selfDestruct()"(overrides?: Overrides): Promise<PopulatedTransaction>;

    getUserQuery(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    "getUserQuery(uint256)"(
      id: BigNumberish,
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    bondageAddress(overrides?: CallOverrides): Promise<PopulatedTransaction>;

    "bondageAddress()"(
      overrides?: CallOverrides
    ): Promise<PopulatedTransaction>;

    respondIntArray(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respondIntArray(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    transferOwnership(
      newOwner: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "transferOwnership(address)"(
      newOwner: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    respond2(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "respond2(uint256,string,string)"(
      id: BigNumberish,
      response1: string,
      response2: string,
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;
  };
}
